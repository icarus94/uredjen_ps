/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.Connection;
import domen.Angazovanje;
import domen.Gradiliste;
import domen.Radnik;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zeljko
 */
public class DBBroker {
    Connection connection;
    
    public void uspostaviKonekciju() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/prosoftg1";
            String user = "root";
            String password = "";
            connection = (Connection) DriverManager.getConnection(url,user,password);
            connection.setAutoCommit(false);
            System.out.println("Konekcija na bazu uspesna!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Greska kod ucitavanja drajvera baze!");
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void potvrdiTransakciju() throws SQLException{
        connection.commit();
    }
    public void ponistiTransakciju() throws SQLException{
        connection.rollback();
    }
    public void raskiniKonekciju() throws SQLException{
        connection.close();
        System.out.println("Raskinuta konekcija sa bazom!");
    }
    

    public List<Gradiliste> vratiSvaGradilista() throws SQLException {
        List<Gradiliste> gradilista = new ArrayList<>();
        String upit = "SELECT * FROM Gradiliste ORDER BY Naziv ASC";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit);
        ResultSet rs = ps.executeQuery();
        Gradiliste gr;
        while (rs.next()) {
            int gradilisteID = rs.getInt("GradilisteID");
            String naziv = rs.getString("Naziv");
            String mesto = rs.getString("Mesto");
            
            gradilista.add(new Gradiliste(gradilisteID, naziv, mesto));
        }
        ps.close();
        rs.close();
        return gradilista;
    }

    public List<Radnik> vratiSveRadnike() throws SQLException {
        List<Radnik> radnici = new ArrayList<>();
        String upit = "SELECT * FROM Radnik ORDER BY Prezime ASC";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit);
        ResultSet rs = ps.executeQuery();
        Radnik r;
        while (rs.next()) {
            int radnikID = rs.getInt("RadnikID");
            String ime = rs.getString("Ime");
            String prezime = rs.getString("Prezime");
            String specijalizacija = rs.getString("Specijalizacija");
            radnici.add(new Radnik(radnikID, ime, prezime, specijalizacija));
        }
        ps.close();
        rs.close();
        return radnici;
    }

    public List<Angazovanje> vratiSvaAngazovanja() throws SQLException {
        List<Angazovanje> ang = new ArrayList<>();        

        String upit = "SELECT "
                + "angazovanje.AngazovanjeID, "
                + "angazovanje.BrojSati, "
                + "angazovanje.Datum, "
                + "angazovanje.RadnikID, "
                + "radnik.Ime, "
                + "radnik.Prezime,"
                + "radnik.Specijalizacija, "
                + "angazovanje.gradilisteID,"
                + "gradiliste.Naziv,"
                + "gradiliste.Mesto "
                + "FROM((angazovanje INNER JOIN radnik ON angazovanje.RadnikID=radnik.RadnikID) "
                + "INNER JOIN gradiliste ON angazovanje.GradilisteID=gradiliste.GradilisteID)";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit);
        
        ResultSet rs = ps.executeQuery();
  
        Radnik r;
        Gradiliste g;
        Angazovanje a;
        while (rs.next()) {
            String imeRadnika = rs.getString("Ime");
            String prezimeRadnika = rs.getString("Prezime");
            String specijalizacija = rs.getString("Specijalizacija");
            int radnikID = rs.getInt("radnikID");
            int gradilisteID = rs.getInt("gradilisteID");
            String naziv = rs.getString("Naziv");
            String mesto = rs.getString("Mesto");
            int angazovanjeID = rs.getInt("angazovanjeID");
            int brojSati = rs.getInt("brojSati");
            Date datum = rs.getDate("datum");
            r = new Radnik(radnikID, imeRadnika, prezimeRadnika, specijalizacija);
            g = new Gradiliste(gradilisteID, naziv, mesto);
            a = new Angazovanje(angazovanjeID, brojSati, datum, g, r);
            ang.add(a);
        }
        ps.close();
        rs.close();
        return ang;
    }

    public void sacuvajAngazovanje(Angazovanje a) throws SQLException {
        String upit = "INSERT INTO Angazovanje(BrojSati, Datum, RadnikID, GradilisteID) VALUES (?,?,?,?)";
        
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.setInt(1, a.getBrojSati());
        ps.setDate(2, new Date(a.getDatum().getTime()));
        ps.setInt(3, a.getRadnik().getRadnikID());
        ps.setInt(4, a.getGradiliste().getGradilisteID());
        ps.executeUpdate();
        ps.close();
        
    }
}
