package com.example.twittok.repositories;

import com.example.twittok.datasource.network.FollowNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.listeners.loaded.OnFollowedListLoadedListener;
import com.example.twittok.listeners.loaded.OnIsFollowedLoadedListener;

//all ops about followed network calls
public class FollowedRepository {



    // --- METHODS ---------------------------------------------------------------------------------
    public void getListOfFollowed(OnFollowedListLoadedListener onFollowedListLoadedListener){
        FollowNetworkDataSource.callGetFollowed(
                new RequestBody(),
                listOfFollowed -> onFollowedListLoadedListener.onFollowedListLoaded(listOfFollowed));
    }

    public void checkIfFollowed(Integer uid, OnIsFollowedLoadedListener onIsFollowedLoadedListener) {
        FollowNetworkDataSource.callIsFollowed(
                new RequestBody(uid),
                isFollowedResponse -> onIsFollowedLoadedListener.isFollowedLoaded(isFollowedResponse)
        );
    }

    public void follow(Integer uid){
        FollowNetworkDataSource.callFollow(new RequestBody(uid));
    }
    public void unfollow(Integer uid){
        FollowNetworkDataSource.callUnfollow(new RequestBody(uid));
    }


}
