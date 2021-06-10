package com.example.recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Bean> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 1; i < 200; i ++)
        {
            Bean bean = new Bean();
            String name = "列表项" + i;
            bean.setName(name);
            data.add(bean);
        }
        RecyclerView recyclerView = findViewById(R.id.rv);
         // 常规布局
         // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
         // recyclerView.setLayoutManager(linearLayoutManager);

         // 网格布局
         GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
         recyclerView.setLayoutManager(gridLayoutManager);

         // 瀑布流布局
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayout.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        MyAdapter myAdapter = new MyAdapter(data, this);

        recyclerView.setAdapter(myAdapter);

        myAdapter.setRecycleItemClickListener(new MyAdapter.OnRecycleItemClickListener() {
            @Override
            public void onRecycleItemClick(int position) {
                Log.e("test", "position: " + position);
            }
        });
    }
}