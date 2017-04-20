/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbbr.DBBroker;
import domen.Lokacija;
import domen.Radnik;
import domen.Raspored;
import exception.ValidacijaException;
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

    private DBBroker dbb;
    private static Controller instance;

    private Controller() {

    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public List<Radnik> vratiRadnike() {
        try {
            List<Radnik> radnici;
            dbb = new DBBroker();
            dbb.uspostaviKonekciju();
            radnici = dbb.ucitajRadnike();
            dbb.raskiniKonekciju();
            return radnici;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<Radnik>();
    }

    public List<Lokacija> vratiLokacije() {
        try {
            List<Lokacija> lokacije;
            dbb = new DBBroker();
            dbb.uspostaviKonekciju();
            lokacije = dbb.ucitajLokaciju();
            dbb.raskiniKonekciju();
            return lokacije;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    public void sacuvajRasporede(List<Raspored> rasporedi) throws ValidacijaException{
        try {
            boolean uspesno;
            dbb.uspostaviKonekciju();
            uspesno = dbb.upisiRasporede(rasporedi);
            if(uspesno){
                dbb.potvrdiKonekciju();
                System.out.println("Sacuvani svi rasporedi!");
            }else{
                dbb.ponistiKonekciju();
                System.out.println("Ponistena");
                
            }
        } catch (ClassNotFoundException ex) {
            throw new ValidacijaException("JDBC Driver ima problem");
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ValidacijaException("Cuvanje nije uspelo!");
        }
    }
}
