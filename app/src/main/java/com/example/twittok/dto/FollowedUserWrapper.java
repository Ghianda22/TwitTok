package com.example.twittok.dto;

import android.graphics.Bitmap;

import androidx.navigation.NavDirections;

import com.example.twittok.datasource.model.UserModel;
import com.example.twittok.listeners.click.OnFollowToggleClickListener;

public class FollowedUserWrapper {

    // --- ATTRIBUTES ------------------------------------------
    private UserModel user;
    private Bitmap image;
    private OnFollowToggleClickListener onFollowToggleClickListener;
    private NavDirections actionToUserboard;


    // --- CONSTRUCTORS ------------------------------------------
    public FollowedUserWrapper() {
    }

    public FollowedUserWrapper(UserModel user, Bitmap image, OnFollowToggleClickListener onFollowToggleClickListener, NavDirections actionToUserboard) {
        this.user = user;
        this.image = image;
        this.onFollowToggleClickListener = onFollowToggleClickListener;
        this.actionToUserboard = actionToUserboard;
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

    public NavDirections getActionToUserboard() {
        return actionToUserboard;
    }

    public void setActionToUserboard(NavDirections actionToUserboard) {
        this.actionToUserboard = actionToUserboard;
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


