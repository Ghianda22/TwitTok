package com.example.twittok.datasource.storage.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.twittok.datasource.storage.entities.UserEntity;

@Dao
public interface UserDao {
    @Insert
    void insert(UserEntity... users);
}
