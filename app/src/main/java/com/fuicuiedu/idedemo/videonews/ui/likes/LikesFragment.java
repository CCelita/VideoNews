package com.fuicuiedu.idedemo.videonews.ui.likes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fuicuiedu.idedemo.videonews.R;
import com.fuicuiedu.idedemo.videonews.commons.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2016/10/28 0028.
 */

public class LikesFragment extends Fragment {
    private View view;

    @BindView(R.id.btnRegister)
    Button btnRegister;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null){
            view = inflater.inflate(R.layout.fragment_likes,container,false);
            ButterKnife.bind(this,view);
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((ViewGroup) view.getParent()).removeView(view);
    }

    //注册
    @OnClick(R.id.btnRegister)
    public void register(){
        ToastUtils.showShort("注册");
    }

    //登录
    @OnClick(R.id.btnLogin)
    public void login(){
        ToastUtils.showShort("登录");
    }
}
