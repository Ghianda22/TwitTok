package com.example.twittok.listeners.loaded;

import com.example.twittok.datasource.model.ProfileModel;

public interface OnProfileLoadedListener {
    void onProfileLoaded(ProfileModel profileResponse);
}
