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
public class MojModelTabele extends AbstractTableModel{
    
    ArrayList<Ucinak> lista ;
    String[] kolone = {"Vrsta posla","Ime i prezime","Broj sati","Datum"};
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public MojModelTabele() {
        lista = new ArrayList<>();
    }

    public MojModelTabele(ArrayList<Ucinak> lista) {
        this.lista = lista;
    }
    
    

    @Override
    public int getRowCount() {

        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Ucinak u = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return u.getVrstaPosla();
            case 1: return u.getRadnik();
            case 2: return u.getBrojSati();
            case 3: return sdf.format(u.getDatum());
            
            default: return "Lepi Moma";
        }

    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodaj(Ucinak u) {
        lista.add(u);
        fireTableDataChanged();
    }

    public void obrisiRed(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

    public ArrayList<Ucinak> getLista() {
        return lista;
    }
    
    
    
}
