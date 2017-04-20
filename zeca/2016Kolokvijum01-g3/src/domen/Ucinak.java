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
public class Ucinak {
    private int ucinakID;
    private int brojSati;
    private Date datum;
    private VrstaPosla vrstaPosla;
    private Radnik radnik;

    public Ucinak(int ucinakID, int brojSati, Date datum, VrstaPosla vrstaPosla, Radnik radnik) {
        this.ucinakID = ucinakID;
        this.brojSati = brojSati;
        this.datum = datum;
        this.vrstaPosla = vrstaPosla;
        this.radnik = radnik;
    }

    public int getUcinakID() {
        return ucinakID;
    }

    public void setUcinakID(int ucinakID) {
        this.ucinakID = ucinakID;
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

    public VrstaPosla getVrstaPosla() {
        return vrstaPosla;
    }

    public void setVrstaPosla(VrstaPosla vrstaPosla) {
        this.vrstaPosla = vrstaPosla;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }
    
}
