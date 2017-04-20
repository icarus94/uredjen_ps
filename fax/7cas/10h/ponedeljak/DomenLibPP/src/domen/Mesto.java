/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author student
 */
public class Mesto {
    private long ppt;
    private String naziv;

    public Mesto() {
    }

    public Mesto(long ppt, String naziv) {
        this.ppt = ppt;
        this.naziv = naziv;
    }

    public long getPpt() {
        return ppt;
    }

    public void setPpt(long ppt) {
        this.ppt = ppt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return getNaziv();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){return false;}
        Mesto m = (Mesto) obj;
        return m.getNaziv().equals(getNaziv()) && m.getPpt()==getPpt();
    }
    
    
    
}
