/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author elezs
 */
public class Gradiliste {

    public Gradiliste(int gradilisteID, String naziv, String Mesto) {
        this.gradilisteID = gradilisteID;
        this.naziv = naziv;
        this.Mesto = Mesto;
    }

    private int gradilisteID;
    private String naziv;
    private String Mesto;

    public Gradiliste() {
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
        return Mesto;
    }

    public void setMesto(String Mesto) {
        this.Mesto = Mesto;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
}
