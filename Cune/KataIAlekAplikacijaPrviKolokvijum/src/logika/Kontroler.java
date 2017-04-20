/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBBroker;
import domen.Angazovanje;
import domen.Gradiliste;
import domen.Radnik;
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
        if(instanca==null)
            instanca = new Kontroler();
        return instanca;
    }

    public ArrayList<Radnik> vratiListuRadnika() {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<Radnik> lista = db.vratiRadnike();
        db.zatvoriKonekciju();
        
        return lista;
    }

    public ArrayList<Gradiliste> vratiGradilista() {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<Gradiliste> lista = db.vratiGradilista();
        db.zatvoriKonekciju();
        
        return lista;
    }

    public boolean sacuvajSvaAngazovanja(ArrayList<Angazovanje> lista) {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        boolean sacuvano = false ;
        
        
            try {
                for (Angazovanje angazovanje : lista) {
                    db.sacuvajAngazovanje(angazovanje);
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
