/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Radnik;
import domen.Ucinak;
import domen.VrstaPosla;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import model.ModelTabeleUcinci;

/**
 *
 * @author Miroslav
 */
public class GlavniProzor extends javax.swing.JFrame {

    /**
     * Creates new form GlavniProzor
     */
    public GlavniProzor() {
        initComponents();
        popuniVrstePoslovaKombo();
        popuniKomboRadnika();
        srediTabelu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbVrstaPosla = new javax.swing.JComboBox();
        cmbRadnik = new javax.swing.JComboBox();
        txtBrojSati = new javax.swing.JTextField();
        txtDatum = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUcinaka = new javax.swing.JTable();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("G3 radionica");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ucinci"));

        jLabel1.setText("Vrsta posla");

        jLabel2.setText("Radnik");

        jLabel3.setText("Broj sati");

        jLabel4.setText("Datum");

        cmbVrstaPosla.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbRadnik.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDodaj.setText("dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        tabelaUcinaka.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaUcinaka);

        btnSacuvaj.setText("Sacuvaj sve");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbVrstaPosla, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbRadnik, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBrojSati)
                            .addComponent(txtDatum)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDodaj)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSacuvaj))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbVrstaPosla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBrojSati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnObrisi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSacuvaj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        VrstaPosla vp = (VrstaPosla) cmbVrstaPosla.getSelectedItem();
        Radnik r = (Radnik) cmbRadnik.getSelectedItem();
        
        String br = txtBrojSati.getText();
        String dat = txtDatum.getText();
        
        if(br.isEmpty() || dat.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ne moze, jer niste popunila sva polja.", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (int i = 0; i < br.length(); i++) {
            if(!Character.isDigit(br.charAt(i))){
                JOptionPane.showMessageDialog(this, "Ne moze, jer morate uneti broj", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        int brojSati = Integer.parseInt(br);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date datum = null;
        try {
            datum = sdf.parse(dat);
        } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Datum nije u dobrom formatu", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
        }
        
        Ucinak u = new Ucinak(-1, brojSati, datum, r, vp);
        
        ModelTabeleUcinci mtu = (ModelTabeleUcinci) tabelaUcinaka.getModel();
        
        mtu.dodaj(u);
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int red = tabelaUcinaka.getSelectedRow();
        
        if(red == -1){
            System.err.println("Niste izabrali red");
        }else{
            ModelTabeleUcinci mtu = (ModelTabeleUcinci) tabelaUcinaka.getModel();
            mtu.obrisi(red);
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        ModelTabeleUcinci mtu = (ModelTabeleUcinci) tabelaUcinaka.getModel();
        ArrayList<Ucinak> lista = mtu.getLista();
        
        for (int i = 0; i < lista.size(); i++) {
            Ucinak u1 = lista.get(i);
            for (int j = i+1; j < lista.size(); j++) {
                Ucinak u2 = lista.get(j);
                if(u1.getRadnik().getRadnikID()==
                        u2.getRadnik().getRadnikID() &&
                     u1.getVrstaPosla().getVrstaPoslaID()!=
                        u2.getVrstaPosla().getVrstaPoslaID()){
                    
                    JOptionPane.showMessageDialog(this, "Radnik moze raditi samo jednu vrstu posla", "Greska", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
            }
            
        }
        
        //8 sati maks
        SimpleDateFormat sdf  = new SimpleDateFormat("dd.MM.yyyy");
        for (int i = 0; i < lista.size(); i++) {
            Ucinak u1 = lista.get(i);
            int ukupnoSati = u1.getBrojSati();
            String dat1 = sdf.format(u1.getDatum());
            for (int j = i +1; j < lista.size(); j++) {
                Ucinak u2 = lista.get(j);
                String dat2 = sdf.format(u2.getDatum());
                if(u1.getRadnik().getRadnikID()==u2.getRadnik().getRadnikID()
                        && dat1.equals(dat2)){
                    ukupnoSati+=u2.getBrojSati();
                }
            }
            
            if(ukupnoSati>8){
                JOptionPane.showMessageDialog(this, "Radnik moze raditi 8 sati maks", "Greska", JOptionPane.ERROR_MESSAGE);
                    return;
            }
            
        }
        
        boolean sacuvano = Kontroler.getKontroler().sacuvaj(lista);
        
        if(sacuvano)
            JOptionPane.showMessageDialog(this, "USpesnooooo", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(this, "JBg", "Greska", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnSacuvajActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GlavniProzor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GlavniProzor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GlavniProzor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GlavniProzor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GlavniProzor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbRadnik;
    private javax.swing.JComboBox cmbVrstaPosla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaUcinaka;
    private javax.swing.JTextField txtBrojSati;
    private javax.swing.JTextField txtDatum;
    // End of variables declaration//GEN-END:variables

    private void popuniVrstePoslovaKombo() {


        cmbVrstaPosla.removeAllItems();
        
        ArrayList<VrstaPosla> lista = Kontroler.getKontroler().vratiPoslove();
        for (VrstaPosla vrstaPosla : lista) {
            cmbVrstaPosla.addItem(vrstaPosla);
        }
    }

    private void popuniKomboRadnika() {

        cmbRadnik.removeAllItems();
        
        ArrayList<Radnik> lista = Kontroler.getKontroler().vratiRadnike();
        
        for (Radnik radnik : lista) {
            cmbRadnik.addItem(radnik);
        }
    }

    private void srediTabelu() {
        ModelTabeleUcinci mtu = new ModelTabeleUcinci();
        tabelaUcinaka.setModel(mtu);
    }
}
