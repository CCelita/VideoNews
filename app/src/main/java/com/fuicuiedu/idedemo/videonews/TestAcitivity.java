package com.fuicuiedu.idedemo.videonews;

import android.graphics.SurfaceTexture;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;

import com.fuicuiedu.idedemo.videoplayer.list.MediaPlayerManager;
import com.fuicuiedu.idedemo.videoplayer.part.SimpleVideoView;

public class TestAcitivity extends AppCompatActivity
        implements TextureView.SurfaceTextureListener,
        MediaPlayerManager.OnPlaybackListener{

    private TextureView textureView;
    private MediaPlayerManager mediaPlayerManager;
    private Surface surface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_acitivity);

        textureView = (TextureView) findViewById(R.id.test_ttv);
        textureView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 判断surface是否初始化
                if (surface == null){
                    return;
                }
                String path = VideoUrlRes.getTestVideo1();
                String videoId = "1";
                mediaPlayerManager.startPlayer(surface,path,videoId);
            }
        });
        mediaPlayerManager = MediaPlayerManager.getInstance(this);

        //监听是否准备好，是否销毁等、、
        textureView.setSurfaceTextureListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayerManager.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayerManager.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayerManager.removeAllListeners();
    }

    //========================SurfaceTextureListener  start==================
    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        //surface初始化
        this.surface = new Surface(surface);
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        this.surface.release();
        this.surface=null;
        mediaPlayerManager.stopPlayer();
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
    }
    //========================SurfaceTextureListener  end==================

    //=====================OnPlaybackListener start================
    @Override
    public void onStartBuffering(String videoId) {

    }

    @Override
    public void onStopBuffering(String videoId) {

    }

    @Override
    public void onStartPlay(String videoId) {

    }

    @Override
    public void onStopPlay(String videoId) {

    }

    @Override
    public void onSizeMeasured(String videoId, int width, int height) {

    }
    //=====================OnPlaybackListener end================
}
