package com.example.twittok.datasource.network;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.twittok.datasource.SidLocalDataSource;
import com.example.twittok.datasource.network.config.ApiInterface;
import com.example.twittok.datasource.network.config.ConfigNetworkDataSource;
import com.example.twittok.listeners.loaded.OnSidLoadedListener;
import com.example.twittok.datasource.model.SidModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SidNetworkDataSource {
    private static final ApiInterface apiInterface = ConfigNetworkDataSource.getApiInterface();
    private static final String TAG = "SID_network";

    public static void callRegister(OnSidLoadedListener onSidLoadedListener) {
        Call<SidModel> registerCall = apiInterface.register();
        registerCall.enqueue(new Callback<SidModel>() {
            @Override
            public void onResponse(@NonNull Call<SidModel> call, @NonNull Response<SidModel> response) {
                Log.d(TAG, "onCreate: SID VALUE: " + response.body().getSid());
                SidLocalDataSource.saveSid(response.body());
                onSidLoadedListener.onSidLoaded(response.body());
            }

            @Override
            public void onFailure(Call<SidModel> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

}
