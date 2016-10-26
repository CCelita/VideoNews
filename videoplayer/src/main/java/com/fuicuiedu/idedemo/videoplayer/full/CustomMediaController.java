package com.fuicuiedu.idedemo.videoplayer.full;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.fuicuiedu.idedemo.videoplayer.R;

import io.vov.vitamio.widget.MediaController;

/**
 * Created by Administrator on 2016/10/26 0026.
 */

public class CustomMediaController extends MediaController {
    private MediaPlayerControl mediaPlayerControl;//自定义视频控制器

    private final AudioManager audioManager;//音频管理
    private Window window;//视频亮度管理

    private final int maxVolume;//最大音量
    private int currentVolume;//当前音量
    private float currentBrightness;//当前亮度

    public CustomMediaController(Context context) {
        super(context);
        //拿到音频管理器
        audioManager = (AudioManager) context.getSystemService(context.AUDIO_SERVICE);
        //最大音量
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        //视频亮度管理
        window = ((Activity)context).getWindow();
    }

    //通过重写此方法，来自定义layout
    @Override
    protected View makeControllerView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_custom_video_controller,this);
        initView(view);
        return view;
    }

    //让我自定义的Controller可以控制mediaplayer
    @Override
    public void setMediaPlayer(MediaPlayerControl player) {
        super.setMediaPlayer(player);
        mediaPlayerControl = player;
    }

    private void initView(View view){
        //forward快进
        ImageButton btnFastForward = (ImageButton) view.findViewById(R.id.btnFastForward);
        btnFastForward.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                long postion = mediaPlayerControl.getCurrentPosition();
                postion += 10000;//快进10秒
                //快进的位置大于最大长度判断
                if (postion >= mediaPlayerControl.getDuration()){
                    postion = mediaPlayerControl.getDuration();
                }
                mediaPlayerControl.seekTo(postion);
            }
        });
        //rewind快退
        ImageButton btnFastRewind = (ImageButton) view.findViewById(R.id.btnFastRewind);
        btnFastRewind.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                long postion = mediaPlayerControl.getCurrentPosition();
                postion -= 10000;//快退10秒
                //快退的位置是否小于0秒
                if (postion <=0 ){
                    postion = 0;
                }
                mediaPlayerControl.seekTo(postion);
            }
        });
        // 调整视图（左边调整亮度，右边调整音量）
    }
}
