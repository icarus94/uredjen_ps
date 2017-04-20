/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Angazovanje;
import domen.Gradiliste;
import exception.ValidacijaException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author elezs
 */
public class AngazovanjeTableModel extends AbstractTableModel {

    List<Angazovanje> angazovanja = new ArrayList<>();

    public AngazovanjeTableModel(List<Angazovanje> angazovanja) {
        this.angazovanja = angazovanja;
    }

    public AngazovanjeTableModel() {
    }
    

    String[] naziviKolona = new String[]{"Gradiliste", "Ime i prezime", "Broj sati", "datum"};

    public String getColumnName(int column) {
        return naziviKolona[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return angazovanja.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Angazovanje a = angazovanja.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return a.getGradiliste();//.getNaziv();
            case 1:
                return a.getRadnik();//.getIme() + " " + a.getRadnik().getPrezime();
            case 2:
                return a.getBrojSati();
            case 3:
                return a.getDatum();
            default:
                return "N/A";
        }
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        Angazovanje a = angazovanja.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {

            case 0:
                a.getGradiliste();
                break;

            case 1:
                a.getRadnik().toString();
                break;

            case 2:
                a.getBrojSati();
                break;

            case 3:
                sdf.format(a.getDatum());
                break;
        }

    }

    public void dodajNoviRed(Angazovanje a) throws ValidacijaException {
        validiraj(a);
        angazovanja.add(a);
        System.out.println("Lista partnera:" + angazovanja);
        fireTableRowsInserted(angazovanja.size() - 1, angazovanja.size() - 1);

    }

    public void obrisiRed(int red) {
        angazovanja.remove(red);
        fireTableRowsDeleted(red, red);
    }
    public List<Angazovanje> vratiListuAngazovanja() {
        return angazovanja;
    }

    public void setListaPartnera(List<Angazovanje> angazovanja) {
        this.angazovanja = angazovanja;
        fireTableDataChanged();
    }
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    private void validiraj(Angazovanje a) throws ValidacijaException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String datumA = sdf.format(a.getDatum());
        int ukupnoSati = a.getBrojSati();
        
        for(Angazovanje angazovanje: angazovanja){
            String datumB = sdf.format(angazovanje.getDatum());
            if(a.getRadnik().getRadnikID() == angazovanje.getRadnik().getRadnikID() && datumA.equals(datumB)){
                if(a.getGradiliste().getGradilisteID() != angazovanje.getGradiliste().getGradilisteID()){
                    throw new ValidacijaException("U toku jednog dana, jedan radnik moze biti angazovan samo na jednom gradilistu");
                }
                ukupnoSati = ukupnoSati+a.getBrojSati();
            }
            if(ukupnoSati > 8){
                throw new ValidacijaException("Radnik ne moze raditi vise od 8h");
            }
        }
        
    }
}
