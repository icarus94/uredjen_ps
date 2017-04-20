/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

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
    
    private static Kontroler kontroler;
    DBBroker db;

    private Kontroler() {
        db = new DBBroker();
    }

    public static Kontroler getKontroler() {
        if(kontroler == null)
            kontroler = new Kontroler();
        return kontroler;
    }

    public ArrayList<VrstaPosla> vratiPoslove() {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<VrstaPosla> lista = db.vratiPoslove();
        db.zatvoriKonekciju();
        return lista;
    }

    public ArrayList<Radnik> vratiRadnike() {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<Radnik> lista = db.vratiRadnike();
        db.zatvoriKonekciju();
        return lista;
    }

    public boolean sacuvaj(ArrayList<Ucinak> lista) {
        boolean sacuvano = false;
        db.ucitajDrajver();
        db.otvoriKonekciju();
        int idMaksUcinak = db.vratiMaks();
         try {
                for (Ucinak u : lista) {
                        db.sacuvajJedanUcinak(u,idMaksUcinak);
                        idMaksUcinak++;
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
