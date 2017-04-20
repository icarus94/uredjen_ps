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
public class Lokacija {
    private int lokacijaID;
    private String naziv;
    private Date pocetakGradnje;
    private Date zavrsetakGradnje;

    public Lokacija() {
    }

    public Lokacija(int lokacijaID, String naziv, Date pocetakGradnje, Date zavrsetakGradnje) {
        this.lokacijaID = lokacijaID;
        this.naziv = naziv;
        this.pocetakGradnje = pocetakGradnje;
        this.zavrsetakGradnje = zavrsetakGradnje;
    }

    public Date getZavrsetakGradnje() {
        return zavrsetakGradnje;
    }

    public void setZavrsetakGradnje(Date zavrsetakGradnje) {
        this.zavrsetakGradnje = zavrsetakGradnje;
    }

    public int getLokacijaID() {
        return lokacijaID;
    }

    public void setLokacijaID(int lokacijaID) {
        this.lokacijaID = lokacijaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getPocetakGradnje() {
        return pocetakGradnje;
    }

    public void setPocetakGradnje(Date pocetakGradnje) {
        this.pocetakGradnje = pocetakGradnje;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
}
