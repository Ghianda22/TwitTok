package com.example.twittok.listeners;

import com.example.twittok.repositories.UserRepository;

public interface OnUserReadyListener {
    void onUserReady(UserRepository user);
}
