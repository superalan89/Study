package com.asuper.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/*
    AscyncTask = 세 개의 기본함수를 지원하는 Thread

    1. onPreExecute : doInBackground() 함수가 실행되기 전에 실행되는 함수

    2. doInBackground : 백그라운드(sub thread) 에서 코드를 실행하는 함수 < 에만 sub thread
            v onPostExecute는 doInBackground로 부터 데이터를 받을 수 있다.

    3. onPostExecute : doInBackground() 함수가 실행된 후에 실행되는 함수

 */
public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        getServer("http://google.com");
    }

    private void getServer(String url) {
        AsyncTask<String,Void,String> task = new AsyncTask<String,Void,String>() {
            // 1. doInBackground 함수의 파라미터로 사용
            // 2. onProgressUpdate 함수의 파라미터로 사용
            //    주로 진행상태의 percent 값(int)으로 사용된다.
            // 3. doInBackground 의 리턴값이면서 onPostExecute 파라미터
            @Override
            protected String doInBackground(String... args) {
                String param1 = args[0];
                String result = Remote.getData(param1);
                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                // 전체 html 코드중에
                // <title> </title> 안에 있는 내용만 출력!
                String title = result.substring(
                        result.indexOf("<title>")+"<title>".length(),
                        result.indexOf("<title>"));
                textView.setText(result);
            }

        };
        task.execute(url);
    }
}