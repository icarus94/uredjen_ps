/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author student
 */
public class PoslovniPartner {

    private int partnerID;
    private String naziv;
    private String maticniBroj;
    private String pib;
    private String ulica;
    private String broj;
    private Mesto mesto;

    public PoslovniPartner() {
    }

    public PoslovniPartner(int partnerID, String naziv, String maticniBroj, String pib, String ulica, String broj, Mesto mesto) {
        this.partnerID = partnerID;
        this.naziv = naziv;
        this.maticniBroj = maticniBroj;
        this.pib = pib;
        this.ulica = ulica;
        this.broj = broj;
        this.mesto = mesto;
    }

    public int getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return naziv;
    }
}
