/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Asistent;
import domen.Predmet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Miroslav
 */
public class ModelTabeleAsistenti extends AbstractTableModel{
    
    ArrayList<Asistent> lista;
    String[] imenaKolona = {"Sifra","Ime","Prezime","Titula","Predmet"};

    public ModelTabeleAsistenti() {
        lista = new ArrayList<>();
    }

    public ModelTabeleAsistenti(ArrayList<Asistent> lista) {
        this.lista = lista;
    }
    

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return imenaKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Asistent a = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return a.getSifra();
            case 1: return a.getIme();
            case 2: return a.getPrezime();
            case 3: return a.getTitula();
            case 4: return a.getPredmet();
            default: return "Andjela vestica";
        }
    }

    @Override
    public String getColumnName(int column) {
        return imenaKolona[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //if(columnIndex == 0 || columnIndex == 1)
            //return true;
        
        //return false;
        
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        Asistent a = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: 
                String sif = (String) aValue;
                int sifra = Integer.parseInt(sif);
                a.setSifra(sifra);
                break;
            case 1: 
                String ime = (String) aValue;
                a.setIme(ime);
                break;
            case 2: 
                String prezime = (String) aValue;
                a.setPrezime(prezime);
                break;
            case 3: 
                String titula = (String) aValue;
                a.setTitula(titula);
                break;
            case 4: 
                Predmet p = (Predmet) aValue;
                a.setPredmet(p);
                break;
        }

    }
    
    public void dodaj(){
        lista.add(new Asistent());
        fireTableDataChanged();
    }
    
    public void obrisi(int red){
        lista.remove(red);
        fireTableDataChanged();
    }

    public ArrayList<Asistent> getLista() {
        return lista;
    }

    public void clear() {
        lista = new ArrayList<>();
        fireTableDataChanged();
    }

    public Asistent vratiIzabranogAsistenta(int red) {
        return lista.get(red);
    }
    
    
    
}
