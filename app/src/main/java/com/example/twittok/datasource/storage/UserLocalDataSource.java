package com.example.twittok.datasource.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.twittok.datasource.storage.dao.UserDao;
import com.example.twittok.datasource.storage.entities.UserEntity;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class UserLocalDataSource extends RoomDatabase {
    public abstract UserDao userDao();
}
