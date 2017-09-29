package com.asuper.threadbasic;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    Rotater rotater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        rotater = new Rotater(handler);
        rotater.start();
    }

    // thread를 종료시키는 함수
    public void stop(View view){
        rotater.setStop();
    }

    public static final int ACTION_SET = 999;
    // seekbar를 변경하는 Handler 작성
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //super.handleMessage(msg);
            switch (msg.what){
                case ACTION_SET:
                    float curRot = button.getRotation();
                    button.setRotation(curRot + 6);
                    break;
            }
        }
    };
}

class Rotater extends Thread {
    Handler handler;
    boolean RUNNING = true;
    public Rotater(Handler handler){
        this.handler = handler;
    }

    public void run(){
        while(RUNNING){
            // 핸들러 측으로 메시지를 보낸다
            Message msg = new Message();
            msg.what = MainActivity.ACTION_SET;
            handler.sendMessage(msg);
            // 위와 같은 코드
            // handler.sendEmptyMessage(MainActivity.ACTION_SET)
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setStop(){
        RUNNING = false;
    }
}