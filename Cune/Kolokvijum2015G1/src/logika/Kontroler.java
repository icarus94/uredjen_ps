/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBbroker;
import domen.Predmet;
import domen.Prijava;
import domen.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kolekcije.KolekcijaPredmeta;
import kolekcije.KolekcijaPrijava;

/**
 *
 * @author Miroslav
 */
public class Kontroler {

    private static Kontroler instanca;
    DBbroker db;
    KolekcijaPredmeta kp;
    KolekcijaPrijava kpr;
    
    private Kontroler() {
        db = new DBbroker();
        kp = new KolekcijaPredmeta();
        kpr = new KolekcijaPrijava();
    }

    public static Kontroler getInstanca() {
        if(instanca == null)
            instanca = new Kontroler();
        return instanca;
    }

    public void ucitajKolekcijuPredmeta() {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<Predmet> lista = db.vratiListuPRedmeta();
        db.zatvoriKonekciju();
        kp.setListaPredmeta(lista);
    }

    public ArrayList<Predmet> dajListuIZKolekcije() {
        return kp.getListaPredmeta();
    }

    public void ucitajKolekcijuPrijava() {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<Prijava> lista = db.vratiListuPrijava();
        db.zatvoriKonekciju();
        kpr.setListaPrijava(lista);
    }

    public ArrayList<Prijava> vratiListuPRijavaIZKolekcije() {
        return kpr.getListaPrijava();
    }

    public ArrayList<Student> vratiStudente() {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<Student> lista = db.vratiListuStudenata();
        db.zatvoriKonekciju();
        return lista;
    }

    public void dodajPrijavuUKolekciju(Prijava pr) {
        kpr.dodajUListu(pr);
    }

    public boolean sacuvaj() {
        boolean sacuvano = false;
        ArrayList<Prijava> lista = kpr.getListaPrijava();
        db.ucitajDrajver();
        db.otvoriKonekciju();
        try {
             for (Prijava pr : lista) {
                 if(pr.getStatus().equals("NEW"))
                    db.sacuvajPrijavu(pr);
                 
                 if(pr.getStatus().equals("UPDATE"))
                     db.updatePrijave(pr);
             }
             
             db.commit();
             sacuvano = true;
         } catch (SQLException ex) {
             Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
             db.rollback();
             sacuvano = false;
         }
        
        db.zatvoriKonekciju();
        
        return sacuvano;
    }
    
    
    
}
