package com.fuicuiedu.idedemo.videonews;

import android.app.Application;

import com.fuicuiedu.idedemo.videonews.commons.ToastUtils;

/**
 * Created by Administrator on 2016/10/28 0028.
 */

public class VideoNewsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtils.init(this);
    }
}
