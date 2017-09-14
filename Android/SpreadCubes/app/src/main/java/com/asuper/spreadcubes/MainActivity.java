package com.asuper.spreadcubes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnSpread;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        btnSpread.setOnClickListener(this);
    }

    private void initView() {
        btnSpread = (Button) findViewById(R.id.btnSpread);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
    }

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
    }
}
