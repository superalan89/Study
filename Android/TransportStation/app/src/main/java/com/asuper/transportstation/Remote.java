package com.asuper.transportstation;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by super on 2017-10-17.
 */

public class Remote {
    public static String getData(String string){
        final StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(string);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
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
        }catch(Exception e){
            Log.e("Error", e.toString());
        }
        return result.toString();
    }
}