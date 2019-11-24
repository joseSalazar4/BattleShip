/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javafx.scene.paint.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mikom
 */
public class DibujoLinea {
    private JFrame GUI;
    private JPanel panel;
    public int border = 1;
    public Color color = Color.BLUEVIOLET;
    
    
    
    public DibujoLinea(JFrame form){
        GUI = form;
    }
    public void DrawLine(int x1, int y1, int  x2, int y2){
        panel = new JPanel(){
        @Override
        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(border));
            g2.setColor(java.awt.Color.red); 
            g2.drawLine(x1, y1, x2, y2);
        }
    };
        GUI.add(panel);
        panel.setBounds(3, 4, 400, 900);
        
    }
}
