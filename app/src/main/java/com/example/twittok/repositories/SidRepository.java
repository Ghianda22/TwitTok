package com.example.twittok.repositories;

import com.example.twittok.datasource.SidLocalDataSource;
import com.example.twittok.datasource.network.SidNetworkDataSource;
import com.example.twittok.listeners.loaded.OnSidLoadedListener;


public class SidRepository {

    //TESTING SID
    private static String sid = "CN3uYxyOLqMp7PCtSzcG";
//    private static String sid = SidLocalDataSource.getSid();

    public static void setSid(OnSidLoadedListener onSidLoadedListener) {
        if (sid == null){
            SidNetworkDataSource.callRegister(sidResponse -> {
                sid = sidResponse.getSid();
                onSidLoadedListener.onSidLoaded(sidResponse);
            });
        }

    }

    public static String getSid() {
        return sid;
    }
}
