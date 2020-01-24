package com.zz.supercleaner.model;

import android.text.TextUtils;

import com.zz.supercleaner.bean.response.UserInfo;
import com.zz.supercleaner.utils.AppPrefs;

public class LoginModel {
    private static final LoginModel instance = new LoginModel();

    public static LoginModel getInstance() {
        return instance;
    }

    private int dialCode;
    private String phone;
    private UserInfo info;

    private LoginModel() {
        info = AppPrefs.getUserInfo();
        if (info == null) {
            info = new UserInfo();
        }
    }

    public void setLoginInfo(int code, String phone) {
        this.dialCode = code;
        this.phone = phone;
    }

    public int getDialCode() {
        return dialCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setUserInfo(UserInfo info) {
        this.info = info;
        AppPrefs.saveUserInfo(info);
    }

    public boolean isLogin() {
        return info != null && !TextUtils.isEmpty(info.getSession());
    }

    public UserInfo getUserInfo() {
        return info;
    }
}
