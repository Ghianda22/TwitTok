package com.example.twittok.dto;

import android.graphics.Bitmap;

import com.example.twittok.datasource.model.UserModel;
import com.example.twittok.listeners.click.OnFollowToggleClickListener;

public class FollowedUserWrapper {

    // --- ATTRIBUTES ------------------------------------------
    private UserModel user;
    private Bitmap image;
    private OnFollowToggleClickListener onFollowToggleClickListener;


    // --- CONSTRUCTORS ------------------------------------------
    public FollowedUserWrapper() {
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
    public OnFollowToggleClickListener getOnFollowToggleClickListener() {
        return onFollowToggleClickListener;
    }
    public void setOnFollowToggleClickListener(OnFollowToggleClickListener onFollowToggleClickListener) {
        this.onFollowToggleClickListener = onFollowToggleClickListener;
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


