/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbb;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import domen.Zadatak;
import domen.Zaposleni;
import exception.DuplikatException;
import java.sql.Date;
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
            String url = "jdbc:mysql://localhost:3306/prosoft2014g1";
            String user = "root";
            String pw = "";
            connection = (Connection) DriverManager.getConnection(url, user,pw);
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
    public void potvrdi() throws SQLException{
        connection.commit();
    }
    public void ponisti() throws SQLException{
        connection.rollback();
    }
    public List<Zaposleni> vratiZaposlene() throws SQLException {
        String upit = "SELECT * FROM TZaposleni ORDER BY prezime ASC";
        PreparedStatement ps = connection.prepareStatement(upit);
        ResultSet rs = ps.executeQuery();
        List<Zaposleni> zap = new ArrayList<>();
        while(rs.next()){
            String sifra = rs.getString("sifraZaposlenog");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            zap.add(new Zaposleni(sifra, ime, prezime));
        }
        rs.close();
        ps.close();
        return zap;
    }

    public void sacuvajZadatak(Zadatak zadatak) throws SQLException, DuplikatException {
        String upit = "Insert into TZadatak(sifraZadatka, datum, naziv, opis, sifraZaposlenog) VALUES (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(upit);
        ps.setString(1,zadatak.getSifraZadatka());
        ps.setDate(2, new Date(zadatak.getDatum().getTime()));
        ps.setString(3,zadatak.getNaziv());
        ps.setString(4,zadatak.getOpis());
        ps.setString(5,zadatak.getZaposleni().getSifraZaposlenog());
        try {
            ps.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException e) {
            throw new DuplikatException("Postoji duplikat kod sifre zadatka!\nZadaci nisu sacuvani.");
        }
        ps.close();
    }

    
    
}
