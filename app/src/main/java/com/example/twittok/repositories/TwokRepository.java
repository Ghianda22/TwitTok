package com.example.twittok.repositories;
import com.example.twittok.datasource.network.TwokNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.listeners.loaded.OnTwokLoadedListener;

public class TwokRepository {
//      only loads and post twoks

    private static final String TAG = "TWOK_REPOSITORY";

    public void loadTwok(OnTwokLoadedListener onTwokLoadedListener){
        TwokNetworkDataSource.callGetTwok(new RequestBody(), twokResponse -> {
            onTwokLoadedListener.onTwokLoaded(twokResponse);
        });
    }

}
