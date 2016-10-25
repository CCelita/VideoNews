package com.fuicuiedu.idedemo.videoplayer.part;

import android.content.Context;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fuicuiedu.idedemo.videoplayer.R;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;

/**
 * Created by Administrator on 2016/10/25 0025.
 */

public class SimpleVideoView extends FrameLayout {

    private String videoPath;//视频播放的url\
    private Boolean isPlaying;//是否正在播放
    private Boolean isPrepared;//是否准备好

    private MediaPlayer mediaPlayer;

    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private ImageView ivPreview;//预览图
    private ImageButton btnToggle;//播放，暂停
    private ProgressBar progressBar;//进度条

    public SimpleVideoView(Context context) {
        this(context,null);
    }

    public SimpleVideoView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public SimpleVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //视图初始化，只在构造方法中调用一次
    private void init() {
        //Vitamio的初始化
        Vitamio.isInitialized(getContext());
        //inflate初始当前视图内容
        LayoutInflater.from(getContext()).inflate(R.layout.view_simple_video_player,this,true);
        initSurfaceView(); // 初始化SurfaceView
        initControllerViews(); // 初始化视频播放控制视图
    }

    // 初始化视频播放控制视图
    private void initControllerViews() {
        //预览图
        ivPreview = (ImageView) findViewById(R.id.ivPreview);
        //播放，暂停
        btnToggle = (ImageButton) findViewById(R.id.btnToggle);
        btnToggle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    pauseMediaPlayer();
                } else if (isPrepared){
                    startMediaPlater();
                }else {
                    Toast.makeText(getContext(),"Can't player now", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // 初始化SurfaceView
    private void initSurfaceView() {
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        //设置pixelformat
        surfaceHolder.setFormat(PixelFormat.RGBA_8888);
    }


    //对播放资源进行设置
    public void setVideoPath(String videoPath){
        this.videoPath = videoPath;
    }

    //生命周期的控制
    // 用来初始状态
    public void onResume(){

    }

    // 用来释放状态
    public void onPause(){

    }
}
