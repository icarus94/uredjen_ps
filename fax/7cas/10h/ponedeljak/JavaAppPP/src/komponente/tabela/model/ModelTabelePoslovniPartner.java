/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponente.tabela.model;

import domen.PoslovniPartner;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author student
 */
public class ModelTabelePoslovniPartner extends AbstractTableModel {

    List<PoslovniPartner> partneri;
    String[] kolone = {"PIB", "Maticni broj", "Naziv", "Adresa", "Sediste"};

    public ModelTabelePoslovniPartner(List<PoslovniPartner> partneri) {
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
        return 5;
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
                return partner.getUlica() + " " + partner.getBroj();
            case 4:
                return partner.getMesto();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        
        return kolone[column];
    }

}
