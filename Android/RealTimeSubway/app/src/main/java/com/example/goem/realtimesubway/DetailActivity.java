package com.example.goem.realtimesubway;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.goem.realtimesubway.model.JsonClass;
import com.example.goem.realtimesubway.model.RealtimeArrivalList;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    int line_num;
    int position;
    private TextView preStation;
    private TextView nowStation;
    private TextView nextStation;
    private RecyclerView upListView;
    private RecyclerView downListView;
    private TextView textUp;
    private TextView textDown;
    String[] lines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        line_num = Integer.parseInt(intent.getStringExtra("Line"));
        position = Integer.parseInt(intent.getStringExtra("Position"));
        lines = Data.lines[line_num];
        initView();
        load(lines[position]);
        setListener();
    }

    private void setListener() {
        preStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position +-1 != 0) {
                    position -= 1;
                    load(lines[position]);
                }
            }
        });
        nextStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position + 1 != lines.length) {
                    position += 1;
                    load(lines[position]);
                }
            }
        });
    }

    private void setDetail(String s) {
        Gson gson = new Gson();
        JsonClass jsonClass = gson.fromJson(s, JsonClass.class);
        RealtimeArrivalList[] arrivalList = jsonClass.getRealtimeArrivalList();
        List<RealtimeArrivalList> upArrivalList = new ArrayList<>();
        List<RealtimeArrivalList> downArrivalList = new ArrayList<>();
        for (RealtimeArrivalList item : arrivalList) {
            if (item.getSubwayId().equals(lines[0])) {
                if (item.getUpdnLine().equals("상행") || item.getUpdnLine().equals("내선")) {
                    upArrivalList.add(item);
                } else {
                    downArrivalList.add(item);
                }
            }
        }
        nowStation.setText(lines[position]);
        if(line_num == 1) {
            preStation.setText(lines[position - 1]);
            textUp.setText("내선");
            UpDownListAdapter upListAdapter = new UpDownListAdapter(upArrivalList);
            upListView.setAdapter(upListAdapter);
            upListView.setLayoutManager(new LinearLayoutManager(this));
            nextStation.setText(lines[position + 1]);
            textDown.setText("외선");
            UpDownListAdapter downListAdapter = new UpDownListAdapter(downArrivalList);
            downListView.setAdapter(downListAdapter);
            downListView.setLayoutManager(new LinearLayoutManager(this));
        }else {
            if (position - 1 != 0) {
                preStation.setText(lines[position - 1]);
                textUp.setText("상행");
                UpDownListAdapter upListAdapter = new UpDownListAdapter(upArrivalList);
                upListView.setAdapter(upListAdapter);
                upListView.setLayoutManager(new LinearLayoutManager(this));
            } else {
                textUp.setText("종착역");
                upListView.setAdapter(null);
            }
            if (position + 1 != lines.length) {
                nextStation.setText(lines[position + 1]);
                textDown.setText("하행");
                UpDownListAdapter downListAdapter = new UpDownListAdapter(downArrivalList);
                downListView.setAdapter(downListAdapter);
                downListView.setLayoutManager(new LinearLayoutManager(this));
            } else {
                textDown.setText("종착역");
                downListView.setAdapter(null);
            }
        }
    }

    private void load(String station) {
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... params) {
                String msg = Remote.getData("http://swopenapi.seoul.go.kr/api/subway/714d526556646d733431646b56446b/json/realtimeStationArrival/0/10/" + params[0]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return msg;
            }

            @Override
            protected void onPostExecute(String s) {
                if(!"".equals(s)) {
                    setDetail(s);
                }else {
                    finish();
                }
            }
        }.execute(station);
    }

    private void initView() {
        preStation = (TextView) findViewById(R.id.preStation);
        nowStation = (TextView) findViewById(R.id.nowStation);
        nextStation = (TextView) findViewById(R.id.nextStation);
        upListView = (RecyclerView) findViewById(R.id.upListView);
        downListView = (RecyclerView) findViewById(R.id.downListView);
        textUp = (TextView) findViewById(R.id.textUp);
        textDown = (TextView) findViewById(R.id.textDown);
    }
}
