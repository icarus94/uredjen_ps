/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbb;

import com.mysql.jdbc.Connection;
import domen.Radnik;
import domen.Ucinak;
import domen.VrstaPosla;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String url = "jdbc:mysql://localhost:3306/prosoftg3";
        String user = "root";
        String pass = "";
        connection = (Connection) DriverManager.getConnection(url, user, pass);
        connection.setAutoCommit(false);
        System.out.println("Uspesno konektovan na bazu");
    }
    public void raskininKonekciju() throws SQLException {
        connection.close();
        System.out.println("Raskinuta kolekcija");
    }
    public void potvrdiTransakciju() throws SQLException {
        connection.commit();
    }
    public void ponistiTransakciju() throws SQLException{
        connection.rollback();
    }

    public List<Radnik> getRadnici() throws SQLException {
        List<Radnik> radnici = new ArrayList<>();
        String upit = "SELECT * FROM radnik ORDER BY prezime ASC";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Radnik r = new Radnik();
            r.setRadnikID(rs.getInt("radnikID"));
            r.setIme(rs.getString("ime"));
            r.setPrezime(rs.getString("prezime"));
            r.setSpecijalizacija(rs.getString("specijalizacija"));
            radnici.add(r);
        }
        rs.close();
        ps.close();
        return radnici;
    }

    public List<VrstaPosla> getVrstePosla() throws SQLException {
        List<VrstaPosla> vrstePosla = new ArrayList<>();
        String upit = "SELECT * FROM vrstaposla ORDER BY naziv DESC";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            VrstaPosla vp = new VrstaPosla();
            vp.setVrstaPoslaID(rs.getInt("vrstaPoslaID"));
            vp.setNaziv(rs.getString("naziv"));
            vrstePosla.add(vp);
        }
        rs.close();
        ps.close();
        return vrstePosla;
    }

    public void sacuvajUcinak(Ucinak u) throws SQLException {
        String upit = "INSERT INTO Ucinak(brojSati, datum, vrstaPoslaID, radnikID) VALUES (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.setInt(1, u.getBrojSati());
        ps.setInt(3, u.getVrstaPosla().getVrstaPoslaID());
        ps.setInt(4, u.getRadnik().getRadnikID());
        ps.setDate(2, new Date(u.getDatum().getTime()));
        ps.executeUpdate();
        ps.close();
    }
}
