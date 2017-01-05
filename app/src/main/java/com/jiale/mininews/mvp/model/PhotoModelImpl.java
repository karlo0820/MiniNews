package com.jiale.mininews.mvp.model;

import android.support.annotation.NonNull;

import com.jiale.mininews.App;
import com.jiale.mininews.apis.ApiConstans;
import com.jiale.mininews.apis.RetrofitManager;
import com.jiale.mininews.apis.net.IPhoto;
import com.jiale.mininews.bean.NewsPhotoBean;
import com.jiale.mininews.bean.PhotoBean;
import com.jiale.mininews.mvp.listener.onLoadListener;
import com.jiale.mininews.mvp.listener.onLoadTypeListener;
import com.jiale.mininews.utils.LogUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.R.attr.type;


/**
 * Created by Karlo on 2016/12/17.
 */
public class PhotoModelImpl implements PhotoModel<List<PhotoBean>> {

    private static final String TAG = "PhotoModelImpl";


    @Override
    public void loadPhotoList(final int type, int count, int page, @NonNull final onLoadTypeListener<List<PhotoBean>> listener) {
        Retrofit retrofit = RetrofitManager.getInstancce(ApiConstans.TYPE_PHOTO);
        IPhoto photo = retrofit.create(IPhoto.class);
        Call<String> call = photo.loadPhotoList(count, page);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String body = response.body();
                    List<PhotoBean> results = PhotoBean.arrayPhotoBeanFromData(body, "results");
                    LogUtil.i(TAG, body);
                    listener.loadSuccess(type, results);
                } else {
                    listener.loadError(type, "请求失败");
                    LogUtil.i(TAG, response.code() + "");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                listener.loadError(type, t.getMessage());
                LogUtil.i(TAG, t.getMessage());
            }
        });
    }
}
