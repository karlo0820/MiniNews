package com.jiale.mininews.mvp.model;

import com.jiale.mininews.App;
import com.jiale.mininews.apis.net.INetEase;
import com.jiale.mininews.bean.NewsDetailBean;
import com.jiale.mininews.mvp.listener.onLoadListener;
import com.jiale.mininews.utils.LogUtil;
import com.jiale.mininews.utils.NewsDetailHtmlUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Karlo on 2016/12/14.
 */
public class NewsDetailModelImpl implements NewsDetailModel<NewsDetailBean> {
    @Override
    public void loadDetial(final String postId, final onLoadListener listener) {
        Retrofit retrofitInstance = App.getRetrofitInstance();
        INetEase iNetEase = retrofitInstance.create(INetEase.class);
        Call<String> detialCall = iNetEase.requestDetial(postId);
        detialCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String json = response.body();
                LogUtil.i("NewsDetail", json);
                NewsDetailBean newsDetailBean = NewsDetailBean.objectFromData(json, postId);
                if (listener != null) {
                    if (newsDetailBean != null) {
                        LogUtil.i("newsDetailBeen", newsDetailBean.toString());
                        listener.loadSuccess(NewsDetailHtmlUtil.dealHtml(newsDetailBean));
                    } else {
                        listener.loadFail("获取详情失败");
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                if (listener != null) {
                    listener.loadFail(t.getMessage());
                }
            }
        });
    }
}
