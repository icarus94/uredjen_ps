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
    
    private Kontroler(){
        dbb = new DBBroker();
    }
    
    public static Kontroler getInstance(){
        if(instanca == null){
            instanca = new Kontroler();
        }
        return instanca;
    }

    public List<Radnik> vratiSveRadnike() throws ClassNotFoundException, SQLException {
        dbb.uspostaviKonekciju();
        List<Radnik> radnici = dbb.vratiSveRadnike();
        dbb.raskiniKonekciju();
        return radnici;
    }

    public List<VrstaPosla> vratiSveVrstePosla() throws ClassNotFoundException, SQLException {
        dbb.uspostaviKonekciju();
        List<VrstaPosla> vp = dbb.vratiSveVrstePosla();
        dbb.raskiniKonekciju();
        return vp;
    }

    public boolean sacuvajListu(List<Ucinak> lista) {
        boolean uspesno = false;
        try {
            dbb.uspostaviKonekciju();
            try {
                for (Ucinak ucinak : lista) {
                    dbb.sacuvajUcinak(ucinak);
                }
                dbb.potvrdiTransakciju();
                uspesno=true;
            } catch (Exception e) {
                dbb.ponistiTransakciju();
                uspesno=false;
            }
            dbb.raskiniKonekciju();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
//            uspesno=false;
        }
        return uspesno;
    }
}
