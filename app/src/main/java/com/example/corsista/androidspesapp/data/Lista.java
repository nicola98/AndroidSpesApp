package com.example.corsista.androidspesapp.data;

import java.util.List;

public class Lista {

    private int listID;
    private int userID;
    private String nameList;
    private List<String> product;

    public Lista( String nameList, int listID, int userID){
        this.nameList=nameList;
        this.listID = listID;
        this.userID = userID;
    }

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    public List<String> Product() {return product; }

    public int getListID() {
        return listID;
    }

    public void setListID(int listID) {
        this.listID = listID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void addProduct(String product){
        this.product.add(product);
    }


}
