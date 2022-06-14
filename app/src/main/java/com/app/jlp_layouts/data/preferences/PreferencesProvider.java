package com.app.jlp_layouts.data.preferences;/*
 * Created by Sandeep(Techno Learning) on 13,June,2022
 */

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesProvider implements PreferencesHelper {

    private static String SHARED_PREFERENCES = "JLP_Preferences";
    private static final String PREF_KEY_DEVICE_NAME = "DEVICE_NAME";


    private static SharedPreferences sPreferences;

    public static SharedPreferences providePreferences() {
        return sPreferences;
    }

    public static void init(Context context) {
        sPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public String getDeviceName() {
        return sPreferences.getString(PREF_KEY_DEVICE_NAME, null);
    }

    @Override
    public void setDeviceName(String deviceName) {
        sPreferences.edit().putString(PREF_KEY_DEVICE_NAME, deviceName).apply();
    }
}
