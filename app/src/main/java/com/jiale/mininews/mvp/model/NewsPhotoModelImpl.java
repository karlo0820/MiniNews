package com.jiale.mininews.mvp.model;

import com.jiale.mininews.App;
import com.jiale.mininews.apis.net.INetEase;
import com.jiale.mininews.bean.NewsPhotoBean;
import com.jiale.mininews.mvp.listener.onLoadListener;
import com.jiale.mininews.utils.LogUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Karlo on 2016/12/15.
 */
public class NewsPhotoModelImpl implements NewsPhotoModel<NewsPhotoBean> {
    @Override
    public void getPhotoSet(String skipId_1, String skipId_2, final onLoadListener<NewsPhotoBean> listener) {
        Retrofit retrofitInstance = App.getRetrofitInstance();
        INetEase iNetEase = retrofitInstance.create(INetEase.class);
        Call<String> stringCall = iNetEase.requestPhotoSet(skipId_1, skipId_2);
        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
//                LogUtil.i("PhotoSet", response.body());
                if (response.isSuccessful()) {
                    NewsPhotoBean newsPhotoBean = NewsPhotoBean.objectFromData(response.body());
                    LogUtil.i("NewsPhotoBean", newsPhotoBean.toString());
                    if (listener != null) {
                        if (newsPhotoBean == null) {
                            listener.loadFail("获取数据为null");
                        } else {
                            listener.loadSuccess(newsPhotoBean);
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                LogUtil.i("PhotoSet", t.getMessage());
            }
        });
    }
}
