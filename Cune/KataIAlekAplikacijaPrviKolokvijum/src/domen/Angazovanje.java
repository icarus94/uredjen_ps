/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;

/**
 *
 * @author Miroslav
 */
public class Angazovanje {
    private int angazovanjeID;
    private int brojSati;
    private Date datum;
    private Radnik radnik;
    private Gradiliste gradiliste;

    public Angazovanje() {
    }

    public Angazovanje(int angazovanjeID, int brojSati, Date datum, Radnik radnik, Gradiliste gradiliste) {
        this.angazovanjeID = angazovanjeID;
        this.brojSati = brojSati;
        this.datum = datum;
        this.radnik = radnik;
        this.gradiliste = gradiliste;
    }

    public Gradiliste getGradiliste() {
        return gradiliste;
    }

    public void setGradiliste(Gradiliste gradiliste) {
        this.gradiliste = gradiliste;
    }

    public int getAngazovanjeID() {
        return angazovanjeID;
    }

    public void setAngazovanjeID(int angazovanjeID) {
        this.angazovanjeID = angazovanjeID;
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

    @Override
    public String toString() {
        return radnik + " "+ gradiliste + " "+brojSati;
    }
    
    
}
