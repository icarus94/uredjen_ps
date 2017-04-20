/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbr;

import domen.Angazovanje;
import domen.Gradiliste;
import domen.Radnik;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author elezs
 */
public class DBBroker {

    private Connection connection;

    public void uspostaviKonekciju() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/prosoftg1";
        String user = "root";
        String pass = "";
        connection = DriverManager.getConnection(url, user, pass);
        System.out.println("Konekcija na bazu uspesna");
        connection.setAutoCommit(false);
    }

    public void potvrdiTransakciju() throws SQLException {
        connection.commit();
    }

    public void ponistiTransakciju() throws SQLException {
        connection.rollback();
    }

    public void raskiniKonekciju() throws SQLException {
        connection.close();
        System.out.println("Uspesno raskinuta konekcija!");
    }
    public List<Gradiliste> getAllGradiliste() throws SQLException {
        List<Gradiliste> gradilista =  new ArrayList<>();
        String upit = "SELECT * "
                     + "FROM gradiliste";
        System.out.println(upit);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        while(rs.next()){
            Gradiliste g = new Gradiliste();
            g.setGradilisteID(rs.getInt("gradilisteid"));
            g.setNaziv(rs.getString("naziv"));
            g.setMesto(rs.getString("mesto"));
            gradilista.add(g);
        }
        rs.close();
        statement.close();
        return gradilista;
    }
    public List<Radnik> getAllRadnik() throws SQLException {
        List<Radnik> radnici =  new ArrayList<>();
        String upit = "SELECT * "
                     + "FROM radnik";
        System.out.println(upit);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        while(rs.next()){
            Radnik g = new Radnik();
            g.setRadnikID(rs.getInt("radnikid"));
            g.setIme(rs.getString("ime"));
            g.setPrezime(rs.getString("prezime"));
            g.setSpecijalizacija(rs.getString("specijalizacija"));
            radnici.add(g);
        }
        rs.close();
        statement.close();
        return radnici;
    }

    public void sacuvajAngazovanje(Angazovanje angazovanje) throws SQLException {
        String upit = "INSERT INTO angazovanje(BrojSati, Datum, GradilisteID, RadnikID) VALUES (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.setInt(1, angazovanje.getBrojSati());
        java.util.Date dat = angazovanje.getDatum();
        Timestamp datum = new Timestamp(dat.getTime());
        ps.setTimestamp(2, datum);
        ps.setInt(3, angazovanje.getGradiliste().getGradilisteID());
        ps.setInt(4, angazovanje.getRadnik().getRadnikID());
        ps.executeUpdate();
        ps.close();
    }
}
