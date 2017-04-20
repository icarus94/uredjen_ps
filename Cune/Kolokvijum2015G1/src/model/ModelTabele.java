/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Prijava;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Miroslav
 */
public class ModelTabele extends AbstractTableModel{
    ArrayList<Prijava> lista;

    public ModelTabele(ArrayList<Prijava> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prijava pr = lista.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch(columnIndex){
            case 0: return pr.getStudent();
            case 1: return  pr.getStudent().getBrojIndeksa();
            case 2: return sdf.format(pr.getDatum());
            case 3: return pr.getOcena();
            case 4: return pr.getPredmet();
            case 5: return pr.getStatus();
            
            default: return "Sta znam";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Ime i prezime";
            case 1: return  "Broj indeksa";
            case 2: return  "Datum";
            case 3: return "Ocena";
            case 4: return "Predmet";
            case 5: return "Status";
            
            default: return "Znas li";
        }
    }
    
}
