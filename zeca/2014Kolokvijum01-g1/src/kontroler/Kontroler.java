/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import dbb.DBBroker;
import domen.Zadatak;
import domen.Zaposleni;
import exception.DuplikatException;
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
    
    public static Kontroler vratiInstancu() {
        if(instanca==null){
            instanca = new Kontroler();
        }
        return instanca;
    }
    private Kontroler(){
        this.dbb=new DBBroker();
    }

    public List<Zaposleni> vratiSveZaposlene() throws SQLException {
        dbb.uspostaviKonekciju();
        List<Zaposleni> zap = dbb.vratiZaposlene();
        dbb.raskiniKonekciju();
        return zap;
    }

    public boolean sacuvajSveZadatke(List<Zadatak> zadaci) throws DuplikatException{
        boolean uspesno = false;
        
        try {
            dbb.uspostaviKonekciju();
            try {
                for (Zadatak zadatak : zadaci) {
                    dbb.sacuvajZadatak(zadatak);
                }
                dbb.potvrdi();
                uspesno=true;
            } catch (SQLException e) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, e);
                dbb.ponisti();
                uspesno=false;
            }
            dbb.raskiniKonekciju();
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            uspesno=false;
        }
        return uspesno;
    }
}
