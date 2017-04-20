/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;

/**
 *
 * @author Cule
 */
public class Prijava {
    private Predmet predmet;
    private Student student;
    private Date datum;
    private int ocena;
    String status;

    public Prijava() {
    }

    public Prijava(Predmet predmet, Student student, Date datum, int ocena, String status) {
        this.predmet = predmet;
        this.student = student;
        this.datum = datum;
        this.ocena = ocena;
        this.status = status;
    }

    

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
