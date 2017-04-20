/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DbKomunikacija;
import domen.Zadatak;
import domen.Zaposleni;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miroslav
 */
public class Kontroler {

    private static Kontroler instanca;
    DbKomunikacija db;
    
    private Kontroler() {
        db = new DbKomunikacija();
    }

    public static Kontroler getInstanca() {
        if(instanca == null)
            instanca = new Kontroler();
        return instanca;
    }

    public ArrayList<Zaposleni> vratiZaposlene() {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<Zaposleni> lista = db.vratiZaposlene();
        db.zatvoriKonekciju();
        return lista;
    }

    public boolean sacuvaj(ArrayList<Zadatak> lista) {
        boolean sacuvano = false;
        db.ucitajDrajver();
        db.otvoriKonekciju();
       
            try {
                 for (Zadatak z : lista) {
                    db.sacuvajZadatak(z);
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
