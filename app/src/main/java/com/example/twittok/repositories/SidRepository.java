package com.example.twittok.repositories;

import com.example.twittok.datasource.SidLocalDataSource;
import com.example.twittok.datasource.model.SidModel;
import com.example.twittok.datasource.network.SidNetworkDataSource;
import com.example.twittok.listeners.OnSidReadyListener;

public class SidRepository {

    private SidModel sid = null;
    private OnSidReadyListener onSidReadyListener;
    public void setOnSidReadyListener(OnSidReadyListener onSidReadyListener) {
        this.onSidReadyListener = onSidReadyListener;
    }

    public void setSid(){
        if(sid == null){
            if (SidLocalDataSource.getSid() != null) {
                sid.setSid(SidLocalDataSource.getSid());
            }else{
                SidNetworkDataSource sidNetworkDataSource = new SidNetworkDataSource();
                sidNetworkDataSource.setOnResponseReadyListener(sidResponse -> {
                    sid = sidResponse;
                    onSidReadyListener.onSidReady(sid);
                });
                sidNetworkDataSource.callRegister();
            }
        }
    }

    public SidModel getSid() {
        return sid;
    }
}
