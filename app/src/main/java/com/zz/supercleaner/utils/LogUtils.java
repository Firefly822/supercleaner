package com.zz.supercleaner.utils;

import android.text.TextUtils;
import android.util.Log;

import com.zz.supercleaner.BuildConfig;


/**
 * 客户端打log的工具，基本为Log.d
 * Created by liuxu on 14-11-20.
 */
public class LogUtils {

    private static final boolean mIsDebug = BuildConfig.DEBUG;

    public static void i(String tag, String... message) {
        if (mIsDebug) {

            StringBuilder msg = new StringBuilder();
            for(String s: message) {
                if(!TextUtils.isEmpty(s)) {
                    msg.append(s);
                }
            }

            String finalMsg = msg.toString();

            if (!TextUtils.isEmpty(tag) && !TextUtils.isEmpty(finalMsg)) {
                log(Log.INFO, tag, finalMsg);
            }
        }
    }

    public static void v(String tag, String... message) {
        if (mIsDebug) {

            StringBuilder msg = new StringBuilder();
            for(String s: message) {
                if(!TextUtils.isEmpty(s)) {
                    msg.append(s);
                }
            }

            String finalMsg = msg.toString();

            if (!TextUtils.isEmpty(tag) && !TextUtils.isEmpty(finalMsg)) {
                log(Log.VERBOSE, tag, finalMsg);
            }
        }
    }

    public static void w(String tag, String... message) {
        if (mIsDebug) {

            StringBuilder msg = new StringBuilder();
            for(String s: message) {
                if(!TextUtils.isEmpty(s)) {
                    msg.append(s);
                }
            }

            String finalMsg = msg.toString();

            if (!TextUtils.isEmpty(tag) && !TextUtils.isEmpty(finalMsg)) {
                log(Log.WARN, tag, finalMsg);
            }
        }
    }

    public static void d(String tag, String... message) {
        if (mIsDebug) {

            StringBuilder msg = new StringBuilder();
            for(String s: message) {
                if(!TextUtils.isEmpty(s)) {
                    msg.append(s);
                }
            }

            String finalMsg = msg.toString();

            if (!TextUtils.isEmpty(tag) && !TextUtils.isEmpty(finalMsg)) {
                log(Log.DEBUG, tag, finalMsg);
            }
        }
    }

    public static void d(String tag, Object obj) {
        if (mIsDebug) {
            if (!TextUtils.isEmpty(tag) && obj != null) {
                log(Log.DEBUG, tag, obj.toString());
            }
        }
    }

    /**
     * msg的形式为msg加上obj的toString。
     *
     * @param tag
     * @param msg
     * @param obj
     */
    public static void d(String tag, String msg, Object obj) {
        if (mIsDebug) {
            if (!TextUtils.isEmpty(tag) && obj != null) {
                log(Log.DEBUG, tag, msg + obj.toString());
            }
        }
    }

    public static void e(String tag, String msg) {
//        if (mIsDebug) {
        if (!TextUtils.isEmpty(tag) && !TextUtils.isEmpty(msg)) {
            log(Log.ERROR, tag, msg);
        }
//        }
    }

    public static void e(String tag, Object obj) {
        if (mIsDebug) {
            if (!TextUtils.isEmpty(tag) && obj != null) {
                log(Log.ERROR, tag, obj.toString());
            }
        }
    }

    public static void df(String tag, String fmt, Object... args) {
        if(mIsDebug) {
            String message = String.format(fmt, args);
            log(Log.DEBUG, tag, message);
        }
    }

    public static void ef(String tag, String fmt, Object... args) {
        String message = String.format(fmt, args);
        log(Log.ERROR, tag, message);
    }

    private static void log(int type, String tag, String msg){
        switch (type){
            case Log.INFO:
                Log.i(tag, msg);
                break;
            case Log.DEBUG:
                Log.d(tag, msg);
                break;
            case Log.VERBOSE:
                Log.v(tag, msg);
                break;
            case Log.ERROR:
                Log.e(tag, msg);
                break;
            case Log.WARN:
                Log.w(tag, msg);
                break;
            default:
                break;
        }
    }
}
