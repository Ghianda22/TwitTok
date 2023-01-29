package com.example.twittok.repositories;

import androidx.room.Room;

import com.example.twittok.datasource.ContextSupplier;
import com.example.twittok.datasource.model.UserModel;
import com.example.twittok.datasource.storage.LocalDataSource;
import com.example.twittok.datasource.storage.entities.UserEntity;

//handles other users operations, like images versioning system & follow/unfollow operations
public class UserRepository {
    private final LocalDataSource appDb = Room
            .databaseBuilder(ContextSupplier.getContext(), LocalDataSource.class, "twittok_db")
            .allowMainThreadQueries()
            .build();

    public void insertProva(UserModel userToInsert){
        //prepare data
        UserEntity user = new UserEntity(
                userToInsert.getUid(),
                userToInsert.getPversion(),
                userToInsert.getPicture());
        appDb.userDao().insert(user);
    }

    public UserEntity getProva(Integer uid){
        return appDb.userDao().getUser(uid);

    }
}
