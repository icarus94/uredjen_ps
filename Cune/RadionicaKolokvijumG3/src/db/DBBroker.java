/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Radnik;
import domen.Ucinak;
import domen.VrstaPosla;
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
    
        String url ="jdbc:mysql://localhost:3306/prosoftg3";
        String user = "root";
        String pass="";
        
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

        ArrayList<Radnik> lista = new ArrayList<>();
        String upit = "select * from radnik order by prezime asc";
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            while (rs.next()) {                
                int radnikID = rs.getInt("RadnikID");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                String specijalizacija = rs.getString("Specijalizacija");
                
                Radnik r = new Radnik(radnikID, ime, prezime, specijalizacija);
                
                lista.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return lista;
    }

    public ArrayList<VrstaPosla> vratiVrste() {

        ArrayList<VrstaPosla> lista = new ArrayList<>();
        
        String upit = "select * from vrstaPosla order by naziv desc";
        
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            while (rs.next()) {                
                int vpID= rs.getInt("VrstaPoslaID");
                String naziv = rs.getString("Naziv");
                
                VrstaPosla vp = new VrstaPosla(vpID, naziv);
                
                lista.add(vp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    public int vratiMaksID() {

        int maks = 0;
        
        String upit = "select max(UcinakID) as maks from Ucinak";
        
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            while (rs.next()) {                
                maks= rs.getInt("maks");                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return maks+1;
    }

    public void sacuvajUCinak(Ucinak u, int maks) throws SQLException {
        String upit = "Insert into Ucinak values (?,?,?,?,?)";
        
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setInt(1, maks);
        ps.setInt(2, u.getBrojSati());
        ps.setDate(3, new Date(u.getDatum().getTime()));
        ps.setInt(4, u.getVrstaPosla().getVrstaPoslaID());
        ps.setInt(5, u.getRadnik().getRadnikID());
        ps.executeUpdate();
    }
}
