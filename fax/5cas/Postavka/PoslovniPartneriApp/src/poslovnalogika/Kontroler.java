/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika;

import domen.Mesto;
import domen.PoslovniPartner;
import java.util.List;
import kolekcija.KolekcijaMesta;
import kolekcija.KolekcijaPoslovnihPartnera;

/**
 *
 * @author student
 */
public class Kontroler {
    private KolekcijaMesta km;
    private KolekcijaPoslovnihPartnera kp;
    private static Kontroler instance;

    private Kontroler() {
        km = new KolekcijaMesta();
        kp = new KolekcijaPoslovnihPartnera();
    }
    
    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }
    
    public void sacuvajMesto(Mesto m) {
        km.sacuvajMesto(m);
    }
    
    public List<Mesto> vratiMesta() {
        return km.vratiMesta();
    }
    
    public void sacuvajPartnera(PoslovniPartner pp) {
        kp.sacuvajPartnera(pp);
    }
    
    public List<PoslovniPartner> vratiPartnere() {
        return kp.vratiPartnere();
    }
    
}
