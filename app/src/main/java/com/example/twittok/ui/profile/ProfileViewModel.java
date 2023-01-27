package com.example.twittok.ui.profile;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.twittok.datasource.network.UserNetworkDataSource;

import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.repositories.UserRepository;

public class ProfileViewModel extends ViewModel {
    private MutableLiveData<UserRepository> userProfile = null;

    public MutableLiveData<UserRepository> getUserProfile(){
        if(userProfile == null){
            userProfile = new MutableLiveData<UserRepository>();
            UserNetworkDataSource userNetworkDataSource = new UserNetworkDataSource();
            userNetworkDataSource.setOnUserReadyListener(response -> {
                userProfile.setValue(response);
            });
            userNetworkDataSource.callGetProfile(new RequestBody());
        }
        return userProfile;
    }

}