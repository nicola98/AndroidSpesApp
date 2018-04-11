package com.example.corsista.androidspesapp.ui.adapter;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ListAdapterHelper {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void update(ArrayAdapter arrayAdapter, ArrayList<Object> listOfObject){
        arrayAdapter.clear();
        for (Object object : listOfObject){
            arrayAdapter.add(object);
        }
    }
}
