package com.example.corsista.androidspesapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.corsista.androidspesapp.data.MainSingletonDetailList;
import com.example.corsista.appmeteo.R;
import com.example.corsista.appmeteo.data.MainSingleton;
import com.example.corsista.appmeteo.ui.activity.MainActivity;

/**
 * Created by Corsista on 30/03/2018.
 */

public class DetailListRecyclerAdapter extends RecyclerView.Adapter<DetailListRecyclerAdapter.MyViewHolder>{
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView infoText;

        public MyViewHolder(View view){
            super(view);
            infoText = (TextView) view.findViewById(R.id.info_text);
        }
    }

    @Override
    public DetailListRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return MainSingletonDetailList.getInstance().getItemList().size();
    }

    @Override
    public void onBindViewHolder(DetailListRecyclerAdapter.MyViewHolder holder, int position) {
        holder.infoText.setText(MainSingletonDetailList.getInstance().getItemList().get(position).getName());
    }
}
