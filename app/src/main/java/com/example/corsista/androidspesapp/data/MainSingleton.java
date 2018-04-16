package com.example.corsista.androidspesapp.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class MainSingleton {

    private static MainSingleton ourInstance = new MainSingleton();
    private DatabaseManager databaseManager;

    //list
    private static User user;
    private List<Lista> liste = new ArrayList<Lista>();



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


    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        MainSingleton.user = user;
    }


    public List<Lista> getListe(){
        return this.liste;
    }

    public void addLista(Lista lista){
        this.liste.add(lista);
    }


    public void resetListe(){
        this.liste.clear();
    }


    public void removeLocation(Lista lista){
        this.liste.remove(liste);
    }

    public void addArticolo(int position, Prodotto prodottoo) {
        this.liste.get(position).addArticolo(prodottoo);

    }

}
