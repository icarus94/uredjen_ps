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
    private String pib;
    private String maticniBroj;
    private String naziv;
    private String ulica;
    private String broj;
    private Mesto mesto;
    
    public PoslovniPartner() {
    }

    public PoslovniPartner(String pib, String maticniBroj, String naziv, String ulica, String broj, Mesto mesto) {
        this.pib = pib;
        this.maticniBroj = maticniBroj;
        this.naziv = naziv;
        this.ulica = ulica;
        this.broj = broj;
        this.mesto = mesto;
    }

    

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
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
    
      
}
