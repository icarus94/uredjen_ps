/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBBroker;
import domen.Lokacija;
import domen.Radnik;
import domen.Raspored;
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
    DBBroker db;

    private Kontroler() {
        db = new DBBroker();
    }

    public static Kontroler getInstanca() {
        if(instanca == null)
            instanca = new Kontroler();
        return instanca;
    }

    public ArrayList<Lokacija> vratiLokacije() {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<Lokacija> lista = db.vratiListuLokacija();
        db.zatvoriKonekciju();
        
        return lista;
    }

    public ArrayList<Radnik> vratiRadnike() {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<Radnik> lista = db.vratiListuRadnika();
        db.zatvoriKonekciju();
        
        return lista;
    }

    public boolean sacuvaj(ArrayList<Raspored> lista) {
        boolean sacuvano = false;
        db.ucitajDrajver();
        db.otvoriKonekciju();
        
            try {
                for (Raspored raspored : lista) {
                     db.sacuvajRaspored(raspored);
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
