package com.asuper.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

public class PropAniActivity extends AppCompatActivity {

    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prop_ani);
        btnGo = (Button) findViewById(R.id.btnGo);
    }


    float y = 0;
    public void move (View view) {

        /*
        // 1. 대상을 정의한다. > btnGo
        // 2. 애니메이터를 설정한다.
        y = y + 100;
        ObjectAnimator ani = ObjectAnimator.ofFloat(
                btnGo,          // 가. 움직일 대상
                "translationY", // 나. 애니메이션 속성 (움직임)
                100             // 다. 속성 값 (위치일 경우는 거리)
        );
        // 3. 애니메이터를 실행한다.
        ani.start();
        */

        // 복합애니메이션
        ObjectAnimator aniY = ObjectAnimator.ofFloat(
                btnGo,          // 가. 움직일 대상
                "translationY", // 나. 애니메이션 속성 (움직임)
                100             // 다. 속성 값 (위치일 경우는 거리)
        );

        ObjectAnimator aniX = ObjectAnimator.ofFloat(
                btnGo,          // 가. 움직일 대상
                "translationY", // 나. 애니메이션 속성 (움직임)
                100             // 다. 속성 값 (위치일 경우는 거리)

        //

        );
        // 애니메이션 셋에 담아서 동시에 실행 할 수 있다.
        AnimatorSet aniSet = new AnimatorSet();
        aniSet.playTogether(aniY, aniX);
        aniSet.setDuration(1000);

        aniSet.setInterpolator(new LinearInterpolator());
        // 점점빠르게 : accelerate_interpolator
        // 점점 느리게 이동 : decelerate_interpolator
        // 위 둘을 동시에 : accelerate_decelerate_interpolator
        // 시작위치에서 조금 뒤로 당겼다 이동 : anticipate_interpolator
        // 도착위치를 조금 지나쳤다가 도착위치로 이동 : overshoot_interpolator
        // 위 둘을 동시에 : anticipate_overshoot_interpolator
        // 도착위치에 팅김 : bounce_interpolator
        aniSet.start();
    }

    public void goJoyStick(View view) {
        Intent intent = new Intent(this, JoyStickActivity.class);
        startActivity(intent);
    }

}
