package com.example.twittok.datasource.network;

import android.util.Log;

import com.example.twittok.datasource.network.config.ApiInterface;
import com.example.twittok.datasource.network.config.ConfigNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.datasource.model.TwokModel;
import com.example.twittok.listeners.OnTwokReadyListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TwokNetworkDataSource {
    private static final ApiInterface apiInterface = ConfigNetworkDataSource.getApiInterface();
    private static final String TAG = "TWOK_network";
    private OnTwokReadyListener onTwokReadyListener;
    public void setOnTwokReadyListener(OnTwokReadyListener onTwokReadyListener) {
        this.onTwokReadyListener = onTwokReadyListener;
    }

    //sid, uid, tid
    public void callGetTwok(RequestBody body) {
        Call<TwokModel> getTwokCall = apiInterface.getTwok(body);
        getTwokCall.enqueue(new Callback<TwokModel>() {
            @Override
            public void onResponse(Call<TwokModel> call, Response<TwokModel> response) {
                Log.d(TAG, "onResponse: " + response.code() + " - " + response.message());
                Log.d(TAG, "onResponse: " + response.body());
                onTwokReadyListener.onTwokReady(response.body());
            }

            @Override
            public void onFailure(Call<TwokModel> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }

    //sid, twok specifics
    public void callAddTwok(RequestBody body) {
        Call<Object> addTwokCall = apiInterface.addTwok(body);
        addTwokCall.enqueue(new Callback<Object>() {
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
}
