package com.asuper.customviewpractice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by super on 2017-09-18.
 */

public class CustomView extends View {

    ArrayList<Paint> paint = new ArrayList<>();
    ArrayList<Path> currentPath = new ArrayList<>();


    public CustomView(Context context) {
        super(context);
        Paint painttemp = new Paint();
        painttemp.setColor(Color.BLACK);
        painttemp.setStyle(Paint.Style.STROKE);
        painttemp.setStrokeWidth(10f);

        paint.add(painttemp);

        Path pathtemp = new Path();

        currentPath.add(pathtemp);
    }

    public void setColor(int color) {
        Paint painttemp = new Paint();
        painttemp.setColor(color);
        painttemp.setStyle(Paint.Style.STROKE);
        painttemp.setStrokeWidth(10f);

        paint.add(painttemp);
        currentPath.add(new Path());


    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        for (int a = 0; a < currentPath.size(); a++) {
            canvas.drawPath(currentPath.get(a), paint.get(a));
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case  MotionEvent.ACTION_DOWN:
                currentPath.get(currentPath.size() -1).moveTo(event.getX(), event.getY());
              break;
            case  MotionEvent.ACTION_MOVE:
                currentPath.get(currentPath.size() -1).lineTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_UP:
            break;

        }

        invalidate();

        return true;

    }

}
