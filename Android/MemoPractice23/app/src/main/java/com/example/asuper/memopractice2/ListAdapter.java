package com.example.asuper.memopractice2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asuper.memopractice2.domain.Memo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by super on 2017-11-16.
 */

public class ListAdapter extends BaseAdapter {
    Context context;
    public static ArrayList<Memo> data;
    public ListAdapter(Context context, ArrayList<Memo> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {return data.size();}

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder = null;
        if(view == null) {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_list, null);
            holder = new Holder(view);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        Memo memo = data.get(position);

        holder.setNo(memo.getNo());
        holder.setTitle(memo.getTitle());
        holder.setDate(memo.getDatetime());
        holder.setPosition(position);
        holder.setAuthor(memo.getAuthor());
        holder.setContent(memo.getContent());
        return view;
    }
}


class Holder {
    private int position;
    private String author;
    private String content;
    private TextView textNo;
    private TextView textTitle;
    private TextView textDate;

    public Holder(View view){
        textNo = view.findViewById(R.id.txtNumber);
        textTitle = view.findViewById(R.id.txtTitle);
        textDate = view.findViewById(R.id.txtDate);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("position", position);
                view.getContext().startActivity(intent);
            }
        });
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setPosition(int position){
        this.position = position;
    }
    public void setNo(int no) {
        textNo.setText(no + "");
    }
    public void setTitle(String title) {
        textTitle.setText(title);
    }
    public void setDate(Long datetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String result = sdf.format(datetime);
        textDate.setText(result);
    }
}
