package com.example.twittok.datasource;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.twittok.datasource.model.SidModel;

//key-value local data source
public class SidLocalDataSource {
    private static final String SID_FILENAME = "com.example.twittok.PREFERENCE_FILE_SID";
    private static final String SID_KEY = "sid";
    private static final String TAG = "SID_SHARED_PREF";
    private static SharedPreferences sharedPreferences = ContextSupplier.getContext().getSharedPreferences(SID_FILENAME, Context.MODE_PRIVATE);

    public static void saveSid(SidModel sid){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SID_KEY, sid.getSid());
        editor.apply();
        Log.d(TAG, "saveSid: sid saved");
    }
    public static String getSid(){
        return sharedPreferences.getString(SID_KEY, null);
    }
}
