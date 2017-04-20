/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbb.DBBroker;
import domen.Radnik;
import domen.Ucinak;
import domen.VrstaPosla;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.ValidationException;

/**
 *
 * @author elezs
 */
public class Controller {
    private static Controller instance;
    DBBroker dbb;
    private Controller(){
        dbb = new DBBroker();
    }
    public static Controller getInstance() {
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public List<Radnik> popuniRadnike() throws SQLException, ClassNotFoundException {
        List<Radnik> radnici;
        dbb.uspostaviKonekciju();
        radnici = dbb.getRadnici();
        dbb.raskininKonekciju();
        return radnici;
    }

    public List<VrstaPosla> popuniVrstePosla() throws ClassNotFoundException, SQLException {
        List<VrstaPosla> vrstePosla;
        dbb.uspostaviKonekciju();
        vrstePosla = dbb.getVrstePosla();
        dbb.raskininKonekciju();
        return vrstePosla;
    }

    public boolean sacuvajListu(List<Ucinak> ucinci) {
        boolean uspesno= true;
        try {
            dbb.uspostaviKonekciju();
            try{
                for(Ucinak u : ucinci){
                dbb.sacuvajUcinak(u);
                uspesno = true;
            }
            dbb.potvrdiTransakciju();
            }catch(Exception e){
                uspesno = false;
                dbb.ponistiTransakciju();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uspesno;
    }
}
