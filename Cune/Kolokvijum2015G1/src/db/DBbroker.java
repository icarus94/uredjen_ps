/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Predmet;
import domen.Prijava;
import domen.Student;
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
public class DBbroker {
    Connection konekcija;
    
    public void ucitajDrajver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void otvoriKonekciju(){
    
        String url ="jdbc:mysql://localhost:3306/kol2015";
        String user = "root";
        String pass = "";
        
        try {
            konekcija = DriverManager.getConnection(url, user, pass);
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void zatvoriKonekciju(){
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void commit(){
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollback(){
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Predmet> vratiListuPRedmeta() {
        String upit = " select * from tpredmet";
        ArrayList<Predmet> lista = new ArrayList<>();
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs  = s.executeQuery(upit);
            while (rs.next()) {                
                Predmet p = new Predmet(rs.getInt("sifraPredmeta"), rs.getString("naziv"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<Prijava> vratiListuPrijava() {
        String upit = " select * from tprijava tpr join tpredmet tp on tpr.sifraPredmeta=tp.sifraPredmeta join tstudent ts on tpr.brojIndeksa = ts.brojIndeksa";
        ArrayList<Prijava> lista = new ArrayList<>();
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs  = s.executeQuery(upit);
            while (rs.next()) {                
                Predmet p = new Predmet(rs.getInt("sifraPredmeta"), rs.getString("naziv"));
                Student st = new Student(rs.getString("brojIndeksa"), rs.getString("ime"), rs.getString("prezime"));
                Prijava pr = new Prijava(p, st, new Date(rs.getDate("datum").getTime()), rs.getInt("ocena"),"");
                
                lista.add(pr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public ArrayList<Student> vratiListuStudenata() {
        String upit = " select * from tstudent ";
        ArrayList<Student> lista = new ArrayList<>();
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs  = s.executeQuery(upit);
            while (rs.next()) {                
                Student st = new Student(rs.getString("brojIndeksa"), rs.getString("ime"), rs.getString("prezime"));
                
                lista.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBbroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void sacuvajPrijavu(Prijava pr) throws SQLException {
        String sql = "insert into tprijava values (?,?,?,?)";
        PreparedStatement ps = konekcija.prepareStatement(sql);
        ps.setInt(1, pr.getPredmet().getSifraPredmeta());
        ps.setString(2, pr.getStudent().getBrojIndeksa());
        ps.setDate(3, new java.sql.Date(pr.getDatum().getTime()));
        ps.setInt(4, pr.getOcena());
        ps.executeUpdate();
    }

    public void updatePrijave(Prijava pr) throws SQLException {
        String sql = "update tprijava set datum=?,ocena=? where brojIndeksa = ? and sifraPredmeta = ?";
        PreparedStatement ps = konekcija.prepareStatement(sql);
        ps.setInt(4, pr.getPredmet().getSifraPredmeta());
        ps.setString(3, pr.getStudent().getBrojIndeksa());
        ps.setDate(1, new java.sql.Date(pr.getDatum().getTime()));
        ps.setInt(2, pr.getOcena());
        ps.executeUpdate();
    }

}
