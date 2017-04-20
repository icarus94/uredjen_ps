/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika;

import db.DatabaseBroker;
import domen.Mesto;
import domen.PoslovniPartner;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private DatabaseBroker db;

    private Kontroler() {
        km = new KolekcijaMesta();
        kp = new KolekcijaPoslovnihPartnera();
        db = new DatabaseBroker();
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

    public List<Mesto> vratiMesta() throws RuntimeException {
        try {
            // return km.vratiMesta();
            db.ucitajDriver();
            db.uspostaviKonekciju();
            List<Mesto> lm = db.vratiMesta();
            db.zatvoriKonekciju();
            return lm;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Nije ucitan driver!", ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Nije ucitana lista mesta", ex);
        }
    }

    public void sacuvajPartnera(PoslovniPartner pp) throws RuntimeException {
        try {
            // kp.sacuvajPartnera(pp);
            db.ucitajDriver();
            db.uspostaviKonekciju();
            db.sacuvajPartnera(pp);
            db.zatvoriKonekciju();
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Nije ucitan driver!", ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Poslovni partner nije sacuvan!", ex);
        }
    }

    public List<PoslovniPartner> vratiPartnere() {
        return kp.vratiPartnere();
    }

}
