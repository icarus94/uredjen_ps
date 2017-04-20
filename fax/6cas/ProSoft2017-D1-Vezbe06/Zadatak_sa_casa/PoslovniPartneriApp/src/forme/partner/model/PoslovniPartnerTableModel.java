/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.partner.model;

import domen.Mesto;
import domen.PoslovniPartner;
import java.util.List;
import javax.swing.table.AbstractTableModel;

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
        return true;
    }

    public PoslovniPartner vratiPartnera(int index) {
        return lp.get(index);
    }

    public void dodajRed() {
        PoslovniPartner pp = new PoslovniPartner();
        lp.add(pp);
        fireTableDataChanged();
        System.out.println("Dodat je novi red!");
    }

    public void obrisiRed(int index) {
        lp.remove(index);
        fireTableDataChanged();
        System.out.println("Obrisan je izabrani red!");
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        PoslovniPartner pp = lp.get(rowIndex);
        switch (columnIndex) {
            case 0:
                pp.setPartnerID(Integer.parseInt((String) aValue));
                break;
            case 1:
                pp.setNaziv((String) aValue);
                break;
            case 2:
                pp.setPib((String) aValue);
                break;
            case 3:
                pp.setMaticniBroj((String) aValue);
                break;
            case 4:
                pp.setUlica((String) aValue);
                break;
            case 5:
                pp.setBroj((String) aValue);
                break;
            case 6:
                pp.setMesto((Mesto) aValue);
                break;
        }
    }

    public List<PoslovniPartner> vratiParntere() {
        return lp;
    }

}
