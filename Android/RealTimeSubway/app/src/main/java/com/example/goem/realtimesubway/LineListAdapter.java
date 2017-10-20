package com.example.goem.realtimesubway;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by GoEM on 2017-10-20.
 */

public class LineListAdapter extends RecyclerView.Adapter<LineListAdapter.Holder>{
    String[] lines;
    int line_num;

    public LineListAdapter(String[] lines, int position) {
        this.lines = lines;
        this.line_num = position;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        String line = lines[position + 1];
        holder.textView.setText(line);
        holder.position = position + 1;
    }

    @Override
    public int getItemCount() {
        return lines.length - 1;
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView textView;
        int position;
        public Holder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    intent.putExtra("Line", line_num + "");
                    intent.putExtra("Position", position + "");
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
