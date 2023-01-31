package com.example.twittok.listeners;

import retrofit2.Response;

public interface OnTwokSentListener {
    void onTwokSent(Response<Object> response);
}
