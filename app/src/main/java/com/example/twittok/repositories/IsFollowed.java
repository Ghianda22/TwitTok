package com.example.twittok.repositories;

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
