package com.asuper.customviewpractice;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout stage;
    CustomView customview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stage = (FrameLayout) findViewById(R.id.stage);
        customview = new CustomView(this);
        stage.addView(customview);


        findViewById(R.id.btnBlack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customview.setColor(Color.BLACK);
            }
        });
        findViewById(R.id.btnYellow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customview.setColor(Color.YELLOW);
            }
        });
        findViewById(R.id.btnMagenta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customview.setColor(Color.MAGENTA);
            }
        });
        findViewById(R.id.btnCyna).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customview.setColor(Color.CYAN);
            }
        });
    }


}
