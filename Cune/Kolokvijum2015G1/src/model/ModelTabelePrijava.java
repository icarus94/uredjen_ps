/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Prijava;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Cule
 */
public class ModelTabelePrijava extends AbstractTableModel{
    
    ArrayList<Prijava> listaPrijava;

    public ModelTabelePrijava(ArrayList<Prijava> listaPrijava) {
        this.listaPrijava = listaPrijava;
    }

    @Override
    public int getRowCount() {
        return listaPrijava.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Prijava prijava = listaPrijava.get(row);
        switch(column){
            case 0: return prijava.getStudent().getIme() + " " + prijava.getStudent().getPrezime();
            case 1: return prijava.getStudent().getBrojIndeksa();
            case 2:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
                String datum = sdf.format(prijava.getDatum());
                return datum;
            case 3: return prijava.getOcena();
            case 4: return prijava.getPredmet();
                default: return "Why so serious? "; 
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Ime i prezime";
            case 1: return "Broj indeksa";
            case 2:
                return "Datum";
            case 3: return "Ocena";
            case 4: return "Naziv predmet";
                default: return "Betmen"; 
        }
    }
    
}
