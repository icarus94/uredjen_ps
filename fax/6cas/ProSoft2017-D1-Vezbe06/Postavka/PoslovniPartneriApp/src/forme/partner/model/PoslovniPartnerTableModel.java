/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.partner.model;

import domen.PoslovniPartner;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import poslovnalogika.Kontroler;

/**
 *
 * @author student
 */
public class PoslovniPartnerTableModel extends AbstractTableModel {

    private List<PoslovniPartner> lp;
    private String[] kolone = new String[]{"PartnerID", "Naziv", "PIB", "Maticni broj", "Ulica", "Broj", "Mesto"};

    public PoslovniPartnerTableModel(List<PoslovniPartner> lp) {
        this.lp = lp;
    }

    @Override
    public int getRowCount() {
        // return Kontroler.getInstance().vratiPartnere().size();
        if (lp == null) {
            return 0;
        }
        return lp.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PoslovniPartner pp = lp.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pp.getPartnerID();
            case 1:
                return pp.getNaziv();
            case 2:
                return pp.getPib();
            case 3:
                return pp.getMaticniBroj();
            case 4:
                return pp.getUlica();
            case 5:
                return pp.getBroj();
            case 6:
                return pp.getMesto();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 1) {
            return true;
        }
        return false;
    }
    
    public PoslovniPartner vratiPartnera(int index) {
        return lp.get(index);
    }

}
