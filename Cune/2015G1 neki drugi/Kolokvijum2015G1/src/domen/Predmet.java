/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Cule
 */
public class Predmet {
    private int sifraPredmeta;
    private String naziv;

    public Predmet() {
    }

    public Predmet(int sifraPredmeta, String naziv) {
        this.sifraPredmeta = sifraPredmeta;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getSifraPredmeta() {
        return sifraPredmeta;
    }

    public void setSifraPredmeta(int sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
}
