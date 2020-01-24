package com.zz.supercleaner.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.zz.supercleaner.bean.response.UserInfo;

/**
 * Created by wangyapeng on 15/10/9.
 */
public class AppPrefs {

    private static final String SP_TIME_OFFSET = "sp_time_offset";
    private static final String SP_USER = "sp_user_info";

    public static long getTimeOffset() {
        return SPUtil.getLong(SP_TIME_OFFSET, 0);
    }

    public static void saveTimeOffset(long offset) {
        SPUtil.save(SP_TIME_OFFSET, offset);
    }

    public static void saveUserInfo(UserInfo info) {
        SPUtil.save(SP_USER, new Gson().toJson(info));
    }

    public static UserInfo getUserInfo() {
        String json = SPUtil.getString(SP_USER, "");
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        return new Gson().fromJson(json, UserInfo.class);
    }

}
