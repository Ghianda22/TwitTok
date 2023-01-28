package com.example.twittok.datasource.model;

import com.example.twittok.datasource.SidLocalDataSource;

public class SidModel {
    //can't be static due to Gson converter
    //another static field (eg. persistentSid) is incompatible with RequestBody, which require non-static fields
    private String sid;

    public SidModel() {}

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
        return "\nSidModel {\n" +
                "    sid = '" + sid + '\'' +
                "\n}";
    }
}
