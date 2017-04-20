/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import dbb.DBBroker;
import domen.Asistent;
import domen.Predmet;
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

    public List<Predmet> vratiSvePredmete() throws SQLException {
        dbb.uspostaviKonekciju();
        List<Predmet> predmeti = dbb.vratiSvePredmete();
        dbb.raskiniKonekciju();
        return predmeti;
    }

    public boolean sacuvajSveAsistente(List<Asistent> lista) {
        boolean uspesno = false;
        try {
            dbb.uspostaviKonekciju();
            try {
                for (Asistent asistent : lista) {
                    dbb.sacuvajAsistenta(asistent);
                }
                dbb.potvrdi();
                uspesno=true;
            } catch (SQLException e) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, e);
                dbb.ponisti();
                uspesno=false;
            }
            dbb.raskiniKonekciju();
        } catch (SQLException e) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, e);
            uspesno=false;
        }
        return uspesno;
    }

    public Predmet dajPredmet(String naziv) throws SQLException {
        Predmet p = new Predmet();
        dbb.uspostaviKonekciju();
        p = dbb.dajPredmet(naziv);
        dbb.raskiniKonekciju();
        return p;
    }
}
