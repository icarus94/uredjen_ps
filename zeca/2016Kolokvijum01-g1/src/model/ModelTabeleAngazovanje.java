/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Angazovanje;
import exception.ValidacijaException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Zeljko
 */
public class ModelTabeleAngazovanje extends AbstractTableModel {

    List<Angazovanje> angazovanja;
    //приказује се градилиште, име и презиме радника, број ангажованих сати и датум ангажовања
    String[] kolone = {"Gradilište", "Ime i prezime", "Broj sati", "Datum angažovanja"};

    public ModelTabeleAngazovanje(List<Angazovanje> angazovanja) {
        this.angazovanja = angazovanja;
    }

    public ModelTabeleAngazovanje() {
        angazovanja = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        if (angazovanja == null) {
            return 0;
        }
        return angazovanja.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return kolone[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Angazovanje ang = angazovanja.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {
            case 0:
                return ang.getGradiliste();
            case 1:
                return ang.getRadnik();
            case 2:
                return ang.getBrojSati();
            case 3:
                return sdf.format(ang.getDatum());
            default:
                return "N/A";
        }
    }

    public void dodajAngazovanje(Angazovanje ang) throws ValidacijaException {
        validiraj(ang);
        angazovanja.add(ang);
        fireTableDataChanged();
    }

    public void validiraj(Angazovanje ang) throws ValidacijaException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String datum = sdf.format(ang.getDatum());
        int ukupnoSati = ang.getBrojSati();

        for (Angazovanje angazovanje : angazovanja) {
            String datum1 = sdf.format(angazovanje.getDatum());

            if (angazovanje.getRadnik().getRadnikID() == ang.getRadnik().getRadnikID() && datum.equals(datum1)) {
                if (angazovanje.getGradiliste().getGradilisteID() != ang.getGradiliste().getGradilisteID()) {
                    throw new ValidacijaException("U okviru jednog dana jedan radnik moze biti angazovan samo na jednom gradilistu!");
                }
                ukupnoSati += angazovanje.getBrojSati();
            }

        }
        if (ukupnoSati > 8) {
            throw new ValidacijaException("Radnik moze biti angazovan najvise 8 sati u toku jednog dana!");
        }

    }

    public void obrisiAngazovanje(int red) {
        angazovanja.remove(red);
        fireTableDataChanged();
    }

    public List<Angazovanje> getAngazovanja() {
        return angazovanja;
    }

    public void setAngazovanja(List<Angazovanje> angazovanja) {
        this.angazovanja = angazovanja;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==0){
            return true;
        }
        return false;
    }

    @Override
    //setValueAt("Mirijevo",0,0)
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String vrednost = (String) aValue;
        Angazovanje ang = angazovanja.get(rowIndex);
        switch(columnIndex){
            case 0: ang.getGradiliste().setNaziv(vrednost);
            default: return;
        }
    }
    
    

}
