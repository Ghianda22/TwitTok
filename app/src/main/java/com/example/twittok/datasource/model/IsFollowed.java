package com.example.twittok.datasource.model;

public class IsFollowed {
    private Boolean followed;

    public IsFollowed() {
    }

    public Boolean getFollowed() {
        return followed;
    }

    @Override
    public String toString() {
        return "IsFollowed{" +
                "followed=" + followed +
                '}';
    }
}
