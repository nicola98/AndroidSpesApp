package com.example.corsista.androidspesapp.logic;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;

import com.example.corsista.androidspesapp.data.DatabaseManager;
import com.example.corsista.androidspesapp.data.MainSingletonDetailList;
import com.example.corsista.androidspesapp.data.Product;
import com.example.corsista.appmeteo.data.Citta;
import com.example.corsista.appmeteo.data.MainSingleton;

import java.util.List;

import static com.example.corsista.androidspesapp.data.DatabaseManager.KEY_ID_RIFERIMENTO_PRODUCT;
import static com.example.corsista.androidspesapp.data.DatabaseManager.KEY_NAME;

/**
 * Created by Corsista on 30/03/2018.
 */

public class DetailDataAccessUtils {

    public static List<Product> getDataSourceItemList(Context context) {

        return MainSingletonDetailList.getInstance().getItemList();
    }

    public static List<Product> addItemToDataSource(Context context, Product itemToAdd) {
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

    //da modificare con chiamata al db
    public static void initDataSource(Context context, int position) {
        DatabaseManager dbManager = new DatabaseManager(context);
        dbManager.open();
        Cursor cursor = dbManager.readAssociazione(position);
        while (cursor.moveToNext())
        {
            Cursor cursor2 = dbManager.readProduct(cursor.getInt(cursor.getColumnIndex(KEY_ID_RIFERIMENTO_PRODUCT)));
            addItemToDataSource(context, new Product (cursor2.getString(cursor2.getColumnIndex(KEY_NAME))));
        }
    }
}
