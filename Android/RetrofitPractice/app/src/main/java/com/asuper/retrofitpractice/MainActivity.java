package com.asuper.retrofitpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    View mview;
    TextView textView, textViewPost, textViewMap,textTitle;

    public static final String BASE_URL = "http://192.168.1.87:8080/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textTitle = findViewById(R.id.textView);
        Gson gson = new GsonBuilder().create();
        ApiService service = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ApiService.class);
        service.getAllData().enqueue(new Callback<List<Data1>>() {
            @Override
            public void onResponse(Call<List<Data1>> call, Response<List<Data1>> response) {
                final List datas = response.body();
                Log.e("datas===============", "message" + datas.toString());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textTitle.setText(datas.toString());
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Data1>> call, Throwable t) {

            }
        });

    }


}
