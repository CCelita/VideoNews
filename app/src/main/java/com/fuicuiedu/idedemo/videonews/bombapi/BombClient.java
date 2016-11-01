package com.fuicuiedu.idedemo.videonews.bombapi;

import com.fuicuiedu.idedemo.videonews.bombapi.entity.UserEntity;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.BufferedSink;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2016/10/31 0031.
 */

public class BombClient implements UserApi {
    private static BombClient bombClient;

    public static BombClient getInstance() {
        if (bombClient == null) {
            bombClient = new BombClient();
        }
        return bombClient;
    }

    private OkHttpClient okHttpClient;
    private Gson gson;
    private Retrofit retrofit;

    private BombClient() {
        gson = new Gson();

        //拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        //拦截器级别
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new BombInterceptor())//用来统一处理bomb必要头字段信息
                .addInterceptor(httpLoggingInterceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.bmob.cn/")
                .build();

        //生成UserApi接口实现
        UserApi userApi = retrofit.create(UserApi.class);
    }


    @Override
    public Call Login(String username, String password) {
        Request request = new Request.Builder()
                .url("https://api.bmob.cn/1/login")
                .build();

        return okHttpClient.newCall(request);
    }

    @Override
    public Call Register(UserEntity userEntity) {
        Request request = new Request.Builder()
                .post(RequestBody.create(null, gson.toJson(userEntity)))
                .url("https://api.bmob.cn/1/users")
                .build();
        return okHttpClient.newCall(request);
    }



}
