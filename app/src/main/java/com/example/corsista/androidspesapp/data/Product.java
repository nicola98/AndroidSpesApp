package com.example.corsista.androidspesapp.data;

/**
 * Created by Corsista on 16/04/2018.
 */

public class Product {
    //manca attributo per vedere se è stato preso o no
    String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
