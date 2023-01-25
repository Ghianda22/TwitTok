package com.example.twittok.datasource;

import com.example.twittok.repositories.IsFollowed;
import com.example.twittok.repositories.SidRepository;
import com.example.twittok.repositories.TwokRepository;
import com.example.twittok.repositories.UserRepository;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {
    @POST("register")
    Call<SidRepository> register();

    @POST("getProfile")
    Call<UserRepository> getProfile(@Body RequestBody body);

    @POST("setProfile")
    Call<Object> setProfile(@Body RequestBody body);
//    Call<Object> setProfile(
//            @Field("sid") String sidValue,
//            @Field("name") String name,
//            @Field("picture") String picture
//    );

    @POST("getTwok")
    Call<TwokRepository> getTwok(@Body RequestBody body);
    @POST("addTwok")
    Call<Object> addTwok(@Body RequestBody body);
    @POST("getPicture")
    Call<UserRepository> getPicture(@Body RequestBody body);
    @POST("follow")
    Call<Object> follow(@Body RequestBody body);
    @POST("unfollow")
    Call<Object> unfollow(@Body RequestBody body);
    @POST("getFollowed")
    Call<UserRepository[]> getFollowed(@Body RequestBody body);
    @POST("isFollowed")
    Call<IsFollowed> isFollowed(@Body RequestBody body);
}
