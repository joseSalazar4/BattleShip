/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author mikom
 */
public class ConexionesGraficas extends JPanel{
    @Override
    public void paintComponent(Graphics g) {
           super.paintComponent(g);    //a
           g.setColor(Color.BLACK);                   
           g.drawLine(0,0,300,300);
       }
};
