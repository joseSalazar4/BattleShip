/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JLabel;
import battleship.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author mikom
 */
public class GUICliente extends javax.swing.JFrame {

    JLabel [][] matrizLabels = new JLabel [20][20];
    Componente [][] matrizLogica;
    Controlador.Controlador_Cliente controlador;
   // public GUICliente(Componente [][] _matrizLogica, Controlador.Controlador_Cliente controlador) {
    public GUICliente(Controlador.Controlador_Cliente controlador){
        initComponents();
        this.controlador = controlador;
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
        txtAreaJuego = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnEnviarMensaje = new javax.swing.JButton();
        txtFieldMensajes = new javax.swing.JTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanelJugador = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAreaChat.setEditable(false);
        txtAreaChat.setColumns(20);
        txtAreaChat.setRows(5);
        jScrollPane2.setViewportView(txtAreaChat);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 634, 600, 63));

        txtAreaJuego.setEditable(false);
        txtAreaJuego.setColumns(20);
        txtAreaJuego.setRows(5);
        jScrollPane3.setViewportView(txtAreaJuego);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 639, 600, 96));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel2.setText("Enemigos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, -1, 20));

        btnEnviarMensaje.setText("Enviar mensaje");
        btnEnviarMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarMensajeActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviarMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 703, 130, 41));

        txtFieldMensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldMensajesActionPerformed(evt);
            }
        });
        getContentPane().add(txtFieldMensajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 703, 465, 41));

        jTabbedPane2.setPreferredSize(new java.awt.Dimension(600, 600));
        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 25, -1, 610));

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

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel3.setText("Mi Oceano");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/oceanEnemigo.PNG"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 28, 600, 604));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarMensajeActionPerformed
        try {
            controlador.enviarMensaje();
        } catch (IOException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEnviarMensajeActionPerformed

    private void txtFieldMensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldMensajesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldMensajesActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarMensaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelJugador;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea txtAreaChat;
    private javax.swing.JTextArea txtAreaJuego;
    private javax.swing.JTextField txtFieldMensajes;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnEnviarMensaje() {
        return btnEnviarMensaje;
    }

    public void setBtnEnviarMensaje(JButton btnEnviarMensaje) {
        this.btnEnviarMensaje = btnEnviarMensaje;
    }

    public JTextArea getTxtAreaChat() {
        return txtAreaChat;
    }

    public void setTxtAreaChat(JTextArea txtAreaChat) {
        this.txtAreaChat = txtAreaChat;
    }

    public JTextArea getTxtAreaJuego() {
        return txtAreaJuego;
    }

    public void setTxtAreaJuego(JTextArea txtAreaJuego) {
        this.txtAreaJuego = txtAreaJuego;
    }

    public JTextField getTxtFieldMensajes() {
        return txtFieldMensajes;
    }

    public void setTxtFieldMensajes(JTextField txtFieldMensajes) {
        this.txtFieldMensajes = txtFieldMensajes;
    }




}
