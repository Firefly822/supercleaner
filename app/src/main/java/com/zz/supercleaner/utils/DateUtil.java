package com.zz.supercleaner.utils;


import com.zz.supercleaner.time.SntpClock;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by wangyapeng on 15/9/17.
 */
public class DateUtil {
    public static final TimeZone china = TimeZone.getTimeZone("GMT+08:00");

    public static Date getStartOfDay() {
        return getStartOfDay(new Date(SntpClock.currentTimeMillis()));
    }

    public static Date getEndOfDay() {
        return getEndOfDay(new Date(SntpClock.currentTimeMillis()));
    }

    public static int getInterval(long start, long end){
        if(start>end){
            return 0;
        }
        return (int) ((end-start)/(24*60*60*1000));
    }

    public static Date getTomorrow(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(china);
        calendar.setTimeInMillis(SntpClock.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }


    public static Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(china);
        calendar.setTimeInMillis(date.getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(china);
        calendar.setTimeInMillis(date.getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

}
