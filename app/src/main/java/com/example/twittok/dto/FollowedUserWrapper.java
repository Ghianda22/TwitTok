package com.example.twittok.dto;

import com.example.twittok.datasource.model.UserModel;

public class FollowedUserWrapper {

    // --- ATTRIBUTES ------------------------------------------
    private UserModel user;
    private String image;


    // --- CONSTRUCTORS ------------------------------------------
    public FollowedUserWrapper() {
    }
    public FollowedUserWrapper(UserModel user, String image) {
        this.user = user;
        this.image = image;
    }

    // --- GETTERS & SETTERS ------------------------------------------

    public UserModel getUser() {
        return user;
    }
    public void setUser(UserModel user) {
        this.user = user;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }


    // --- METHODS ------------------------------------------


    @Override
    public String toString() {
        return "FollowedUserWrapper{" +
                "\n    user=" + user +
                ", \n    image='" + image + '\'' +
                "\n}";
    }
}


