/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Lokacija;
import domen.Radnik;
import domen.Raspored;
import exception.ValidacijaException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author elezs
 */
public class RasporedTableModel extends AbstractTableModel {

    List<Raspored> rasporedi;
    String[] naziviKolona = new String[]{"Lokacija", "Ime i prezime", "Broj sati", "Datum"};

    public RasporedTableModel() {
        rasporedi = new ArrayList<>();
    }

    public String getColumnName(int columnIndex) {
        return naziviKolona[columnIndex];
    }

    @Override
    public int getRowCount() {
        return rasporedi.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Raspored r = rasporedi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getLokacija();
            case 1:
                return r.getRadnik();
            case 2:
                return r.getBrojSati();
            case 3:
                return r.getDatum();
            default:
                return "N/A";
        }
    }

    public void dodajRaspored(Raspored raspored) throws ValidacijaException {
        izvrsiValidaciju(raspored);
        rasporedi.add(raspored);
        fireTableDataChanged();
    }

    private void izvrsiValidaciju(Raspored raspored) throws ValidacijaException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String datum = sdf.format(raspored.getDatum());
        int ukupnoSati = raspored.getBrojSati();
        for (Raspored r : rasporedi) {
            String dat = sdf.format(r.getDatum());
            if (raspored.getRadnik().getRadnikID() == r.getRadnik().getRadnikID() && datum.equals(dat)) {
                if (raspored.getLokacija().getLokacijaID() != r.getLokacija().getLokacijaID()) {
                    throw new ValidacijaException("Jedan radnik ne moze biti na vise lokacija u toku jednog dana");
                }
                ukupnoSati = ukupnoSati + raspored.getBrojSati();
                if (ukupnoSati > 8) {
                    throw new ValidacijaException("Radnik ne moze raditi vise od 8h na jednoj lokaciji");
                }
            }
        }
    }

    public void obrisiRaspored(int red) {
        rasporedi.remove(red);
        fireTableRowsDeleted(red, red);
    }

    public List<Raspored> vratiListuRasporeda() {
        return rasporedi;
    }
}
