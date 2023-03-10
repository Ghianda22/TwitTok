package com.example.twittok.datasource.model;

public class UserModel {
    // --- ATTRIBUTES ------------------------------------------
    private Integer uid;
    private String name;
    private Integer pversion;
    private String picture;


    // --- CONSTRUCTORS ------------------------------------------
    public UserModel() {
    }
    public UserModel(Integer uid, String name, Integer pversion, String picture) {
        this.uid = uid;
        this.name = name;
        this.pversion = pversion;
        this.picture = picture;
    }


    // --- GETTERS & SETTERS ------------------------------------------
    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPversion() {
        return pversion;
    }
    public void setPversion(Integer pversion) {
        this.pversion = pversion;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

    // --- METHODS ------------------------------------------


    @Override
    public String toString() {
        return "\nUserModel{" +
                "\n    uid=" + uid +
                ",\n    name='" + name + '\'' +
                ",\n    pversion=" + pversion +
                ",\n    picture='" + picture + '\'' +
                "\n}";
    }
}

