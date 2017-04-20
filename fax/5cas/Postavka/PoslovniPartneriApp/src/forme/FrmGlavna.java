/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Mesto;
import forme.partner.FrmPrikazPartnera;
import forme.partner.FrmPrikazPartneraTabela;
import forme.partner.FrmUnosPartnera;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import poslovnalogika.Kontroler;

/**
 *
 * @author student
 */
public class FrmGlavna extends javax.swing.JFrame {

    /**
     * Creates new form FrmGlavna
     */
    public FrmGlavna() {
        initComponents();
        Kontroler.getInstance().sacuvajMesto(new Mesto(11000, "Beograd"));
        Kontroler.getInstance().sacuvajMesto(new Mesto(34000, "Kragujevac"));
        Kontroler.getInstance().sacuvajMesto(new Mesto(18000, "Nis"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jmbGlavniMeni = new javax.swing.JMenuBar();
        jmRadSaPartnerima = new javax.swing.JMenu();
        jmiUnosPartnera = new javax.swing.JMenuItem();
        jmiPrikazPartnera = new javax.swing.JMenuItem();
        jmiPrikazPartneraTabela = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jmRadSaPartnerima.setText("Rad sa partnerima");

        jmiUnosPartnera.setText("Unos partnera");
        jmiUnosPartnera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnosPartneraActionPerformed(evt);
            }
        });
        jmRadSaPartnerima.add(jmiUnosPartnera);

        jmiPrikazPartnera.setText("Prikaz partnera");
        jmiPrikazPartnera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPrikazPartneraActionPerformed(evt);
            }
        });
        jmRadSaPartnerima.add(jmiPrikazPartnera);

        jmiPrikazPartneraTabela.setText("Prikaz partnera - tabela");
        jmiPrikazPartneraTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPrikazPartneraTabelaActionPerformed(evt);
            }
        });
        jmRadSaPartnerima.add(jmiPrikazPartneraTabela);

        jmbGlavniMeni.add(jmRadSaPartnerima);

        setJMenuBar(jmbGlavniMeni);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiUnosPartneraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnosPartneraActionPerformed
        FrmUnosPartnera f = new FrmUnosPartnera(this, true);
        f.setVisible(true);
    }//GEN-LAST:event_jmiUnosPartneraActionPerformed

    private void jmiPrikazPartneraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPrikazPartneraActionPerformed
        FrmPrikazPartnera f = new FrmPrikazPartnera(this, true);
        f.setVisible(true);
    }//GEN-LAST:event_jmiPrikazPartneraActionPerformed

    private void jmiPrikazPartneraTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPrikazPartneraTabelaActionPerformed
        FrmPrikazPartneraTabela f = new FrmPrikazPartneraTabela();
        f.setVisible(true);
        // Prikaz panela u okviru dijaloga
        JDialog d = new JDialog(this, "Prikaz partnera", true);
        d.setLayout(new BorderLayout());
        d.add(f, BorderLayout.CENTER);
        d.pack();
        d.setVisible(true);
    }//GEN-LAST:event_jmiPrikazPartneraTabelaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGlavna().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jmRadSaPartnerima;
    private javax.swing.JMenuBar jmbGlavniMeni;
    private javax.swing.JMenuItem jmiPrikazPartnera;
    private javax.swing.JMenuItem jmiPrikazPartneraTabela;
    private javax.swing.JMenuItem jmiUnosPartnera;
    // End of variables declaration//GEN-END:variables
}
