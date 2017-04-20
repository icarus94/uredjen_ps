/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Ucinak;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Miroslav
 */
public class ModelTabeleUcinci extends AbstractTableModel{

    ArrayList<Ucinak> lista ;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleUcinci() {
        lista = new ArrayList<>();
    }

    public ModelTabeleUcinci(ArrayList<Ucinak> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ucinak u = lista.get(rowIndex);
        
        
        switch(columnIndex){
            case 0: return u.getVrstaPosla();
            case 1: return u.getRadnik();
            case 2: return u.getBrojSati();
            case 3: return sdf.format(u.getDatum());
            default: return "Bas kidamo danas";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Vrsta posla";
            case 1: return "Ime i prezime";
            case 2: return "Broj sati";
            case 3: return "Datum";
            default: return "Koliko kidamo danas???";
        }
    }

    public void dodaj(Ucinak u) {
        lista.add(u);
        fireTableDataChanged();
    }

    public void obrisi(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

    public ArrayList<Ucinak> getLista() {
        return lista;
    }
    
}
