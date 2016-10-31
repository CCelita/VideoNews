package com.fuicuiedu.idedemo.videonews.bombapi.entity;

/**
 * Created by Administrator on 2016/10/31 0031.
 */

public class UserEntity extends BaseEntity {


    private String username;//用户名
    private String password;//密码

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
