/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Asistent;
import domen.Predmet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miroslav
 */
public class DBBroker {
    Connection konekcija;
    
    public void ucitajDrajver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void otvoriKonekciju(){
        String url ="jdbc:mysql://localhost:3306/pskol2013";
        String user ="root";
        String pass = "";
        
        try {
            konekcija = DriverManager.getConnection(url, user, pass);
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void zatvoriKonekciju(){
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void commit(){
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollback(){
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Predmet> vratiPredmete() {
        String upit = "select * from Tpredmet";
        ArrayList<Predmet> lista = new ArrayList<>();
        
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            
            while (rs.next()) {                
                int sifra  = rs.getInt("sifra");
                String nazivPredmeta = rs.getString("nazivPredmeta");
                int semestar = rs.getInt("semestar");
                int brojBodova = rs.getInt("brojBodova");
                
                Predmet p = new Predmet(sifra, nazivPredmeta, semestar, brojBodova);
                
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
        
    }

    public void sacuvajAsistenta(Asistent a) throws SQLException {
        String upit = "INSERT INTO TAsistent(sifra,ime,prezime,titula,predmetID) VALUES (?,?,?,?,?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setInt(1, a.getSifra());
        ps.setString(2, a.getIme());
        ps.setString(3, a.getPrezime());
        ps.setString(4, a.getTitula());
        ps.setInt(5, a.getPredmet().getSifra());
        ps.executeUpdate();
    }
}
