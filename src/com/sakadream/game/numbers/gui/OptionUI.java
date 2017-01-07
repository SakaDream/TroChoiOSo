/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakadream.game.numbers.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sakadream.game.numbers.func.Function;

/**
 *
 * @author haipbps04741
 */
public class OptionUI extends javax.swing.JFrame {

    /**
     * Creates new form OptionUI
     */
    public OptionUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        cbbDif.addItem(Function.EASY);
        cbbDif.addItem(Function.MEDIUM);
        cbbDif.addItem(Function.HARD);
        cbbDif.setSelectedIndex(0);
        try {
            Function.openOption(rFM, rTLM, cbbDif, sldTime);
        } catch (IOException ex) {
            Logger.getLogger(OptionUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OptionUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        lblMode = new javax.swing.JLabel();
        rFM = new javax.swing.JRadioButton();
        rTLM = new javax.swing.JRadioButton();
        lblDif = new javax.swing.JLabel();
        cbbDif = new javax.swing.JComboBox<>();
        lblTime = new javax.swing.JLabel();
        sldTime = new javax.swing.JSlider();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setTitle("Trò Chơi Ô Số - Option");

        lblMode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMode.setText("Mode: ");

        btnGroup.add(rFM);
        rFM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rFM.setSelected(true);
        rFM.setText("Free Mode");

        btnGroup.add(rTLM);
        rTLM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rTLM.setText("Time Left Mode");

        lblDif.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDif.setText("Difficulty: ");

        lblTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTime.setText("Time: ");

        sldTime.setMajorTickSpacing(5);
        sldTime.setMaximum(30);
        sldTime.setMinimum(1);
        sldTime.setMinorTickSpacing(5);
        sldTime.setPaintLabels(true);
        sldTime.setPaintTicks(true);
        sldTime.setSnapToTicks(true);

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancel.setText("Cancel");

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setText("Save");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDif)
                    .addComponent(lblTime)
                    .addComponent(lblMode))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rTLM)
                    .addComponent(rFM)
                    .addComponent(sldTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbDif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnCancel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMode)
                    .addComponent(rFM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rTLM)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDif)
                    .addComponent(cbbDif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTime)
                    .addComponent(sldTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
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
            java.util.logging.Logger.getLogger(OptionUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptionUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptionUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptionUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptionUI().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancel;
    private javax.swing.ButtonGroup btnGroup;
    public javax.swing.JButton btnSave;
    public javax.swing.JComboBox<String> cbbDif;
    public javax.swing.JLabel lblDif;
    public javax.swing.JLabel lblMode;
    public javax.swing.JLabel lblTime;
    public javax.swing.JRadioButton rFM;
    public javax.swing.JRadioButton rTLM;
    public javax.swing.JSlider sldTime;
    // End of variables declaration//GEN-END:variables
}