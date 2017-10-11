package com.asuper.raindrop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 10/10/2017.
 */

public class CustomView extends View {
    Paint paint;
    List<RainDrop> rainDrops = new ArrayList<>();
    public CustomView(Context context) {
        super(context);
        // 색지정
        paint = new Paint();
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(rainDrops.size() > 0) {
            for(RainDrop rainDrop : rainDrops) {
                paint.setColor(rainDrop.color);
                canvas.drawCircle(rainDrop.x
                        , rainDrop.y
                        , rainDrop.size
                        , paint);
            }
        }
    }

    public void addRainDrop(RainDrop rainDrop){
        this.rainDrops.add(rainDrop);
        rainDrop.start();
    }

    public void runStage(){
        new Thread(){
            public void run(){
                while(MainActivity.runFlag){
                    postInvalidate();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
