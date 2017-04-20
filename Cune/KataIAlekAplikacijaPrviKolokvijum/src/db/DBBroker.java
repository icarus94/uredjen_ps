/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Angazovanje;
import domen.Gradiliste;
import domen.Radnik;
import java.sql.Connection;
import java.sql.Date;
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
    
        String url ="jdbc:mysql://localhost:3306/kataialek";
        String user = "root";
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

    public ArrayList<Radnik> vratiRadnike() {
        String upit = "select * from radnik order by prezime asc";
        ArrayList<Radnik> lista = new ArrayList<>();
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            while (rs.next()) {                
                int radnikID = rs.getInt("radnikID");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String specijalizacija = rs.getString("specijalizacija");
                
                Radnik r = new Radnik(radnikID, ime, prezime, specijalizacija);
                
                lista.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  lista;
    }

    public ArrayList<Gradiliste> vratiGradilista() {
        String upit = "select * from gradiliste order by naziv asc";
        ArrayList<Gradiliste> lista = new ArrayList<>();
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            while (rs.next()) {                
                int gradilisteID = rs.getInt("gradilisteID");
                String naziv = rs.getString("naziv");
                String mesto = rs.getString("mesto");
                
                Gradiliste g = new Gradiliste(gradilisteID, naziv, mesto);
                lista.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  lista;

    }

    public void sacuvajAngazovanje(Angazovanje a) throws SQLException {
        String upit = "Insert into angazovanje(brojSati,datum,radnikID,gradilisteID) VALUES (?,?,?,?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setInt(1, a.getBrojSati());
        ps.setDate(2, new Date(a.getDatum().getTime()));
        ps.setInt(3, a.getRadnik().getRadnikID());
        ps.setInt(4, a.getGradiliste().getGradilisteID());
        ps.executeUpdate();
        

    }
}
