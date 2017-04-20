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
public class StavkaRacuna {
    private Racun racun;
    private int rb;
    private int kolicina;
    private Proizvod proizvod;
    private double iznos;

    public StavkaRacuna() {
    }

    public StavkaRacuna(Racun racun, int rb, int kolicina, Proizvod proizvod, double iznos) {
        this.racun = racun;
        this.rb = rb;
        this.kolicina = kolicina;
        this.proizvod = proizvod;
        this.iznos = iznos;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    @Override
    public String toString() {
        return racun+", "+rb+", "+kolicina+", "+proizvod+", "+iznos;
    }
    
    
}
