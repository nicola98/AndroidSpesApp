package com.example.corsista.androidspesapp.logic;

import android.content.Context;

import com.example.corsista.androidspesapp.data.ListSingleton;
import com.example.corsista.androidspesapp.data.Lista;
import java.util.List;

public class ListUtils {

    public static void initDataSource(Context context) {
        List<Lista> lista = ListSingleton.getInstance().getListaArray();
        lista.add(new Lista("Lista Mercato"));
        lista.add(new Lista("Macelleria"));
        lista.add(new Lista("Panificio"));
        lista.add(new Lista("Per festa da Livio"));
        ListSingleton.getInstance().setListaArray(lista);
    }

    public static List<Lista> getDataSourceItemList() {
        return ListSingleton.getInstance().getListaArray();
    }

    public static void addProduct(String item) {
        List<Lista> lista = ListSingleton.getInstance().getListaArray();
        lista.add(new Lista(item));
        ListSingleton.getInstance().getListaArray();
    }

    public static void removeProduct(int pos) {
        List<Lista> lista = ListSingleton.getInstance().getListaArray();
        lista.remove(pos);
    }
}
