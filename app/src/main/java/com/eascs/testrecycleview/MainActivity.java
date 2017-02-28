package com.eascs.testrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rclv;
    //一步步添加，首先需要添加Adapter
    private myAdapter adapter;
    private List<String> listData = new ArrayList<String>();
//    private RecyclerView.ItemDecoration itemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();


        rclv = (RecyclerView) findViewById(R.id.rclv_Test);
//        rclv.setLayoutManager(new GridLayoutManager(this, 2));
        rclv.setLayoutManager(new LinearLayoutManager(this));
        rclv.setItemAnimator(new DefaultItemAnimator());
        adapter = new myAdapter(MainActivity.this, listData);
        rclv.addItemDecoration(new myItemDecoration(this));
        rclv.setAdapter(adapter);

    }

    private void initData() {

        listData.add("我的单据");

        listData.add("历史单据");

        listData.add("订单统计");

        listData.add("基础信息");

    }
}
