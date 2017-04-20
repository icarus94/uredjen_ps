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

}
