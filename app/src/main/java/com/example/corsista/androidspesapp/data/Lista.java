package com.example.corsista.androidspesapp.data;

import java.util.ArrayList;
import java.util.List;

public class Lista {

    private int id_lista;
    private String nome;
    private int id_utente;
    private List<Prodotto> articoli = new ArrayList<Prodotto>();

    public Lista(int id_lista, String nome, int id_utente) {
        this.id_lista = id_lista;
        this.nome = nome;
        this.id_utente = id_utente;
    }


    public int getId_lista() {
        return id_lista;
    }



    public String getNome() {
        return nome;
    }



    public int getId_utente() {
        return id_utente;
    }



    public List<Prodotto> getArticoli() {
        return articoli;
    }



    public void addArticolo(Prodotto prodotto) {
        this.articoli.add(prodotto);
    }
}
