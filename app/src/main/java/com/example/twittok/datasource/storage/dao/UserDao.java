package com.example.twittok.datasource.storage.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.twittok.datasource.storage.entities.UserEntity;
import com.google.common.util.concurrent.ListenableFuture;

@Dao
public interface UserDao {
    //CRUD OP

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    ListenableFuture<Void> insert(UserEntity... users);

    @Update
    ListenableFuture<Void> update(UserEntity... users);

    @Delete
    ListenableFuture<Void> delete(UserEntity... users);

    @Query("select * from UserEntity where uid = :uid")
    ListenableFuture<UserEntity> getUserFromUid(Integer uid);


}
