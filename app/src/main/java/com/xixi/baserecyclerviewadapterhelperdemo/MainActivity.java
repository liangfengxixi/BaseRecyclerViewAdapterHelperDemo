package com.xixi.baserecyclerviewadapterhelperdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xixi.baserecyclerviewadapterhelperdemo.adapter.HomeAdapter;
import com.xixi.baserecyclerviewadapterhelperdemo.entity.HomeItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ArrayList<HomeItem> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAdapter();
    }

    private void initView() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        toolbar.setTitle("RecyclerViewAdapterDemo");
//        setSupportActionBar(toolbar);
		toolbar.setNavigationIcon(R.drawable.ic_back);
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
    }

    private void initData() {
        mDataList = new ArrayList<>();
        for(int i=0;i<10;i++){
            HomeItem homeItem = new HomeItem();
            homeItem.title = "测试---"+i;
            mDataList.add(homeItem);
        }

    }

    private void initAdapter() {
        HomeAdapter homeAdapter = new HomeAdapter(R.layout.home_item_view, mDataList);
        homeAdapter.openLoadAnimation();
        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                HomeItem item = (HomeItem)adapter.getItem(position);
                toast(item.title);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));
        recyclerView.setAdapter(homeAdapter);
    }

    private void toast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

}
