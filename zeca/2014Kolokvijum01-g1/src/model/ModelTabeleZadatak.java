/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Zadatak;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Zeljko
 */
public class ModelTabeleZadatak extends AbstractTableModel {

    List<Zadatak> zadaci;
    String[] kolone = {"Sifra zadatka", "Naziv", "Opis", "Datum", "Ime radnika", "Prezime radnika"};
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleZadatak() {
        this.zadaci = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return zadaci.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zadatak zad = zadaci.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return zad.getSifraZadatka();
            case 1:
                return zad.getNaziv();
            case 2:
                return zad.getOpis();
            case 3:
                return sdf.format(zad.getDatum());
            case 4:
                return zad.getZaposleni().getIme();
            case 5:
                return zad.getZaposleni().getPrezime();
            default:
                return "N/A";
        }
    }

    public List<Zadatak> getZadaci() {
        return zadaci;
    }

    public void setZadaci(List<Zadatak> zadaci) {
        this.zadaci = zadaci;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0 || columnIndex == 1 || columnIndex == 3) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Zadatak z = zadaci.get(rowIndex);
        switch (columnIndex) {
            case 0:
                z.setSifraZadatka((String) aValue);
                break;
            case 1: 
                z.setNaziv((String) aValue);
                break;
            case 3:{
                String datum = (String) aValue;
                Date dat;
                try {
                    dat = sdf.parse(datum);
                    if(!datum.equals(sdf.format(dat))){
                        throw new ParseException(datum, rowIndex);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(ModelTabeleZadatak.class.getName()).log(Level.SEVERE, null, ex);
                    dat = z.getDatum();
                }
                z.setDatum(dat);
                System.out.println(z.getDatum());
                break;
            }
       }

        super.setValueAt(aValue, rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    public void dodajUListu(Zadatak z) {
        zadaci.add(z);
        fireTableDataChanged();
    }

    public void isprazniListu() {
        zadaci.clear();
        fireTableDataChanged();
    }

}
