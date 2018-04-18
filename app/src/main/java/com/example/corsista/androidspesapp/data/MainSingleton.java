package com.example.corsista.androidspesapp.data;

import android.content.Context;

import java.util.List;

public class MainSingleton {

    private static MainSingleton ourInstance = new MainSingleton();
    private DatabaseManager databaseManager;

    //list
    private List<Lista> liste;
    private String currentUser;


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



    public List<Lista> getListe(){
        return this.liste;
    }

    public void setListe(List<Lista> listSetter){
        this.liste=listSetter;
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
        this.liste.get(position).addProdotti(prodottoo);
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }


    public  String getCurrentUser() {
        return currentUser;
    }
}
