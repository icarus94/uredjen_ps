/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Zadatak;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author elezs
 */
public class ZadatakTableModel extends AbstractTableModel {

    String[] naziviKolona = new String[]{"Sifra zadatka", "Naziv", "Opis", "Datum", "Ime", "Prezime"};
    List<Zadatak> zadaci = new ArrayList<>();
    
    public String getColumnName(int column){
        return naziviKolona[column];
    }

    @Override
    public int getRowCount() {
        return zadaci.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zadatak z  = zadaci.get(rowIndex);
        switch(columnIndex){
            case 0: return z.getSifraZadatka();
            case 1: return z.getNaziv();
            case 2: return z.getOpis();
            case 3: return z.getDatum();
            case 4: return z.getZaposleni().getIme();
            case 5: return z.getZaposleni().getPrezime();
            default: return "N/A";
        }
    }

    public void sacuvajZadatak(Zadatak zadatak) {
        //System.out.println(zadatak.getDatum());
        zadaci.add(zadatak);
        fireTableDataChanged();
    }

}
