/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Armas.*;
import Componentes.Componente;
import Controlador.Controlador_Cliente;
import Grafo.Vertice;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
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
        this.jPanelBomba.setVisible(false);
        this.jPanelTorpedo.setVisible(false);
        this.jPanelTrumpedo.setVisible(false);
        this.jPanelMultiShot.setVisible(false);
        this.jLabelTextoFabricar.setVisible(false);
     
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
        jPanelJugador = new javax.swing.JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                int tamanno = 30, x1,x2,y1,y2;
                super.paintComponent(g);
                for(Vertice vertice: Controlador.Controlador_Adquisicion.grafo.getVertices()){
                    for(int k = 0 ;k<vertice.getAristas().size()  ;k++){
                        Componente orig = vertice.getAristas().get(k).getOrigin().getComponente();
                        Componente dest = vertice.getAristas().get(k).getDestination().getComponente();
                        x1 = orig.getPoint().x;
                        y1 = orig.getPoint().y;
                        x2 = vertice.getAristas().get(k).getConector().getPoint().x;
                        y2 = vertice.getAristas().get(k).getConector().getPoint().y;
                        g.drawLine((x1*tamanno)+8, (y1*tamanno)+8, (x2* tamanno)+8, (y2* tamanno)+8);

                        x1 = vertice.getAristas().get(k).getConector().getPoint().x;
                        y1 = vertice.getAristas().get(k).getConector().getPoint().y;
                        x2 = dest.getPoint().x;
                        y2 = dest.getPoint().y;
                        g.drawLine((x1*tamanno)+8, (y1*tamanno)+8, (x2* tamanno)+8, (y2* tamanno)+8);
                    }
                }
            }
        };
        ;
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelDinero = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelAcero = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelTextoFabricar = new javax.swing.JLabel();
        jPanelTrumpedo = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButtonTrumpedo = new javax.swing.JButton();
        jPanelTorpedo = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jButtonTorpedo = new javax.swing.JButton();
        jPanelBomba = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButtonBomba = new javax.swing.JButton();
        jPanelMultiShot = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButtonMultiShot = new javax.swing.JButton();
        jComboBoxEnemigos = new javax.swing.JComboBox();
        jPanelEnemigo = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonBarcoEspía = new javax.swing.JButton();

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

        jLabelDinero.setText("Dinero:");
        getContentPane().add(jLabelDinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jLabel8.setText("Mis Recursos");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, -1));

        jLabelAcero.setText("Acero:");
        getContentPane().add(jLabelAcero, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, -1, -1));

        jButton1.setText("Usar Comodín");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 110, 40));

        jLabelTextoFabricar.setFont(new java.awt.Font("Segoe UI Symbol", 2, 15)); // NOI18N
        jLabelTextoFabricar.setText(" Click para fabricar");
        getContentPane().add(jLabelTextoFabricar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 130, -1));

        jLabel11.setText("5000Kg Acero");

        jButtonTrumpedo.setText("Trumpedo");
        jButtonTrumpedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTrumpedoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTrumpedoLayout = new javax.swing.GroupLayout(jPanelTrumpedo);
        jPanelTrumpedo.setLayout(jPanelTrumpedoLayout);
        jPanelTrumpedoLayout.setHorizontalGroup(
            jPanelTrumpedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrumpedoLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanelTrumpedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonTrumpedo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanelTrumpedoLayout.setVerticalGroup(
            jPanelTrumpedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrumpedoLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonTrumpedo)
                .addContainerGap())
        );

        getContentPane().add(jPanelTrumpedo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 110, 70));

        jPanelTorpedo.setLayout(null);

        jLabel15.setText("500 Kg Acero");
        jPanelTorpedo.add(jLabel15);
        jLabel15.setBounds(20, 6, 76, 16);

        jButtonTorpedo.setText("Torpedo");
        jButtonTorpedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTorpedoActionPerformed(evt);
            }
        });
        jPanelTorpedo.add(jButtonTorpedo);
        jButtonTorpedo.setBounds(20, 30, 80, 32);

        getContentPane().add(jPanelTorpedo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, 120, 70));

        jLabel13.setText("2000 Kg Acero");

        jButtonBomba.setText("Bomba");
        jButtonBomba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBombaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBombaLayout = new javax.swing.GroupLayout(jPanelBomba);
        jPanelBomba.setLayout(jPanelBombaLayout);
        jPanelBombaLayout.setHorizontalGroup(
            jPanelBombaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBombaLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanelBombaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonBomba, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap())
        );
        jPanelBombaLayout.setVerticalGroup(
            jPanelBombaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBombaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonBomba)
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanelBomba, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, 110, 60));

        jLabel14.setText("1000 Kg Acero");

        jButtonMultiShot.setText("Multi-Shot");
        jButtonMultiShot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMultiShotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMultiShotLayout = new javax.swing.GroupLayout(jPanelMultiShot);
        jPanelMultiShot.setLayout(jPanelMultiShotLayout);
        jPanelMultiShotLayout.setHorizontalGroup(
            jPanelMultiShotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMultiShotLayout.createSequentialGroup()
                .addGroup(jPanelMultiShotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMultiShotLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jButtonMultiShot))
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
                .addComponent(jButtonMultiShot)
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanelMultiShot, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 600, 100, 70));

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

        btnFinalizar.setText("Finalizar Turno");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 710, 120, -1));

        jLabel1.setText("$2500");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, -1, -1));

        jButtonBarcoEspía.setText("Barco Espía");
        jButtonBarcoEspía.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBarcoEspíaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBarcoEspía, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, -1, -1));

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
        controlador.encenderEscudo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonTrumpedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTrumpedoActionPerformed
        try {
            controlador.Trumpedo();
        } catch (InterruptedException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonTrumpedoActionPerformed

    private void jComboBoxEnemigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEnemigosActionPerformed
        try {
            //Selecciono un enemigo
            controlador.buscarOceanoEnemigo();
        } catch (IOException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxEnemigosActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        try {
            controlador.finalizarTurno();
        } catch (IOException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void jButtonTorpedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTorpedoActionPerformed
        try {
            controlador.Torpedo();
        } catch (InterruptedException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonTorpedoActionPerformed

    private void jButtonBombaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBombaActionPerformed
        try {
            controlador.Bomba();
        } catch (InterruptedException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonBombaActionPerformed

    private void jButtonMultiShotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMultiShotActionPerformed
        try {
            controlador.MultiShot();
        } catch (InterruptedException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonMultiShotActionPerformed

    private void jButtonBarcoEspíaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBarcoEspíaActionPerformed
        try {
            controlador.Barco();        // TODO add your handling code here:
        } catch (InterruptedException ex) {
            Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonBarcoEspíaActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBarcoEspía;
    private javax.swing.JButton jButtonBomba;
    private javax.swing.JButton jButtonEnvMensaje;
    private javax.swing.JButton jButtonMultiShot;
    private javax.swing.JButton jButtonTorpedo;
    private javax.swing.JButton jButtonTrumpedo;
    private javax.swing.JComboBox jComboBoxEnemigos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAcero;
    private javax.swing.JLabel jLabelDinero;
    private javax.swing.JLabel jLabelTextoFabricar;
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

    public void setjButtonEnvMensaje(JButton jButtonEnvMensaje) {
        this.jButtonEnvMensaje = jButtonEnvMensaje;
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

    public Controlador_Cliente getControlador() {
        return controlador;
    }

    public void setControlador(Controlador_Cliente controlador) {
        this.controlador = controlador;
    }

    public JLabel getjLabelAcero() {
        return jLabelAcero;
    }

    public void setjLabelAcero(JLabel jLabelAcero) {
        this.jLabelAcero = jLabelAcero;
    }

    public JLabel getjLabelDinero() {
        return jLabelDinero;
    }

    public void setjLabelDinero(JLabel jLabelDinero) {
        this.jLabelDinero = jLabelDinero;
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

    public JLabel getjLabelTextoFabricar() {
        return jLabelTextoFabricar;
    }

    public void setjLabelTextoFabricar(JLabel jLabelTextoFabricar) {
        this.jLabelTextoFabricar = jLabelTextoFabricar;
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
