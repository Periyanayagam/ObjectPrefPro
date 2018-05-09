package com.perusudroid.objectprefpro;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;


public class SharedPref {


    // Single ton objects...
    private static SharedPreferences preference = null;
    private static SharedPref sharedPref = null;

    //Single ton method for this class...
    public static SharedPref getInstance() {

        if (sharedPref == null) {
            sharedPref = new SharedPref();
        }

        return sharedPref;
    }


    private SharedPreferences getPreferenceInstance() {

        if (preference != null) {
            return preference;
        } else {
            //TODO: Shared Preference name has to be set....
            preference = AppController.getSharedPreferences();
            return preference;
        }
    }


    public void setSharedValue(String key, String value) {
        getPreferenceInstance();
        Editor editor = preference.edit();
       /* if (value.equals("null")){
            value=null;
        }*/
        editor.putString(key, value);
        editor.apply();
    }


    public void clearAll() {
        getPreferenceInstance();
        Editor editor = preference.edit();
        editor.clear();
        editor.apply();

    }


    /**
     * Set the Integer value in the shared preference W.R.T the given key.
     *
     * @param key   String used as a key for accessing the value.
     * @param value Integer value which is to be stored in shared preference.
     */

    public void setSharedValue(String key, int value) {
        getPreferenceInstance();
        Editor editor = preference.edit();
        editor.putInt(key, value);
        editor.apply();
    }


    /**
     * Set the boolean value in the shared preference W.R.T the given key.
     *
     * @param key   String used as a key for accessing the value.
     * @param value Boolean value which is to be stored in shared preference.
     */

    public void setSharedValue(String key, boolean value) {
        getPreferenceInstance();
        Editor editor = preference.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void setSharedValue(String key, long value) {
        getPreferenceInstance();
        Editor editor = preference.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static void setSharedValue(String key, Object value) {
        try {
            Gson gson = new GsonBuilder().create();
            AppController.getSharedPreferences().edit().putString(key, gson.toJson(value)).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*
    public static <T> List<T> getSharedList( Class<T[]> clazz, String key) {
        Type type = new TypeToken<List<classType>>() {
        }.getType();
        Gson gson = new Gson();
        return gson.fromJson(AppController.getSharedPreferences().getString(key, null), type);
    }
*/

    public static <T> List<T> getSharedList(final Class<T[]> clazz, String key) {

        if (AppController.getSharedPreferences().getString(key, null) != null) {
            final T[] jsonToObject = new Gson().fromJson(AppController.getSharedPreferences().getString(key, ""), clazz);
            return Arrays.asList(jsonToObject);
        }
        return null;
    }



    public static <T> Object getObject(String key, Class<?> tClass) {
        try {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(getInstance().getStringValue(key), tClass);
        } catch (Exception e) {
            Log.e("gson", e.getMessage());
            return "";
        }
    }

    /***/
    public static <T> T setSharedList(String key, List<T> value) {


        Gson gson = new Gson();
        String json = gson.toJson(value);
        Editor editor = AppController.getSharedPreferences().edit();
        editor.putString(key, json);
        editor.apply();
        return null;
    }


    public Boolean getBooleanValue(String key) {
        return getPreferenceInstance().getBoolean(key, false);
    }

    /**
     * Returns Integer value for the given key.
     * By default it will return "-1".
     *
     * @param key String used as a key for accessing the value.
     * @return -1 by default; returns the Integer value for the given key.
     */

    public int getIntValue(String key) {
        return getPreferenceInstance().getInt(key, -1);
    }

    /**
     * Returns String value for the given key.
     * By default it will return null.
     *
     * @param key String used as a key for accessing the value.
     * @return null by default; returns the String value for the given key.
     */

    public String getStringValue(String key) {
        return getPreferenceInstance().getString(key, null);
    }

}