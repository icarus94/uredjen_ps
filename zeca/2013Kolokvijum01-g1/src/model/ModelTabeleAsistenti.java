/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Asistent;
import domen.Predmet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import kontroler.Kontroler;

/**
 *
 * @author Zeljko
 */
public class ModelTabeleAsistenti extends AbstractTableModel {

    List<Asistent> lista;
    String[] kolone = {"Sifra", "Ime", "Prezime", "Titula", "Predmet"};

    public ModelTabeleAsistenti() {
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
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Asistent a = lista.get(rowIndex);
        if (aValue instanceof Predmet) {
            a.setPredmet((Predmet) aValue);
        } else {
            String value = (String) aValue;
//        Asistent a = lista.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    int sifra = 0;
                    try {
                        sifra = Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        break;
                    }
                    a.setSifraAsistenta(sifra);
                    break;
                case 1:
                    a.setIme(value);
                    break;
                case 2:
                    a.setPrezime(value);
                    break;
                case 3:
                    a.setTitula(value);
                    break;
                case 4:
                    break;

            }
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Asistent a = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                if (a.getSifraAsistenta() == -1) {
                    return "";
                }
                return a.getSifraAsistenta();
            case 1:
                if (a.getIme() == null) {
                    return "";
                }
                return a.getIme();
            case 2:
                if (a.getPrezime() == null) {
                    return "";
                }
                return a.getPrezime();
            case 3:
                if (a.getTitula() == null) {
                    return "";
                }
                return a.getTitula();
            case 4:
                if (a.getPredmet() == null) {
                    return "";
                }
                return a.getPredmet().getNaziv();
            default:
                return "N/A";
        }
        //table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(myComboBox));
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column]; //To change body of generated methods, choose Tools | Templates.
    }

    public void dodajPolje() {
        lista.add(new Asistent());
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    public List<Asistent> getLista() {
        return lista;
    }

    public void setLista(List<Asistent> lista) {
        this.lista = lista;
    }

    public void obrisiPolje(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

}
