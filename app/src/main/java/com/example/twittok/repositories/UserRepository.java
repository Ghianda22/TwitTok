package com.example.twittok.repositories;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.twittok.datasource.ContextSupplier;
import com.example.twittok.datasource.model.UserModel;
import com.example.twittok.datasource.network.FollowNetworkDataSource;
import com.example.twittok.datasource.network.UserNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.datasource.storage.LocalDataSource;
import com.example.twittok.datasource.storage.entities.UserEntity;
import com.example.twittok.listeners.OnDbResponseListener;
import com.example.twittok.listeners.OnImageReadyListener;
import com.example.twittok.utils.converter.ImageConverter;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

//handles other users operations, like images versioning system & follow/unfollow operations
public class UserRepository {
    //    --- ATTRIBUTES ----------------------------------------------------------------------------
    private static final String TAG = "USER_REPOSITORY";
    private final LocalDataSource appDb = LocalDataSource.getInstance();

    //    --- DB OPERATIONS ---------------------------------------------------------------------------
    public void insertUser(UserModel userToInsert) {
        UserEntity user = new UserEntity(
                userToInsert.getUid(),
                userToInsert.getPversion(),
                userToInsert.getPicture());
        appDb.userDao().insert(user);
    }

    public void getUserFromDb(Integer uid, OnDbResponseListener onDbResponseListener) {
        ListenableFuture<UserEntity> getOp = appDb.userDao().getUserFromUid(uid);
        getOp.addListener(() -> {
            Log.d(TAG, "getProva: siamo nel DB listener");
            try {
                onDbResponseListener.onDbResponse(getOp.get());
            } catch (ExecutionException | InterruptedException e) {
                Log.d(TAG, "getUserFromDb: exception class: " + e.getClass() + " - " + e.getMessage());
                throw new RuntimeException(e);
            }
        }, ContextSupplier.getContext().getMainExecutor());
    }

    public void checkImageVersion(Integer uid, Integer pVersion, OnImageReadyListener onImageReadyListener) {
        /* call db
        --> if not present OR if pVersionSaved < pVersion
            --> call api
                --> save in db
                --> return from api
        --> else return from db
        * */
        getUserFromDb(uid, userEntity -> {
            if (userEntity == null || userEntity.getPversion() < pVersion) {
                UserNetworkDataSource.callGetPicture(new RequestBody(uid), userResponse -> {
                    insertUser(userResponse);
                    if (userResponse.getPicture() != null) {
                        Bitmap convertedImage = convertedImage = ImageConverter.base64ToBitmap(userResponse.getPicture());
                        onImageReadyListener.onImageReady(convertedImage);
                    }
                });
            }
        });
    }

}
