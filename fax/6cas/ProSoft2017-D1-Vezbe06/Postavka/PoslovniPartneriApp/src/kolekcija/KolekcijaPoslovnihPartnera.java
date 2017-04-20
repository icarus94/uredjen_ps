/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kolekcija;

import domen.PoslovniPartner;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author student
 */
public class KolekcijaPoslovnihPartnera {
    private List<PoslovniPartner> lp;

    public KolekcijaPoslovnihPartnera() {
        lp = new LinkedList<>();
    }
    
    public void sacuvajPartnera(PoslovniPartner pp) {
        lp.add(pp);
    }
    
    public List<PoslovniPartner> vratiPartnere() {
        return lp;
    }
    
    
    
}
