/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeliTabele;

import domen.Lokacija;
import domen.Radnik;
import domen.Raspored;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Miroslav
 */
public class ModelTabeleRasporedi extends AbstractTableModel{
    
    ArrayList<Raspored> listaRasporeda;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleRasporedi() {
        listaRasporeda = new ArrayList<>();
    }

    public ModelTabeleRasporedi(ArrayList<Raspored> listaRasporeda) {
        this.listaRasporeda = listaRasporeda;
    }
    
    @Override
    public int getRowCount() {
        return listaRasporeda.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Raspored r = listaRasporeda.get(rowIndex);
        
        switch(columnIndex){
            case 0: return r.getLokacija();
            case 1: return r.getRadnik();
            case 2: return r.getBrojSati();
            case 3:
                
                return sdf.format(r.getDatum()) ;
            
            default: return "Bas smo dobra grupa, sve znamooo ";
        }
    }
    
    String[] imenaKolona = {"Lokacija","Ime i prezime","Broj sati","Datum"};

    @Override
    public String getColumnName(int column) {
        return imenaKolona[column];
    }

    public void dodaj(Raspored raspored) {
        listaRasporeda.add(raspored);
        fireTableDataChanged();
    }

    public void obrisi(int red) {
        listaRasporeda.remove(red);
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;       
   }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Raspored r = listaRasporeda.get(rowIndex);
        
        switch(columnIndex){
            case 0: 
                Lokacija lokacija = (Lokacija) aValue;
                r.setLokacija(lokacija);
                break;
            case 1:
                Radnik rad = (Radnik) aValue;
                r.setRadnik(rad);
                break;
                
            case 2: 
                String brS = (String) aValue;
                int brojSati = Integer.parseInt(brS);
                r.setBrojSati(brojSati);
                break;
            case 3: 
                String dat = (String) aValue;
        {
            try {
                Date datum = sdf.parse(dat);
                r.setDatum(datum);
            } catch (ParseException ex) {
                Logger.getLogger(ModelTabeleRasporedi.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
        }
        }
    }

    public ArrayList<Raspored> getListaRasporeda() {
        return listaRasporeda;
    }
    
    
    
}
