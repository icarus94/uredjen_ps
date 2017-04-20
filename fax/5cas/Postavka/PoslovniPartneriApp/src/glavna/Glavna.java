/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glavna;

import domen.Mesto;
import domen.PoslovniPartner;

/**
 *
 * @author student
 */
public class Glavna {

    public static void main(String[] args) {
        Mesto m = new Mesto(11000, "Beograd");
        PoslovniPartner pp = new PoslovniPartner(1, "Bambi", "11", "1234", "Bulevar Zorana Djindjica", "100", m);
        System.out.println(pp);
    }

}
