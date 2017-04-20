/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;

/**
 *
 * @author Zeljko
 */
public class Zadatak {
    private String sifraZadatka;
    private Date datum;
    private String naziv;
    private String opis;
    private Zaposleni zaposleni;

    public Zadatak(String sifraZadatka, Date datum, String naziv, String opis, Zaposleni zaposleni) {
        this.sifraZadatka = sifraZadatka;
        this.datum = datum;
        this.naziv = naziv;
        this.opis = opis;
        this.zaposleni = zaposleni;
    }

    public Zadatak() {
    }

    public String getSifraZadatka() {
        return sifraZadatka;
    }

    public void setSifraZadatka(String sifraZadatka) {
        this.sifraZadatka = sifraZadatka;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }
    
}
