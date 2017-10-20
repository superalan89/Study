package com.example.goem.realtimesubway;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[][] lines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lines = Data.lines;
        initView();
        setMainView();
        setListener();
    }

    private void setListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void setMainView() {
        tabLayout.addTab(tabLayout.newTab().setText("1 호선"));
        tabLayout.addTab(tabLayout.newTab().setText("2 호선"));
        tabLayout.addTab(tabLayout.newTab().setText("3 호선"));
        tabLayout.addTab(tabLayout.newTab().setText("4 호선"));
        tabLayout.addTab(tabLayout.newTab().setText("5 호선"));
        tabLayout.addTab(tabLayout.newTab().setText("6 호선"));
        tabLayout.addTab(tabLayout.newTab().setText("7 호선"));
        tabLayout.addTab(tabLayout.newTab().setText("8 호선"));
        TabLayoutAdapter adapter = new TabLayoutAdapter(this, lines);
        viewPager.setAdapter(adapter);
    }
}
