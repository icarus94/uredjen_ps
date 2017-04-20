/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kolekcija;

import domen.Mesto;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author student
 */
public class KolekcijaMesta {
    private List<Mesto> lm;

    public KolekcijaMesta() {
        lm = new LinkedList<>();
    }
    
    public void sacuvajMesto(Mesto m) {
        lm.add(m);
    }
    
    public List<Mesto> vratiMesta() {
        return lm;
    }
    
}
