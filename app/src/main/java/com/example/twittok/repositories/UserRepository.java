package com.example.twittok.repositories;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Log;

import com.example.twittok.R;
import com.example.twittok.datasource.ContextSupplier;
import com.example.twittok.datasource.model.UserModel;
import com.example.twittok.datasource.network.UserNetworkDataSource;
import com.example.twittok.datasource.network.config.RequestBody;
import com.example.twittok.datasource.storage.LocalDataSource;
import com.example.twittok.datasource.storage.entities.UserEntity;
import com.example.twittok.listeners.OnDbResponseListener;
import com.example.twittok.listeners.ready.OnImageReadyListener;
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
            try {
                Log.d(TAG, "getUserFromDb: " + getOp.get());
                onDbResponseListener.onDbResponse(getOp.get());
            } catch (ExecutionException | InterruptedException e) {
                Log.d(TAG, "getUserFromDb: exception class: " + e.getClass() + " - " + e.getMessage());
                throw new RuntimeException(e);
            }
        }, ContextSupplier.getContext().getMainExecutor());
    }


    public void checkImageVersion(Integer uid, Integer pVersion, OnImageReadyListener onImageReadyListener) {
        getUserFromDb(uid, userEntity -> {
            //if it's not saved in db or picture is an older version
            if (userEntity == null || userEntity.getPversion() < pVersion) {
                UserNetworkDataSource.callGetPicture(new RequestBody(uid), userResponse -> {
                    insertUser(userResponse);
                    if (userResponse.getPicture() != null) {
                        //implement external library call to assure that base64 is actually an image
                        Log.d(TAG, "checkImageVersion: user response" + userResponse);
                    }
                        onImageReadyListener.onImageReady(ImageConverter.convertImage(userResponse.getPicture()));
                });

            }else{ //it's saved
                onImageReadyListener.onImageReady(ImageConverter.convertImage(userEntity.getPicture()));
            }
        });

        /* call db
        --> if not present OR if pVersionSaved < pVersion
            --> call api
                --> save in db
                --> return from api
        --> else return from db
        * */
    }



}
