/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Lokacija;
import domen.Radnik;
import domen.Raspored;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
        String urlKaBazi = "jdbc:mysql://localhost:3306/raspored2016";
        String user ="root";
        String password = "";
        
        try {
            konekcija = DriverManager.getConnection(urlKaBazi, user, password);
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

    public ArrayList<Lokacija> vratiListuLokacija() {
        String upit = "select * from lokacija order by naziv asc";
        ArrayList<Lokacija> lista = new ArrayList<>();
        
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            while (rs.next()) {                
                int lokacijaID = rs.getInt("lokacijaID");
                String naziv = rs.getString("naziv");
                Date pocetakGradnje = new Date(rs.getDate("pocetakGradnje").getTime());
                Date zavrsetakGradnje = new Date(rs.getDate("zavrsetakGradnje").getTime());
                
                Lokacija l = new Lokacija(lokacijaID, naziv, pocetakGradnje, zavrsetakGradnje);
                lista.add(l);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    public ArrayList<Radnik> vratiListuRadnika() {
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
        
        return lista;
    }

    public void sacuvajRaspored(Raspored raspored) throws SQLException {
        String upit ="INSERT into raspored(brojSati,datum,lokacijaID,radnikID) VALUES (?,?,?,?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setInt(1, raspored.getBrojSati());
        ps.setDate(2, new java.sql.Date(raspored.getDatum().getTime()));
        ps.setInt(3, raspored.getLokacija().getLokacijaID());
        ps.setInt(4, raspored.getRadnik().getRadnikID());
        
        ps.executeUpdate();
    }
}
