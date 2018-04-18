package com.example.corsista.androidspesapp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.corsista.androidspesapp.R;
import com.example.corsista.androidspesapp.logic.DetailDataAccessUtils;
import com.example.corsista.androidspesapp.ui.adapter.DetailListRecyclerAdapter;

/**
 * Created by Corsista on 16/04/2018.
 */

public class DetailList extends Activity{

    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter<DetailListRecyclerAdapter.MyViewHolder> myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    long position;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_list_layout);

        intent = getIntent();
        position = Long.parseLong(intent.getStringExtra("position"));

        DetailDataAccessUtils.initDataSource(getApplicationContext(), position);
        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        myAdapter = new DetailListRecyclerAdapter();
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);
        myRecyclerView.setAdapter(myAdapter);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        Button addProduct = (Button) findViewById(R.id.addProduct);
        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(DetailList.this,AddProduct.class);
                intent2.putExtra("position2", intent.getStringExtra("position"));
                startActivity(intent2);
            }
        });
    }
}
