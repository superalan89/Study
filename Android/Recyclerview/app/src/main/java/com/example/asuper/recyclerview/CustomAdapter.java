package com.example.asuper.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by super on 2017-11-16.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder> {

    List<Message> list = new ArrayList<>();

    public static final int ME = 0;
    public static final int YOU = 1;

    public void setData(List<Message> data){
        this.list = data;
        notifyDataSetChanged();
    }

    // 0. 생성자
    public CustomAdapter(List<Message> list){
        this.list = list;
    }

    // 1. 개수 확인
    @Override
    public int getItemCount() {
        return list.size();
    }

    // 2. 뷰타입 호출
    @Override
    public int getItemViewType(int position) {
        if(list.get(position).viewType == ME){
            return 0;
        } else {
            return 1;
        }
    }

    // 3. 홀더 생성 - 재활용 Recycler
    //             - 시스템에서 화면에 보여줄만큼 홀더 생성
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if(viewType == ME){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
        }
        return new Holder(view);
    }

    // 4. 데이터 바인딩
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.textView.setText(list.get(position).message);
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView textView;
        public Holder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView1);
        }
    }
}
