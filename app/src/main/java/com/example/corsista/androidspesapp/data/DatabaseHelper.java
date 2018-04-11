package com.example.corsista.androidspesapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "shopMyListDatabase.db";
    private static final int DATABASE_VERSION = 1;

    // Lo statement SQL di creazione del database
    private static final String DATABASE_CREATE=
            "CREATE TABLE "+DatabaseManager.USER_TABLE +" ("+
                    DatabaseManager.KEY_CONTACTID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DatabaseManager.KEY_NAME + " TEXT, " +
                    DatabaseManager.KEY_SURNAME + " TEXT, " +
                    DatabaseManager.KEY_URLIMAGE + " TEXT, " +
                    DatabaseManager.KEY_EMAIL + " TEXT, " +
                    DatabaseManager.KEY_USERNAME + " TEXT, " +
                    DatabaseManager.KEY_PASSWORD + " TEXT, " +
                    DatabaseManager.KEY_FIRSTTIME + " TEXT" + ");";

    // Costruttore
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Questo metodo viene chiamato durante la creazione del database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    // Questo metodo viene chiamato durante l'upgrade del database,
    // ad esempio quando viene incrementato il numero di versione
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion ) {
        database.execSQL("DROP TABLE IF EXISTS "+DatabaseManager.USER_TABLE);
        onCreate(database);
    }
}
