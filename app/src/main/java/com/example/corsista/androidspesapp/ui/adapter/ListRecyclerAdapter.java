package com.example.corsista.androidspesapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.corsista.androidspesapp.R;
import com.example.corsista.androidspesapp.data.Lista;

import java.util.List;



public class ListRecyclerAdapter extends RecyclerView.Adapter<ListRecyclerAdapter.ViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(String item);
     }

    public interface OnItemLongClickListener{
        void onItemLongClick(String item);
    }

    private List<Lista> lista;
    private final OnItemClickListener clickListener;
    private final OnItemLongClickListener longClickListener;


    public ListRecyclerAdapter(List<Lista> lista, OnItemClickListener clickListener, OnItemLongClickListener longClickListener) {
        this.lista = lista;
        this.clickListener = clickListener;
        this.longClickListener = longClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView listImage;
        private TextView listText;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(final String item, final OnItemClickListener clickListener,final OnItemLongClickListener longClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    clickListener.onItemClick(item);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {
                    longClickListener.onItemLongClick(item);
                    return true;
                }
            });
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout listLayout;
        listLayout= (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.lists_layout,parent,false);
        ViewHolder viewHolder= new ViewHolder(listLayout);
        return viewHolder;
    }


   @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(lista.get(position).getNameList(),clickListener,longClickListener);
        ImageView imageView = holder.itemView.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.ic_launcher_foreground);
        TextView textView = holder.itemView.findViewById(R.id.textView);
        textView.setText(lista.get(position).getNameList());

    }


    @Override
    public int getItemCount() {
        return lista.size();
    }







}