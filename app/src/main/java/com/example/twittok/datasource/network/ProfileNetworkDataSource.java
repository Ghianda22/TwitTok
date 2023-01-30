package com.example.twittok.datasource.network;

import android.util.Log;

import com.example.twittok.datasource.model.ProfileModel;
import com.example.twittok.datasource.network.config.ApiInterface;
import com.example.twittok.datasource.network.config.ConfigNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.listeners.loaded.OnProfileLoadedListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileNetworkDataSource {

    private static final ApiInterface apiInterface = ConfigNetworkDataSource.getApiInterface();
    private static final String TAG = "PROFILE_network";


    public static void callGetProfile(RequestBody body, OnProfileLoadedListener onProfileLoadedListener) {
        Call<ProfileModel> getProfile = apiInterface.getProfile(body);
        getProfile.enqueue(new Callback<ProfileModel>() {
            @Override
            public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {
                Log.d(TAG, "onResponse: " + response.code() + " - " + response.message());
                Log.d(TAG, "onResponse: " + response.body());
                onProfileLoadedListener.onProfileLoaded(response.body());
            }

            @Override
            public void onFailure(Call<ProfileModel> call, Throwable t) {
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
}
