package com.zz.supercleaner;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.zz.supercleaner.time.SntpClock;

public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        SntpClock.syncTime(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static Context getAppContext() {
        return context;
    }
}
