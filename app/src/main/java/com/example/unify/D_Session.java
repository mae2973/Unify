package com.example.unify;
import android.content.Context;
import android.content.SharedPreferences;

public class D_Session {
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private static final String PREF_NAME = "session_pref";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_USER_TOKEN = "token";

    public D_Session(Context context) {
        int PRIVATE_MODE = 0;
        prefs = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = prefs.edit();
    }

    public void createLoginSession(String token) {
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.putString(KEY_USER_TOKEN, token);
        editor.commit();
    }

    public boolean isLoggedIn(){
        return prefs.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public String getUserToken(){
        return prefs.getString(KEY_USER_TOKEN, null);
    }

    public void logoutUser(){
        editor.clear();
        editor.commit();
    }
}
