/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Componentes.Componente;
import javax.swing.JLabel;
import battleship.*;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
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
        X1 = Y1 = 0;
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
        jCheckBoxComprar = new javax.swing.JCheckBox();
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
        jComboBoxEnemigos = new javax.swing.JComboBox();
        jPanelEnemigo = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1290, 800));
        setSize(new java.awt.Dimension(1290, 800));
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

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 650, 600, 96));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel2.setText("Enemigo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, -1, 30));

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
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 600, 600));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel3.setText("Mi Oceano");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 260, -1, -1));

        jLabel6.setText("Dinero:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jLabel8.setText("Mis Recursos");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, -1));

        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 100, -1));

        jLabel9.setText("Acero:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, -1, -1));

        jButton1.setText("Usar Arma!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 100, 40));

        jLabel12.setText("Armas Compradas");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, -1, -1));

        jLabel10.setText("Click para fabricar!");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, -1, -1));

        jCheckBoxComprar.setText("Comprar");
        jCheckBoxComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxComprarActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 690, -1, -1));

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
                .addGap(2, 2, 2)
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

        getContentPane().add(jPanelTrumpedo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 110, 70));

        jPanelTorpedo.setLayout(null);

        jLabel15.setText("500 Kg Acero");
        jPanelTorpedo.add(jLabel15);
        jLabel15.setBounds(20, 6, 76, 16);

        jButton3.setText("Torpedo");
        jPanelTorpedo.add(jButton3);
        jButton3.setBounds(20, 30, 80, 32);

        getContentPane().add(jPanelTorpedo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 120, 70));

        jLabel13.setText("2000 Kg Acero");

        jButton2.setText("Bomba");

        javax.swing.GroupLayout jPanelBombaLayout = new javax.swing.GroupLayout(jPanelBomba);
        jPanelBomba.setLayout(jPanelBombaLayout);
        jPanelBombaLayout.setHorizontalGroup(
            jPanelBombaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBombaLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanelBombaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap())
        );
        jPanelBombaLayout.setVerticalGroup(
            jPanelBombaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBombaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanelBomba, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 530, 110, 60));

        jLabel14.setText("1000 Kg Acero");

        jButton5.setText("Multi-Shot");

        javax.swing.GroupLayout jPanelMultiShotLayout = new javax.swing.GroupLayout(jPanelMultiShot);
        jPanelMultiShot.setLayout(jPanelMultiShotLayout);
        jPanelMultiShotLayout.setHorizontalGroup(
            jPanelMultiShotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMultiShotLayout.createSequentialGroup()
                .addGroup(jPanelMultiShotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMultiShotLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jButton5))
                    .addGroup(jPanelMultiShotLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelMultiShotLayout.setVerticalGroup(
            jPanelMultiShotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMultiShotLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanelMultiShot, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 600, 110, 70));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Barcos espía");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, -1, -1));

        jButtonArmeria1.setBackground(new java.awt.Color(0, 61, 101));
        jButtonArmeria1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonArmeria1.setText("$1500");
        jButtonArmeria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArmeria1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonArmeria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, -1, -1));

        jComboBoxEnemigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEnemigosActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxEnemigos, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 240, 30));

        jPanelEnemigo.setBackground(new java.awt.Color(255, 102, 102));
        jPanelEnemigo.setOpaque(false);
        jPanelEnemigo.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout jPanelEnemigoLayout = new javax.swing.GroupLayout(jPanelEnemigo);
        jPanelEnemigo.setLayout(jPanelEnemigoLayout);
        jPanelEnemigoLayout.setHorizontalGroup(
            jPanelEnemigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanelEnemigoLayout.setVerticalGroup(
            jPanelEnemigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelEnemigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 600, 600));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/oceanEnemigo.PNG"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 600, 600));

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

    private void jCheckBoxComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxComprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxComprarActionPerformed

    private void jButtonArmeria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArmeria1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonArmeria1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBoxEnemigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEnemigosActionPerformed
        try {
            //Selecciono un enemigo
            controlador.buscarOceanoEnemigo();
        } catch (IOException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxEnemigosActionPerformed

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
    private javax.swing.JCheckBox jCheckBoxComprar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBoxEnemigos;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelBomba;
    private javax.swing.JPanel jPanelEnemigo;
    private javax.swing.JPanel jPanelJugador;
    private javax.swing.JPanel jPanelMultiShot;
    private javax.swing.JPanel jPanelTorpedo;
    private javax.swing.JPanel jPanelTrumpedo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
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

    public JButton getjButtonArmeria1() {
        return jButtonArmeria1;
    }

    public void setjButtonArmeria1(JButton jButtonArmeria1) {
        this.jButtonArmeria1 = jButtonArmeria1;
    }

    public JButton getjButtonEnvMensaje() {
        return jButtonEnvMensaje;
    }

    public void setjButtonEnvMensaje(JButton jButtonEnvMensaje) {
        this.jButtonEnvMensaje = jButtonEnvMensaje;
    }

    public JCheckBox getjCheckBoxComprar() {
        return jCheckBoxComprar;
    }

    public void setjCheckBoxComprar(JCheckBox jCheckBoxComprar) {
        this.jCheckBoxComprar = jCheckBoxComprar;
    }

    public JComboBox getjComboBoxEnemigos() {
        return jComboBoxEnemigos;
    }

    public void setjComboBoxEnemigos(JComboBox jComboBoxEnemigos) {
        this.jComboBoxEnemigos = jComboBoxEnemigos;
    }

    public JPanel getjPanelBomba() {
        return jPanelBomba;
    }

    public void setjPanelBomba(JPanel jPanelBomba) {
        this.jPanelBomba = jPanelBomba;
    }

    public JPanel getjPanelEnemigo() {
        return jPanelEnemigo;
    }

    public void setjPanelEnemigo(JPanel jPanelEnemigo) {
        this.jPanelEnemigo = jPanelEnemigo;
    }

    public JPanel getjPanelMultiShot() {
        return jPanelMultiShot;
    }

    public JPanel getjPanelJugador() {
        return jPanelJugador;
    }

    public void setjPanelJugador(JPanel jPanelJugador) {
        this.jPanelJugador = jPanelJugador;
    }

    public JPanel getjPanelTorpedo() {
        return jPanelTorpedo;
    }

    public void setjPanelTorpedo(JPanel jPanelTorpedo) {
        this.jPanelTorpedo = jPanelTorpedo;
    }

    public JPanel getjPanelTrumpedo() {
        return jPanelTrumpedo;
    }

    public void setjPanelTrumpedo(JPanel jPanelTrumpedo) {
        this.jPanelTrumpedo = jPanelTrumpedo;
    }



}
