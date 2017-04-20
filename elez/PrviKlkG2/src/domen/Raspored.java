/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.Date;

/**
 *
 * @author elezs
 */
public class Raspored {
    private int rasporedID;
    private int brojSati;
    private Date datum;
    private Radnik radnik;
    private Lokacija lokacija;

    public Raspored(int rasporedID, int brojSati, Date datum, Radnik radnik, Lokacija lokacija) {
        this.rasporedID = rasporedID;
        this.brojSati = brojSati;
        this.datum = datum;
        this.radnik = radnik;
        this.lokacija = lokacija;
    }

    public int getRasporedID() {
        return rasporedID;
    }

    public void setRasporedID(int rasporedID) {
        this.rasporedID = rasporedID;
    }

    public int getBrojSati() {
        return brojSati;
    }

    public void setBrojSati(int brojSati) {
        this.brojSati = brojSati;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }
    
    
}
