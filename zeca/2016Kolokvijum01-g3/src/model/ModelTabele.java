/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Ucinak;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Zeljko
 */
public class ModelTabele extends AbstractTableModel {

    List<Ucinak> lista;
    String[] kolone = {"Vrsta posla", "Ime i prezime", "Broj sati", "Datum"};
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabele() {
        lista = new ArrayList<>();
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
    public String getColumnName(int column) {
        return kolone[column]; //To change body of generated methods, choose Tools | Templates.
    }

    public List<Ucinak> getLista() {
        return lista;
    }

    public void setLista(List<Ucinak> lista) {
        this.lista = lista;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ucinak u = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return u.getVrstaPosla();
            case 1:
                return u.getRadnik();
            case 2:
                return u.getBrojSati();
            case 3:
                return sdf.format(u.getDatum());
            default:
                return "N/A";
        }
    }

    public void ubaciUListu(Ucinak u) throws Exception {
        validiraj(u);
        lista.add(u);
        fireTableDataChanged();
    }

    public void obrisi(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

    private void validiraj(Ucinak u) throws Exception {
        int id = u.getRadnik().getRadnikID();
        int vpID = u.getVrstaPosla().getVrstaPoslaID();
        String datum = sdf.format(u.getDatum());
        int ukupnoSati = u.getBrojSati();
        for (Ucinak ucinak : lista) {

            if (ucinak.getRadnik().getRadnikID() == id) {
                if (ucinak.getVrstaPosla().getVrstaPoslaID() != vpID) {
                    throw new Exception("Jedan radnik moze biti angazovan samo na jednoj vrsti posla!");
                }
                if (sdf.format(ucinak.getDatum()).equals(datum)) {
                    ukupnoSati += ucinak.getBrojSati();
                }
            }
        }
        if (ukupnoSati > 8) {
            throw new Exception("Jedan radnik moze biti angazovan najvise 8 sati u toku istog dana");
        }
    }

}
