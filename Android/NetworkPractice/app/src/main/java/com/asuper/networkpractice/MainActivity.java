package com.asuper.networkpractice;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    String data = "";
    Handler handler = new Handler() {
        @Override
        public  void handleMessage(Message msg) {
            switch (msg.what) {
                case 999:
                    setData();
                    break;
            }
        }
    };

    public void setData() { textView.setText(data);}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        NetworkWorking network = new NetworkWorking(handler);
        network.start();
    }

    class NetworkWorking extends Thread {
        Handler handler;
        public NetworkWorking(Handler handler) {this.handler = handler;}
        public void run() {
            final StringBuilder result = new StringBuilder();
            try {
                URL url = new URL ("http://google.co.kr");
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setRequestMethod("GET");

                if(con.getResponseCode() ==  HttpURLConnection.HTTP_OK) {
                    InputStreamReader isr = new InputStreamReader(con.getInputStream());
                    BufferedReader br = new BufferedReader(isr);
                    String temp = "";
                    while ((temp = br.readLine()) != null) {
                        result.append(temp).append("\n");
                    }
                    br.close();
                    isr.close();
                } else {
                    Log.e("ServerError", con.getResponseCode()+"");
                }
                con.disconnect();
            } catch (Exception e) {
                Log.e("Error", e.toString());
            }
            data = result.toString();
            handler.sendEmptyMessage(999);
        }
    }
}
