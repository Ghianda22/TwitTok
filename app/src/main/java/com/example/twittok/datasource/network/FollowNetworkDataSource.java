package com.example.twittok.datasource.network;

import android.util.Log;

import com.example.twittok.datasource.network.config.ApiInterface;
import com.example.twittok.datasource.network.config.ConfigNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.repositories.IsFollowed;
import com.example.twittok.repositories.UserRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FollowNetworkDataSource {
    private static ApiInterface apiInterface = ConfigNetworkDataSource.getApiInterface();
    private static final String TAG = "FOLLOW_network";
    //todo add listener

    //sid, uid
    public static void callFollow(RequestBody body) {
        Call<Object> followCall = apiInterface.follow(body);
        followCall.enqueue(new Callback<Object>()   {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.d(TAG, "onResponse: " + response.code());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });

    }

    public static void callUnfollow(RequestBody body) {
        Call<Object> unfollowCall = apiInterface.unfollow(body);
        unfollowCall.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.d(TAG, "onResponse: " + response.code());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });

    }

    //sid
    public static void callGetFollowed(RequestBody body) {
        Call<UserRepository[]> getFollowedCall = apiInterface.getFollowed(body);
        getFollowedCall.enqueue(new Callback<UserRepository[]>() {
            @Override
            public void onResponse(Call<UserRepository[]> call, Response<UserRepository[]> response) {
                Log.d(TAG, "onResponse: " + response.body().length);
            }

            @Override
            public void onFailure(Call<UserRepository[]> call, Throwable t) {

            }
        });

    }

    //sid, uid
    public static void callIsFollowed(RequestBody body) {
        Call<IsFollowed> isFollowedCall = apiInterface.isFollowed(body);
        isFollowedCall.enqueue(new Callback<IsFollowed>() {
            @Override
            public void onResponse(Call<IsFollowed> call, Response<IsFollowed> response) {
                Log.d(TAG, "onResponse: " + response.body().getFollowed());
            }

            @Override
            public void onFailure(Call<IsFollowed> call, Throwable t) {

            }
        });

    }

}
