package com.example.corsista.androidspesapp.logic;

import android.content.Context;
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

        return MainSingleton.getInstance().getDatabaseManager().createUser(itemToAdd);

    }

    public static boolean removeItem(Context context, long userId) {

        return MainSingleton.getInstance().getDatabaseManager().deleteUser(userId);

    }

    public static void openDatabase(Context context) {

        MainSingleton.getInstance().openDatabase(context);

    }

}
