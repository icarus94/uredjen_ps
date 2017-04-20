/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Zaposleni;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elezs
 */
public class DBBroker {
    private Connection connection;
    
    public void uspostaviKonekciju() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/prosoftg12014";
        String user = "root";
        String pass = "";
        connection = DriverManager.getConnection(url, user, pass);
        System.out.println("Konekcija na bazu uspostavljena!");
        connection.setAutoCommit(false);
    }
    public void potvrdiTransakciju() throws SQLException {
        connection.commit();
    }
    public void ponistiTransakciju() throws SQLException{
        connection.rollback();
    }
    public void prekiniKonekciju() throws SQLException {
        connection.close();
        System.out.println("Konekcija prekinuta");
    }

    public List<Zaposleni> getZaposleni() throws SQLException {
        List<Zaposleni> zaposleni = new ArrayList<>();
        String upit = "SELECT* FROM tzaposleni";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(upit);
        while(rs.next()){
            Zaposleni z = new Zaposleni();
            z.setSifraZaposlenog(rs.getString("sifrazaposlenog"));
            z.setIme(rs.getString("ime"));
            z.setPrezime(rs.getString("prezime"));
            zaposleni.add(z);
        }
        return zaposleni;
    }
}
