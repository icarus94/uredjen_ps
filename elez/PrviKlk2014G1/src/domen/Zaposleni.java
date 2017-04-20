/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author elezs
 */
public class Zaposleni {
    private String sifraZaposlenog;
    private String ime;
    private String prezime;

    public Zaposleni(String sifraZaposlenog, String ime, String prezime) {
        this.sifraZaposlenog = sifraZaposlenog;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Zaposleni() {
    }

    public String getSifraZaposlenog() {
        return sifraZaposlenog;
    }

    public void setSifraZaposlenog(String sifraZaposlenog) {
        this.sifraZaposlenog = sifraZaposlenog;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
}
