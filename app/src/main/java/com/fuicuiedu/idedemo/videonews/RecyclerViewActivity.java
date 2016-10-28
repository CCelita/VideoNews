package com.fuicuiedu.idedemo.videonews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2016/10/28 0028.
 */

public class RecyclerViewActivity extends AppCompatActivity {
    @BindView(R.id.recycle_rcv) RecyclerView recyclerView;

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        unbinder = ButterKnife.bind(this);

        //设置布局
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
//        layoutManager.setOrientation(OrientationHelper.HORIZONTAL);
//        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        //设置adapter

        //设置分可线
        //设置item动画
        //点击事件接口实现（两个）

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();//解绑
    }
}
