/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import db.DBKomunikacija;
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
 * @author Cule
 */
public class Kontroler {
//singlton patern
    private static Kontroler instance;
    KolekcijaPredmeta kp;
    KolekcijaPrijava kpr;
    DBKomunikacija db;
    
    private Kontroler() {
        db = new DBKomunikacija();
        kp = new KolekcijaPredmeta();
        kpr = new KolekcijaPrijava();
        popuniKolekcijuPredmeta();
        popuniKolekcijuPrijava();
    }

    public static Kontroler getInstance() {
        
        if(instance == null)
            instance = new Kontroler();
        return instance;
    }

    private void popuniKolekcijuPredmeta() {
        ArrayList<Predmet> lista = new ArrayList<>();
        db.ucitajDrajver();
        db.otvoriKonekciju();
        try {
            lista = db.inicijalizujListuPredmeta();
            db.commit();
        } catch (SQLException ex) {
            System.out.println("Nije uspesno vracena lista predmeta");
            db.rollback();
        }
        db.zatvoriKonekciju();
        kp.setListaPredmeta(lista);
    }
    
    public ArrayList<Predmet> vratiListuPredmetaIzKolekcije(){
        return kp.getListaPredmeta();
    }

    public void popuniKolekcijuPrijava() {
        ArrayList<Prijava> lista = new ArrayList<>();
        db.ucitajDrajver();
        db.otvoriKonekciju();
        try {
            lista = db.inicijalizujListuPrijava();
            db.commit();
        } catch (SQLException ex) {
            System.out.println("Neuspesno vracena lista prijava");
            db.rollback();
        }
        
        db.zatvoriKonekciju();
        kpr.setListaPrijava(lista);
    }

    public ArrayList<Prijava> vratiPrijaveIzKolekcije(){
       return kpr.getListaPrijava();
    }
    
    public ArrayList<Student> vratiListuStudenta(){
        ArrayList<Student> lista = new ArrayList<>();
        db.ucitajDrajver();
        db.otvoriKonekciju();
        try {
            lista = db.vratiListuStudenta();
            db.commit();
        } catch (SQLException ex) {
            System.out.println("Nije ucitana lista studenata");
            db.rollback();
            }
          
        db.zatvoriKonekciju();
        return lista;
    }
    
    public void dodajPrijavu(Prijava p){
        kpr.dodajPrijavu(p);
    }

    public boolean sacuvajSveeeee(ArrayList<Prijava> lista) {
        boolean sacuvano;
        db.ucitajDrajver();
        db.otvoriKonekciju();
         try {
        for (Prijava pr : lista) {
            if(pr.getStatus().equals("Novi")){
                    db.unesiNovuPrijavu(pr);
            }
            if(pr.getStatus().equals("Izmeni")){
                db.izmeniPrijavu(pr);
            }
        }
        db.commit();
        sacuvano= true;
        } catch (SQLException ex) {
            db.rollback();
            sacuvano = false;
       }
        db.zatvoriKonekciju();
        return sacuvano;
    }
}
