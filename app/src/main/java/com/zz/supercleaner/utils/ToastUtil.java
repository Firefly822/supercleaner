package com.zz.supercleaner.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: colarking
 * Date: 13-12-22
 * Time: 下午3:15
 * To change this template use File | Settings | File Templates.
 */
public class ToastUtil {
    public static void show(Context mContext, String text, boolean shortShow) {
        Toast toast = Toast.makeText(mContext, text, shortShow ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG);
        toast.show();
    }

    public static void show(Context mContext, String text, boolean shortShow, int gravity) {
        Toast toast = Toast.makeText(mContext, text, shortShow ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG);
        toast.setGravity(gravity,0,0);
        toast.show();
    }

    public static void show(Context mContext, int resId, boolean shortShow) {
        String text = mContext.getString(resId);
        show(mContext, text, shortShow);
    }

}
