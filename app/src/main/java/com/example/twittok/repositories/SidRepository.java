package com.example.twittok.repositories;

public class SidRepository {
    private String sid;

    public SidRepository() {}

    public String getSid() {    //todo Make it retrieve it from SharedPreferences or call the api
        return "CN3uYxyOLqMp7PCtSzcG";
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
