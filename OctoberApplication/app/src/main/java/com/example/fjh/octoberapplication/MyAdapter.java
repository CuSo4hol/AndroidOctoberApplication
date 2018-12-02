package com.example.fjh.octoberapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by FJH on 2018/9/28.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<String> Sbt, Snr, Simgurl;

    public MyAdapter(Context context, List<String> bt, List<String> nr) {
        this.context = context;
        this.Sbt = bt;
        this.Snr = nr;
    }

    @Override
    //onCreateViewHolder()负责为Item创建视图
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    //onBindViewHolder()负责将数据绑定到Item的视图上
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bt.setText(Sbt.get(position));
        holder.nr.setText(Snr.get(position));
        holder.image.setImageResource(R.drawable.time_image);
    }

    @Override
    //返回item中有多少条数据
    public int getItemCount() {

        return Sbt.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView bt, nr;
        public ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            bt = (TextView) itemView.findViewById(R.id.list_bt);
            nr = (TextView) itemView.findViewById(R.id.list_nr);
            image = (ImageView) itemView.findViewById(R.id.list_Image);

        }
    }


}
