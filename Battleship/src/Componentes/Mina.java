/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import static Componentes.Componente.tipoComponente.Mina;



public class Mina extends Componente {
    int aceroGenerado,aceroTotal, tiempo;
    //private ThreadProductoraAcero threadProductor = null;
    
    
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
                tiempo = 60000;
                break;
            case 2:
                costo = 1700;
                aceroGenerado = 120;
                tiempo = 50000;
                break;
            case 3:
                costo  = 2700;
                aceroGenerado = 180;
                tiempo = 45000;
                break;
            case 4:
                costo = 3200;
                aceroGenerado = 210;
                tiempo = 40000;
                break;
            case 5:    
                costo = 3900;
                aceroGenerado = 260;
                tiempo = 30000;
                break;
        }
        
    }

    public int getAceroGenerado() {
        return aceroGenerado;
    }

    public void setAceroGenerado(int aceroGenerado) {
        this.aceroGenerado = aceroGenerado;
    }

    public int getAceroTotal() {
        return aceroTotal;
    }

    public void setAceroTotal(int aceroTotal) {
        this.aceroTotal = aceroTotal;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

//    public ThreadProductoraAcero getThreadProductor() {
//        return threadProductor;
//    }
//
//    public void setThreadProductor(ThreadProductoraAcero threadProductor) {
//        this.threadProductor = threadProductor;
//    }

}
