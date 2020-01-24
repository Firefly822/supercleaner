package com.zz.supercleaner.net;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public abstract class ICallback<T> implements Callback<T> {
    public abstract void onSuccess(T object);
    public abstract void onFail(int code, String msg);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        }else {
            onFail(-1, "Data error");
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
        if (throwable instanceof ApiException) {
            onFail(((ApiException) throwable).getErrorCode(), throwable.getMessage());
            return;
        }
        String message = "Error Happen";
        if (throwable instanceof HttpException) {
            message = "Network Error";
        }else if (throwable instanceof IOException) {
            message = "Connect Error";
        }

        onFail(-1, message);
    }
}
