package com.example.twittok.listeners;

import com.example.twittok.datasource.storage.entities.UserEntity;

public interface OnDbResponseListener {
    void onDbResponse(UserEntity userEntity);
}
