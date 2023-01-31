package com.example.twittok.repositories;

import android.util.Log;

import com.example.twittok.datasource.model.TwokModel;
import com.example.twittok.datasource.model.TwokToAdd;
import com.example.twittok.datasource.network.TwokNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.listeners.OnTwokSentListener;
import com.example.twittok.listeners.loaded.OnTwokLoadedListener;

public class TwokRepository {
//      only loads and post twoks

    // --- ATTRIBUTES ------------------------------------------------------------------------------
    private static final String TAG = "TWOK_REPOSITORY";
    private static Integer tid = 27;

    // --- CONSTRUCTORS ----------------------------------------------------------------------------
    public TwokRepository() {}

    // --- GETTERS & SETTERS -----------------------------------------------------------------------


    // --- METHODS ---------------------------------------------------------------------------------
    public void loadTwok(OnTwokLoadedListener onTwokLoadedListener) {
        RequestBody requestBody = new RequestBody();
        if (tid != -1) {
            requestBody.setTid(tid);
            tid++;
        }
        TwokNetworkDataSource.callGetTwok(requestBody, twokResponse -> {
            Log.d(TAG, "loadTwok: test tid " + twokResponse.getTid());
            onTwokLoadedListener.onTwokLoaded(twokResponse);
        });
    }

    public void loadTwokOfUser(Integer uid, OnTwokLoadedListener onTwokLoadedListener) {
        TwokNetworkDataSource.callGetTwok(new RequestBody(uid), twokResponse -> {
            onTwokLoadedListener.onTwokLoaded(twokResponse);
        });
    }

    public static void addTwok(TwokToAdd twokToAdd, OnTwokSentListener onTwokSentListener) {
        TwokNetworkDataSource.callAddTwok(twokToAdd, onTwokSentListener);
    }
}
