/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Zadatak;
import domen.Zaposleni;
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
public class DbKomunikacija {
    Connection konekcija;
    
    public void ucitajDrajver(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbKomunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void otvoriKonekciju(){
        String url = "jdbc:mysql://localhost:3306/anax2";
        String user = "root";
        String password = "";
        
        try {
            konekcija = DriverManager.getConnection(url, user, password);
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DbKomunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void zatvoriKonekciju(){
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbKomunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void commit(){
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DbKomunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollback(){
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DbKomunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Zaposleni> vratiZaposlene() {
        String upit = "select * from TZaposleni";
        ArrayList<Zaposleni> lista = new ArrayList<>();
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            while (rs.next()) {                
                String sifra = rs.getString("sifra");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                
                Zaposleni z = new Zaposleni(sifra, ime, prezime);
                
                lista.add(z);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbKomunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    public void sacuvajZadatak(Zadatak z) throws SQLException {
        String upit = "INSERT into TZadatak(sifraZadatka,naziv,opis,datum,zaposleni) VALUES (?,?,?,?,?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setString(1, z.getSifra());
        ps.setString(2, z.getNaziv());
        ps.setString(3, z.getOpis());
        ps.setDate(4, new Date(z.getDatum().getTime()));
        ps.setString(5, z.getZaposleni().getSifra());
        ps.executeUpdate();
    }   
}
