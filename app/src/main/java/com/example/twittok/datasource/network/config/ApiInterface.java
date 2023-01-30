package com.example.twittok.datasource.network.config;

import com.example.twittok.datasource.model.IsFollowed;
import com.example.twittok.datasource.model.ProfileModel;
import com.example.twittok.datasource.model.SidModel;
import com.example.twittok.datasource.model.TwokModel;
import com.example.twittok.datasource.model.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("register")
    Call<SidModel> register();

    @POST("getProfile")
    Call<ProfileModel> getProfile(@Body RequestBody body);

    @POST("setProfile")
    Call<Object> setProfile(@Body RequestBody body);


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
    Call<ArrayList<UserModel>> getFollowed(@Body RequestBody body);
    @POST("isFollowed")
    Call<IsFollowed> isFollowed(@Body RequestBody body);
}
