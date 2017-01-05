package com.jiale.mininews.apis.net;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Karlo on 2016/12/17.
 */

public interface IPhoto {
    @GET("data/福利/{count}/{page}")
    Call<String> loadPhotoList(@Path("count") int count, @Path("page") int page);
}
