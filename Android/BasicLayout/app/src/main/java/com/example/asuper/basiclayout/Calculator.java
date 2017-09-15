package com.example.asuper.basiclayout;

import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity implements View.OnClickListener{

    // 사용할 위젯을 선언
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn_plus, btn_minus, btn_multiple, btn_devide, btn_equal, btn_clear, btn_parleft, btn_parright, btn_point;
    private TextView inputViewText, outputViewText;

    double result = 0.0;
    double input = 0.0;
    int calcCheck = 1;
    // calcCheck == 1   +
    // calcCheck == 2   -
    // calcCheck == 3   *
    // calcCheck == 4   /
    boolean check = false;
    // false == 계산 안한거
    // true == 계산 한거


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        setViewId();
        setListener();
    }

    // 화면과 소스코드를 ID로 연결
    private void setViewId() {
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multiple = (Button) findViewById(R.id.btn_multiple);
        btn_devide = (Button) findViewById(R.id.btn_devide);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_parleft = (Button) findViewById(R.id.btn_parleft);
        btn_parright = (Button) findViewById(R.id.btn_parright);
        btn_point = (Button) findViewById(R.id.btn_point);

        inputViewText = (TextView) findViewById(R.id.inputViewText);
        outputViewText = (TextView) findViewById(R.id.outputViewText);
    }

    private void setListener() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiple.setOnClickListener(this);
        btn_devide.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_parleft.setOnClickListener(this);
        btn_parright.setOnClickListener(this);
        btn_point.setOnClickListener(this);
    }


    /*@Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn0: append("0"); break;
            case R.id.btn1: append("1"); break;
            case R.id.btn2: append("2"); break;
            case R.id.btn3: append("3"); break;
            case R.id.btn4: append("4"); break;
            case R.id.btn5: append("5"); break;
            case R.id.btn6: append("6"); break;
            case R.id.btn7: append("7"); break;
            case R.id.btn8: append("8"); break;
            case R.id.btn9: append("9"); break;
            case R.id.btn_plus: append("+"); break;
            case R.id.btn_minus: append("-"); break;
            case R.id.btn_multiple: append("*"); break;
            case R.id.btn_devide: append("/"); break;
            case R.id.btn_parleft: append("("); break;
            case R.id.btn_parright: append(")"); break;
            case R.id.btn_point: append("."); break;
            case R.id.btn_clear:
                inputViewText.setText("0");
                outputViewText.setText("0");
                break;
            case R.id.btn_equal:
                double result = calc1();
                outputViewText.setText(""+result);
                break;
        }
    }

    private double calc1(){

        // 34 + 15 * 3 - 5 / 13

        // 1. 우선순위 없을경우

        // 2. 연산자 우선순위 있을경우

        // 가. 입력받을 때 단위별로 공백을 추가해서 받는다
        String target = "34 + 15 * - 5 / 3";
        ArrayList<String> subTarget = new ArrayList<>();
        // 나. 공백을 기준으로 split하면 연산자와 숫자가 구분된다.
        String calculTarget[] = target.split(" ");

        double front, back, subResult, result;
        // 다. 반복문에서 연산자를 기준로 * 와 /를 먼저 연산해서 결과값을 담아둔다.
        // 34 + 15 * 3 - 5 / 10
        // 34 + 45 - 0.5
        for(int i=0 ; i<calculTarget.length ; i++){
            if(calculTarget[i].equals("*") || calculTarget.equals("/")) {
                front = Double.parseDouble(subTarget.get(subTarget.size() - 1));
                back = Double.parseDouble(calculTarget[i + 1]);
                if(calculTarget[i].equals("*")){
                    subResult = front * back;
                }else{
                    subResult = front / back;
                }
                subTarget.remove(subTarget.size()-1);
                subTarget.add(subResult+"");
            }else{
                subTarget.add(calculTarget[i]);
            }
        }

        // 라. 다시 반복을 돌면서 + 와 - 연산을 해준다.
        // 34 + 45 - 0.5
        result = Double.parseDouble(subTarget.get(0));
        for(int k=0 ; k<subTarget.size()-1; k++){
            switch(subTarget.get(k)){
                case "+":
                    result += Double.parseDouble(subTarget.get(k+1));
                    break;
                case "-":
                    result -= Double.parseDouble(subTarget.get(k+1));
            }
        }
        return result;
    }

    private void calc2(){
        // 1. 저장소를 두개로 분리해서 선언
        ArrayList<Integer> numberArray = new ArrayList<>();
        ArrayList<Integer> otherArray = new ArrayList<>();

        // 2. 숫자가 입력되면 텍스트뷰에 숫자를 입력
        inputViewText.append("숫자값");

        // 3. 연산기호가 입력되면 이전에 입력됬던 숫자값을 numberArray에 입력
        //    연산기호 버튼의 실제아이디를 otherArray에 입력

        // 4. 연산기호를 입력했을 때만 배열에 숫자가 입력되므로
        //    마지막 숫자에 대한 처리가 필요

        // 5. 그리고 반복문으로 연산 우선순위에 따라 처리한다.
    }

    private void calc3(){
        String inputText      = "34+15*3-5/10";
        String splittedText[] = inputText.split("(?<=[+-])|?=[+-]");

        String temp[] = { "34", "+", "15", "*", "3", "-", "5", "-", "10"};
        ArrayList<String> result =  new ArrayList<>();
        for(String item : temp){
            if(item.equals("*") | item.equals("/")){
                // 결과값을 result에 add 한다...
            }
        }

        for(String item : result){
            if(item.equals("+") | item.equals("-")){
                // 결과값을 result에 add 한다...
            }
        }
    }

    private void append(String str){
        if(inputViewText.getText().toString().equals("0")){
            // 1. 처음에 연산자가 오면 예외처리
            if(str.equals("+") || str.equals("-")
                    || str.equals("*") || str.equals("/")){
                Toast.makeText(this
                        , "연산자를 먼저 입력할 수 없습니다!"
                        , Toast.LENGTH_SHORT).show();
                return;
                // 2. 연산자를 연속해서 입력하면 예외처리
            }else {
                inputViewText.setText("");
            }
        }
        inputViewText.append(str);
    }*/



    @Override
    public void onClick(View v) {
        if (v.getId() == btn0.getId()) {
            if(check == true) {
                inputViewText.setText("");
                input = 0.0;
                check = false;
            }
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("0");
            }else {
                inputViewText.setText(inputViewText.getText() + "0");
            }
            input = input * 10 + 0;
            outputViewText.setText("");
        }else if (v.getId() == btn1.getId()) {
            if(check == true) {
                inputViewText.setText("");
                input = 0.0;
                check = false;
            }
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("1");
            }else {
                inputViewText.setText(inputViewText.getText() + "1");
            }
            input = input * 10 + 1;
            outputViewText.setText("");
        }else if (v.getId() == btn2.getId()) {
            if(check == true) {
                inputViewText.setText("");
                input = 0.0;
                check = false;
            }
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("2");
            }else {
                inputViewText.setText(inputViewText.getText() + "2");
            }
            input = input * 10 + 2;
            outputViewText.setText("");
        }else if (v.getId() == btn3.getId()) {
            if(check == true) {
                inputViewText.setText("");
                input = 0.0;
                check = false;
            }
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("3");
            }else {
                inputViewText.setText(inputViewText.getText() + "3");
            }
            input = input * 10 + 3;
            outputViewText.setText("");
        }else if (v.getId() == btn4.getId()) {
            if(check == true) {
                inputViewText.setText("");
                input = 0.0;
                check = false;
            }
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("4");
            }else {
                inputViewText.setText(inputViewText.getText() + "4");
            }
            input = input * 10 + 4;
            outputViewText.setText("");
        }else if (v.getId() == btn5.getId()) {
            if(check == true) {
                inputViewText.setText("");
                input = 0.0;
                check = false;
            }
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("5");
            }else {
                inputViewText.setText(inputViewText.getText() + "5");
            }
            input = input * 10 + 5;
            outputViewText.setText("");
        }else if (v.getId() == btn6.getId()) {
            if(check == true) {
                inputViewText.setText("");
                input = 0.0;
                check = false;
            }
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("6");
            }else {
                inputViewText.setText(inputViewText.getText() + "6");
            }
            input = input * 10 + 6;
            outputViewText.setText("");
        }else if (v.getId() == btn7.getId()) {
            if(check == true) {
                inputViewText.setText("");
                input = 0.0;
                check = false;
            }
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("7");
            }else {
                inputViewText.setText(inputViewText.getText() + "7");
            }
            input = input * 10 + 7;
            outputViewText.setText("");
        }else if (v.getId() == btn8.getId()) {
            if(check == true) {
                inputViewText.setText("");
                input = 0.0;
                check = false;
            }
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("8");
            }else {
                inputViewText.setText(inputViewText.getText() + "8");
            }
            input = input * 10 + 8;
            outputViewText.setText("");
        }else if (v.getId() == btn9.getId()) {
            if(check == true) {
                inputViewText.setText("");
                input = 0.0;
                check = false;
            }
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("9");
            }else {
                inputViewText.setText(inputViewText.getText() + "9");
            }
            input = input * 10 + 9;
            outputViewText.setText("");
        }else if (v.getId() == btn_parleft.getId()) {
            if(check == true) {
                inputViewText.setText("");
                input = 0.0;
                check = false;
            }
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("(");
            }else {
                inputViewText.setText(inputViewText.getText() + "(");
            }
            outputViewText.setText("");
        }else if (v.getId() == btn_parright.getId()) {
            if(check == true) {
                inputViewText.setText("");
                input = 0.0;
                check = false;
            }
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText(")");
            }else {
                inputViewText.setText(inputViewText.getText() + ")");
            }
            outputViewText.setText("");
        }else if (v.getId() == btn_point.getId()) {
            if(check == true) {
                inputViewText.setText("");
                input = 0.0;
                check = false;
            }
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText(".");
            }else {
                inputViewText.setText(inputViewText.getText() + ".");
            }
            outputViewText.setText("");
        }else if (v.getId() == btn_plus.getId()) {
            if(check == true) {
                inputViewText.setText(outputViewText.getText() + "");
            }
            String imsi = inputViewText.getText() + "";
            if(imsi.equals("") || imsi.equals("0")) {
                return;
            }
            String imsi2 = imsi.charAt(imsi.length() - 1) + "";
            if(imsi2.equals("+") || imsi2.equals("-") || imsi2.equals("x") || imsi2.equals("/")) {
                inputViewText.setText(imsi.substring(0, imsi.length() - 1) +"+");
            } else {
                inputViewText.setText(inputViewText.getText() + "+");
            }
            calc();
            input = 0;
            calcCheck = 1;
            check = false;
            outputViewText.setText("");
        }else if (v.getId() == btn_minus.getId()) {
            if(check == true) {
                inputViewText.setText(outputViewText.getText() + "");
            }
            String imsi = inputViewText.getText() + "";
            if(imsi.equals("") || imsi.equals("0")) {
                return;
            }
            String imsi2 = imsi.charAt(imsi.length() - 1) + "";
            if(imsi2.equals("+") || imsi2.equals("-") || imsi2.equals("x") || imsi2.equals("/")) {
                inputViewText.setText(imsi.substring(0, imsi.length() - 1) +"-");
            } else {
                inputViewText.setText(inputViewText.getText() + "-");
            }
            calc();
            input = 0;
            calcCheck = 2;
            check = false;
            outputViewText.setText("");
        }else if (v.getId() == btn_multiple.getId()) {
            if(check == true) {
                inputViewText.setText(outputViewText.getText() + "");
            }
            String imsi = inputViewText.getText() + "";
            if(imsi.equals("") || imsi.equals("0")) {
                return;
            }
            String imsi2 = imsi.charAt(imsi.length() - 1) + "";
            if(imsi2.equals("+") || imsi2.equals("-") || imsi2.equals("x") || imsi2.equals("/")) {
                inputViewText.setText(imsi.substring(0, imsi.length() - 1) +"x");
            } else {
                inputViewText.setText(inputViewText.getText() + "x");
            }
            calc();
            input = 0;
            calcCheck = 3;
            check = false;
            outputViewText.setText("");
        }else if (v.getId() == btn_devide.getId()) {
            if(check == true) {
                inputViewText.setText(outputViewText.getText() + "");
            }
            String imsi = inputViewText.getText() + "";
            if(imsi.equals("") || imsi.equals("0")) {
                return;
            }
            String imsi2 = imsi.charAt(imsi.length() - 1) + "";
            if(imsi2.equals("+") || imsi2.equals("-") || imsi2.equals("x") || imsi2.equals("/")) {
                inputViewText.setText(imsi.substring(0, imsi.length() - 1) +"/");
            } else {
                inputViewText.setText(inputViewText.getText() + "/");
            }
            calc();
            input = 0;
            calcCheck = 4;
            check = false;
            outputViewText.setText("");
        }else if (v.getId() == btn_equal.getId()) {
            if(result == 0.0) {
                return;
            }
            String imsi = inputViewText.getText() + "";
            if(imsi.equals("") || imsi.equals("0")) {
                return;
            }
            String imsi2 = imsi.charAt(imsi.length() - 1) + "";
            if(imsi2.equals("+") || imsi2.equals("-") || imsi2.equals("x") || imsi2.equals("/")) {
                return;
            } else {
                calc();
                if(result % 1 == 0) {
                    outputViewText.setText((int)result + "");
                }else {
                    result = Math.round(result * 10000);
                    result /= 10000;
                    outputViewText.setText(result + "");
                }
                inputViewText.setText("");

                input = result;
                result = 0;
                calcCheck = 1;
                check = true;
            }
        }else if (v.getId() == btn_clear.getId()) {
            inputViewText.setText("");
            outputViewText.setText("");
            result = 0;
            input = 0;
            calcCheck = 1;
            check = false;
        }

    }

    public void calc() {
        if(calcCheck == 1) {
            result += input;
        }else if(calcCheck == 2) {
            result -= input;
        }else if(calcCheck == 3) {
            result *= input;
        }else if(calcCheck == 4) {
            result /= input;
        }
    }

}