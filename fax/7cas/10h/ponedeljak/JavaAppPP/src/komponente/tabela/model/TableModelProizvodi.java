/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komponente.tabela.model;

import domen.Proizvod;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author student
 */
public class TableModelProizvodi extends AbstractTableModel{
    private List<Proizvod> proizvodi;
    private String[] columnNames=new String[]{"Sifra", "Naziv", "Cena"};
    public TableModelProizvodi(List<Proizvod> proizvodi){
        this.proizvodi=proizvodi;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public int getRowCount() {
        return proizvodi.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proizvod p=proizvodi.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getIdProizvod();
            case 1: return p.getNaziv();
            case 2: return p.getCena();
            default: return "N/A";
        }
    }
    
    public Proizvod vratiProizvod(int rowIndex){
        return proizvodi.get(rowIndex);
    }
}
