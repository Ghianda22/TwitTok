package com.example.twittok.datasource.storage.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserEntity {
    @PrimaryKey
    private Integer uid;
    private Integer pVersion;
    private String picture;

    public UserEntity(Integer uid, Integer pVersion, String picture) {
        this.uid = uid;
        this.pVersion = pVersion;
        this.picture = picture;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getpVersion() {
        return pVersion;
    }

    public void setpVersion(Integer pVersion) {
        this.pVersion = pVersion;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
