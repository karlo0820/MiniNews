package com.jiale.mininews.mvp.model;


import com.jiale.mininews.App;
import com.jiale.mininews.apis.ApiConstans;
import com.jiale.mininews.apis.net.INetEase;
import com.jiale.mininews.bean.NewsBean;
import com.jiale.mininews.mvp.listener.onLoadTypeListener;
import com.jiale.mininews.utils.Constant;
import com.jiale.mininews.utils.LogUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by Karlo on 2016/12/12.
 */

public class NewsListModelImpl implements NewsListModel {
    private static final String TAG= "NewsListModelImpl";
    private onLoadTypeListener listener;

    public NewsListModelImpl(onLoadTypeListener listener) {
        this.listener = listener;
    }

    @Override
    public void loadData(final int requestType, final String id, int page) {
        LogUtil.i(TAG,"id="+id+",page="+page);
        Retrofit retrofitInstance = App.getRetrofitInstance();
        INetEase iNetEase = retrofitInstance.create(INetEase.class);
        final String type = ApiConstans.getTypeById(id);
        Call<String> stringCall = iNetEase.requestNews2(type, id, page);
        stringCall.enqueue(new Callback<String>() {
            private List<NewsBean> newsBeen;
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String json = response.body();
                LogUtil.d(id, json);
                if (json == null) {
                    if (listener != null) {
                        listener.loadError(requestType, "请求数据为空");
                    }
                    return;
                }
                if (ApiConstans.NETEASE_TYPE_HOUSE.equals(type)) {
                    newsBeen = NewsBean.arrayNewsBeanFromData(json, "北京");
                } else {
                    newsBeen = NewsBean.arrayNewsBeanFromData(json, id);
                }
                for (NewsBean bean : newsBeen
                        ) {
                    if (bean.getSkipType() != null && (bean.getSkipType().equals(Constant.PHOTOSET) || bean.getSkipType().equals(Constant.LIVE))) {
                        bean.setType(1);
                    } else {
                        bean.setType(0);
                    }
                }
                if (listener != null) {
                    if (newsBeen.size() > 0) {
                        listener.loadSuccess(requestType, newsBeen);
                    } else {
                        listener.loadError(requestType, "请求数据为空");
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                if (listener != null) {
                    listener.loadError(requestType, t.getMessage());
                }
            }
        });
    }
}
