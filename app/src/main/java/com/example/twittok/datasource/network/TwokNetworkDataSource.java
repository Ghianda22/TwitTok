package com.example.twittok.datasource.network;

import android.util.Log;

import com.example.twittok.datasource.model.TwokToAdd;
import com.example.twittok.datasource.network.config.ApiInterface;
import com.example.twittok.datasource.network.config.ConfigNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.datasource.model.TwokModel;
import com.example.twittok.listeners.OnTwokSentListener;
import com.example.twittok.listeners.loaded.OnTwokLoadedListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TwokNetworkDataSource {
    private static final ApiInterface apiInterface = ConfigNetworkDataSource.getApiInterface();
    private static final String TAG = "TWOK_network";

    //sid, uid, tid
    public static void callGetTwok(RequestBody body, OnTwokLoadedListener onTwokLoadedListener) {
        Call<TwokModel> getTwokCall = apiInterface.getTwok(body);
        getTwokCall.enqueue(new Callback<TwokModel>() {
            @Override
            public void onResponse(Call<TwokModel> call, Response<TwokModel> response) {
                if(response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.body());
                    onTwokLoadedListener.onTwokLoaded(response.body());
                }else Log.d(TAG, "onResponse: " + response.code() + " - " + response.message());
            }

            @Override
            public void onFailure(Call<TwokModel> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }

    //sid, twok specifics
    public static void callAddTwok(TwokToAdd body, OnTwokSentListener onTwokSentListener) {
        Call<Object> addTwokCall = apiInterface.addTwok(body);
        addTwokCall.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.d(TAG, "onResponse: " + response.code() + " - " + response.message());
                onTwokSentListener.onTwokSent(response);
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }
}
