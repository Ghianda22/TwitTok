package com.example.twittok.datasource;

import com.example.twittok.repositories.SidRepository;
import com.example.twittok.repositories.UserRepository;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("register")
    Call<SidRepository> getSid();

    @POST("getProfile")
    Call<UserRepository> getProfile();
}
