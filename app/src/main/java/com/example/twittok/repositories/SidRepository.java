package com.example.twittok.repositories;

import android.content.SharedPreferences;

import com.example.twittok.datasource.SidLocalDataSource;

public class SidRepository {
    private String sid = null;

    public SidRepository() {}

    public String getSid() {    //todo Make it retrieve it from SharedPreferences or call the api
        if(sid == null){
//            if SidLocalDataSource != null -> return SidLocalDataSource
//            else callRegister(); SidLocalDataSource.saveSid()
//            OR callRegister() and inside the onResponse call the saveSid
        }else return sid;
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
