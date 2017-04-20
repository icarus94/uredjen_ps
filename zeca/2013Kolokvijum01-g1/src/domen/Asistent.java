/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Zeljko
 */
public class Asistent {
    private int sifraAsistenta;
    private String ime;
    private String prezime;
    private String titula;
    private Predmet predmet;

    public Asistent(int sifraAsistenta, String ime, String prezime, String titula, Predmet predmet) {
        this.sifraAsistenta = sifraAsistenta;
        this.ime = ime;
        this.prezime = prezime;
        this.titula = titula;
        this.predmet = predmet;
    }

    public Asistent() {
        this.sifraAsistenta=-1;
    }

    public int getSifraAsistenta() {
        return sifraAsistenta;
    }

    public void setSifraAsistenta(int sifraAsistenta) {
        this.sifraAsistenta = sifraAsistenta;
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

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }
    
    
}
