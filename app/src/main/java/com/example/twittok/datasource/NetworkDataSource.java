package com.example.twittok.datasource;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkDataSource {
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

    // Implements all network calls
    // Mantainance'll be easier -> if some parameter changes, I have all code here to modify
    // ! -> I'd have to modify each file with each call implementation
    /*
    * Call<SidRepository> register = apiInterface.getSid();
        register.enqueue(new Callback<SidRepository>() {
            @Override
            public void onResponse(@NonNull Call<SidRepository> call, @NonNull Response<SidRepository> response) {

                Log.d(API, "onCreate: SID VALUE: " + response.body().getSid());

            }

            @Override
            public void onFailure(Call<SidRepository> call, Throwable t) {
                Log.d(API, "onFailure: " + t.getMessage());
                t.printStackTrace();
                Log.d(API, "onFailure: " + t.getLocalizedMessage());
            }
        });
    * */
}
