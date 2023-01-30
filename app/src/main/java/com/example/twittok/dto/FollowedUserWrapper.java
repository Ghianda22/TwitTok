package com.example.twittok.dto;

import android.graphics.Bitmap;

import com.example.twittok.datasource.model.UserModel;

public class FollowedUserWrapper {

    // --- ATTRIBUTES ------------------------------------------
    private UserModel user;
    private Bitmap image;


    // --- CONSTRUCTORS ------------------------------------------
    public FollowedUserWrapper() {
    }
    public FollowedUserWrapper(UserModel user, Bitmap image) {
        this.user = user;
        this.image = image;
    }

    // --- GETTERS & SETTERS ------------------------------------------

    public UserModel getUser() {
        return user;
    }
    public void setUser(UserModel user) {
        this.user = user;
    }
    public Bitmap getImage() {
        return image;
    }
    public void setImage(Bitmap image) {
        this.image = image;
    }


    // --- METHODS ------------------------------------------


    @Override
    public String toString() {
        return "FollowedUserWrapper{" +
                "\n    user=" + user +
                ", \n    image='" + image + '\'' +
                "\n}";
    }
}


