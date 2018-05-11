package com.perusudroid.objectprefpro;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class AppController extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
       SharedPref.init(this);
    }


}
