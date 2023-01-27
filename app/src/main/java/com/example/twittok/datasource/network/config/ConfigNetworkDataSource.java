package com.example.twittok.datasource.network.config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigNetworkDataSource {
    private static final String BASE_URL = "https://develop.ewlab.di.unimi.it/mc/twittok/";
    private static final String TAG = "NETWORK_CLASS";
    private static ApiInterface apiInterface = null;
    public static ApiInterface getApiInterface() {
        if (apiInterface == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = retrofit.create(ApiInterface.class);
        }
        return apiInterface;
    }
}
