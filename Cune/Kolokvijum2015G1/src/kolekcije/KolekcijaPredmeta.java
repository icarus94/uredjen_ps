/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kolekcije;

import domen.Predmet;
import java.util.ArrayList;

/**
 *
 * @author Miroslav
 */
public class KolekcijaPredmeta {
    ArrayList<Predmet> listaPredmeta;

    public KolekcijaPredmeta() {
        listaPredmeta = new ArrayList<>();
    }

    public void setListaPredmeta(ArrayList<Predmet> listaPredmeta) {
        this.listaPredmeta = listaPredmeta;
    }

    public ArrayList<Predmet> getListaPredmeta() {
        return listaPredmeta;
    }
    
    public void dodajUListu(Predmet p){
        listaPredmeta.add(p);
    }
}
