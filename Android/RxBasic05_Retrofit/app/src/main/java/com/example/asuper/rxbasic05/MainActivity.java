package com.example.asuper.rxbasic05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


import com.example.asuper.rxbasic05.domain.Row;
import com.example.asuper.rxbasic05.domain.WeatherApi;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1. 생성
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(IWeather.SERVER_URL);
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        Retrofit retrofit = builder.build();

        // 2. 서비스 만들기 < 인터페이스로부터
        IWeather service = retrofit.create(IWeather.class);

        // 3. 옵저버블(Emitter) 생성
        Observable<WeatherApi> observable = service.getData(IWeather.SERVER_KEY, 1, 10, "동작");

        // 4. 발행시작
        observable
                .subscribeOn(Schedulers.io())
                // 5. 구독
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        weatherApi -> {
                            String result = "";
                            for(Row row : weatherApi.getRealtimeWeatherStation().getRow()){
                                result += "지역명:"+row.getSTN_NM()+"\n";
                                result += "온도:"+row.getSAWS_TA_AVG()+"\n";
                                result += "습도:"+row.getSAWS_HD()+"\n";
                            }
                            ((TextView)findViewById(R.id.result)).setText(result);
                        }
                );
    }
}

// 0. 레트로핏 인터페이스 생성
interface IWeather {
    public static final String SERVER_URL = "http://openAPI.seoul.go.kr:8088/";
    public static final String SERVER_KEY = "67676d737073757037385245515762";

    @GET("{key}/json/RealtimeWeatherStation/{skip}/{count}/{gu}")
    Observable<WeatherApi> getData(
            @Path("key") String server_key,
            @Path("skip") int skip,
            @Path("count") int count,
            @Path("gu") String gu);
}