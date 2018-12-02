package com.example.fjh.octoberapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView_one;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        //开始设置
        recyclerView_one = (RecyclerView) findViewById(R.id.RecyclerView);
        //固定大小
        recyclerView_one.setHasFixedSize(true);
        //创建线性布局
        mLayoutManager = new LinearLayoutManager(this);
        //垂直方向
        mLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        //把布局管理给RecyclerView
        recyclerView_one.setLayoutManager(mLayoutManager);
        //创建假数据zz
        List<String> bt = new ArrayList<>();
        List<String> nr = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            bt.add("标题---" + i);
            nr.add("内容---" + i);
        }
        //创建适配器，并设置

        mAdapter = new MyAdapter(this, bt, nr);
        recyclerView_one.setAdapter(mAdapter);

    }

}
