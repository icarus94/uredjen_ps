/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltabele;

import domen.Angazovanje;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Miroslav
 */
public class ModelTabeleAngazovanja extends AbstractTableModel{
    
    ArrayList<Angazovanje> lista ;
    String[] kolone = {"Gradiliste", "Ime i prezime","Broj sati","Datum"};

    public ModelTabeleAngazovanja() {
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        Angazovanje a = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return a.getGradiliste();
            case 1: return a.getRadnik();
            case 2: return a.getBrojSati();
            case 3: 
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                return sdf.format(a.getDatum());
                
            
            default: return "Betmen";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodaj(Angazovanje a) {
        lista.add(a);
        fireTableDataChanged();
    }

    public void obrisi(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

    public ArrayList<Angazovanje> getLista() {
        return lista;
    }

}
