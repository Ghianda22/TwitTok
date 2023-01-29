package com.example.twittok.repositories;

import android.util.Log;

import com.example.twittok.datasource.model.TwokModel;
import com.example.twittok.datasource.network.FollowNetworkDataSource;
import com.example.twittok.datasource.network.TwokNetworkDataSource;
import com.example.twittok.datasource.network.UserNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.datasource.storage.entities.UserEntity;
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
//            checkIfFollowed(twok);
            checkImageSaved(twok.getUid());
            onTwokReadyListener.onTwokReady(this);
        });
    }

//    public void checkIfFollowed(TwokModel twok){ //technically parameter is useless
//        FollowNetworkDataSource.callIsFollowed(
//                new RequestBody(twok.getUid()),
//                isFollowedResponse -> isFollowed = isFollowedResponse.getFollowed()
//        );
//    }
    public void checkImageSaved(Integer uid){
        //implement room db
        Log.d(TAG, "checkImageSaved: " + uid);
        UserNetworkDataSource.callGetPicture(new RequestBody(uid), userResponse -> {
            Log.d(TAG, "checkImageSaved: the user is " + userResponse);
            //ROOM TEST
            UserRepository userRepository = new UserRepository();
            userRepository.insertProva(userResponse, new Runnable() {
                @Override
                public void run() {
                    Log.d(TAG, "run: siamo nel listener del db, ma anche nel runnable");
                    userRepository.getProva(userResponse.getUid(), userEntity -> {
                        Log.d(TAG, "checkImageSaved: questo è l'utente preso! " + userEntity);
                    });
                }
            });


        });
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
