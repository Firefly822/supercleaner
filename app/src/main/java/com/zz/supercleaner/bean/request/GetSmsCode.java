package com.zz.supercleaner.bean.request;

import com.zz.supercleaner.bean.BaseBean;

public class GetSmsCode extends BaseBean {
    public String zone;
    public String phone;
    public String code;

    public GetSmsCode() {
    }

    public GetSmsCode(String phone, String zone) {
        this.phone = phone;
        this.zone = zone;
    }
}
