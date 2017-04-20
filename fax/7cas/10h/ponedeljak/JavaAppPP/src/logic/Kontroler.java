/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import db.DatabaseBroker;
import domen.Mesto;
import domen.PoslovniPartner;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class Kontroler {

    //private static List<PoslovniPartner> partneri = new ArrayList<>();
    private DatabaseBroker dbbr;
    private static Kontroler instance;
    
    private Kontroler(){
        dbbr=new DatabaseBroker();
    }
    
    public static Kontroler getInstance(){
        if(instance==null){
            instance=new Kontroler();
        }
        return instance;
    }
    
    public List<Mesto> vratiMesta() {

        /*List<Mesto> mesta = new ArrayList<>();
            mesta.add(new Mesto(11000l, "Beograd"));
            mesta.add(new Mesto(35000l, "Jagodina"));
            mesta.add(new Mesto(36000l, "Kraljevo"));
            return mesta;*/
        try {
            List<Mesto> mesta = new ArrayList<>();
            //DatabaseBroker dbbr = new DatabaseBroker();
            dbbr.uspostaviKonekciju();
            mesta = dbbr.getAllMesto();
            dbbr.raskiniKonekciju();
            return mesta;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<Mesto>();
    }

    public void sacuvajPoslovnogPartnera(PoslovniPartner poslovniPartner) {
        //partneri.add(poslovniPartner);
        try {
            //DatabaseBroker dbbr = new DatabaseBroker();
            dbbr.uspostaviKonekciju();
            dbbr.insertPoslovniPartnerBoljiNacin(poslovniPartner);
            dbbr.raskiniKonekciju();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sacuvajPoslovnePartnere(List<PoslovniPartner> partneri) throws Exception {

            //partneri.add(poslovniPartner);

            //DatabaseBroker dbbr = new DatabaseBroker();
            try{
                dbbr.uspostaviKonekciju();
            }catch(Exception e){
                e.printStackTrace();
                throw new Exception("Desila se greska prilikom uspostavljanja konekcije sa bazom!\n"+e.getMessage());
            }
            try{
                for (PoslovniPartner poslovniPartner : partneri) {
                    dbbr.insertPoslovniPartnerBoljiNacin(poslovniPartner);
                }
                dbbr.potvrdiTransakciju();
            }catch(Exception e){
                e.printStackTrace();
                dbbr.ponistiTransakciju();
                throw new Exception("Greska prilikom cuvanja p[oslovnih partnera u bazi podataka!\n"+e.getMessage());
            }finally{
                dbbr.raskiniKonekciju();
            }
            


    }

    public List<PoslovniPartner> vratiPoslovnePartnere() {
        List<PoslovniPartner> partneri = new ArrayList<>();
        try {

            //DatabaseBroker dbbr = new DatabaseBroker();
            dbbr.uspostaviKonekciju();
            partneri = dbbr.getAllPoslovniPartner();
            dbbr.raskiniKonekciju();
            return partneri;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return partneri;
    }
}
