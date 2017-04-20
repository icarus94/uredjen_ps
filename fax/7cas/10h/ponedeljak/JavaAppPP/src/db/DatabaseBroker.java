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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class DatabaseBroker {
    private Connection connection;
    
    public void uspostaviKonekciju() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/partneri";
        String user="root";
        String password="";
        connection=DriverManager.getConnection(url, user, password);
        System.out.println("Uspesna konekcija!");
        connection.setAutoCommit(false);
    }
    
    public void potvrdiTransakciju() throws SQLException{
        connection.commit();
    }
    
    public void ponistiTransakciju() throws SQLException{
        connection.rollback();
    }
    
    public void raskiniKonekciju() throws SQLException{
        connection.close();
        System.out.println("Uspesno raskinuta konekcija!");
    }
    
    public void insertPoslovniPartner(PoslovniPartner pp) throws SQLException{
        String upit="INSERT INTO PoslovniPartner (pib, maticnibroj, naziv, ulica, broj, ptt) VALUES ('"+pp.getPib()+"','"+pp.getMaticniBroj()+"','"+pp.getNaziv()+"', '"+pp.getUlica()+"','"+pp.getBroj()+"',"+pp.getMesto().getPpt()+")";
        System.out.println(upit);
        Statement statement=connection.createStatement();
        statement.executeUpdate(upit);
        statement.close();
    }
    
    public void insertPoslovniPartnerBoljiNacin(PoslovniPartner pp) throws SQLException{
        String upit="INSERT INTO PoslovniPartner (pib, maticnibroj, naziv, ulica, broj, ptt) VALUES (?,?,?,?,?,?)";
        System.out.println(upit);
        PreparedStatement statement=connection.prepareStatement(upit);
        statement.setString(1, pp.getPib());
        statement.setString(2, pp.getMaticniBroj());
        statement.setString(3, pp.getNaziv());
        statement.setString(4, pp.getUlica());
        statement.setString(5, pp.getBroj());
        statement.setLong(6, pp.getMesto().getPpt());
        statement.executeUpdate();
        statement.close();
    }
    
    public List<Mesto> getAllMesto() throws SQLException{
        List<Mesto> mesta=new ArrayList<>();
        String upit="SELECT ptt, naziv FROM Mesto";
        System.out.println(upit);
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery(upit);
        while(rs.next()){
            Mesto mesto=new Mesto();
            mesto.setPpt(rs.getLong("ptt"));
            mesto.setNaziv(rs.getString("naziv"));
            mesta.add(mesto);
        }
        rs.close();
        statement.close();
        return mesta;
    }
    
    public List<PoslovniPartner> getAllPoslovniPartner() throws SQLException{
        List<PoslovniPartner> partneri=new ArrayList<>();
        String upit="SELECT pib, maticniBroj, pp.naziv AS nazivPoslovnogPartnera, ulica, broj, pp.ptt AS pttBroj, m.naziv AS NazivMesta FROM PoslovniPartner pp INNER JOIN Mesto m ON pp.ptt=m.ptt";
        System.out.println(upit);
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery(upit);
        while(rs.next()){
            PoslovniPartner pp=new PoslovniPartner();
            pp.setPib(rs.getString("pib"));
            pp.setMaticniBroj(rs.getString("maticniBroj"));
            pp.setNaziv(rs.getString("nazivPoslovnogPartnera"));
            pp.setUlica(rs.getString("ulica"));
            pp.setBroj(rs.getString("broj"));
            Mesto m=new Mesto();
            m.setPpt(rs.getLong("pttBroj"));
            m.setNaziv(rs.getString("nazivMesta"));
            pp.setMesto(m);
            partneri.add(pp);
        }
        rs.close();
        statement.close();
        return partneri;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DatabaseBroker dbbr=new DatabaseBroker();
        dbbr.uspostaviKonekciju();
        
        PoslovniPartner pp=new PoslovniPartner("123", "223", "BIP", "Oblakovska", "bb", new Mesto(11000, "Beograd"));
        dbbr.insertPoslovniPartner(pp);
        
        dbbr.raskiniKonekciju();
    }
}
