package com.example.goem.realtimesubway;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by GoEM on 2017-10-16.
 */

public class Remote {
    public static String getData(String string) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(string);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            // 통신이 성공인지 확인
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // 여기서 부터는 파일에서 데이터를 가져오는 것과 동일
                InputStreamReader isr = new InputStreamReader(con.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String temp = "";
                while (null != (temp = br.readLine())) {
                    result.append(temp);
                }
                br.close();
                isr.close();
            } else {
                Log.e("Server Error", String.valueOf(con.getResponseCode()));
            }
            con.disconnect();
        } catch (Exception e) {
            Log.e("Error", e.toString());
        }
        return result.toString();
    }
}
