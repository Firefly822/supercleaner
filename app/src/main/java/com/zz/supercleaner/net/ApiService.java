package com.zz.supercleaner.net;

import com.zz.supercleaner.BuildConfig;
import com.zz.supercleaner.bean.request.GetSmsCode;
import com.zz.supercleaner.bean.response.UserInfo;
import com.zz.supercleaner.net.converter.MyGsonConverterFactory;

import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class ApiService {

    public interface LoginService {

        @POST("api/sns/v1/lit/get_sms_code")
        Call<Result> getSmsCode(@Body GetSmsCode bean);

        @POST("api/sns/v1/lit/user/phone_login")
        Call<Result<UserInfo>> phoneLogin(@Body Map<String, String> data);

        @POST("api/sns/v1/lit/user/verify_nickname")
        Call<Result> verfiyNickName();

        @POST("api/sns/v1/lit/user/info")
        Call<Result> updateInfo(@Body Map<String, String> data);

        @POST("api/sns/v1/lit/user/{userId}")
        Call<Result> getUserInfo(@Path("userId") String userId);
    }

    public interface PicService {
        @POST("/lit/image/upload")
        Call<Result> uploadPic();
    }

    private static Retrofit retrofit;

    static {
        BasicParamsInterceptor basicParamsInterceptor = new BasicParamsInterceptor.Builder()
                .addQueryParam("sid","1")  // 添加公共版本号，加在 URL 后面
                .build();


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(basicParamsInterceptor).build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.litatom.com/")
                .client(client)
                .addConverterFactory(MyGsonConverterFactory.create())
                .build();
    }

    public static LoginService getLoginService() {
        return retrofit.create(LoginService.class);
    }

    public static PicService getPicService() {
        return retrofit.create(PicService.class);
    }
}
