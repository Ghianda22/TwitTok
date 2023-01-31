package com.example.twittok.dto;

import android.graphics.Bitmap;

import androidx.navigation.NavDirections;

import com.example.twittok.datasource.model.TwokModel;
import com.example.twittok.listeners.click.OnFollowToggleClickListener;
import com.google.common.reflect.ClassPath;

public class TwokUserWrapper {
    // --- ATTRIBUTES ------------------------------------------
    private TwokModel twok;
    private Bitmap image;
    private boolean isFollowed;
    private OnFollowToggleClickListener onFollowToggleClickListener;
    private NavDirections actionToMap;
    private NavDirections actionToUserboard;

    // --- CONSTRUCTORS ------------------------------------------
    public TwokUserWrapper() {
    }
    public TwokUserWrapper(TwokModel twok, Bitmap image, boolean isFollowed, OnFollowToggleClickListener onFollowToggleClickListener) {
        this.twok = twok;
        this.image = image;
        this.isFollowed = isFollowed;
        this.onFollowToggleClickListener = onFollowToggleClickListener;
    }

    // --- GETTERS & SETTTERS -------------------------------------------------------
    public TwokModel getTwok() {
        return twok;
    }
    public void setTwok(TwokModel twok) {
        this.twok = twok;
    }
    public Bitmap getImage() {
        return image;
    }
    public void setImage(Bitmap image) {
        this.image = image;
    }
    public boolean isFollowed() {
        return isFollowed;
    }
    public void setFollowed(boolean followed) {
        isFollowed = followed;
    }
    public OnFollowToggleClickListener getOnFollowToggleClickListener() {
        return onFollowToggleClickListener;
    }
    public void setOnFollowToggleClickListener(OnFollowToggleClickListener onFollowToggleClickListener) {
        this.onFollowToggleClickListener = onFollowToggleClickListener;
    }

    public NavDirections getActionToMap() {
        return actionToMap;
    }

    public void setActionToMap(NavDirections actionToMap) {
        this.actionToMap = actionToMap;
    }

    public NavDirections getActionToUserboard() {
        return actionToUserboard;
    }

    public void setActionToUserboard(NavDirections actionToUserboard) {
        this.actionToUserboard = actionToUserboard;
    }
}
