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
import com.fuicuiedu.idedemo.videonews.bombapi.result.UserResult;
import com.fuicuiedu.idedemo.videonews.commons.ToastUtils;


import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_likes, container, false);
            ButterKnife.bind(this, view);
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
    public void register() {
        String username = mName.getText().toString();
        String password = mPass.getText().toString();
        UserEntity userEntity = new UserEntity(username, password);


        Call<UserResult> call = BombClient.getInstance().getUserApi().Register(userEntity);
        call.enqueue(new Callback<UserResult>() {
            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                if (response.isSuccessful()){
                    UserResult result = response.body();
                    Log.e("aaa","sessionToken = " + result.getSessionToken());
            }}

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {

            }
        });

    }

    //登录
    @OnClick(R.id.btnLogin)
    public void login() {
        String username = mName.getText().toString();
        String password = mPass.getText().toString();

        Call<UserResult> call = BombClient.getInstance().getUserApi().Login(username,password);
        call.enqueue(new Callback<UserResult>() {
            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                if (response.isSuccessful()){
                    UserResult userResult = response.body();
                    Log.e("bbb","token = " + userResult.getSessionToken());
                }
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {

            }
        });
    }
}
