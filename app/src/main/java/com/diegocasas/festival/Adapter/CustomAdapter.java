package com.diegocasas.festival.Adapter;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.battleent.ribbonviews.RibbonLayout;
import com.diegocasas.festival.Model.Item;
import com.diegocasas.festival.R;
import com.squareup.picasso.Picasso;

import java.util.List;

class CustomViewHolder extends RecyclerView.ViewHolder{

    RibbonLayout ribbonLayout;
    ImageView imageView;

    public CustomViewHolder(View itemView) {
        super(itemView);

        ribbonLayout = (RibbonLayout)itemView.findViewById(R.id.ribbonLayout);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
    }
}

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    Context context;
    List<Item> itemList;

    public CustomAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
      return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Item item = itemList.get(position);
        if (item.type == 0){
            holder.ribbonLayout.setShowBottom(true);
            holder.ribbonLayout.setShowBottom(true);

            holder.ribbonLayout.setHeaderRibbonColor(Color.parseColor("#2B323A"));
            holder.ribbonLayout.setHeaderTextColor(Color.parseColor("#FFFFFF"));

            holder.ribbonLayout.setHeaderText(item.headerText);
            holder.ribbonLayout.setBottomText(item.bottomText);
            Picasso.get().load(item.imageURL).into(holder.imageView);

        } else   if (item.type == 1){
            holder.ribbonLayout.setShowBottom(true);
            holder.ribbonLayout.setShowBottom(true);

            holder.ribbonLayout.setHeaderRibbonColor(Color.parseColor("#B94948"));
            holder.ribbonLayout.setHeaderTextColor(Color.parseColor("#FFFFFF"));

            holder.ribbonLayout.setHeaderText(item.headerText);
            holder.ribbonLayout.setBottomText(item.bottomText);
            Picasso.get().load(item.imageURL).into(holder.imageView);
        } else {
            holder.ribbonLayout.setShowBottom(false);
            holder.ribbonLayout.setShowBottom(false);


            Picasso.get().load(item.imageURL).into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
        }
}
