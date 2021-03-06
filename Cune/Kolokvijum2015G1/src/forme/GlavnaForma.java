/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Predmet;
import domen.Prijava;
import java.util.ArrayList;
import logika.Kontroler;
import model.ModelTabele;

/**
 *
 * @author Miroslav
 */
public class GlavnaForma extends javax.swing.JFrame {

    /**
     * Creates new form GlavnaForma
     */
    public GlavnaForma() {
        initComponents();
        ucitajKolekcijuPredmeta();
        ucitajKolekcijuPrijava();
        popuniKomboPredmeta();
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
        cmbPredmet = new javax.swing.JComboBox();
        btnPonistiFilter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnDodajPrijavu = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter"));

        jLabel1.setText("Predmet");

        cmbPredmet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPredmet.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPredmetItemStateChanged(evt);
            }
        });
        cmbPredmet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbPredmetMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmbPredmetMouseReleased(evt);
            }
        });
        cmbPredmet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPredmetActionPerformed(evt);
            }
        });
        cmbPredmet.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbPredmetPropertyChange(evt);
            }
        });
        cmbPredmet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmbPredmetKeyReleased(evt);
            }
        });

        btnPonistiFilter.setText("Ponesti filter");
        btnPonistiFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonistiFilterActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabela);

        btnDodajPrijavu.setText("Dodaj priijavu");
        btnDodajPrijavu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajPrijavuActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj prijave");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cmbPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPonistiFilter)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSacuvaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDodajPrijavu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPonistiFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDodajPrijavu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSacuvaj)))
                .addContainerGap(22, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPredmetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPredmetActionPerformed
        srediTabelu();
    }//GEN-LAST:event_cmbPredmetActionPerformed

    private void cmbPredmetItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPredmetItemStateChanged
       //srediTabelu();
    }//GEN-LAST:event_cmbPredmetItemStateChanged

    private void cmbPredmetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbPredmetKeyReleased
    }//GEN-LAST:event_cmbPredmetKeyReleased

    private void cmbPredmetMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbPredmetMouseReleased
        //srediTabelu();
    }//GEN-LAST:event_cmbPredmetMouseReleased

    private void cmbPredmetPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbPredmetPropertyChange
        //srediTabelu();
    }//GEN-LAST:event_cmbPredmetPropertyChange

    private void cmbPredmetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbPredmetMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPredmetMousePressed

    private void btnDodajPrijavuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajPrijavuActionPerformed
        DodajDijalog dd = new DodajDijalog(this, true);
        dd.setVisible(true);
    }//GEN-LAST:event_btnDodajPrijavuActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        boolean sacuvano = Kontroler.getInstanca().sacuvaj();
        
        if(sacuvano){
            ucitajKolekcijuPrijava();
            srediTabelu();
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnPonistiFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonistiFilterActionPerformed
        ucitajKolekcijuPrijava();
        srediTabelu();
    }//GEN-LAST:event_btnPonistiFilterActionPerformed

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
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GlavnaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajPrijavu;
    private javax.swing.JButton btnPonistiFilter;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbPredmet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

    private void ucitajKolekcijuPredmeta() {
        Kontroler.getInstanca().ucitajKolekcijuPredmeta();
    }

    private void popuniKomboPredmeta() {
        ArrayList<Predmet> lista = Kontroler.getInstanca().dajListuIZKolekcije();
        
        cmbPredmet.removeAllItems();
        Predmet pr = new Predmet(-1, "Svi predmeti");
        cmbPredmet.addItem(pr);
        
        for (Predmet p : lista) {
            cmbPredmet.addItem(p);
        }
    }

    private void ucitajKolekcijuPrijava() {
        Kontroler.getInstanca().ucitajKolekcijuPrijava();
    }

    private void srediTabelu() {
        
        ArrayList<Prijava> lista = Kontroler.getInstanca().vratiListuPRijavaIZKolekcije();
        ArrayList<Prijava> filterLista = new ArrayList<>();
        Predmet izabraniPredmet = (Predmet) cmbPredmet.getSelectedItem();
        
        if(izabraniPredmet == null)
            return;
        
        if(izabraniPredmet.getSifraPredmeta() == -1){
            filterLista = lista;
        }else{
            for (Prijava prijava : lista) {
                if(prijava.getPredmet().getSifraPredmeta() == izabraniPredmet.getSifraPredmeta()){
                    filterLista.add(prijava);
                }
            }
        }
        
        ModelTabele mt = new ModelTabele(filterLista);
        tabela.setModel(mt);
    }

    void dodajPRijavu(Prijava pr) {
        Kontroler.getInstanca().dodajPrijavuUKolekciju(pr);
        srediTabelu();
    }
}
