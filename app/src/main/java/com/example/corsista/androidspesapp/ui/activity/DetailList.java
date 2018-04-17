package com.example.corsista.androidspesapp.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.corsista.androidspesapp.logic.DetailDataAccessUtils;
import com.example.corsista.androidspesapp.ui.adapter.DetailListRecyclerAdapter;

/**
 * Created by Corsista on 16/04/2018.
 */

public class DetailList extends Activity{

    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter<DetailListRecyclerAdapter.MyViewHolder> myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_list_layout);

        int position = 1; //per adesso è fisso ma poi verrà passato dall'activity precedente
        DetailDataAccessUtils.initDataSource(getApplicationContext(), position);
        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        myAdapter = new DetailListRecyclerAdapter();
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);
        myRecyclerView.setAdapter(myAdapter);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
    }
}
