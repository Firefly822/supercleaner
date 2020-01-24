package com.zz.supercleaner.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.zz.supercleaner.MyApplication;

public class SPUtil {

    public static SharedPreferences sp;

    public static void initSP(Context context) {
        if (sp == null) {
            sp = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    public static void checkSP() {
        if (sp == null) {
            initSP(MyApplication.getAppContext());
        }
    }

    public static boolean getBoolean(String key, boolean value) {
        checkSP();
        return sp.getBoolean(key, value);
    }

    public static int getInt(String key, int defValue) {
        checkSP();
        return sp.getInt(key, defValue);
    }

    public static String getString(String key, String defValue) {
        checkSP();
        return sp.getString(key, defValue);
    }

    public static long getLong(String key, long defValue) {
        checkSP();
        return sp.getLong(key, defValue);
    }

    public static boolean save(String key, boolean value) {
        checkSP();
        return sp.edit().putBoolean(key, value).commit();
    }

    public static boolean save(String key, int value) {
        checkSP();
        return sp.edit().putInt(key, value).commit();
    }

    public static boolean save(String key, long value) {
        checkSP();
        return sp.edit().putLong(key, value).commit();
    }

    public static boolean save(String key, float value) {
        checkSP();
        return sp.edit().putFloat(key, value).commit();
    }

    public static boolean save(String key, String value) {
        checkSP();
        return sp.edit().putString(key, value).commit();
    }

    public static boolean remove(String key) {
        checkSP();
        return sp.edit().remove(key).commit();
    }

    public static float getFloat(String key) {
        checkSP();
        return sp.getFloat(key, 0f);
    }

    public static boolean save(String key, double value) {
        checkSP();
        return sp.edit().putString(key, String.valueOf(value)).commit();
    }

    public static double getDouble(String key) {
        checkSP();
        double value = 0d;
        try {
            String string = sp.getString(key, "0");
            value = Double.parseDouble(string);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return value;
    }
}
