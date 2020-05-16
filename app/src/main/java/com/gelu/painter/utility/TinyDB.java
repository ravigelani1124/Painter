package com.gelu.painter.utility;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

@SuppressWarnings("unused")
@SuppressLint("DefaultLocale")
public class TinyDB {


    public static final String isLogin = "isLogin";
    public static final String defaultString = "-1";


    private SharedPreferences preferences;

    public TinyDB(Context appContext) {
        preferences = PreferenceManager.getDefaultSharedPreferences(appContext);
    }

    public String getString(String key) {
        return preferences.getString(key, defaultString);
    }

    public void putString(String key, String value) {
        if (key == null) {
            return;
        }
        if (value == null) {
            return;
        }
        preferences.edit().putString(key, value).apply();
    }


    public void putBoolean(String key, boolean value) {
        if (key == null) {
            return;
        }
        preferences.edit().putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }


    public void clear() {
        preferences.edit().clear().apply();
    }
}