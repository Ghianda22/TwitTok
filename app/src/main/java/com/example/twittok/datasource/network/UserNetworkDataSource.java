package com.example.twittok.datasource.network;

import android.util.Log;

import com.example.twittok.datasource.network.config.ApiInterface;
import com.example.twittok.datasource.network.config.ConfigNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.repositories.UserRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserNetworkDataSource {
    private static final ApiInterface apiInterface = ConfigNetworkDataSource.getApiInterface();
    private static final String TAG = "USER_network";
    //todo add listener

    //sid -> new RequestBody
    public static void callGetProfile(RequestBody body) {
        Call<UserRepository> getProfile = apiInterface.getProfile(body);
        getProfile.enqueue(new Callback<UserRepository>() {
            @Override
            public void onResponse(Call<UserRepository> call, Response<UserRepository> response) {
                Log.d(TAG, "onResponse: " + response.code() + " - " + response.message());
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<UserRepository> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }

    //sid, name, picture
    public static void callSetProfile(RequestBody body) {
        Call<Object> setProfileCall = apiInterface.setProfile(body);
        setProfileCall.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.d(TAG, "onResponse: " + response.body());
                Log.d(TAG, "onResponse: " + response.code() + " - " + response.message());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    //sid, uid
    public static void callGetPicture(RequestBody body) {
        Call<UserRepository> getPictureCall = apiInterface.getPicture(body);
        getPictureCall.enqueue(new Callback<UserRepository>() {
            @Override
            public void onResponse(Call<UserRepository> call, Response<UserRepository> response) {
                Log.d(TAG, "onResponse: " + response.code() + " - " + response.message());
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<UserRepository> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }

}
