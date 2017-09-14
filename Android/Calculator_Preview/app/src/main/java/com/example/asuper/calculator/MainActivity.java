package com.example.asuper.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button button1, button2, button3, button4, button5, button6, button7,
            button8, button9, button0, button_run, button_plus, button_minus,
            button_multiple, button_divide, button_clear;

    TextView text_preview, text_result;


    String temp = "", temp_b = "";
    int a = 0, b = 0;
    int operator = 0; // 1 > + / 2 > - / 3 > * / 4 > / /
    boolean hit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindCal();
        listenerCal();

    }

    private void listenerCal() {

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button_clear.setOnClickListener(this);
        button_plus.setOnClickListener(this);
        button_minus.setOnClickListener(this);
        button_multiple.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_run.setOnClickListener(this);

    }

    private void bindCal() {

        text_preview = (TextView) findViewById(R.id.text_preview);
        text_result = (TextView) findViewById(R.id.text_result);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button_plus = (Button) findViewById(R.id.button_plus);
        button_minus = (Button) findViewById(R.id.button_minus);
        button_multiple = (Button) findViewById(R.id.button_multiple);
        button_divide = (Button) findViewById(R.id.button_divide);
        button_run = (Button) findViewById(R.id.button_run);
        button_clear = (Button) findViewById(R.id.button_clear);

    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {

            case R.id.button0:
                temp = temp + "0";

                if (hit == true) {
                    temp_b = temp_b + "0";
                }

                text_preview.setText(temp);
                check();

                break;

            case R.id.button1:
                temp = temp + "1";

                if (hit == true) {
                    temp_b = temp_b + "1";
                }

                text_preview.setText(temp);
                check();

                break;

            case R.id.button2:
                temp = temp + "2";

                if (hit == true) {
                    temp_b = temp_b + "2";
                }
                text_preview.setText(temp);

                check();

                break;

            case R.id.button3:
                temp = temp + "3";

                if (hit == true) {
                    temp_b = temp_b + "3";
                }

                text_preview.setText(temp);

                check();

                break;

            case R.id.button4:
                temp = temp + "4";

                if (hit == true) {
                    temp_b = temp_b + "4";
                }

                text_preview.setText(temp);
                check();

                break;

            case R.id.button5:
                temp = temp + "5";

                if (hit == true) {
                    temp_b = temp_b + "5";
                }

                text_preview.setText(temp);
                check();

                break;

            case R.id.button6:

                temp = temp + "6";

                if (hit == true) {
                    temp_b = temp_b + "6";
                }

                text_preview.setText(temp);
                check();


                break;

            case R.id.button7:
                temp = temp + "7";

                if (hit == true) {
                    temp_b = temp_b + "7";
                }

                text_preview.setText(temp);
                check();

                break;

            case R.id.button8:

                temp = temp + "8";

                if (hit == true) {
                    temp_b = temp_b + "8";
                }

                text_preview.setText(temp);
                check();

                break;

            case R.id.button9:

                temp = temp + "9";

                if (hit == true) {
                    temp_b = temp_b + "9";
                }

                text_preview.setText(temp);
                check();

                break;

            case R.id.button_clear:

                temp = "";
                temp_b = "";
                a = 0;
                b = 0;
                hit = false;
                text_preview.setText(temp);
                check();

                break;

            case R.id.button_plus:

                a = Integer.parseInt(temp);
                temp = temp + "+";
                text_preview.setText(temp);
                hit = true;
                operator = 1;
                check();

                break;

            case R.id.button_minus:
                a = Integer.parseInt(temp);

                temp = temp + "-";
                text_preview.setText(temp);
                hit = true;
                operator = 2;
                check();

                break;

            case R.id.button_multiple:
                a = Integer.parseInt(temp);

                temp = temp + "*";
                text_preview.setText(temp);
                hit = true;
                operator = 3;
                check();

                break;

            case R.id.button_divide:
                a = Integer.parseInt(temp);

                temp = temp + "/";
                text_preview.setText(temp);
                hit = true;
                operator = 4;
                check();

                break;


            case R.id.button_run:
                b = Integer.parseInt(temp_b);


                if (operator == 1) {
                    text_result.setText(a + b + "");
                }
                if (operator == 2) {
                    text_result.setText(a - b + "");
                }
                if (operator == 3) {
                    text_result.setText(a * b + "");
                }
                if (operator == 4) {
                    text_result.setText(a / b + "");
                }
                check();
                break;

        }
    }

    private void check() {
        Log.d("TAG","=====================a : "+a);
        Log.d("TAG","=====================b : "+b);
        Log.d("TAG","=====================temp : "+temp);
        Log.d("TAG","=====================temp_b : "+temp_b);
    }
}
