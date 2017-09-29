package com.asuper.tabpractice;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTabLayout();
        setViewPager();
        setListener();
    }

    private void setListener(){
        tabLayout.addOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewPager)
        );
        viewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout)
        );
    }

    private void setTabLayout(){
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab( tabLayout.newTab().setText("One") );
        tabLayout.addTab( tabLayout.newTab().setText("Two") );
        tabLayout.addTab( tabLayout.newTab().setText("Three") );
        tabLayout.addTab( tabLayout.newTab().setText("Four") );
    }

    private void setViewPager(){
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        CustomAdapter adapter = new CustomAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}