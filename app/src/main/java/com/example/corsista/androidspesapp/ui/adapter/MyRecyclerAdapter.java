package com.example.corsista.androidspesapp.ui.adapter;


import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.corsista.androidspesapp.R;
import com.example.corsista.androidspesapp.data.DatabaseManager;
import com.example.corsista.androidspesapp.data.Lista;
import com.example.corsista.androidspesapp.logic.SharedPreferenceUtility;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    List<Lista> liste = new ArrayList<Lista>();
    DatabaseManager userDatabaseManager;
    DatabaseManager listDatabaseManager;
    int userId;

    public MyRecyclerAdapter(Context context) {
        this.updateList(context);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView infoText;
        Context context;

        public MyViewHolder(View view){
            super(view);
            infoText = (TextView) view.findViewById(R.id.info_text);
            context = view.getContext();
        }
    }

    public void updateList(Context context){
        String username = SharedPreferenceUtility.readUserFromSharedPreferences(context);
        userDatabaseManager = new DatabaseManager(context);
        userDatabaseManager.open();
        Cursor userCursor = userDatabaseManager.readUser(username);
        userCursor.moveToFirst();
        this.userId = userCursor.getInt(userCursor.getColumnIndex(userDatabaseManager.KEY_PASSWORD));

        listDatabaseManager = new DatabaseManager(context);
        listDatabaseManager.open();
        Cursor cursor = listDatabaseManager.getListsByUser(this.userId);
        cursor.moveToFirst();
        int index = cursor.getCount();
        if(index > 0){
            int i = 0;
            this.liste.clear();
            do{
                Lista lista = new Lista(cursor.getInt(cursor.getColumnIndex(listDatabaseManager.KEY_LISTID)),
                        cursor.getString(cursor.getColumnIndex(listDatabaseManager.KEY_NAME)),
                        cursor.getInt(cursor.getColumnIndex(listDatabaseManager.KEY_CONTACTID)));
                this.liste.add(lista);
                i++;
                cursor.moveToNext();
            }while (i<index);
        }
    }



    @Override
    public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapter.MyViewHolder holder, int position) {
        holder.infoText.setText(liste.get(position).getNome());
    }
}