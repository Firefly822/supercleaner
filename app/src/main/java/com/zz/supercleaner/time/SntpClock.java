package com.zz.supercleaner.time;

import android.content.Context;
import android.os.AsyncTask;

import com.zz.supercleaner.utils.AppPrefs;

/**
 * Created by wangyapeng on 14-4-15.
 */
public class SntpClock {
    public static final String[] NTP_SERVERS = new String[]{
            "hk.pool.ntp.org",
            "cn.pool.ntp.org",
            "tw.pool.ntp.org",
            "jp.pool.ntp.org",
            "pool.ntp.org",
            "asia.pool.ntp.org",
            "sg.pool.ntp.org",
            "ntp.nasa.gov"
    };

    public static final String PREF_KEY_TIME_OFFSET = "time_offset";
    public static long offset;

    public static long currentTimeMillis() {
        return System.currentTimeMillis() + offset;
    }
    public static long currentTime() {
        return currentTimeMillis()/1000;
    }
    private static AsyncTask<Void, Void, Object[]> task;

    public static void syncTime(final Context context) {
        offset = AppPrefs.getTimeOffset();

        if (task == null) {
            task = new AsyncTask<Void, Void, Object[]>() {
                @Override
                protected Object[] doInBackground(Void... params) {
                    for (String host : NTP_SERVERS) {
                        SntpClient client = new SntpClient();
                        if (client.requestTime(host, 10000)) {
                            offset = client.getClockOffset();
                            AppPrefs.saveTimeOffset(offset);
                            return new Object[]{host, offset};
                        }
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Object[] objects) {
                    super.onPostExecute(objects);
                    if (objects != null) {
                        String host = (String) objects[0];
                        Long offset = (Long) objects[1];
                        //时间偏差超过一天
                        if (Math.abs(offset) > 24 * 3600 * 1000) {
//                            AnalyseUtils.mge("system", "SNTP_offset", host, offset.toString());
                        }
                    } else {
//                        LogDataUtil.saveLogInfo(
//                                new LogData(null, LogConstants.CODE_RETURN_SNTP_FAILED,
//                                        LogConstants.ACTION_RETURN_SNTP_FAILED, LogConstants.RETURN,
//                                        "", System.currentTimeMillis(), ""));
                    }
                    task = null;
                }
            };
            task.execute();
        }
    }
}
