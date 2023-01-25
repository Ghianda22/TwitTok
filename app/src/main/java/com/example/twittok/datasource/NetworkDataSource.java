package com.example.twittok.datasource;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.twittok.repositories.IsFollowed;
import com.example.twittok.repositories.SidRepository;
import com.example.twittok.repositories.TwokRepository;
import com.example.twittok.repositories.UserRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkDataSource {
    private static final String BASE_URL = "https://develop.ewlab.di.unimi.it/mc/twittok/";
    private static final String TAG = "NETWORK_CLASS";
    private static ApiInterface apiInterface = null;
    private static SidRepository sid;

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
    // pro: I'd have a class for each object I recive
    //
    public static void callRegister() {
        Call<SidRepository> registerCall = getApiInterface().register();
        registerCall.enqueue(new Callback<SidRepository>() {
            @Override
            public void onResponse(@NonNull Call<SidRepository> call, @NonNull Response<SidRepository> response) {
                sid = response.body();
                Log.d(TAG, "onCreate: SID VALUE: " + response.body().getSid());

            }

            @Override
            public void onFailure(Call<SidRepository> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                t.printStackTrace();
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    //sid -> new RequestBody
    public static void callGetProfile(RequestBody body) {
        Call<UserRepository> getProfile = getApiInterface().getProfile(body);
        getProfile.enqueue(new Callback<UserRepository>() {
            @Override
            public void onResponse(Call<UserRepository> call, Response<UserRepository> response) {
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<UserRepository> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }

    //sid, name, picture
    public static void callSetProfile(RequestBody body) {
        Call<Object> setProfileCall = getApiInterface().setProfile(body);
        setProfileCall.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.d(TAG, "onResponse: " + response.body());
                Log.d(TAG, "onResponse: " + response.code() + " - " + response.message());
                Log.d(TAG, "onResponse: " + response.raw());
                callGetProfile(new RequestBody());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }

    //sid, uid, tid
    public static void callGetTwok(RequestBody body) {
        Call<TwokRepository> getTwokCall = getApiInterface().getTwok(body);
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
        Call<Object> addTwokCall = getApiInterface().addTwok(body);
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

    //sid, uid
    public static void callGetPicture(RequestBody body) {
        Call<UserRepository> getPictureCall = getApiInterface().getPicture(body);
        getPictureCall.enqueue(new Callback<UserRepository>() {
            @Override
            public void onResponse(Call<UserRepository> call, Response<UserRepository> response) {
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<UserRepository> call, Throwable t) {

            }
        });

    }

    //sid, uid
    public static void callFollow(RequestBody body) {
        Call<Object> followCall = getApiInterface().follow(body);
        followCall.enqueue(new Callback<Object>()   {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.d(TAG, "onResponse: " + response.code());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });

    }

    public static void callUnfollow(RequestBody body) {
        Call<Object> unfollowCall = getApiInterface().unfollow(body);
        unfollowCall.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.d(TAG, "onResponse: " + response.code());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });

    }

    //sid
    public static void callGetFollowed(RequestBody body) {
        Call<UserRepository[]> getFollowedCall = getApiInterface().getFollowed(body);
        getFollowedCall.enqueue(new Callback<UserRepository[]>() {
            @Override
            public void onResponse(Call<UserRepository[]> call, Response<UserRepository[]> response) {
                Log.d(TAG, "onResponse: " + response.body().length);
            }

            @Override
            public void onFailure(Call<UserRepository[]> call, Throwable t) {

            }
        });

    }

    //sid, uid
    public static void callIsFollowed(RequestBody body) {
        Call<IsFollowed> isFollowedCall = getApiInterface().isFollowed(body);
        isFollowedCall.enqueue(new Callback<IsFollowed>() {
            @Override
            public void onResponse(Call<IsFollowed> call, Response<IsFollowed> response) {
                Log.d(TAG, "onResponse: " + response.body().getFollowed());
            }

            @Override
            public void onFailure(Call<IsFollowed> call, Throwable t) {

            }
        });

    }
}
