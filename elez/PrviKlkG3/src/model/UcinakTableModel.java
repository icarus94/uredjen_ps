/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller;
import domen.Ucinak;
import exception.ValidacijaException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author elezs
 */
public class UcinakTableModel extends AbstractTableModel {

    String[] naziviKolona = new String[]{"Vrsta posla", "Ime i prezime", "Broj sati", "Datum"};
    List<Ucinak> ucinci;

    public UcinakTableModel() {
        ucinci = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return ucinci.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ucinak ucinak = ucinci.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {
            case 0:
                return ucinak.getVrstaPosla();
            case 1:
                return ucinak.getRadnik();
            case 2:
                return ucinak.getBrojSati();
            case 3:
                return sdf.format(ucinak.getDatum());
            default:
                return "N/A";
        }
    }

    public String getColumnName(int columnIndex) {
        return naziviKolona[columnIndex];
    }

    /*@Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return true;
        }
        return false; //To change body of generated methods, choose Tools | Templates.
        //pravi se switch po columnIndex gde se navodi sta moze da se menja
        
    }*/

 /*@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String vr = (String) aValue;
        Ucinak ucinak = ucinci.get(rowIndex);
        switch(columnIndex){
            case 0: ucinak.getVrstaPosla().setNaziv(vr);
            case 1: ucinak.getRadnik();
        }
    }*/
    public void ubaciUListu(Ucinak u) throws ValidacijaException {
        validiraj(u);
        ucinci.add(u);
        fireTableDataChanged();
    }

    private void validiraj(Ucinak u) throws ValidacijaException {
        int radnikID = u.getRadnik().getRadnikID();
        int vpID = u.getVrstaPosla().getVrstaPoslaID();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String datumU = sdf.format(u.getDatum());
        int ukupnoSati = u.getBrojSati();
        for (Ucinak ucinak : ucinci) {
            if (ucinak.getRadnik().getRadnikID() == radnikID && sdf.format(ucinak.getDatum()).equals(datumU)) {
                if (ucinak.getVrstaPosla().getVrstaPoslaID() == vpID) {
                    ukupnoSati += ucinak.getBrojSati();
                }else{
                    throw new ValidacijaException("Jedan radnik ne moze raditi vise vrsta poslova");
                }
            }
            if (ukupnoSati > 8) {
                throw new ValidacijaException("Radnik ne moze raditi vise od 8h");
            }
        }
    }

    public void obrisiRed(int red) {
        ucinci.remove(red);
        fireTableDataChanged();
    }

    public List<Ucinak> vratiListu() {
        return ucinci;
    }
}
