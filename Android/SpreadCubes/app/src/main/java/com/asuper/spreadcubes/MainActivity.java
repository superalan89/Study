package com.asuper.spreadcubes;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    Button btnSpread;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSpread = (Button) findViewById(R.id.btnSpread);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        //initView();
        //initListener();
    }

    /*private void initListener() {
        btnSpread.setOnClickListener(this);
    }

    private void initView() {
        btnSpread = (Button) findViewById(R.id.btnSpread);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
    }*/

    /*
    @Override
    public void onClick(View view) {

        if (count==0) {
            btnSpread.setText("Combine");
            count = 1;
            switch (view.getId()) {
                case R.id.btnSpread : spread(); spread2(); spread3(); spread4(); break;
            }
        } else if (count == 1) {
            btnSpread.setText("Spread");
            count = 0;
            switch (view.getId()) {
                case R.id.btnSpread : combine(); combine2(); combine3(); combine4(); break;
            }
        }


    }

    private void spread() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.spread);
        btn1.startAnimation(animation);
    }

    private void spread2() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.spread2);
        btn2.startAnimation(animation);
    }

    private void spread3() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.spread3);
        btn3.startAnimation(animation);
    }

    private void spread4() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.spread4);
        btn4.startAnimation(animation);
    }

    private void combine() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.combine);
        btn1.startAnimation(animation);
    }

    private void combine2() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.combine2);
        btn2.startAnimation(animation);
    }

    private void combine3() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.combine3);
        btn3.startAnimation(animation);
    }

    private void combine4() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.combine4);
        btn4.startAnimation(animation);
    }*/

    public void clickButton (View v) {
        if (count == 1) {
            setAnimator(btn1);
            setAnimator(btn2);
            setAnimator(btn3);
            setAnimator(btn4);
            count = 2;
            btnSpread.setText("Combine");
        } else if (count == 2) {
            setAnimator(btn1);
            setAnimator(btn2);
            setAnimator(btn3);
            setAnimator(btn4);
            count = 1;
            btnSpread.setText("Spread");
        }
    }

    private void setAnimator(Button b) {
        float x = 0;
        float y = 0;
        int rot;


        if(count==1) {
            if (b.getId() == btn1.getId()) {
                x = 300;
                y = 300;
            } else if (b.getId() == btn2.getId()) {
                x = 300;
                y = -300;
            } else if (b.getId() == btn3.getId()) {
                x = -300;
                y = 300;
            } else {
                x = -300;
                y = -300;
            }
            rot = 1800;
        } else {
            rot = 0;
        }
        ObjectAnimator aniX = ObjectAnimator.ofFloat(b, "translationX", x);
        ObjectAnimator aniY = ObjectAnimator.ofFloat(b, "translationY", y);
        ObjectAnimator rotation = ObjectAnimator.ofFloat(b, "rotation", rot);
        rotation.setDuration(3000);
        aniX.setDuration(2000);
        aniY.setDuration(2000);
        AnimatorSet aniSet = new AnimatorSet();
        aniSet.playTogether(aniX, aniY, rotation);
        aniSet.setInterpolator(new AccelerateInterpolator());
        aniSet.start();
    }
}
