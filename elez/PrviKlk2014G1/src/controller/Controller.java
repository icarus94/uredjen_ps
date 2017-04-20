/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domen.Zadatak;
import domen.Zaposleni;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elezs
 */
public class Controller {
    private static Controller instance;
    private DBBroker dbb;
    private Zadatak zadatak;
    private Controller (){
        
    }
    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public List<Zaposleni> vratiZaposlene() {
        List<Zaposleni> zaposleni;
        try {
            dbb = new DBBroker();
            dbb.uspostaviKonekciju();
            zaposleni = dbb.getZaposleni();
            dbb.prekiniKonekciju();
            if(zaposleni != null){
                return zaposleni;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    public void prihvatiZadatak(Zadatak z) {
        zadatak = z;
    }
    public Zadatak proslediZadatak(){
        return zadatak;
    }
}
