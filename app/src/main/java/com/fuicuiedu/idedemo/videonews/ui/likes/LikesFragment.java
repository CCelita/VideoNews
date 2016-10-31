package com.fuicuiedu.idedemo.videonews.ui.likes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.fuicuiedu.idedemo.videonews.R;
import com.fuicuiedu.idedemo.videonews.bombapi.BombClient;
import com.fuicuiedu.idedemo.videonews.bombapi.entity.UserEntity;
import com.fuicuiedu.idedemo.videonews.commons.ToastUtils;


import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/10/28 0028.
 */

public class LikesFragment extends Fragment {
    private View view;

    @BindView(R.id.btnRegister)
    Button btnRegister;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.likes_username)
    EditText mName;
    @BindView(R.id.likes_password)
    EditText mPass;

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

        String username = mName.getText().toString();
        String password = mPass.getText().toString();

        UserEntity userEntity = new UserEntity(username,password);

        Call call = BombClient.getInstance().Register(userEntity);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("aaa","创建成功");
            }
        });
    }

    //登录
    @OnClick(R.id.btnLogin)
    public void login(){
        ToastUtils.showShort("注册");
    }
}
