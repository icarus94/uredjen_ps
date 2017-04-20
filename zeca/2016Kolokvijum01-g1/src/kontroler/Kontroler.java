/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import db.DBBroker;
import domen.Angazovanje;
import domen.Gradiliste;
import domen.Radnik;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zeljko
 */
public class Kontroler {
    private static Kontroler instanca;
    private DBBroker dbb;

    public Kontroler() {
        this.dbb = new DBBroker();
    }
    
    public static Kontroler vratiInstancu(){
        if(instanca == null){
            instanca = new Kontroler();
        }
        return instanca;
    }

    public List<Gradiliste> vratiSvaGradilista() throws SQLException {
        dbb.uspostaviKonekciju();
        List<Gradiliste> gradilista = dbb.vratiSvaGradilista();
        dbb.potvrdiTransakciju();
        dbb.raskiniKonekciju();
        return gradilista;
    }

    public List<Radnik> vratiSveRadnike() throws SQLException {
        dbb.uspostaviKonekciju();
        List<Radnik> radnici = dbb.vratiSveRadnike();
        dbb.potvrdiTransakciju();
        dbb.raskiniKonekciju();
        return radnici;
    }

    public List<Angazovanje> vratiAngazovanja() throws SQLException {
        dbb.uspostaviKonekciju();
        List<Angazovanje> ang = dbb.vratiSvaAngazovanja();
        dbb.potvrdiTransakciju();
        dbb.raskiniKonekciju();
        return ang;
        
    }

    public boolean sacuvajAngazovanja(List<Angazovanje> lista){
        boolean uspesno = false;
        try {
            dbb.uspostaviKonekciju();
            try {
                for (Angazovanje angazovanje : lista) {
                    dbb.sacuvajAngazovanje(angazovanje);
                }
                dbb.potvrdiTransakciju();
                uspesno=true;
            } catch (SQLException e) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, e);
                dbb.ponistiTransakciju();
                uspesno=false;
            }
            dbb.raskiniKonekciju();
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uspesno;
    }
}
