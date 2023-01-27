package com.example.twittok.repositories;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.twittok.datasource.SidLocalDataSource;
import com.example.twittok.datasource.network.SidNetworkDataSource;

public class SidRepository {
    //can't be static due to Gson converter
    //another static field (eg. persistentSid) is incompatible with RequestBody, which require non-static fields
    private String sid;

    public SidRepository() {}

    public String getSid() {    //todo Make it retrieve it from SharedPreferences or call the api
        if(sid == null){
            SidLocalDataSource sidLocalDataSource = new SidLocalDataSource();
            if (sidLocalDataSource.getSid() != null) {
                setSid(sidLocalDataSource.getSid());
                return sid;
            }
        }
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }



    @Override
    public String toString() {
        return "\nSidRepository {\n" +
                "    sid = '" + sid + '\'' +
                "\n}";
    }
}
