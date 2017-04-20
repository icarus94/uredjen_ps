/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbr;

import domen.Lokacija;
import domen.Radnik;
import domen.Raspored;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        String url = "jdbc:mysql://localhost:3306/prosoftg2";
        String user = "root";
        String pass = "";

        connection = DriverManager.getConnection(url, user, pass);
        System.out.println("Uspostavljena konekcija");
        connection.setAutoCommit(false);
    }
    public void potvrdiKonekciju() throws SQLException{
        connection.commit();
    }
    public void ponistiKonekciju() throws SQLException {
        connection.rollback();
    }

    public List<Radnik> ucitajRadnike() throws SQLException {
        List<Radnik> radnici =  new ArrayList<>();
        String upit = "SELECT * FROM Radnik ORDER BY prezime ASC";
        System.out.println(upit);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        while(rs.next()){
            Radnik r = new Radnik();
            r.setRadnikID(rs.getInt("radnikID"));
            r.setIme(rs.getString("ime"));
            r.setPrezime(rs.getString("prezime"));
            r.setSpecijalizacija(rs.getString("specijalizacija"));
            radnici.add(r);
        }
        rs.close();
        statement.close();
        return radnici;
    }
    public List<Lokacija> ucitajLokaciju() throws SQLException{
        List<Lokacija> lokacije = new ArrayList<>();
        String upit = "SELECT * FROM Lokacija ORDER BY naziv ASC";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(upit);
        while(rs.next()){
            Lokacija l = new Lokacija();
            l.setLokacijaID(rs.getInt("lokacijaID"));
            l.setNaziv(rs.getString("naziv"));
            l.setPocetakGradnje(rs.getDate("pocetakGradnje"));
            l.setPocetakGradnje(rs.getDate("zavrsetakGradnje"));
            lokacije.add(l);
        }
        rs.close();
        statement.close();
        return lokacije;
    }

    public void raskiniKonekciju() throws SQLException {
        connection.close();
        System.out.println("Konekcija raskinuta");
    }

    public boolean upisiRasporede(List<Raspored> rasporedi) throws SQLException {
        boolean uspesno = false;
        String upit = "INSERT INTO Raspored(brojSati, datum, lokacijaID, radnikID) VALUES (?,?,?,?)";
        System.out.println(upit);
        for(Raspored r : rasporedi){
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setInt(1,r.getBrojSati() );
            ps.setDate(2, r.getDatum());
            ps.setObject(3, r.getLokacija().getLokacijaID());
            ps.setObject(4, r.getRadnik().getRadnikID());
            ps.executeUpdate();
            ps.close();
            uspesno = true;
        }
        return uspesno;
    }
    
}
