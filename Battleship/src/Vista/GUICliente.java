/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JLabel;
import battleship.*;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author mikom
 */
public class GUICliente extends javax.swing.JFrame {
    int X1, Y1, X2, Y2;
    JLabel [][] matrizLabels = new JLabel [20][20];
    Componente [][] matrizLogica;
    Controlador.Controlador_Cliente controlador;
   // public GUICliente(Componente [][] _matrizLogica, Controlador.Controlador_Cliente controlador) {
    public GUICliente(Controlador.Controlador_Cliente controlador){
        X1= Y1 = 0;
        X2=  Y2 = 200;
        initComponents();
        this.controlador = controlador;
        
        Graphics g = this.jPanelJugador.getGraphics();
        g.setColor(Color.white);
        g.drawLine(X1, Y1, X2, Y2);
       // matrizLogica = _matrizLogica;
    }
    @SuppressWarnings("unchecked")
    
    
    public static void main(String args[]) {
        GUICliente gui = new GUICliente(); 
        gui.setVisible(true);
        
    }

    private GUICliente() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaChat = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButtonEnvMensaje = new javax.swing.JButton();
        txtFieldMensajes = new javax.swing.JTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        jPanelJugador = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanelTrumpedo = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanelTorpedo = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanelBomba = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanelMultiShot = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jButtonArmeria1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1400, 780));
        setPreferredSize(new java.awt.Dimension(1300, 780));
        setSize(new java.awt.Dimension(1300, 780));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAreaChat.setEditable(false);
        txtAreaChat.setColumns(20);
        txtAreaChat.setRows(5);
        jScrollPane2.setViewportView(txtAreaChat);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 634, 600, 63));

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 640, 600, 96));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel2.setText("Enemigos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, -1, 20));

        jButtonEnvMensaje.setText("Enviar mensaje");
        jButtonEnvMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnvMensajeActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEnvMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 703, 130, 41));

        txtFieldMensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldMensajesActionPerformed(evt);
            }
        });
        getContentPane().add(txtFieldMensajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 703, 465, 41));

        jTabbedPane2.setPreferredSize(new java.awt.Dimension(600, 600));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/oceanEnemigo.PNG"))); // NOI18N
        jLabel1.setText("jLabel1");
        jTabbedPane2.addTab("tab1", jLabel1);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, -1, 610));

        jPanelJugador.setBackground(new java.awt.Color(255, 102, 102));
        jPanelJugador.setOpaque(false);
        jPanelJugador.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout jPanelJugadorLayout = new javax.swing.GroupLayout(jPanelJugador);
        jPanelJugador.setLayout(jPanelJugadorLayout);
        jPanelJugadorLayout.setHorizontalGroup(
            jPanelJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanelJugadorLayout.setVerticalGroup(
            jPanelJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 600, 600));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/ocean2.PNG"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 26, 600, 604));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel3.setText("Mi Oceano");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 260, -1, -1));

        jLabel6.setText("Dinero:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jLabel8.setText("Mis Recursos");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 100, -1));

        jLabel9.setText("Acero:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, -1, -1));

        jButton1.setText("Usar Arma!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 100, 40));

        jLabel12.setText("Armas Compradas");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, -1, -1));

        jLabel10.setText("Click para fabricar!");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, -1, -1));

        jCheckBox1.setText("Comprar");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, -1, -1));

        jLabel11.setText("5000Kg Acero");

        jButton4.setText("Trumpedo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTrumpedoLayout = new javax.swing.GroupLayout(jPanelTrumpedo);
        jPanelTrumpedo.setLayout(jPanelTrumpedoLayout);
        jPanelTrumpedoLayout.setHorizontalGroup(
            jPanelTrumpedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrumpedoLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanelTrumpedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanelTrumpedoLayout.setVerticalGroup(
            jPanelTrumpedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrumpedoLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap())
        );

        getContentPane().add(jPanelTrumpedo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 110, 70));

        jPanelTorpedo.setLayout(null);

        jLabel15.setText("500Kg Acero");
        jPanelTorpedo.add(jLabel15);
        jLabel15.setBounds(20, 6, 73, 16);

        jButton3.setText("Torpedo");
        jPanelTorpedo.add(jButton3);
        jButton3.setBounds(20, 30, 80, 32);

        getContentPane().add(jPanelTorpedo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 500, 110, 70));

        jLabel13.setText("2000Kg Acero");

        jButton2.setText("Bomba");

        javax.swing.GroupLayout jPanelBombaLayout = new javax.swing.GroupLayout(jPanelBomba);
        jPanelBomba.setLayout(jPanelBombaLayout);
        jPanelBombaLayout.setHorizontalGroup(
            jPanelBombaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBombaLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanelBombaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelBombaLayout.setVerticalGroup(
            jPanelBombaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBombaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanelBomba, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 580, 110, 60));

        jLabel14.setText("1000Kg Acero");

        jButton5.setText("Multi-Shot");

        javax.swing.GroupLayout jPanelMultiShotLayout = new javax.swing.GroupLayout(jPanelMultiShot);
        jPanelMultiShot.setLayout(jPanelMultiShotLayout);
        jPanelMultiShotLayout.setHorizontalGroup(
            jPanelMultiShotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMultiShotLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanelMultiShotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanelMultiShotLayout.setVerticalGroup(
            jPanelMultiShotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMultiShotLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanelMultiShot, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 650, 110, 70));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Barcos espía");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, -1, -1));

        jButtonArmeria1.setBackground(new java.awt.Color(0, 61, 101));
        jButtonArmeria1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonArmeria1.setText("$1500");
        jButtonArmeria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArmeria1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonArmeria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 330, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEnvMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnvMensajeActionPerformed
        try {
            controlador.enviarMensaje();
        } catch (IOException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEnvMensajeActionPerformed

    private void txtFieldMensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldMensajesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldMensajesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButtonArmeria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArmeria1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonArmeria1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonArmeria1;
    private javax.swing.JButton jButtonEnvMensaje;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelBomba;
    private javax.swing.JPanel jPanelJugador;
    private javax.swing.JPanel jPanelMultiShot;
    private javax.swing.JPanel jPanelTorpedo;
    private javax.swing.JPanel jPanelTrumpedo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea txtAreaChat;
    private javax.swing.JTextField txtFieldMensajes;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnEnviarMensaje() {
        return jButtonEnvMensaje;
    }

    public void setBtnEnviarMensaje(JButton btnEnviarMensaje) {
        this.jButtonEnvMensaje = btnEnviarMensaje;
    }

    public JTextArea getTxtAreaChat() {
        return txtAreaChat;
    }

    public void setTxtAreaChat(JTextArea txtAreaChat) {
        this.txtAreaChat = txtAreaChat;
    }

    public JTextArea getTxtAreaJuego() {
        return jTextArea3;
    }

    public void setTxtAreaJuego(JTextArea txtAreaJuego) {
        this.jTextArea3 = txtAreaJuego;
    }

    public JTextField getTxtFieldMensajes() {
        return txtFieldMensajes;
    }

    public void setTxtFieldMensajes(JTextField txtFieldMensajes) {
        this.txtFieldMensajes = txtFieldMensajes;
    }
    
    public JComboBox getComboBoxArmas(){
        return this.jComboBox1;
    }



}
