package com.asuper.raindrop;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    FrameLayout stage;
    CustomView view;
    public static boolean runFlag = true;
    int width = 0;
    int height = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stage = (FrameLayout)findViewById(R.id.stage);
        view = new CustomView(this);
        stage.addView(view);

        // 화면을 지속적으로 다시 그려준다
        view.runStage();

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels;
    }

    public void addRainDrop(View v){
        Random random = new Random();

        int x = random.nextInt(width);
        int speed = random.nextInt(30)+10;
        int size = random.nextInt(100);

        RainDrop rainDrop = new RainDrop(x, 0, speed, size, Color.RED, height);
        view.addRainDrop(rainDrop);
    }

    /*private void run(){
        new Thread() {
            public void run() {
                while (runFlag) {
                    view.y = view.y + 10;
                    view.postInvalidate();

                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }*/

    @Override
    protected void onDestroy() {
        runFlag=false;
        super.onDestroy();
    }
}

class RainDrop extends Thread{
    // 속성
    float x;
    float y;
    float speed;
    float size;
    int color;
    // 생명주기 - 바닥에 닿을때 까지
    float limit;

    // 기능
    public void run(){
        while(y < limit) {
            y = y + speed;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public RainDrop(float x, float y, float speed, float size, int color, float limit){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.size = size;
        this.color = color;
        this.limit = limit;
    }
}