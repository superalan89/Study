package com.asuper.animation;

import android.animation.AnimatorInflater;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // 버튼을 선언
    private Button btnMove;
    private Button btnRotate;
    private Button btnScale;
    private Button btnAlpha;
    private Button object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }



    private void initView() {
        btnMove = (Button) findViewById(R.id.btnMove);
        btnRotate = (Button) findViewById(R.id.btnRotate);
        btnScale = (Button) findViewById(R.id.btnScale);
        btnAlpha = (Button) findViewById(R.id.btnAlpha);
        object = (Button) findViewById(R.id.object);
    }

    //클릭 리스너 등록
    private void initListener() {
        btnMove.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnAlpha.setOnClickListener(this);
        object.setOnClickListener(this);
    }

    //버튼 분기처리
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnMove : move(); break;
            case R.id.btnRotate : rotate(); break;
            case R.id.btnScale : scale(); break;
            case R.id.btnAlpha : alpha(); break;
            case R.id.object :
                Intent intent = new Intent(this, PropAniActivity.class);
            startActivity(intent);
        }
    }

    // 버튼에서 호출되는 함수 정의
    private void move() {
        // - View 애니메이션 실행하기
        // 1. 애니메이션 xml 정의
        // 2. Animation Util 정의된 애니메이션을 로드
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move);
        // 3. 로드된 애니메이션을 실제 위젯에 사용
        object.startAnimation(animation);
    }
    private void rotate() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        object.startAnimation(animation);
    }
    private void scale() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        object.startAnimation(animation);

    }
    private void alpha() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        object.startAnimation(animation);
    }

}
