package com.fuicuiedu.idedemo.videonews.bombapi;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;

/**
 * Created by Administrator on 2016/10/31 0031.
 */

public class BombClient implements UserApi{
    private static BombClient bombClient;

    public static BombClient getInstance(){
        if (bombClient == null){
            bombClient = new BombClient();
        }
        return bombClient;
    }

    private OkHttpClient okHttpClient;

    private BombClient(){
        okHttpClient = new OkHttpClient();
    }

    @Override
    public Call Login() {
        Request request = new Request.Builder()
                .url("https://github.com/wxcican")
                .build();
        return okHttpClient.newCall(request);
    }

    @Override
    public Call Register() {
        Request request = new Request.Builder()
                .url("www.baidu.com")
                .build();
        return null;
    }


}
