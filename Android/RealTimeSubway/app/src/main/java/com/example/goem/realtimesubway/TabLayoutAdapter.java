package com.example.goem.realtimesubway;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by GoEM on 2017-10-20.
 */

public class TabLayoutAdapter extends PagerAdapter {
    Context context;
    String[][] lines;
    public TabLayoutAdapter(Context context, String[][] lines) {
        this.context = context;
        this.lines = lines;
    }

    @Override
    public int getCount() {
        return lines.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.line_list, null);
        RecyclerView recyclerView =(RecyclerView) view.findViewById(R.id.recyclerView);
        LineListAdapter adapter = new LineListAdapter(lines[position], position);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
