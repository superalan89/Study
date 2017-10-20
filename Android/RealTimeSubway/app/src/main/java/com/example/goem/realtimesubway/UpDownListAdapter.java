package com.example.goem.realtimesubway;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.goem.realtimesubway.model.RealtimeArrivalList;

import java.util.List;

/**
 * Created by GoEM on 2017-10-19.
 */

public class UpDownListAdapter extends RecyclerView.Adapter<UpDownListAdapter.Holder>{
    List<RealtimeArrivalList> data;
    public UpDownListAdapter(List<RealtimeArrivalList> data) {
        this.data = data;
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list2, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        RealtimeArrivalList temp = data.get(position);
        holder.trainLineNm.setText(temp.getTrainLineNm());
        holder.barvlDt.setText(temp.getArvlMsg2());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView trainLineNm;
        TextView barvlDt;
        public Holder(View itemView) {
            super(itemView);
            trainLineNm = (TextView) itemView.findViewById(R.id.trainLineNm);
            barvlDt = (TextView) itemView.findViewById(R.id.barvlDt);
        }
    }
}
