package com.fuicuiedu.idedemo.videonews;

import android.graphics.SurfaceTexture;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fuicuiedu.idedemo.videonews.bombapi.BombClient;
import com.fuicuiedu.idedemo.videoplayer.list.MediaPlayerManager;
import com.fuicuiedu.idedemo.videoplayer.part.SimpleVideoView;
//
//import org.apache.http.Header;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class TestAcitivity extends AppCompatActivity{

    @BindViews({R.id.textView,R.id.textView2})
    List<TextView> tvList;
    @BindViews({R.id.button,R.id.button2})
    List<Button> btnList;
    @BindView(R.id.button)      Button btn;
    @BindView(R.id.button2)     Button btn2;

    private Unbinder unbinder;

    static final ButterKnife.Action<TextView> HEHE = new ButterKnife.Action<TextView>() {
        @Override
        public void apply(@NonNull TextView view, int index) {
            view.setText("233333");
        }
    };

    //绑定资源
    @BindColor(R.color.colorPrimaryDark) int pDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_acitivity);

        unbinder = ButterKnife.bind(this);

        btn.setBackgroundColor(pDark);

        ButterKnife.apply(tvList,HEHE);

        ButterKnife.apply(btnList,View.ALPHA,0.0f);

    }

    @OnClick(R.id.button2)
    public void Click(){
        Toast.makeText(this,"点击了btn2",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();//解绑！

//        //客户端
//        HttpClient client = new DefaultHttpClient();
//
//        //get请求
//        HttpGet httpGet = new HttpGet();
//        httpGet.setURI(URI.create("www.baidu.com"));//路径
//        httpGet.setHeader("Accept - Language","zh-CN");//请求头
//        //没有请求体
//        .....
//
//        //post请求
//        HttpPost httpPost = new HttpPost();
//        httpPost.setURI(URI.create("www.baidu.com"));//路径
//        httpPost.setHeader("Accept - Language","zh-CN");//请求头
//        //需要请求体
//        httpPost.setEntity(new HttpEntity() {
//        });
//
//        //执行请求，拿到响应
//        try {
//            HttpResponse response = client.execute(httpGet);
//            //响应码
//            int code = response.getStatusLine().getStatusCode();
//            //判断是否成功
//            if (code >= 200 && code <300){
//                //响应体
//                HttpEntity httpEntity = response.getEntity();
//                httpEntity......
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
