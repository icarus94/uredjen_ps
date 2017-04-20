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
            // db.sacuvajPartnera(pp);
            db.snimiPartnera(pp);
            // Treba dodati commit/rollback transakcije
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

    public void sacuvajPartnere(List<PoslovniPartner> lp) throws Exception {
        try {
            db.ucitajDriver();
            db.uspostaviKonekciju();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Neuspesno uspostavljanje konekcije!");
        }
        try {
            for (PoslovniPartner pp : lp) {
                db.snimiPartnera(pp);
                System.out.println("Sacuvan partner sa PartnerID: " + pp.getPartnerID());
            }
            db.commitTraksancije();
        } catch (SQLException ex) {
            ex.printStackTrace();
            db.rollbackTransakcije();
            throw new Exception("Neuspesno cuvanje partnera! " + ex.getMessage());
        } finally {
            db.zatvoriKonekciju();
        }

    }

}
