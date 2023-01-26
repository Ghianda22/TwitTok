package com.example.twittok.datasource;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.twittok.MainActivity;
import com.example.twittok.datasource.network.config.ContextSupplier;
import com.example.twittok.repositories.SidRepository;

//key-value local data source
public class SidLocalDataSource {
    private final Context context;
    private static final String SID_FILENAME = "com.example.twittok.PREFERENCE_FILE_SID";
    private static final String SID_KEY = "sid";
    private static final String TAG = "SID_SHARED_PREF";

    //todo add listener to notify the succesfully saved data

    public SidLocalDataSource() {
        this.context = ContextSupplier.getContext();
    }

    public void saveSid(SidRepository sid){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SID_FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SID_KEY, sid.getSid());
        editor.commit();
//        editor.apply();
//        here a listener
        Log.d(TAG, "saveSid: sid saved");
    }
    public String getSid(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SID_FILENAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(SID_KEY, null);
    }
    //set preferences
    //get preferences
}
