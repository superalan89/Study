package com.asuper.subway;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by super on 2017-10-20.
 */

public class TabLayoutAdapter extends PagerAdapter{
    Context context;
    String[][] lines;
    public TabLayoutAdapter(Context context, String[][] lines) {
        this.context = context;
        this.lines = lines;
    }

    @Override
    public int getCount() { return lines.length; }

    @Override
    public boolean isViewFromObject(View view, Object object) {return view == object;}

    @Override
    public Object istantiateitem(ViewGroup container, int position) {
        View view
    }

}
