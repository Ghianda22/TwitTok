package com.example.twittok.datasource.model;

public class ProfileModel {
    // --- ATTRIBUTES ------------------------------------------
    private Integer uid;
    private String sid;
    private String name;
    private String picture;
    private Integer pversion;


    // --- CONSTRUCTORS ------------------------------------------
    public ProfileModel() {
    }
    public ProfileModel(Integer uid, String sid, String name, String picture, Integer pversion) {
        this.uid = uid;
        this.sid = sid;
        this.name = name;
        this.picture = picture;
        this.pversion = pversion;
    }


    // --- GETTERS & SETTERS ------------------------------------------
    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getSid() {
        return sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public Integer getPversion() {
        return pversion;
    }
    public void setPversion(Integer pversion) {
        this.pversion = pversion;
    }


    @Override
    public String toString() {
        return "\nProfileModel{" +
                "\n    uid=" + uid +
                ", \n    sid='" + sid + '\'' +
                ", \n    name='" + name + '\'' +
                ", \n    picture='" + picture + '\'' +
                ", \n    pversion=" + pversion +
                "\n}";
    }

}