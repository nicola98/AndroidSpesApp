package com.example.corsista.androidspesapp.data;

import java.util.ArrayList;
import java.util.List;

public class Lista {

    private int id_lista;
    private String nome;
    private String username;
    private List<Prodotto> articoli = new ArrayList<Prodotto>();

    public Lista( String nome, String username) {
        this.nome = nome;
        this.username = username;
    }


    public Lista( String nome, String username, List<Prodotto> articoli ) {
        this.nome = nome;
        this.username = username;
        this.articoli = articoli;
    }


    public int getId_lista() {
        return id_lista;
    }



    public String getNomeLista() {
        return nome;
    }



    public String getUsername() {
        return username;
    }



    public List<Prodotto> getProdotti() {
        return articoli;
    }



    public void addProdotti(Prodotto prodotto) {
        this.articoli.add(prodotto);
    }
}
