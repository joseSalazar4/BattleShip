/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author mikom
 */
public class ConexionesGraficas extends JPanel{

    private BufferedImage img = null;  // ADD THIS LINE
    
    private void initialize() {
        JPanel lblpicture = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img,0,0,null);
                g.setColor(Color.cyan);
                g.drawLine(0, 0, 25, 25);
            }
        };
    }
//    public void mouseClicked(MouseEvent e) {
//        lblpicture.repaint();
//    }
//    public void actionPerformed(ActionEvent e) {
//        lblpicture.repaint();
//    }
}