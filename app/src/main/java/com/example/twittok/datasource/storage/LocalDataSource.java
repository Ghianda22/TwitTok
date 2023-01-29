package com.example.twittok.datasource.storage;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.twittok.datasource.ContextSupplier;
import com.example.twittok.datasource.storage.dao.UserDao;
import com.example.twittok.datasource.storage.entities.UserEntity;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class LocalDataSource extends RoomDatabase {
    public abstract UserDao userDao();
    private static LocalDataSource instance;
    public static synchronized LocalDataSource getInstance(){
        if(instance == null){
            instance = Room
                    .databaseBuilder(ContextSupplier.getContext(), LocalDataSource.class, "twittok_db")
                    .build();
        }
        return instance;
    }
}
