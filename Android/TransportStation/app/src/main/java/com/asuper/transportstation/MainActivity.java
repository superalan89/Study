package com.asuper.transportstation;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.asuper.transportstation.model.JsonClass;
import com.asuper.transportstation.model.RESULT;
import com.asuper.transportstation.model.Row;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        load();
    }




    private void load(){
        new AsyncTask<String, Void, String>(){

            @Override
            protected String doInBackground(String... params) {
                String result = Remote.getData(params[0]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                Gson gson = new Gson();
                JsonClass json = gson.fromJson(result, JsonClass.class);
                Row rows[] = json.getStationDayTrnsitNmpr().getRow();
                List<Row> data = Arrays.asList(rows);
                setList(data);

            }
        }.execute("http://openapi.seoul.go.kr:8088/67676d737073757037385245515762/json/StationDayTrnsitNmpr/1/44/");
    }
    /*
    private List<Row> parse(String string){
        Gson gson = new Gson();
        Row user[] = gson.fromJson(string, Row[].class);
        List<Row> result = Arrays.asList(user);
        return result;
    }*/
    private void setList(List<Row> data){
        ListAdapter adapter = new ListAdapter(data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
