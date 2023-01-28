package com.example.twittok.datasource.network;

import android.util.Log;

import com.example.twittok.datasource.network.config.ApiInterface;
import com.example.twittok.datasource.network.config.ConfigNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.datasource.model.IsFollowed;
import com.example.twittok.datasource.model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FollowNetworkDataSource {
    private static final ApiInterface apiInterface = ConfigNetworkDataSource.getApiInterface();
    private static final String TAG = "FOLLOW_network";
    //todo add listener

    //sid, uid
    public static void callFollow(RequestBody body) {
        Call<Object> followCall = apiInterface.follow(body);
        followCall.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

                Log.d(TAG, "onResponse: " + response.code() + " - " + response.message());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }

    public static void callUnfollow(RequestBody body) {
        Call<Object> unfollowCall = apiInterface.unfollow(body);
        unfollowCall.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

                Log.d(TAG, "onResponse: " + response.code() + " - " + response.message());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }

    //sid
    public static void callGetFollowed(RequestBody body) {
        Call<UserModel[]> getFollowedCall = apiInterface.getFollowed(body);
        getFollowedCall.enqueue(new Callback<UserModel[]>() {
            @Override
            public void onResponse(Call<UserModel[]> call, Response<UserModel[]> response) {
                Log.d(TAG, "onResponse: " + response.code() + " - " + response.message());
                Log.d(TAG, "onResponse: " + response.body().length);
            }

            @Override
            public void onFailure(Call<UserModel[]> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }

    //sid, uid
    public static void callIsFollowed(RequestBody body) {
        Call<IsFollowed> isFollowedCall = apiInterface.isFollowed(body);
        isFollowedCall.enqueue(new Callback<IsFollowed>() {
            @Override
            public void onResponse(Call<IsFollowed> call, Response<IsFollowed> response) {
                Log.d(TAG, "onResponse: " + response.code() + " - " + response.message());
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<IsFollowed> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }

}
