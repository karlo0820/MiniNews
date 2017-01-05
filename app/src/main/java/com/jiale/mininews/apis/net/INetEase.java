package com.jiale.mininews.apis.net;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 网易新闻请求接口
 * Created by Karlo on 2016/12/12.
 */

public interface INetEase {
    @GET("nc/article/{type}/{id}/{page}-20.html")
    Call<String> requestNews2(@Path("type") String type, @Path("id") String id, @Path("page") int page);

    /*请求新闻详情*/
    @GET("nc/article/{postId}/full.html")
    Call<String> requestDetial(@Path("postId") String postId);

    @GET("/photo/api/set/{skipId_1}/{skipId_2}.json")
    Call<String> requestPhotoSet(@Path("skipId_1") String skipId_1, @Path("skipId_2") String skipId_2);
}
