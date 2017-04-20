/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Mesto;
import domen.PoslovniPartner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author student
 */
public class DatabaseBroker {

    private Connection connection;

    public void ucitajDriver() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public void uspostaviKonekciju() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poslovnipartneri", "root", "");
        connection.setAutoCommit(false);
        // Zahteva eksplicitnu potvrdu transakcije
    }

    public void commitTraksancije() throws SQLException {
        connection.commit();
    }

    public void rollbackTransakcije() throws SQLException {
        connection.rollback();
    }

    public void zatvoriKonekciju() throws SQLException {
        connection.close();
    }

    public List<Mesto> vratiMesta() throws SQLException {
        List<Mesto> lm = new LinkedList<>();
        String sql = "SELECT ptt, naziv FROM Mesto";
        System.out.println(sql);
        Statement sqlNaredba = connection.createStatement();
        ResultSet rs = sqlNaredba.executeQuery(sql);
        while (rs.next()) {
            // Redni broj/naziv kolone zavisi od sql upita!
            int ptt = rs.getInt(1);
            String naziv = rs.getString("naziv");
            Mesto m = new Mesto(ptt, naziv);
            lm.add(m);
        }
        rs.close();
        sqlNaredba.close();
        return lm;
    }

    public void sacuvajPartnera(PoslovniPartner pp) throws SQLException {
        String sql = "INSERT INTO PoslovniPartner VALUES (" + pp.getPartnerID() + ",'" + pp.getNaziv() + "','" + pp.getMaticniBroj() + "','" + pp.getPib() + "','" + pp.getUlica() + "','" + pp.getBroj() + "'," + pp.getMesto().getPtt() + ")";
        System.out.println(sql);
        Statement sqlNaredba = connection.createStatement();
        sqlNaredba.executeUpdate(sql);
        sqlNaredba.close();
    }

    public void snimiPartnera(PoslovniPartner pp) throws SQLException {
        String sql = "INSERT INTO PoslovniPartner VALUES (?,?,?,?,?,?,?)";
        System.out.println(sql);
        PreparedStatement sqlNaredba = connection.prepareStatement(sql);
        sqlNaredba.setInt(1, pp.getPartnerID());
        sqlNaredba.setString(2, pp.getNaziv());
        sqlNaredba.setString(3, pp.getMaticniBroj());
        sqlNaredba.setString(4, pp.getPib());
        sqlNaredba.setString(5, pp.getUlica());
        sqlNaredba.setString(6, pp.getBroj());
        sqlNaredba.setInt(7, pp.getMesto().getPtt());
        sqlNaredba.executeUpdate();
        sqlNaredba.close();
    }

    public List<PoslovniPartner> vratiPartnere() throws SQLException {
        List<PoslovniPartner> lp = new LinkedList<>();
        String sql = "SELECT p.partnerID, p.naziv AS NazivPartnera, p.maticniBroj, p.pib, p.ulica, p.broj, m.ptt, m.naziv AS NazivMesta FROM PoslovniPartner p INNER JOIN Mesto m ON (p.ptt = m.ptt)";
        // TODO Dovrsisiti zadatak za domaci
        return lp;
    }

}
