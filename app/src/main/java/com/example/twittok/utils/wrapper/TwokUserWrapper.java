package com.example.twittok.utils.wrapper;

import android.graphics.Bitmap;

import com.example.twittok.datasource.model.TwokModel;

public class TwokUserWrapper {
    private TwokModel twok;
    private Bitmap image;
    private boolean isFollowed;

    public TwokUserWrapper() {
    }
    public TwokUserWrapper(TwokModel twok, Bitmap image, boolean isFollowed) {
        this.twok = twok;
        this.image = image;
        this.isFollowed = isFollowed;
    }

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
}
