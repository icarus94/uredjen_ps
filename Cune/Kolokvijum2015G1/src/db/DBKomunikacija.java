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
import javax.swing.JOptionPane;

/**
 *
 * @author Cule
 */
public class DBKomunikacija {
    
    Connection konekcija;
    
    public void ucitajDrajver(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Nije ucitan drajver");
        }
    }
    
    public void otvoriKonekciju(){
        try {
            konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/kolokvijum2015G1", "root", "");
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            System.err.println("Nije otvorena konekcija");        }
    }
    
    public void zatvoriKonekciju(){
        try {
            konekcija.close();
        } catch (SQLException ex) {
            System.err.println("Nije zatvorena konekcija");
        }
    }
    
    public void commit(){
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            System.out.println("Nije izvrsen commit");
        }
    }
    
    public void rollback(){
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            System.out.println("Nije izvrsen rollback");    
        }
    }

    public ArrayList<Predmet> inicijalizujListuPredmeta() throws SQLException {
        
        ArrayList<Predmet> listaPredmeta = new ArrayList<>();
        
        String sql = "SELECT * FROM predmet";
        
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(sql);
        
        while(rs.next()){
            int sifraP = rs.getInt("sifraPredmeta");
            String naziv= rs.getString("naziv");
            
            Predmet p = new Predmet(sifraP, naziv);
            
            listaPredmeta.add(p);
        }
    return listaPredmeta;
    }

    public ArrayList<Prijava> inicijalizujListuPrijava() throws SQLException {
        ArrayList<Prijava> listaPrijava = new ArrayList<>();
        
        String sql = "SELECT * FROM prijava pr join predmet p on pr.sifraPredmeta= p.sifraPredmeta join student s on pr.brojIndeksa=s.brojIndeksa";
        
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(sql);
        
        while(rs.next()){
            int sifraP = rs.getInt("sifraPredmeta");
            String naziv= rs.getString("naziv");
            
            Predmet p = new Predmet(sifraP, naziv);
            
            String brojIndeksa= rs.getString("brojIndeksa");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            
            Student student = new Student(brojIndeksa, ime, prezime);
            
            int ocena = rs.getInt("ocena");
            
            Date datum = new Date(rs.getDate("datum").getTime());
            
            Prijava prijava = new Prijava(p, student, datum, ocena,"");
            
            listaPrijava.add(prijava);
        }
    return listaPrijava;
    }

    public ArrayList<Student> vratiListuStudenta() throws SQLException {
         ArrayList<Student> listaStudenata = new ArrayList<>();
        
        String sql = "SELECT * FROM student";
        
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(sql);
        
        while(rs.next()){
            
            
            String brojIndeksa= rs.getString("brojIndeksa");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            
            Student student = new Student(brojIndeksa, ime, prezime);
            listaStudenata.add(student);
        }
    return listaStudenata;
    }

    public void unesiNovuPrijavu(Prijava pr) throws SQLException {

        String sql = "INSERT INTO prijava(sifraPredmeta,brojIndeksa,datum,ocena) VALUES (?,?,?,?)";
        PreparedStatement ps = konekcija.prepareStatement(sql);
        ps.setInt(1, pr.getPredmet().getSifraPredmeta());
        ps.setString(2, pr.getStudent().getBrojIndeksa());
        ps.setDate(3, new java.sql.Date(pr.getDatum().getTime()));
        ps.setInt(4, pr.getOcena());
        ps.executeUpdate();
    }

    public void izmeniPrijavu(Prijava pr) throws SQLException {
        String sql = "UPDATE prijava SET ocena ="+pr.getOcena()+",datum='"+new java.sql.Date(pr.getDatum().getTime())+"' where sifraPredmeta="+pr.getPredmet().getSifraPredmeta()+" and brojIndeksa='"+pr.getStudent().getBrojIndeksa()+"'";
        Statement s = konekcija.createStatement();
        s.executeUpdate(sql);
    }
}
