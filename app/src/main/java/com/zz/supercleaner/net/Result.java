package com.zz.supercleaner.net;

import com.zz.supercleaner.bean.BaseBean;

public class Result <T> extends BaseBean {
    private boolean success;
    private int result;
    private String msg;
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isOk() {
        return result == 0;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", result=" + result +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}