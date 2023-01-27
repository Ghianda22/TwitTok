package com.example.twittok.listeners;

import com.example.twittok.repositories.SidRepository;

public interface OnResponseReadyListener {
    void onSidReady(SidRepository sid);
}
