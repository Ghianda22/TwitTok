package com.example.twittok.datasource.network;

import android.util.Log;

import com.example.twittok.datasource.ApiInterface;
import com.example.twittok.datasource.ConfigNetworkDataSource;
import com.example.twittok.datasource.RequestBody;
import com.example.twittok.repositories.TwokRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TwokNetworkDataSource {
    private static ApiInterface apiInterface = ConfigNetworkDataSource.getApiInterface();
    private static final String TAG = "TWOK_network";
    //todo add listener


    //sid, uid, tid
    public static void callGetTwok(RequestBody body) {
        Call<TwokRepository> getTwokCall = apiInterface.getTwok(body);
        getTwokCall.enqueue(new Callback<TwokRepository>() {
            @Override
            public void onResponse(Call<TwokRepository> call, Response<TwokRepository> response) {
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<TwokRepository> call, Throwable t) {

            }
        });

    }

    //sid, twok specifics
    public static void callAddTwok(RequestBody body) {
        Call<Object> addTwokCall = apiInterface.addTwok(body);
        addTwokCall.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.d(TAG, "onResponse: " + response.code());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });

    }
}
