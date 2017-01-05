package com.jiale.mininews.apis;

import android.util.SparseArray;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Karlo on 2016/12/17.
 */

public class RetrofitManager {
    private static SparseArray<Retrofit> retrofitArr = new SparseArray<>();


    public static Retrofit getInstancce(int hostType) {
        Retrofit retrofit = retrofitArr.get(hostType);
        if (retrofit == null) {
            retrofit = create(hostType);
            retrofitArr.put(hostType, retrofit);
        }
        return retrofit;
    }

    private static Retrofit create(int hostType) {
        try {
            return new Retrofit.Builder()
                    .baseUrl(ApiConstans.getHost(hostType))
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
