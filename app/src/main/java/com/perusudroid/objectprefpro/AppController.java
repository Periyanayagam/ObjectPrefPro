package com.perusudroid.objectprefpro;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class AppController extends Application {

    private static SharedPreferences sharedpreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedpreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
    }

    public static SharedPreferences getSharedPreferences() {
        return sharedpreferences;
    }

}
