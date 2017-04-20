/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import domen.Radnik;
import domen.Ucinak;
import domen.VrstaPosla;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zeljko
 */
public class DBBroker {
    Connection connection;
    
    public void uspostaviKonekciju() throws ClassNotFoundException, SQLException{
        //ucitamo drajver baze - mora da bude dodata biblioteka MySQL JDBC Driver
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/prosoftg3";
        String user = "root";
        String pw = "";
        connection = (Connection) DriverManager.getConnection(url,user,pw);
        connection.setAutoCommit(false);
        System.out.println("Uspesno konektovan na bazu!");
    }
    
    public void raskiniKonekciju() throws SQLException{
        connection.close();
        System.out.println("Konekcija sa bazom raskinuta!");
    }
    
    public void potvrdiTransakciju() throws SQLException{
        connection.commit();
    }
    public void ponistiTransakciju() throws SQLException{
        connection.rollback();
    }

    public List<Radnik> vratiSveRadnike() throws SQLException {
        List<Radnik> radnici = new ArrayList<>();
        String upit = "select * from radnik order by prezime asc";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(upit);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            int radnikID = rs.getInt("radnikID");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String specijalizacija = rs.getString("specijalizacija");
            Radnik r = new Radnik(radnikID, ime, prezime, specijalizacija);
            radnici.add(r);
        }
        rs.close();
        ps.close();
        return radnici;
    }

    public List<VrstaPosla> vratiSveVrstePosla() throws SQLException {
        List<VrstaPosla> lista = new ArrayList<>();
        String upit = "select * from vrstaposla order by naziv desc";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(upit);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            int id = rs.getInt("vrstaposlaid");
            String naziv = rs.getString("naziv");
            VrstaPosla vp = new VrstaPosla(id, naziv);
            lista.add(vp);
        }
        rs.close();
        ps.close();
        return lista;
    }

    public void sacuvajUcinak(Ucinak ucinak) throws SQLException {
        String upit="Insert into Ucinak(brojsati,datum,vrstaposlaid,radnikid) values (?,?,?,?)";
        PreparedStatement ps = (PreparedStatement) connection.prepareStatement(upit);
        ps.setInt(1, ucinak.getBrojSati());
        ps.setInt(3, ucinak.getVrstaPosla().getVrstaPoslaID());
        ps.setInt(4, ucinak.getRadnik().getRadnikID());
        ps.setDate(2, new Date(ucinak.getDatum().getTime()));
        ps.executeUpdate();
        ps.close();
    }
}
