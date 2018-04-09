package com.example.corsista.androidspesapp.logic;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;

import com.example.corsista.androidspesapp.data.MainSingleton;
import com.example.corsista.androidspesapp.data.User;

public class DataAccessUtils {

    public final static String PREFS_FILENAME = "favoriteFile";
    public final static String PREFS_FAVORITE_KEY = "favoriteKey";

    public static Cursor getDataSourceItemList(Context context) {

        return MainSingleton.getInstance().getDatabaseManager().fetchAllUsers();
    }

    public static long addItemToDataSource(Context context, User itemToAdd) {

        return MainSingleton.getInstance().getDatabaseManager().createContact(itemToAdd);

    }

    public static boolean removeItem(Context context, long contactId) {

        return MainSingleton.getInstance().getDatabaseManager().deleteContact(contactId);

    }

    public static void openDatabase(Context context) {

        MainSingleton.getInstance().openDatabase(context);

    }

}
