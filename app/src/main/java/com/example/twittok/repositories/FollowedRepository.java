package com.example.twittok.repositories;

import com.example.twittok.datasource.network.FollowNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.listeners.OnIsFollowedLoadedListener;

public class FollowedRepository {

    //all ops about followed network calls


    public void getListOfFollowed(){}

    public void checkIfFollowed(Integer uid, OnIsFollowedLoadedListener onIsFollowedLoadedListener) {
        FollowNetworkDataSource.callIsFollowed(
                new RequestBody(uid),
                isFollowedResponse -> onIsFollowedLoadedListener.isFollowedLoaded(isFollowedResponse)
        );
    }


}
