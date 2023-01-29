package com.example.twittok.repositories;

import android.util.Log;

import com.example.twittok.datasource.ContextSupplier;
import com.example.twittok.datasource.model.UserModel;
import com.example.twittok.datasource.storage.LocalDataSource;
import com.example.twittok.datasource.storage.entities.UserEntity;
import com.example.twittok.listeners.OnDbResponseListener;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

//handles other users operations, like images versioning system & follow/unfollow operations
public class UserRepository {
    private static final String TAG = "USER_REPOSITORY";
    private final LocalDataSource appDb = LocalDataSource.getInstance();
    public void insertProva(UserModel userToInsert, Runnable runnable){
        //prepare data
        UserEntity user = new UserEntity(
                userToInsert.getUid(),
                userToInsert.getPversion(),
                userToInsert.getPicture());
        ListenableFuture<Void> insertOp = appDb.userDao().insert(user);
        insertOp.addListener(runnable, ContextSupplier.getContext().getMainExecutor());
    }

    public void getProva(Integer uid, OnDbResponseListener onDbResponseListener){
        ListenableFuture<UserEntity> getOp = appDb.userDao().getUserFromUid(uid);
        getOp.addListener(() -> {
            Log.d(TAG, "getProva: siamo nel DB listener");
            try {
                UserEntity userFromDb = getOp.get();
                onDbResponseListener.onDbResponse(userFromDb);
                Log.d(TAG, "getProva: \n Utente ricevuto: " + userFromDb);
            } catch (ExecutionException | InterruptedException e) {
                Log.d(TAG, "getProva: siamo finiti nel catch " + e.getMessage());
                throw new RuntimeException(e);
            }
        }, ContextSupplier.getContext().getMainExecutor());
    }
}
