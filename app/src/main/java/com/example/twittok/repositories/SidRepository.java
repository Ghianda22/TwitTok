package com.example.twittok.repositories;

import com.example.twittok.datasource.SidLocalDataSource;
import com.example.twittok.datasource.model.SidModel;
import com.example.twittok.datasource.network.SidNetworkDataSource;
import com.example.twittok.listeners.OnSidLoadedListener;


public class SidRepository {

    private SidModel sid = null;

    public void setSid(OnSidLoadedListener onSidLoadedListener) {
        if (sid != null) {
            return;
        }

        if (SidLocalDataSource.getSid() != null) {
            sid.setSid(SidLocalDataSource.getSid());
        } else {
            SidNetworkDataSource.callRegister(sidResponse -> {
                sid = sidResponse;
                onSidLoadedListener.onSidLoaded(sid);
            });
        }

    }

    public SidModel getSid() {
        return sid;
    }
}
