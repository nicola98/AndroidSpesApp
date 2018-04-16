package com.example.corsista.androidspesapp.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Corsista on 30/03/2018.
 */

public class MainSingletonDetailList {

    private static MainSingletonDetailList ourInstance = new MainSingletonDetailList();

    public static MainSingletonDetailList getInstance() {
        return ourInstance;
    }

    private List<Product> itemList;

    private MainSingletonDetailList() {
        this.itemList = new ArrayList<Product>();
    }

    public List<Product> getItemList() {
        return itemList;
    }

    public void setItemList(List<Product> itemList) {
        this.itemList = itemList;
    }
}
