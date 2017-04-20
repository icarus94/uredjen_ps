/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;
import java.util.List;

/**
 *
 * @author student
 */
public class Racun {
    private int idRacun;
    private Date datum;
    private PoslovniPartner partner;
    private List<StavkaRacuna> stavke;
    private double ukupanIznos;

    public Racun() {
    }

    public Racun(int idRacun, Date datum, PoslovniPartner partner, List<StavkaRacuna> stavke, double ukupanIznos) {
        this.idRacun = idRacun;
        this.datum = datum;
        this.partner = partner;
        this.stavke = stavke;
        this.ukupanIznos = ukupanIznos;
    }

    public int getIdRacun() {
        return idRacun;
    }

    public void setIdRacun(int idRacun) {
        this.idRacun = idRacun;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public PoslovniPartner getPartner() {
        return partner;
    }

    public void setPartner(PoslovniPartner partner) {
        this.partner = partner;
    }

    public List<StavkaRacuna> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    @Override
    public String toString() {
        return idRacun+", "+datum+", "+partner+", "+ukupanIznos+", "+stavke;
    }
    
    
}
