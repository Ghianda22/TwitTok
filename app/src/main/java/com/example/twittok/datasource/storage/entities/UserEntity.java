package com.example.twittok.datasource.storage.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserEntity {
    @PrimaryKey
    private Integer uid;
    private Integer pversion;
    private String picture;

    public UserEntity(Integer uid, Integer pversion, String picture) {
        this.uid = uid;
        this.pversion = pversion;
        this.picture = picture;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    @Override
    public String toString() {
        return "UserEntity{" +
                "\n   uid=" + uid +
                ",\n    pversion=" + pversion +
                ",\n    picture='" + picture + '\'' +
                '}';
    }
}
