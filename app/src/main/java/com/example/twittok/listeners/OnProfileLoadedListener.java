package com.example.twittok.listeners;

import com.example.twittok.datasource.model.UserModel;

public interface OnProfileLoadedListener {
    void onProfileLoaded(UserModel userResponse);
}
