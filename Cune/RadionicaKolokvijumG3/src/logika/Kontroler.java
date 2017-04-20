/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBBroker;
import domen.Radnik;
import domen.Ucinak;
import domen.VrstaPosla;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miroslav
 */
public class Kontroler {
    
    private static Kontroler k;
    DBBroker db;

    private Kontroler() {
        db = new DBBroker();
    }

    public static Kontroler getK() {
        if(k == null)
            k = new Kontroler();
        return k;
    }

    public ArrayList<Radnik> vratiListuRadnika() {

        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<Radnik> lista = db.vratiRadnike();
        db.zatvoriKonekciju();
        
        return lista;
    }

    public ArrayList<VrstaPosla> vratiListuVrstiPsolova() {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<VrstaPosla> lista = db.vratiVrste();
        db.zatvoriKonekciju();
        
        return lista;
    }

    public boolean sacuvaj(ArrayList<Ucinak> lista) {
        boolean sacuvano = false;
        db.ucitajDrajver();
        db.otvoriKonekciju();
        int maks = db.vratiMaksID();
        
            try {
                for (Ucinak u : lista) {
                     maks++;
                     db.sacuvajUCinak(u,maks);
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
