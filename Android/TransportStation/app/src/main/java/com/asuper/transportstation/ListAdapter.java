package com.asuper.transportstation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asuper.transportstation.model.JsonClass;

import java.util.List;


/**
 * Created by super on 2017-10-17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Holder>{
    Context context;
    List<JsonClass> data;
    public ListAdapter(List<JsonClass> data, Context context){
        this.data = data;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        JsonClass jsonClass = data.get(position);
        //holder.imageView.setImageURI();
        holder.textID.setText(jsonClass.getStationDayTrnsitNmpr()+"");

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        TextView textID;
        TextView stationNM;
        public Holder(View itemView) {
            super(itemView);
            textID = itemView.findViewById(R.id.textID);
            stationNM = itemView.findViewById(R.id.stationNM);
        }
    }
}