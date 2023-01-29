package com.example.twittok.repositories;

import com.example.twittok.datasource.model.TwokModel;
import com.example.twittok.datasource.network.FollowNetworkDataSource;
import com.example.twittok.datasource.network.TwokNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.listeners.OnTwokReadyListener;

public class TwokRepository {
    /*  handles the calls from network:
     *   getTwok -> to get the requested twok
     *   isFollowed -> check if the author is followed
     *   check if author image is in the DB
     *   if so -> convert it
     * */

    private static final String TAG = "TWOK_REPOSITORY";
    private TwokModel twok;
    private boolean isFollowed;

    public void loadTwok(OnTwokReadyListener onTwokReadyListener){
        TwokNetworkDataSource.callGetTwok(new RequestBody(), twokResponse -> {
            twok = twokResponse;
            checkIfFollowed(twok);
//            checkImageSaved(twok.getUid());
            onTwokReadyListener.onTwokReady(this);
        });
    }

    public void checkIfFollowed(TwokModel twok){ //technically parameter is useless
        FollowNetworkDataSource.callIsFollowed(
                new RequestBody(twok.getUid()),
                isFollowedResponse -> isFollowed = isFollowedResponse.getFollowed()
        );
    }
    public void checkImageSaved(Integer uid){
        //implement room db

    }

    public TwokModel getTwok() {
        return twok;
    }

    public void setTwok(TwokModel twok) {
        this.twok = twok;
    }

    public boolean isFollowed() {
        return isFollowed;
    }

    public void setFollowed(boolean followed) {
        isFollowed = followed;
    }

    @Override
    public String toString() {
        return "TwokRepository{" +
                "twok=" + twok +
                ", isFollowed=" + isFollowed +
                '}';
    }
}
