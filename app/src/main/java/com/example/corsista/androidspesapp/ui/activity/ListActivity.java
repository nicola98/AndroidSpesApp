package com.example.corsista.androidspesapp.ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.example.corsista.androidspesapp.R;
import com.example.corsista.androidspesapp.data.Lista;
import com.example.corsista.androidspesapp.data.ListSingleton;
import com.example.corsista.androidspesapp.logic.ListDataAccessUtils;
import com.example.corsista.androidspesapp.ui.adapter.MyRecyclerAdapter;

public class ListActivity extends AppCompatActivity {


    private RecyclerView myRecyclerView;
    private MyRecyclerAdapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        ListDataAccessUtils.initDataSource(getApplicationContext(), ListSingleton.getInstance().getCurrentUser());
        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        myAdapter = new MyRecyclerAdapter(this);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);
        myRecyclerView.setAdapter(myAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Context thisContext = ListActivity.this;
                ListActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        final AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                        final EditText input = new EditText(ListActivity.this);
                        input.setInputType(InputType.TYPE_CLASS_TEXT);
                        builder.setTitle("AGGIUNGI LISTA");
                        builder.setView(input);
                        builder.setPositiveButton("CREA", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Lista lista = new Lista(String.valueOf(input.getText()), ListSingleton.getInstance().getCurrentUser());
                                ListDataAccessUtils.addItemToDataSource(getApplicationContext(), lista);
                                dialog.cancel();
                            }
                        });

                        builder.setNegativeButton("ANNULLA", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        builder.show();
                    }
                });
            }
        });
    }

}