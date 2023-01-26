package com.example.twittok.datasource.network;

import android.util.Log;

import com.example.twittok.datasource.network.config.ApiInterface;
import com.example.twittok.datasource.network.config.ConfigNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.repositories.TwokRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TwokNetworkDataSource {
    private static final ApiInterface apiInterface = ConfigNetworkDataSource.getApiInterface();
    private static final String TAG = "TWOK_network";
    //todo add listener


    //sid, uid, tid
    public static void callGetTwok(RequestBody body) {
        Call<TwokRepository> getTwokCall = apiInterface.getTwok(body);
        getTwokCall.enqueue(new Callback<TwokRepository>() {
            @Override
            public void onResponse(Call<TwokRepository> call, Response<TwokRepository> response) {
                Log.d(TAG, "onResponse: " + response.code() + " - " + response.message());
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<TwokRepository> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }

    //sid, twok specifics
    public static void callAddTwok(RequestBody body) {
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
