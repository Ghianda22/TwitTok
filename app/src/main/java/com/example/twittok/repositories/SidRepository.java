package com.example.twittok.repositories;

import com.example.twittok.datasource.SidLocalDataSource;
import com.example.twittok.datasource.model.SidModel;
import com.example.twittok.datasource.network.SidNetworkDataSource;
import com.example.twittok.listeners.OnSidLoadedListener;

public class SidRepository {

    private SidModel sid = null;
    private OnSidLoadedListener onSidLoadedListener;
    public void setOnSidReadyListener(OnSidLoadedListener onSidLoadedListener) {
        this.onSidLoadedListener = onSidLoadedListener;
    }

    public void setSid(){
        if(sid == null){
            if (SidLocalDataSource.getSid() != null) {
                sid.setSid(SidLocalDataSource.getSid());
            }else{
                SidNetworkDataSource sidNetworkDataSource = new SidNetworkDataSource();
                sidNetworkDataSource.setOnSidLoadedListener(sidResponse -> {
                    sid = sidResponse;
                    onSidLoadedListener.onSidLoaded(sid);
                });
                sidNetworkDataSource.callRegister();
            }
        }
    }

    public SidModel getSid() {
        return sid;
    }
}
