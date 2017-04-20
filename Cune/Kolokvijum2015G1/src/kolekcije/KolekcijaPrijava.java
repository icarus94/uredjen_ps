/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kolekcije;

import domen.Prijava;
import java.util.ArrayList;

/**
 *
 * @author Miroslav
 */
public class KolekcijaPrijava {
    ArrayList<Prijava> listaPrijava;

    public KolekcijaPrijava() {
        listaPrijava = new ArrayList<>();
    }
    
    public void dodajUListu(Prijava p){
        
        if(listaPrijava.contains(p)){
            for (Prijava pr : listaPrijava) {
                if(pr.equals(p)){
                    pr.setDatum(p.getDatum());
                    pr.setOcena(p.getOcena());
                    pr.setStatus("UPDATE");
                }
            }
        }else{
            listaPrijava.add(p);
        }
        
        
    }

    public ArrayList<Prijava> getListaPrijava() {
        return listaPrijava;
    }

    public void setListaPrijava(ArrayList<Prijava> listaPrijava) {
        this.listaPrijava = listaPrijava;
    }
}
