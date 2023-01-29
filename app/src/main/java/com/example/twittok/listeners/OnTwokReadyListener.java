package com.example.twittok.listeners;

import com.example.twittok.datasource.model.TwokModel;
import com.example.twittok.repositories.TwokRepository;

public interface OnTwokReadyListener {
    void onTwokReady(TwokModel twokModel);
}
