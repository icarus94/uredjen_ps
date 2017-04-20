/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltabele;

import domen.Zadatak;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Miroslav
 */
public class ModelTabeleZadatak extends AbstractTableModel{
    
    ArrayList<Zadatak> lista;
    String[] kolone = {"Sifra zadatka","Naziv","Opis","Datum","Ime","Prezime"};

    public ModelTabeleZadatak() {
        lista = new ArrayList<>();
    }
    //kada budu trazili da vec imas podatke 
    public ModelTabeleZadatak(ArrayList<Zadatak> lista) {
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

        Zadatak z = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        switch(columnIndex){
            case 0: return z.getSifra();
            case 1: return z.getNaziv();
            case 2: return z.getOpis();
            case 3: return sdf.format(z.getDatum());
            case 4: return z.getZaposleni().getIme();
            case 5: return z.getZaposleni().getPrezime();
            
            default: return "Kim Kardasijan is fat";
        }
        
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodajZadatak(Zadatak zad) {
        lista.add(zad);
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==0 || columnIndex == 1 || columnIndex==3){
            return true;
        }
        
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Zadatak z = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                String sifra = (String) aValue;
                String regex = "SIF-[0-9]+";
                if(!sifra.matches(regex)){
                    JOptionPane.showMessageDialog(null, "Sifra mora biti u formatu SIF-1");
                    break;
                }
                z.setSifra(sifra);
                break;
            case 1: 
                String naziv = (String) aValue;
                z.setNaziv(naziv);
                break;
            case 3:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                String dat = (String) aValue;
                Date datum ;

                try {
                    datum = sdf.parse(dat);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Datum mora biti u formatu dd.MM.yyyy");
                    return;
                }
                z.setDatum(datum);
                break;  
        }
    }

    public ArrayList<Zadatak> getLista() {
        return lista;
    }
    
    
    
    
}
