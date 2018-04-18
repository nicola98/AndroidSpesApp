package com.example.corsista.androidspesapp.logic;

import android.content.Context;
import android.database.Cursor;

import com.example.corsista.androidspesapp.data.DatabaseManager;
import com.example.corsista.androidspesapp.data.ListSingleton;
import com.example.corsista.androidspesapp.data.Lista;

import java.util.List;

public class ListDataAccessUtils {


    public static List<Lista> getDataSourceItemList(Context context) {
        return ListSingleton.getInstance().getListe();
    }


    public static List<Lista> addItemToDataSource(Context context, Lista itemToAdd) {
        DatabaseManager listDatabaseManager = new DatabaseManager(context);
        listDatabaseManager.open();
        listDatabaseManager.createLista(itemToAdd);
        Cursor cursor = listDatabaseManager.readList2(itemToAdd.getUsername(), itemToAdd.getNomeLista());
        if(cursor.moveToFirst())
            listDatabaseManager.createUserList(itemToAdd.getUsername(), cursor.getInt(cursor.getColumnIndex("list_id")) );

        List<Lista> datasource = ListDataAccessUtils.getDataSourceItemList(context);
        datasource.add(itemToAdd);
        ListSingleton.getInstance().setListe(datasource);
        return datasource;
    }


    public static Lista getItemAtIndex(Context context, int index) {
        List<Lista> datasource = ListDataAccessUtils.getDataSourceItemList(context);
        return datasource.get(index);
    }


    public static List<Lista> removeItemAtIndex(Context context, int index) {
        List<Lista> datasource = ListDataAccessUtils.getDataSourceItemList(context);
        datasource.remove(index);
        ListSingleton.getInstance().setListe(datasource);
        return datasource;
    }


    public static void initDataSource(Context context, String username) {
        List<Lista> lista = ListDataAccessUtils.getDataSourceItemList(context);
        lista.clear();
        ListSingleton.getInstance().setListe(lista);
        DatabaseManager listDatabaseManager = new DatabaseManager(context);
        listDatabaseManager.open();
        Cursor cursor = listDatabaseManager.readUserList(username);
        while (cursor.moveToNext()) {
            Cursor cursorForList = listDatabaseManager.readList(cursor.getInt(cursor.getColumnIndex("id_riferimento_list")));
            if (cursorForList.moveToFirst() && cursorForList != null) {
                lista = ListDataAccessUtils.getDataSourceItemList(context);
                lista.add(new Lista(cursorForList.getString(cursorForList.getColumnIndex("name")), cursorForList.getString(cursorForList.getColumnIndex("username"))));
                ListSingleton.getInstance().setListe(lista);
            }

            cursorForList.close();
        }

        cursor.close();
    }

}