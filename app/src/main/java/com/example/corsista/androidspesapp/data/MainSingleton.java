package com.example.corsista.androidspesapp.data;

import android.content.Context;

public class MainSingleton {

    private static MainSingleton ourInstance = new MainSingleton();
    private DatabaseManager databaseManager;

    public static MainSingleton getInstance() {
        return ourInstance;
    }

    public void openDatabase(Context context){
        databaseManager = new DatabaseManager(context);
        databaseManager.open();
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public void closeDatabase(){
        databaseManager.close();
    }
}
