package com.example.asuper.basiclayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// 안드로이드 화면 구조          Fragment(화면조각)
// App(어플) > Activity(화면한개단위) > Layout(뷰그룹 : 컨테이너) > Widget(뷰)

public class Calculator extends AppCompatActivity {
    // Activity 기반 클래스를
    // 상속받아서 구성된다.

    // 레이아웃에 정의된 위젯의 아이디로 해당 객체를 변수에 저장해둔다.
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn_plus, btn_minus, btn_multiple, btn_devide, btn_equal, btn_clear;
    TextView txtTitle, inputText, outputText;
    //boolean calcCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // 위에서 저장한 변수를 사용

        // 0. 레이아웃 xml 파일을 메모리에 로드
        setContentView(R.layout.activity_calculator);

        // 1. 내가 사용할 객체들을 가져오고

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        inputText = (TextView) findViewById(R.id.inputText);
        outputText = (TextView) findViewById(R.id.outputText);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn3);
        btn5 = (Button) findViewById(R.id.btn3);
        btn6 = (Button) findViewById(R.id.btn3);
        btn7 = (Button) findViewById(R.id.btn3);
        btn8 = (Button) findViewById(R.id.btn3);
        btn9 = (Button) findViewById(R.id.btn3);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multiple = (Button) findViewById(R.id.btn_multiple);
        btn_devide = (Button) findViewById(R.id.btn_devide);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_clear = (Button) findViewById(R.id.btn_clear);


        // 2. 이벤트(캐치, 터치) 필요할 경우는 리스터를 달아준다.
        // 3. 위에서 지정한 변수를 사용
        // 아래에 선언한 실행객체를 리스너에 던져준다.

        btn0.setOnClickListener(onClickListener);
        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        btn4.setOnClickListener(onClickListener);
        btn5.setOnClickListener(onClickListener);
        btn6.setOnClickListener(onClickListener);
        btn7.setOnClickListener(onClickListener);
        btn8.setOnClickListener(onClickListener);
        btn9.setOnClickListener(onClickListener);
        btn_plus.setOnClickListener(onClickListener);
        btn_minus.setOnClickListener(onClickListener);
        btn_multiple.setOnClickListener(onClickListener);
        btn_devide.setOnClickListener(onClickListener);
        btn_equal.setOnClickListener(onClickListener);
        btn_clear.setOnClickListener(onClickListener);

        /*
        findViewById(R.id.btn1).setOnClickListener(onClickListener);
        findViewById(R.id.btn2).setOnClickListener(onClickListener);
        findViewById(R.id.btn4).setOnClickListener(onClickListener);
        findViewById(R.id.btn5).setOnClickListener(onClickListener);
        findViewById(R.id.btn6).setOnClickListener(onClickListener);
        findViewById(R.id.btn7).setOnClickListener(onClickListener);
        findViewById(R.id.btn8).setOnClickListener(onClickListener);
        findViewById(R.id.btn9).setOnClickListener(onClickListener);
        findViewById(R.id.btn_plus).setOnClickListener(onClickListener);
        findViewById(R.id.btn_minus).setOnClickListener(onClickListener);
        findViewById(R.id.btn_multiple).setOnClickListener(onClickListener);
        findViewById(R.id.btn_devide).setOnClickListener(onClickListener);
        findViewById(R.id.btn_equal).setOnClickListener(onClickListener);
        findViewById(R.id.btn_clear).setOnClickListener(onClickListener);
        */
    }



    // 리스너를 전역 변수로 선언할 수 있다.
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId() == btn1.getId()) {

            } else if(v.getId() == btn1.getId()) {}
        }
    };
}

