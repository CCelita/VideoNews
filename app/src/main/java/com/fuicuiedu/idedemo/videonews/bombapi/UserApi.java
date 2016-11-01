package com.fuicuiedu.idedemo.videonews.bombapi;

import com.fuicuiedu.idedemo.videonews.bombapi.entity.UserEntity;
import com.fuicuiedu.idedemo.videonews.bombapi.result.UserResult;

import okhttp3.Call;


/**
 * Created by Administrator on 2016/10/31 0031.
 */

public interface UserApi {

    //登录
    Call Login(String username, String password);
    //注册
    Call Register(UserEntity userEntity);

}
