/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import static Componentes.Componente.tipoComponente.Mina;



public class Mina extends Componente {
    int aceroGenerado,aceroTotal, tiempo;
    private ThreadProductoraAcero threadProductor = null;
    
    
    public Mina(int nivelSeleccionado){
        tipoComponente = Mina;
        nombre = "Mina";
        aceroTotal = 0;        
        this.is1x1 = false;
        this.imagen=new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/Mina.png"));
        switch(nivelSeleccionado){
            case 1:
                costo = 1000;
                aceroGenerado = 50;
                tiempo = 60;
                break;
            case 2:
                costo = 1700;
                aceroGenerado = 120;
                tiempo = 50;
                break;
            case 3:
                costo  = 2700;
                aceroGenerado = 180;
                tiempo = 450;
                break;
            case 4:
                costo = 3200;
                aceroGenerado = 210;
                tiempo = 40;
                break;
            case 5:    
                costo = 4800;
                aceroGenerado = 260;
                tiempo = 35;
                break;
        }
        
    }

}
