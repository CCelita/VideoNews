package com.fuicuiedu.idedemo.videonews.bombapi;

import com.fuicuiedu.idedemo.videonews.bombapi.entity.UserEntity;
import com.fuicuiedu.idedemo.videonews.bombapi.result.UserResult;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * Created by Administrator on 2016/10/31 0031.
 */

public interface UserApi {

    //登录
    @GET("1/login")
    Call<UserResult> Login(@Query("username") String username,
               @Query("password") String password);
    //注册
    @POST("1/users")
    Call<UserResult> Register(@Body UserEntity userEntity);

}
