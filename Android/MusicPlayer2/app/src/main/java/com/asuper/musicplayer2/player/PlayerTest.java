package com.asuper.musicplayer2.player;

import android.media.MediaPlayer;
import android.net.Uri;

import com.asuper.musicplayer2.domain.Music;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by super on 2017-10-13.
 */


public class PlayerTest {

    // 음원 재생 기능
    MediaPlayer np;

    // 음원데이터
    List<Music> data;

    // 현재 플레이 되고 있는 음악정보
    int currentPosition = -1;

    // 리스너 저장소
    List<Listener> listeners = new ArrayList<>();

    // 리스너를 등록하는 명령어
    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    // 리스너 인터페이스
    public interface Listener {
        void setProgress();
    }

    // 데이터 구조체 또는 인터페이스
    public interface Music {
        Uri getMusicUri();
        int getDuration();
    }

    public class PlayerThread extends Thread {
        public void run() {
            while(true) {
                for(Listener listener : listeners) {
                    listener.setProgress();
                }
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
