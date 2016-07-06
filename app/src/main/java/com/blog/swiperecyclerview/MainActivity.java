package com.blog.swiperecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private SwipeRecyclerView mRecycleView;
    private MyRecycleAdapter mAdapter;
    private ArrayList<String> mList = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleView = (SwipeRecyclerView)findViewById(R.id.recycleView);
        mList.add("Item 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16");
        mList.add("Item 2 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16");
        mList.add("Item 3 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16");
        mList.add("Item 4 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16");
        mList.add("Item 5");
        mList.add("Item 6");
        mList.add("Item 7");
        mList.add("Item 8");
        mList.add("Item 9");
        mList.add("Item 10");

        mAdapter = new MyRecycleAdapter(this, mList);
        initView();
    }

    private void initView() {
        //设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecycleView.setAdapter(mAdapter);
        DividerItemDecoration dividerLine = new DividerItemDecoration(DividerItemDecoration.VERTICAL);
        dividerLine.setSize(1);
        dividerLine.setColor(0xffdddddd);
        mRecycleView.addItemDecoration(dividerLine);
        mRecycleView.setRightClickListener(new SwipeRecyclerView.OnRightClickListener(){

            @Override
            public boolean onRightClick(int position, String id) {
                Toast.makeText(MainActivity.this, " position = " + position, Toast.LENGTH_SHORT).show();
                Log.e(TAG, " onRightClick position = " + position);
                mList.remove(position);
                return true;
            }
        });


    }
}
