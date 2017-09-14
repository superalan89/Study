package com.asuper.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;

public class JoyStickActivity extends AppCompatActivity implements View.OnClickListener{

    private FrameLayout layoutGround;
    private Button btnUp;
    private Button btnDown;
    private Button btnLeft;
    private Button btnRight;
    private Button player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joy_stick);
        initView();
        initListener();
    }

    private void initView() {
        btnUp = (Button) findViewById(R.id.btnUp);
        btnDown = (Button) findViewById(R.id.btnDown);
        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnRight = (Button) findViewById(R.id.btnRight);
        player = (Button) findViewById(R.id.player);
    }

    private void initListener(){
        btnUp.setOnClickListener(this);
        btnDown.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);
    }

    //버튼 분기처리
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnUp : up(); break;
            case R.id.btnDown : down(); break;
            case R.id.btnLeft : left(); break;
            case R.id.btnRight : right(); break;
        }
    }

    int playerX = 0;
    int playerY = 0;

    private void up(){
        playerY -= 100;
        move();
    }
    private void down(){
        playerY += 100;
        move();
    }
    private void left(){
        playerX -= 100;
        move();
    }
    private void right(){
        playerX += 100;
        move();
    }
    // 이동 애니메이션
    private void move() {
        ObjectAnimator aniY = ObjectAnimator.ofFloat(
                player, "translationY", playerY
        );

        ObjectAnimator aniX = ObjectAnimator.ofFloat(
                player, "translationX", playerX

        );
        AnimatorSet aniSet = new AnimatorSet();
        aniSet.playTogether(aniY, aniX);
        aniSet.start();
    }
}
