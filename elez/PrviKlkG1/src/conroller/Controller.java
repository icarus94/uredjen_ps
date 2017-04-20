/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conroller;

import dbbr.DBBroker;
import domen.Angazovanje;
import domen.Gradiliste;
import domen.Radnik;
import java.sql.SQLException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AngazovanjeTableModel;

/**
 *
 * @author elezs
 */
public class Controller {

    private static Controller instance;
    private List<Angazovanje> angazovanja;
    private DBBroker dbb;
    private Controller(){
        angazovanja = new ArrayList<>();
    }
    public static Controller instanceController(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }
    public List<Gradiliste> vratiGradilista() {
        try {
            List<Gradiliste> gradilista;
            dbb = new DBBroker();
            dbb.uspostaviKonekciju();
            gradilista = dbb.getAllGradiliste();
            sortirajGradilista(gradilista);
            return gradilista;
        } catch (SQLException ex) {
            System.out.println("Nije vracena lista gradilista");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Radnik> vratiRadnike() {
        try {
            List<Radnik> radnici;
            dbb = new DBBroker();
            dbb.uspostaviKonekciju();
            radnici = dbb.getAllRadnik();
            sortirajRadnike(radnici);
            return radnici;
        } catch (SQLException ex) {
            System.out.println("Nije vracena lista radnika");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    private static void sortirajGradilista(List<Gradiliste> gradilista) {
        Collator collator = Collator.getInstance(Locale.US);
        if (!gradilista.isEmpty()) {
            Collections.sort(gradilista, new Comparator<Gradiliste>() {
                @Override
                public int compare(Gradiliste c1, Gradiliste c2) {
                    //You should ensure that list doesn't contain null values!
                    return collator.compare(c1.getNaziv(), c2.getNaziv());
                }
            });
        }
    }
    private static void sortirajRadnike(List<Radnik> radnici) {
        Collator collator = Collator.getInstance(Locale.US);
        if (!radnici.isEmpty()) {
            Collections.sort(radnici, new Comparator<Radnik>() {
                @Override
                public int compare(Radnik c1, Radnik c2) {
                    //You should ensure that list doesn't contain null values!
                    return collator.compare(c1.getPrezime(), c2.getPrezime());
                }
            });
        }
    }

    public List<Angazovanje> vratiAngazovanja() {
        return angazovanja;
    }

    public boolean sacuvajAngazovanja(List<Angazovanje> angazovanja) {
        boolean uspesno = false;
        try {
            dbb.uspostaviKonekciju();
            try {
                for (Angazovanje angazovanje : angazovanja) {
                    dbb.sacuvajAngazovanje(angazovanje);
                }
                dbb.potvrdiTransakciju();
                uspesno=true;
            } catch (SQLException e) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
                dbb.ponistiTransakciju();
                uspesno=false;
            }
            dbb.raskiniKonekciju();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uspesno;
    }
}
