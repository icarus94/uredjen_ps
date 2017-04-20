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
public class Gradiliste {
    private int gradilisteID;
    private String naziv;
    private String mesto;

    public Gradiliste(int gradilisteID, String naziv, String mesto) {
        this.gradilisteID = gradilisteID;
        this.naziv = naziv;
        this.mesto = mesto;
    }

    public int getGradilisteID() {
        return gradilisteID;
    }

    public void setGradilisteID(int gradilisteID) {
        this.gradilisteID = gradilisteID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return naziv; //To change body of generated methods, choose Tools | Templates.
    }
    
}
