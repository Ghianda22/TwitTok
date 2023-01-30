package com.example.twittok.repositories;

import com.example.twittok.datasource.network.ProfileNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.listeners.loaded.OnProfileLoadedListener;

//handles local profile op, like updating profile (-> access to gallery)
public class ProfileRepository {

    private static final String TAG = "PROFILE_REPOSITORY";

    public void getProfile(OnProfileLoadedListener onProfileLoadedListener){
        ProfileNetworkDataSource.callGetProfile(new RequestBody(), profileResponse -> {
            onProfileLoadedListener.onProfileLoaded(profileResponse);
        });
    }

    public void setProfile(String name, String picture){
        ProfileNetworkDataSource.callSetProfile(new RequestBody(name, picture));
    }
}
