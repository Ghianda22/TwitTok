package com.example.twittok.listeners.loaded;

import com.example.twittok.datasource.model.UserModel;

public interface OnUserLoadedListener {
    void onUserLoaded(UserModel userResponse);
}
