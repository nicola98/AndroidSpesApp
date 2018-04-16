package com.example.corsista.androidspesapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class DatabaseManager {

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    private Context mContext;

    // Database constants
    public static final String USER_TABLE = "user";
    public static final String DATABASE_TABLE_LIST = "listDelleListe";
    public static final String KEY_CONTACTID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_SURNAME = "surname";
    public static final String KEY_URLIMAGE = "urlImage";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_FIRSTTIME = "firstTime";
    public static final String KEY_LISTID = "list_id";

    public DatabaseManager(Context context) {
        mContext = context;
    }

    public DatabaseManager open() throws SQLException {
        dbHelper = new DatabaseHelper(mContext);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentValues(String name, String surname, String urlImage, String email, String username, String password, boolean firstTime) {
        ContentValues values = new ContentValues();
        values.put( KEY_NAME, name );
        values.put( KEY_SURNAME, surname );
        values.put( KEY_URLIMAGE, urlImage);
        values.put( KEY_EMAIL, email );
        values.put( KEY_USERNAME, username );
        values.put( KEY_PASSWORD, password );
        values.put( KEY_FIRSTTIME, firstTime );
        return values;
    }






    //create a user
    public long createUser(User user ) {
        ContentValues initialValues = createContentValues(user.getName(), user.getSurname(), user.getUrlImage(), user.getEmail(), user.getUsername(), user.getPassword(), user.getFirstTime());
        return database.insertOrThrow(USER_TABLE, null, initialValues);
    }

    //update a user
    public boolean updateUser(int contactID, User user) {
        ContentValues updateValues = createContentValues(user.getName(), user.getSurname(), user.getUrlImage(), user.getEmail(), user.getUsername(), user.getPassword(), user.getFirstTime());
        return database.update(USER_TABLE, updateValues, KEY_CONTACTID + "=" + contactID, null) > 0;
    }

    //delete a contact
    public boolean deleteUser(long userID) {
        return database.delete(USER_TABLE, KEY_CONTACTID + "=" + userID, null) > 0;
    }

    //fetch all contacts
    public Cursor fetchAllUsers() {
        return database.query(USER_TABLE, null, null, null, null, null, null);
    }

    public boolean checkUser(String username, String password) {
       Cursor cursor = database.query(USER_TABLE, null, KEY_USERNAME + " = ? AND "+ KEY_PASSWORD+ " = ?", new String[]{username, password}, null, null, null);

       cursor.getString(cursor.getColumnIndex(KEY_USERNAME));

       boolean found = cursor != null && cursor.getCount() > 0;
       cursor.close();
       return  found;
    }

    public Cursor readUser(String username) {
        String[] columns = new String[]{KEY_PASSWORD};
        return database.query(USER_TABLE, columns, "username = '"+username+"'", null, null, null, null);
    }


//LISTA


    private ContentValues createListContentValues(String name, int id) {
        ContentValues values = new ContentValues();
        values.put( KEY_NAME, name );
        values.put(KEY_CONTACTID, id);
        return values;

    }


    //mettere invece di user tua classe lista
    public long createLista(String name, int id ) {
        ContentValues initialValues = createListContentValues(name, id);
        return database.insertOrThrow(DATABASE_TABLE_LIST, null, initialValues);
    }

    //mettere invece di user tua classe lista
    public boolean updateLista(Lista lista) {
        ContentValues updateValues = createListContentValues(lista.getNome(), lista.getId_utente());
        return database.update(DATABASE_TABLE_LIST, updateValues, KEY_LISTID + "=" + lista.getId_lista(), null) > 0;
    }

    //delete a contact
    public boolean deleteLista(Lista  lista) {
        return database.delete(DATABASE_TABLE_LIST, KEY_CONTACTID + "=" + lista.getId_lista(), null) > 0;
    }

    //fetch all contacts
    public Cursor fetchAllLista() {
        return database.query(DATABASE_TABLE_LIST, null, null, null, null, null, null);
    }

    public Cursor readList(int id) {
        String[] columns = new String[]{"*"};
        return database.query(DATABASE_TABLE_LIST, columns, "list_id = '"+id+"'", null, null, null, null);
    }

    public Cursor getListsByUser(int id_user){
        String[] columns = new String[] {"*"};
        return database.query(DATABASE_TABLE_LIST, columns, KEY_CONTACTID+" = "+id_user, null, null, null, null);
    }
}