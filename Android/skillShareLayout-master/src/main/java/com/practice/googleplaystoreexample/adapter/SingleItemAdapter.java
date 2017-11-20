package com.practice.googleplaystoreexample.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.practice.googleplaystoreexample.ProfileActivity;
import com.practice.googleplaystoreexample.R;
import com.practice.googleplaystoreexample.sampleModel.SingleItemModel;

import java.util.ArrayList;

/**
 * Created by JisangYou on 2017-11-18.
 */

public class SingleItemAdapter extends RecyclerView.Adapter<SingleItemAdapter.Holder> {

    private ArrayList<SingleItemModel> singleItemModels;
    private Context mContext;
    private SingleItemModel singleItem;

    public SingleItemAdapter(Context context, ArrayList<SingleItemModel> singleItemModels) {
        this.singleItemModels = singleItemModels;
        this.mContext = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        Holder Holder = new Holder(view);
        return Holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int i) {

        singleItem = singleItemModels.get(i);

        holder.serviceNameText.setText(singleItem.getServiceName());
        holder.seeAllText.setText(singleItem.getSee());
        holder.contentsName.setText(singleItem.getContentName());
        holder.contentsAuthor.setText(singleItem.getContentAuthor());
        //TODO

       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != singleItemModels ? singleItemModels.size() : 0);
    }

    public class Holder extends RecyclerView.ViewHolder {


        TextView seeAllText;
        TextView contentsName;
        TextView contentsAuthor;
        TextView serviceNameText;
        ImageView contentsImageView;


        public Holder(View view) {
            super(view);

            this.serviceNameText = (TextView) view.findViewById(R.id.serviceNameText);
            this.seeAllText = (TextView) view.findViewById(R.id.seeAllText);
            this.contentsName = (TextView) view.findViewById(R.id.contentsName);
            this.contentsAuthor = (TextView) view.findViewById(R.id.contentsAuthor);
            this.contentsImageView = (ImageView) view.findViewById(R.id.contentsImageView);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Toast.makeText(v.getContext(), serviceNameText.getText(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), ProfileActivity.class);
//                    intent.putExtra("position",);
                    intent.putExtra("serviceName", serviceNameText.getText().toString());
                    intent.putExtra("contentsAuthor", String.valueOf(contentsAuthor));
                    intent.putExtra("contentsName", String.valueOf(contentsName));
                    Log.e("서비스이름","체크=========="+serviceNameText.getText().toString());


                    v.getContext().startActivity(intent);

                }
            });


        }

    }

}