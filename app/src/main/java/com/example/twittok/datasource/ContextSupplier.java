package com.example.twittok.datasource;

import android.app.Application;
import android.content.Context;

public class ContextSupplier extends Application {
    private static ContextSupplier instance;
    public static ContextSupplier getInstance(){return instance;}

    public static Context getContext(){
        return instance;
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}
