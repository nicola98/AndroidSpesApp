package com.example.corsista.androidspesapp.data;

import java.util.List;

public class Lista {

    private String nameList;
    private List<String> product;

    public Lista( String nameList){
        this.nameList=nameList;
    }

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    public List<String> addProduct() {return product;}
}
