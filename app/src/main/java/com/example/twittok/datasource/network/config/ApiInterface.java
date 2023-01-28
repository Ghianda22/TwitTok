package com.example.twittok.datasource.network.config;

import com.example.twittok.datasource.model.IsFollowed;
import com.example.twittok.datasource.model.SidModel;
import com.example.twittok.datasource.model.TwokModel;
import com.example.twittok.datasource.model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("register")
    Call<SidModel> register();

    @POST("getProfile")
    Call<UserModel> getProfile(@Body RequestBody body);

    @POST("setProfile")
    Call<Object> setProfile(@Body RequestBody body);
//    Call<Object> setProfile(
//            @Field("sid") String sidValue,
//            @Field("name") String name,
//            @Field("picture") String picture
//    );

    @POST("getTwok")
    Call<TwokModel> getTwok(@Body RequestBody body);
    @POST("addTwok")
    Call<Object> addTwok(@Body RequestBody body);
    @POST("getPicture")
    Call<UserModel> getPicture(@Body RequestBody body);
    @POST("follow")
    Call<Object> follow(@Body RequestBody body);
    @POST("unfollow")
    Call<Object> unfollow(@Body RequestBody body);
    @POST("getFollowed")
    Call<UserModel[]> getFollowed(@Body RequestBody body);
    @POST("isFollowed")
    Call<IsFollowed> isFollowed(@Body RequestBody body);
}
