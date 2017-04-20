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
public class Asistent {
    private int sifra;
    private String ime; 
    private String prezime;
    private String titula;
    private Predmet predmet;

    public Asistent() {
    }

    public Asistent(int sifra, String ime, String prezime, String titula, Predmet predmet) {
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.titula = titula;
        this.predmet = predmet;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
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

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    @Override
    public String toString() {
        return ime +" "+prezime;
    }
    
    
}
