package com.example.corsista.androidspesapp.data;

import java.util.ArrayList;
import java.util.List;

public class ListSingleton {

    private static ListSingleton ourInstance = new ListSingleton();

    public String currentUser;


    public static ListSingleton getInstance() {
        return ourInstance;
    }

    private List<Lista> itemList;

    private ListSingleton() {
        this.itemList = new ArrayList<Lista>();
    }


    public List<Lista> getListe() {
        return itemList;
    }


    public void setListe(List<Lista> itemList) {
        this.itemList = itemList;
    }


    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }


    public String getCurrentUser() {
        return currentUser;
    }
}