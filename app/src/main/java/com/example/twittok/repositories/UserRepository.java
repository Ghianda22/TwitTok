package com.example.twittok.repositories;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class UserRepository {

    public Bitmap base64ToBitmap(String base){
        byte[] decodedBase64 = Base64.decode(base, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedBase64, 0, decodedBase64.length);
    }
    public String bitmapToBase64(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream .toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }
}
