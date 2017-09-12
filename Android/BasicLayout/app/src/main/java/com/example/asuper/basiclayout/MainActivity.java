package com.example.asuper.basiclayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.TextView;

// 안드로이드 화면 구조          Fragment(화면조각)
// App(어플) > Activity(화면한개단위) > Layout(뷰그룹 : 컨테이너) > Widget(뷰)

public class MainActivity extends AppCompatActivity {
    // Activity 기반 클래스를
    // 상속받아서 구성된다.

    // 레이아웃에 정의된 위젯의 아이디로 해당 객체를 변수에 저장해둔다.
    Button btnFrame, btnLinear, btnGrid, btnRelative, btnCalculator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 위에서 저장한 변수를 사용

        // 0. 레이아웃 xml 파일을 메모리에 로드
        setContentView(R.layout.activity_main);

        // 1. 내가 사용할 객체들을 가져오고
        btnFrame = (Button) findViewById(R.id.btnFrame);
        btnLinear = (Button) findViewById(R.id.btnLinear);
        btnGrid = (Button) findViewById(R.id.btnGrid);
        btnRelative = (Button) findViewById(R.id.btnRelative);
        btnCalculator = (Button) findViewById(R.id.btnCalculator);

        // 2. 이벤트(캐치, 터치) 필요할 경우는 리스터를 달아준다.
        // 3. 위에서 지정한 변수를 사용
        // 아래에 선언한 실행객체를 리스너에 던져준다.
        btnFrame.setOnClickListener(onClickListener);
        btnLinear.setOnClickListener(onClickListener);
        btnGrid.setOnClickListener(onClickListener);
        btnRelative.setOnClickListener(onClickListener);
        btnCalculator.setOnClickListener(onClickListener);

/*      줄여서 사용할수도 있음
        findViewById(R.id.btnFrame).setOnClickListener(onClickListener);
        findViewById(R.id.btnLinear).setOnClickListener(onClickListener);
        findViewById(R.id.btnGrid).setOnClickListener(onClickListener);
        findViewById(R.id.btnRelative).setOnClickListener(onClickListener);
        findViewById(R.id.btnCalculator).setOnClickListener(onClickListener);
        */
    }

    // 리스너를 전역 변수로 선언할 수 있다.
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 액티비티(메이저 컴포넌트) 실행
            // 1. 인텐트 (시스템에 전달되는 메세지 객체) 생성

            Intent intent = null;
            switch (v.getId()) {
                case R.id.btnFrame:
                    intent = new Intent(MainActivity.this, FrameActivity.class);
                    //                    컨텍스트        ,   타겟
                    break;
                case R.id.btnLinear:
                    intent = new Intent(MainActivity.this, LinearActivity.class);
                    break;
                case R.id.btnGrid:
                    intent = new Intent(MainActivity.this, GridActivity.class);
                    break;
                case R.id.btnRelative:
                    intent = new Intent(MainActivity.this, RelativeActivity.class);
                    break;
                case R.id.btnCalculator:
                    intent = new Intent(MainActivity.this, Calculator.class);
                    break;
            }
            // 2. 액티비티 실행요청
            startActivity(intent);
        }
    };
}

