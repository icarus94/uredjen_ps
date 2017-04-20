/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponente.tabela.model;

import domen.Mesto;
import domen.PoslovniPartner;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author student
 */
public class ModelTabelePoslovniPartnerUnos extends AbstractTableModel {

    List<PoslovniPartner> partneri;
    String[] kolone = {"PIB", "Maticni broj", "Naziv", "Ulica", "Broj", "Sediste"};

    public ModelTabelePoslovniPartnerUnos(List<PoslovniPartner> partneri) {
        this.partneri = partneri;
    }

    @Override
    public int getRowCount() {
        if (partneri == null) {
            return 0;
        }
        return partneri.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PoslovniPartner partner = partneri.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return partner.getPib();
            case 1:
                return partner.getMaticniBroj();
            case 2:
                return partner.getNaziv();
            case 3:
                return partner.getUlica();
            case 4:
                return partner.getBroj();
            case 5:
                return partner.getMesto();
            default:
                return "N/A";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        PoslovniPartner pp=partneri.get(rowIndex);
        switch(columnIndex){
            case 0: pp.setPib((String)aValue); break;
            case 1: pp.setMaticniBroj((String)aValue); break;
            case 2: pp.setNaziv((String)aValue); break;
            case 3: pp.setUlica((String)aValue); break;
            case 4: pp.setBroj((String)aValue); break;
            case 5: pp.setMesto((Mesto)aValue); break;
        }
    }
    
    

    @Override
    public String getColumnName(int column) {
        
        return kolone[column];
    }
    
    public void dodajPoslovnogPartnera(PoslovniPartner pp){
        partneri.add(pp);
        fireTableDataChanged();
    }
    
    public void obrisiPoslovnogPartnera(int rowIndex){
        partneri.remove(rowIndex);
        fireTableDataChanged();
    }
    
    public List<PoslovniPartner> vratiListuPoslovnihPartnera(){
        return partneri;
    }

}
