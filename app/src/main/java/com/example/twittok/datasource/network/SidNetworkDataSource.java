package com.example.twittok.datasource.network;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.twittok.datasource.SidLocalDataSource;
import com.example.twittok.datasource.network.config.ApiInterface;
import com.example.twittok.datasource.network.config.ConfigNetworkDataSource;
import com.example.twittok.listeners.OnSidReadyListener;
import com.example.twittok.repositories.SidRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SidNetworkDataSource {
    private static final ApiInterface apiInterface = ConfigNetworkDataSource.getApiInterface();
    private static final String TAG = "SID_network";
    private OnSidReadyListener onSidReadyListener;

    public void setOnResponseReadyListener(OnSidReadyListener onSidReadyListener) {
        this.onSidReadyListener = onSidReadyListener;
    }

    public void callRegister() {
        Call<SidRepository> registerCall = apiInterface.register();
        registerCall.enqueue(new Callback<SidRepository>() {
            @Override
            public void onResponse(@NonNull Call<SidRepository> call, @NonNull Response<SidRepository> response) {
                Log.d(TAG, "onCreate: SID VALUE: " + response.body().getSid());
                new SidLocalDataSource().saveSid(response.body());
                onSidReadyListener.onSidReady(response.body());
            }

            @Override
            public void onFailure(Call<SidRepository> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

}