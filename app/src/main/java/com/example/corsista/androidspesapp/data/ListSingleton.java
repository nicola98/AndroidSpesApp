package com.example.corsista.androidspesapp.data;

import java.util.ArrayList;
import java.util.List;

public class ListSingleton {
    private static List<Lista> LISTS;
    private static ListSingleton listSingleton = new ListSingleton();

    private ListSingleton() {
        this.LISTS= new ArrayList<>();
    }

    public static ListSingleton getInstance() {
        return listSingleton;
    }

    public  List<Lista> getListaArray() {
        return this.LISTS;
    }

    public  void setListaArray(List<Lista> array) {
        this.LISTS = LISTS;
    }

}
