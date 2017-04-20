/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Miroslav
 */
public class Predmet {
    private int sifra;
    private String nazivPredmeta;
    private int semestar;
    private int brojBodova;

    public Predmet() {
    }

    public Predmet(int sifra, String nazivPredmeta, int semestar, int brojBodova) {
        this.sifra = sifra;
        this.nazivPredmeta = nazivPredmeta;
        this.semestar = semestar;
        this.brojBodova = brojBodova;
    }

    public int getBrojBodova() {
        return brojBodova;
    }

    public void setBrojBodova(int brojBodova) {
        this.brojBodova = brojBodova;
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public int getSemestar() {
        return semestar;
    }

    public void setSemestar(int semestar) {
        this.semestar = semestar;
    }

    @Override
    public String toString() {
        return nazivPredmeta;
    }
    
    
}
