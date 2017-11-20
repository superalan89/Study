package com.practice.googleplaystoreexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.practice.googleplaystoreexample.adapter.MainListAdapter;
import com.practice.googleplaystoreexample.sampleModel.MainListModel;
import com.practice.googleplaystoreexample.sampleModel.SingleItemModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<MainListModel> allSampleData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        allSampleData = new ArrayList<MainListModel>();

        createDummyData();

        RecyclerView mainRecyclerView = (RecyclerView) findViewById(R.id.mainRecyclerView);
        mainRecyclerView.setHasFixedSize(true);
        MainListAdapter mainListAdapter = new MainListAdapter(this, allSampleData);
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mainRecyclerView.setAdapter(mainListAdapter);


    }

    public void createDummyData() {
        for (int i = 1; i <= 5; i++) {

            MainListModel dm = new MainListModel();

            dm.setHeaderTitle("Section " + i);

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("a " + j, "b" + j, "b" + j,"d"+j));
            }

            dm.setAllItemsInList(singleItem);

            allSampleData.add(dm);

        }
    }
}
