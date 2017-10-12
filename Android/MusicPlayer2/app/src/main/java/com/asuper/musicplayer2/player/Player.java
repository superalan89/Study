package com.asuper.musicplayer2.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import com.asuper.musicplayer2.Const;

public class Player {
    //Singleton
    private static Player instance = new Player();
    private Player(){ }
    public static Player getInstance(){
        if(instance == null)
            instance = new Player();
        return instance;
    }
    // 멤버변수
    private MediaPlayer player = null;
    private boolean loop = false;
    private int status = Const.STAT_STOP;

    // 음원 세팅
    public void set(Context context, Uri musicUri){
        if(player != null) {
            player.release();
            player = null;
        }
        player = MediaPlayer.create(context, musicUri);
                            // musicUri에 해당하는 파일에 Stream을 꽂는다.
        player.setLooping(loop);
    }

    public void start(){
        if(player != null) {
            player.start();
            status = Const.STAT_PLAY;
        }
    }

    public void pause(){
        if(player != null) {
            player.pause();
            status = Const.STAT_PAUSE;
        }
    }

    public void stop(){
        if(player != null) {
            player.stop();
            player.release(); // 음악 파일에 꽂혀있는 Stream 을 해제한다.
            player = null;
            status = Const.STAT_STOP;
        }
    }

    public int getStatus(){
        return status;
    }

    public boolean isPlay(){
        if(player != null)
            return player.isPlaying();
        return false;
    }

    public int getCurrent(){
        if(player != null)
            return player.getCurrentPosition();
        return 0;
    }

    public int getDuration(){
        if(player != null)
            return player.getDuration();
        return 0;
    }
}
