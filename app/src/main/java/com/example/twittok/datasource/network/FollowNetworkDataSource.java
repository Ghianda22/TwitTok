package com.example.twittok.datasource.network;

import android.util.Log;

import com.example.twittok.datasource.network.config.ApiInterface;
import com.example.twittok.datasource.network.config.ConfigNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.datasource.model.IsFollowed;
import com.example.twittok.datasource.model.UserModel;
import com.example.twittok.listeners.loaded.OnFollowedListLoadedListener;
import com.example.twittok.listeners.loaded.OnIsFollowedLoadedListener;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FollowNetworkDataSource {
    // --- ATTRIBUTES ---------------------------------------------------------------------------------
    private static final ApiInterface apiInterface = ConfigNetworkDataSource.getApiInterface();
    private static final String TAG = "FOLLOW_network";



    // --- METHODS ---------------------------------------------------------------------------------
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
    public static void callGetFollowed(RequestBody body, OnFollowedListLoadedListener followedListLoadedListener) {
        Call<ArrayList<UserModel>> getFollowedCall = apiInterface.getFollowed(body);
        getFollowedCall.enqueue(new Callback<ArrayList<UserModel>>() {
            @Override
            public void onResponse(Call<ArrayList<UserModel>> call, Response<ArrayList<UserModel>> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: followed users are " + response.body().size());
                    followedListLoadedListener.onFollowedListLoaded(response.body());
                }
                Log.d(TAG, "onResponse: " + response.code() + " - " + response.message());
            }
            @Override
            public void onFailure(Call<ArrayList<UserModel>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }
    //sid, uid
    public static void callIsFollowed(RequestBody body, OnIsFollowedLoadedListener onIsFollowedLoadedListener) {
        Call<IsFollowed> isFollowedCall = apiInterface.isFollowed(body);
        isFollowedCall.enqueue(new Callback<IsFollowed>() {
            @Override
            public void onResponse(Call<IsFollowed> call, Response<IsFollowed> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: " + response.body());
                    onIsFollowedLoadedListener.isFollowedLoaded(response.body());
                }
                Log.d(TAG, "onResponse: " + response.code() + " - " + response.message());
            }

            @Override
            public void onFailure(Call<IsFollowed> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }

}
