/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_Adquisicion;
import Controlador.PosicionarComponente;
import Componentes.ItemCompra;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIAdquisicion extends javax.swing.JFrame {

    Controlador_Adquisicion controlador;
    int TAMANNO = 30;
    
    public JLabel [][] matrizLabels = new JLabel [20][20];
    public PosicionarComponente [][] pcs = new PosicionarComponente[20][20];
    
    public GUIAdquisicion(Controlador_Adquisicion controlador) {
        initComponents();
        this.controlador=controlador;  
        rellenarMatriz();       
        jLabelCarga.setVisible(false);  
        jLabelInstruccionColocado.setVisible(false);
    }    
    
private void rellenarMatriz(){
        for(int i = 0; i<20 ;i++){
            for(int j = 0; j<20 ;j++){
                JLabel labelNuevo = new JLabel();
                labelNuevo.setOpaque(false);
                PosicionarComponente pc = new PosicionarComponente(labelNuevo, matrizLabels, i, j, controlador);
                labelNuevo.setSize(TAMANNO, TAMANNO);
                labelNuevo.setLocation(j*TAMANNO, i*TAMANNO);
                matrizLabels[i][j] = labelNuevo;
                pcs[i][j] = pc;
                jPanelJugador.add(labelNuevo);
            }
        }
    }



    private GUIAdquisicion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        jButtonMina = new javax.swing.JButton();
        jButtonTemplo = new javax.swing.JButton();
        jButtonArmeria = new javax.swing.JButton();
        jButtonConector = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButtonMercado = new javax.swing.JButton();
        jButtonFuente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabelInstruccionColocado = new javax.swing.JLabel();
        btnConectar = new javax.swing.JButton();
        jPanelJugador = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabelCantMercado = new javax.swing.JLabel();
        jLabelCantFuentePoder = new javax.swing.JLabel();
        jLabelCantArmeria = new javax.swing.JLabel();
        jLabelCantConectores = new javax.swing.JLabel();
        jLabelCantMina = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelCantTemplos = new javax.swing.JLabel();
        lblnickName1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        lblDinero = new javax.swing.JLabel();
        lblnickName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelCarga = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelCantMina1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 51));
        setMinimumSize(new java.awt.Dimension(1000, 720));
        setSize(new java.awt.Dimension(1000, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 61, 101));

        jButtonMina.setBackground(new java.awt.Color(0, 61, 101));
        jButtonMina.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMina.setText("$1000");
        jButtonMina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinaActionPerformed(evt);
            }
        });

        jButtonTemplo.setBackground(new java.awt.Color(0, 61, 101));
        jButtonTemplo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonTemplo.setText("$2500");
        jButtonTemplo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTemploActionPerformed(evt);
            }
        });

        jButtonArmeria.setBackground(new java.awt.Color(0, 61, 101));
        jButtonArmeria.setForeground(new java.awt.Color(255, 255, 255));
        jButtonArmeria.setText("$1500");
        jButtonArmeria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArmeriaActionPerformed(evt);
            }
        });

        jButtonConector.setBackground(new java.awt.Color(0, 61, 101));
        jButtonConector.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConector.setText("$100");
        jButtonConector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConectorActionPerformed(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(204, 0, 51));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nivel 1", "Nivel 2", "Nivel 3", "Nivel 4", "Nivel5" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(204, 0, 51));
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Torpedo", "Multi-Shot", "Bomba", "Trumpedo" }));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 2, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Compras antes del juego:");

        jButtonMercado.setBackground(new java.awt.Color(0, 61, 101));
        jButtonMercado.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMercado.setText("$2000");
        jButtonMercado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMercadoActionPerformed(evt);
            }
        });

        jButtonFuente.setBackground(new java.awt.Color(0, 61, 101));
        jButtonFuente.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFuente.setText("$12000");
        jButtonFuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFuenteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 2, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Posición:");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Armeria");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Mina");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Fuente Poder");

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Conectores");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Templos");

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Mercados");

        jComboBox3.setBackground(new java.awt.Color(204, 0, 51));
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Horizontal", "Vertical" }));

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Nivel");

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Tipo Armeria");

        jLabelInstruccionColocado.setFont(new java.awt.Font("Georgia", 2, 20)); // NOI18N
        jLabelInstruccionColocado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInstruccionColocado.setText("Ubique el elemento comprado!");

        btnConectar.setText("Conectar :3");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21))
                        .addGap(30, 44, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jButtonTemplo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonMercado, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonMina, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonArmeria, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jComboBox2, 0, 127, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonFuente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonConector, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel20)
                            .addComponent(jLabel17)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelInstruccionColocado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btnConectar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTemplo)
                    .addComponent(jButtonConector))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMercado)
                    .addComponent(jButtonFuente))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMina)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonArmeria)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConectar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInstruccionColocado))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 290, 410));

        jPanelJugador.setBackground(new java.awt.Color(0, 102, 255));
        jPanelJugador.setForeground(new java.awt.Color(1, 1, 1));
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

        getContentPane().add(jPanelJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 600, 600));

        jLabel10.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Adquisiciones");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 170, -1));

        jLabelCantMercado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantMercado.setText("Mercados: 0");
        getContentPane().add(jLabelCantMercado, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, -1, -1));

        jLabelCantFuentePoder.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantFuentePoder.setText("Fuente Poder: 0");
        getContentPane().add(jLabelCantFuentePoder, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, -1, -1));

        jLabelCantArmeria.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantArmeria.setText("Armeria: 0");
        getContentPane().add(jLabelCantArmeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, -1, -1));

        jLabelCantConectores.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantConectores.setText("Conectores: 0");
        getContentPane().add(jLabelCantConectores, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, -1, -1));

        jLabelCantMina.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantMina.setText("Mina: 0");
        getContentPane().add(jLabelCantMina, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/ocean2.PNG"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setMaximumSize(new java.awt.Dimension(600, 600));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 600, 600));

        jLabelCantTemplos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantTemplos.setText("Templos: 0");
        getContentPane().add(jLabelCantTemplos, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, -1, -1));

        lblnickName1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        getContentPane().add(lblnickName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 670, 50, 20));

        jButton7.setBackground(new java.awt.Color(0, 61, 101));
        jButton7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Iniciar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 640, 120, -1));

        lblDinero.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDinero.setForeground(new java.awt.Color(255, 255, 255));
        lblDinero.setText("Dinero: ");
        getContentPane().add(lblDinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, -1, -1));

        lblnickName.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblnickName.setForeground(new java.awt.Color(255, 255, 255));
        lblnickName.setText("nickName");
        getContentPane().add(lblnickName, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Previsualización de su Océano ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabelCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/ezgif.com-resize.gif"))); // NOI18N
        getContentPane().add(jLabelCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 630, -1, 90));

        jLabel6.setBackground(new java.awt.Color(0, 61, 101));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 730));

        jLabelCantMina1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantMina1.setText("Mina: 0");
        getContentPane().add(jLabelCantMina1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonConectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConectorActionPerformed
        
        controlador.ejecutarCompra(100, ItemCompra.CONECTOR, jComboBox3.getSelectedIndex()==1);
    }//GEN-LAST:event_jButtonConectorActionPerformed

    private void jButtonMinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinaActionPerformed
  
        controlador.ejecutarCompra(1000, ItemCompra.MINA, jComboBox3.getSelectedIndex()==1);
    }//GEN-LAST:event_jButtonMinaActionPerformed

    private void jButtonTemploActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTemploActionPerformed
        controlador.ejecutarCompra(2500, ItemCompra.TEMPLO, jComboBox3.getSelectedIndex()==1);
    }//GEN-LAST:event_jButtonTemploActionPerformed

    private void jButtonArmeriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArmeriaActionPerformed
        controlador.ejecutarCompra(1500, ItemCompra.ARMERIA, jComboBox3.getSelectedIndex()==1);
    }//GEN-LAST:event_jButtonArmeriaActionPerformed

    private void jButtonMercadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMercadoActionPerformed
        controlador.ejecutarCompra(2000, ItemCompra.MERCADO, jComboBox3.getSelectedIndex()==1);    
    }//GEN-LAST:event_jButtonMercadoActionPerformed

    private void jButtonFuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFuenteActionPerformed
        controlador.ejecutarCompra(2000, ItemCompra.FUENTEDEENERGIA, jComboBox3.getSelectedIndex()==1);      
    }//GEN-LAST:event_jButtonFuenteActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            controlador.iniciarPartida();        // TODO add your handling code here:
        } catch (InterruptedException ex) {
            Logger.getLogger(GUIAdquisicion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        controlador.setIsConectar();
    }//GEN-LAST:event_btnConectarActionPerformed

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
            java.util.logging.Logger.getLogger(GUIAdquisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIAdquisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIAdquisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIAdquisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIAdquisicion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonArmeria;
    private javax.swing.JButton jButtonConector;
    private javax.swing.JButton jButtonFuente;
    private javax.swing.JButton jButtonMercado;
    private javax.swing.JButton jButtonMina;
    private javax.swing.JButton jButtonTemplo;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCantArmeria;
    private javax.swing.JLabel jLabelCantConectores;
    private javax.swing.JLabel jLabelCantFuentePoder;
    private javax.swing.JLabel jLabelCantMercado;
    private javax.swing.JLabel jLabelCantMina;
    private javax.swing.JLabel jLabelCantMina1;
    private javax.swing.JLabel jLabelCantTemplos;
    private javax.swing.JLabel jLabelCarga;
    private javax.swing.JLabel jLabelInstruccionColocado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelJugador;
    private javax.swing.JLabel lblDinero;
    private javax.swing.JLabel lblnickName;
    private javax.swing.JLabel lblnickName1;
    // End of variables declaration//GEN-END:variables

    public JLabel getLblDinero() {
        return lblDinero;
    }

    public void setLblDinero(JLabel lblDinero) {
        this.lblDinero = lblDinero;
    }

    public JLabel getLblnickName() {
        return lblnickName;
    }

    public void setLblnickName(JLabel lblnickName) {
        this.lblnickName = lblnickName;
    }

    
    public JComboBox getComboBoxMina(){
        return this.jComboBox1;
    }
    
    public void setComboBoxMina(JComboBox comboBoxMina){
        this.jComboBox1 = comboBoxMina;
    }
    
    public JComboBox getComboBoxArmeria(){
        return this.jComboBox2;
    }
    
    public void setComboBoxArmeria(JComboBox comboBoxArmeria){
        this.jComboBox2 = comboBoxArmeria;
    }

    public JComboBox getComboBoxPos(){
        return this.jComboBox3;
    } 
    
    public JLabel getLabelInstruccion(){
        return this.jLabelInstruccionColocado;
    }
    
    public void setLabelInstruccion(JLabel nuevaInstr){
        this.jLabelInstruccionColocado = nuevaInstr;
    }
    
    public JButton getButtonArmeria(){
        return this.jButtonArmeria;
    }
    
    public void setButtonArmeria(JButton botonNuevo){
        this.jButtonArmeria = botonNuevo;
    }
    
    public JButton getButtonTemplo(){
        return this.jButtonArmeria;
    }
    
    public void setButtonTemplo(JButton botonNuevo){
        this.jButtonTemplo = botonNuevo;
    }
    
    public JButton getButtonMina(){
        return this.jButtonMina;
    }
    
    public void setButtonMina(JButton botonNuevo){
        this.jButtonMina = botonNuevo;
    }
    
    public JButton getButtonMercado(){
        return this.jButtonMercado;
    }
    
    public void setButtonMercado(JButton botonNuevo){
        this.jButtonMercado = botonNuevo;
    }
    public JButton getButtonFuente(){
        return this.jButtonFuente;
    }
    
    public void setButtonFuente(JButton botonNuevo){
        this.jButtonFuente = botonNuevo;
    }
    public JButton getButtonConector(){
        return this.jButtonConector;
    }
    
    public void setButtonConector(JButton botonNuevo){
        this.jButtonConector = botonNuevo;
    }
    
    public JPanel getPanelJugador(){
        return this.jPanelJugador;
    }

    public JLabel getjLabelCantArmeria() {
        return jLabelCantArmeria;
    }

    public JLabel getjLabelCantConectores() {
        return jLabelCantConectores;
    }

    public JLabel getjLabelCantFuentePoder() {
        return jLabelCantFuentePoder;
    }

    public JLabel getjLabelCantMercado() {
        return jLabelCantMercado;
    }

    public JLabel getjLabelCantMina() {
        return jLabelCantMina;
    }

    public JLabel getjLabelCantMina1() {
        return jLabelCantMina1;
    }

    public JLabel getjLabelCantTemplos() {
        return jLabelCantTemplos;
    }

    public JLabel getjLabelInstruccionColocado() {
        return jLabelInstruccionColocado;
    }
    
    public JLabel [][] getMatrizLabel(){
        return this.matrizLabels;   
    }
    
    public JLabel getjLabelCarga(){
        return this.jLabelCarga;
    }

    public JButton getBtnConectar() {
        return btnConectar;
    }

    public void setBtnConectar(JButton btnConectar) {
        this.btnConectar = btnConectar;
    }

    public int getTAMANNO() {
        return TAMANNO;
    }

    public void setTAMANNO(int TAMANNO) {
        this.TAMANNO = TAMANNO;
    }

    public JPanel getjPanelJugador() {
        return jPanelJugador;
    }

    public void setjPanelJugador(JPanel jPanelJugador) {
        this.jPanelJugador = jPanelJugador;
    }
    
    
    
}
