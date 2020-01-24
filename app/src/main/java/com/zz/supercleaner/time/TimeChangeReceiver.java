package com.zz.supercleaner.time;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.zz.supercleaner.utils.AppPrefs;


/**
 * Created by wangyapeng on 14-4-15.
 */
public class TimeChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        SntpClock.offset = 0l;
        AppPrefs.saveTimeOffset(0l);
        SntpClock.syncTime(context);
    }
}
