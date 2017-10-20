package com.asuper.subway;

import android.content.res.Configuration;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[][] lines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // lines = Data.lines;
    }

    private void setMainView() {
        tabLayout.addTab(tabLayout.newTab().setText("1호선"));
        tabLayout.addTab(tabLayout.newTab().setText("2호선"));
        tabLayout.addTab(tabLayout.newTab().setText("3호선"));
        tabLayout.addTab(tabLayout.newTab().setText("4호선"));
        tabLayout.addTab(tabLayout.newTab().setText("5호선"));
        tabLayout.addTab(tabLayout.newTab().setText("6호선"));
        tabLayout.addTab(tabLayout.newTab().setText("7호선"));
        tabLayout.addTab(tabLayout.newTab().setText("8호선"));

    }

}