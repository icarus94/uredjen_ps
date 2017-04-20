/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbb;

import com.mysql.jdbc.Connection;
import domen.Asistent;
import domen.Predmet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zeljko
 */
public class DBBroker {

    Connection connection;

    public void uspostaviKonekciju() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/prosoft2013g1";
            String user = "root";
            String pw = "";
            connection = (Connection) DriverManager.getConnection(url, user, pw);
            connection.setAutoCommit(false);
            System.out.println("Konekcija na bazu uspesna!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void raskiniKonekciju() throws SQLException {
        connection.close();
        System.out.println("Konekcija sa bazom raskinuta!");
    }

    public void potvrdi() throws SQLException {
        connection.commit();
    }

    public void ponisti() throws SQLException {
        connection.rollback();
    }

    public List<Predmet> vratiSvePredmete() throws SQLException {
        List<Predmet> lista = new ArrayList<>();

        String upit = "Select * from Predmet order by semestar asc";
        PreparedStatement ps = connection.prepareStatement(upit);
        ResultSet rs = ps.executeQuery();
        Predmet p;
        while (rs.next()) {
            int sifraPredmeta = rs.getInt("sifraPredmeta");
            String naziv = rs.getString("nazivPredmeta");
            int semestar = rs.getInt("semestar");
            int brojBodova = rs.getInt("brojBodova");
            lista.add(new Predmet(sifraPredmeta, naziv, semestar, brojBodova));
        }
        rs.close();
        ps.close();
        return lista;
    }

    public void sacuvajAsistenta(Asistent asistent) throws SQLException {
        String upit = "Insert into Asistent(sifraAsistenta, ime, prezime, titula, sifraPredmeta) values (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.setInt(1, asistent.getSifraAsistenta());
        ps.setString(2, asistent.getIme());
        ps.setString(3, asistent.getPrezime());
        ps.setString(4, asistent.getTitula());
        ps.setInt(5, asistent.getPredmet().getSifraPredmeta());
        ps.executeUpdate();
        ps.close();

    }

    public Predmet dajPredmet(String naziv) throws SQLException {
        String upit = "Select * from Predmet where nazivPredmeta='" +naziv+"'";
        PreparedStatement ps = connection.prepareStatement(upit);
        ResultSet rs = ps.executeQuery();
        Predmet p = null;
        while (rs.next()) {
            int sifraPredmeta = rs.getInt("sifraPredmeta");
            String nazivPredmeta = rs.getString("nazivPredmeta");
            int brojBodova = rs.getInt("brojBodova");
            int semestar = rs.getInt("semestar");
            p = new Predmet(sifraPredmeta, nazivPredmeta, semestar, brojBodova);
        }
        return p;
    }
}
