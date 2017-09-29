package com.asuper.tabpractice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CustomAdapter extends FragmentStatePagerAdapter{
    private static final int COUNT = 4;

    public CustomAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 1:
                return new TwoFragment();
            case 2:
                return new ThreeFragment();
            case 3:
                return new FourFragment();
            default:
                return new OneFragment();
        }
    }

    @Override
    public int getCount() {
        return COUNT;
    }
}
