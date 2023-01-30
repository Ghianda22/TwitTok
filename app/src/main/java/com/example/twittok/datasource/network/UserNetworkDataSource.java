package com.example.twittok.datasource.network;

import android.util.Log;

import com.example.twittok.datasource.network.config.ApiInterface;
import com.example.twittok.datasource.network.config.ConfigNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.datasource.model.UserModel;
import com.example.twittok.listeners.loaded.OnUserLoadedListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserNetworkDataSource {
    private static final ApiInterface apiInterface = ConfigNetworkDataSource.getApiInterface();
    private static final String TAG = "USER_network";

    //sid -> new RequestBody


    //sid, uid
    public static void callGetPicture(RequestBody body, OnUserLoadedListener onUserLoadedListener) {
        Call<UserModel> getPictureCall = apiInterface.getPicture(body);
        getPictureCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                Log.d(TAG, "onResponse: " + response.code() + " - " + response.message());
                Log.d(TAG, "onResponse: " + response.body());
                onUserLoadedListener.onUserLoaded(response.body());
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }

}
