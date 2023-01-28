package com.example.twittok.listeners;

import com.example.twittok.datasource.model.UserModel;

import java.util.ArrayList;

public interface OnFollowedListLoadedListener {
    void onFollowedListLoaded(ArrayList<UserModel> listOfFollowed);
}
