package com.practice.googleplaystoreexample.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.googleplaystoreexample.R;
import com.practice.googleplaystoreexample.sampleModel.MainListModel;

import java.util.ArrayList;

/**
 * Created by JisangYou on 2017-11-18.
 */

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.Holder> {

    private ArrayList<MainListModel> mainListModels;
    private Context context;

    public MainListAdapter(Context context, ArrayList<MainListModel> dataList) {
        this.mainListModels = dataList;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder Holder, int i) {

        final String sectionName = mainListModels.get(i).getHeaderTitle();

        ArrayList singleListItems = mainListModels.get(i).getAllItemsInList();
        Holder.itemTitle.setText(sectionName);

        SingleItemAdapter singleItemAdapter = new SingleItemAdapter(context, singleListItems);
        Holder.singleItemRecylerView.setHasFixedSize(true);
        Holder.singleItemRecylerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        Holder.singleItemRecylerView.setAdapter(singleItemAdapter);


        Holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(v.getContext(), "click event on more, " + sectionName, Toast.LENGTH_SHORT).show();


            }
        });


       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != mainListModels ? mainListModels.size() : 0);
    }

    public class Holder extends RecyclerView.ViewHolder {

        protected TextView itemTitle;
        protected RecyclerView singleItemRecylerView;
        protected Button btnMore;


        public Holder(View view) {
            super(view);

            this.itemTitle = (TextView) view.findViewById(R.id.itemTitle);
            this.singleItemRecylerView = (RecyclerView) view.findViewById(R.id.singleItemRecylerView);
            this.btnMore = (Button) view.findViewById(R.id.btnMore);


        }

    }

}
