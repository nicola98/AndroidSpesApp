package com.example.corsista.androidspesapp.logic;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;

import com.example.corsista.androidspesapp.data.DatabaseManager;
import com.example.corsista.androidspesapp.data.MainSingletonDetailList;
import com.example.corsista.androidspesapp.data.Product;

import java.util.ArrayList;
import java.util.List;

import static com.example.corsista.androidspesapp.data.DatabaseManager.KEY_ID;
import static com.example.corsista.androidspesapp.data.DatabaseManager.KEY_ID_RIFERIMENTO_PRODUCT;
import static com.example.corsista.androidspesapp.data.DatabaseManager.KEY_NAME;

/**
 * Created by Corsista on 30/03/2018.
 */

public class DetailDataAccessUtils {

    public static List<Product> getDataSourceItemList(Context context) {

        return MainSingletonDetailList.getInstance().getItemList();
    }

    public static List<Product> addItemToDataSource(Context context, Product itemToAdd, long position) {

        DatabaseManager dbManager = new DatabaseManager(context);
        dbManager.open();
        dbManager.createProduct(itemToAdd);
        Cursor cursor = dbManager.readProductByName(itemToAdd.getName());

        if(cursor.moveToFirst())
            dbManager.createAssociazione(position, cursor.getInt(cursor.getColumnIndex(KEY_ID)));

        List<Product> datasource = DetailDataAccessUtils.getDataSourceItemList(context);
        datasource.add(itemToAdd);

        MainSingletonDetailList.getInstance().setItemList(datasource);
        return datasource;
    }

    public static Product getItemAtIndex(Context context, int index) {
        List<Product> datasource = DetailDataAccessUtils.getDataSourceItemList(context);
        return datasource.get(index);
    }

    public static List<Product> removeItemAtIndex(Context context, int index) {
        List<Product> datasource = DetailDataAccessUtils.getDataSourceItemList(context);
        datasource.remove(index);

        MainSingletonDetailList.getInstance().setItemList(datasource);
        return datasource;
    }

    public static void initDataSource(Context context, long position) {
        List<Product> datasource = DetailDataAccessUtils.getDataSourceItemList(context);
        datasource.clear();
        MainSingletonDetailList.getInstance().setItemList(datasource);
        DatabaseManager dbManager = new DatabaseManager(context);
        dbManager.open();
        Cursor cursor = dbManager.readAssociazione(position);
        while (cursor.moveToNext())
        {
            Cursor cursor2 = dbManager.readProduct(cursor.getInt(cursor.getColumnIndex(KEY_ID_RIFERIMENTO_PRODUCT)));
            if(cursor2.moveToFirst()) {
                datasource = DetailDataAccessUtils.getDataSourceItemList(context);
                datasource.add(new Product(cursor2.getString(cursor2.getColumnIndex(KEY_NAME))));
                MainSingletonDetailList.getInstance().setItemList(datasource);
            }
            cursor2.close();
        }
        cursor.close();
    }
}
