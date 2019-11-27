/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Controlador.Controlador_Cliente;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikom
 */
public class ThreadProductoraAcero extends Thread{
    Mina minaProductora;
    Semaphore semaf;
    int tiempo, cantPorGenerar ;
    boolean activo = false;
    Controlador_Cliente controlador;
    
    public ThreadProductoraAcero(Mina minaProd, Semaphore semaphore, Controlador_Cliente controladorP){
        minaProductora = minaProd;
        semaf = semaphore;
        controlador = controladorP;
        tiempo = minaProductora.tiempo;
        cantPorGenerar = minaProductora.aceroGenerado;
        
    }

    
    @SuppressWarnings("SleepWhileInLoop")
    @Override
    public void run(){          
        while(true){
            while(activo){
                try {
                    sleep(tiempo);  
                    semaf.tryAcquire(2, TimeUnit.SECONDS);

                    int t = controlador.getCliente().jugador.getAcero();
                    t+=this.cantPorGenerar;
                    System.out.println(t);
                    controlador.getCliente().jugador.setAcero(t);
                    controlador.cargarRecursos();

                    semaf.release();
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(ThreadProductoraAcero.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
            try {
                sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadProductoraAcero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Mina getMinaProductora() {
        return minaProductora;
    }

    public void setMinaProductora(Mina minaProductora) {
        this.minaProductora = minaProductora;
    }

    public Semaphore getSemaf() {
        return semaf;
    }

    public void setSemaf(Semaphore semaf) {
        this.semaf = semaf;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getCantPorGenerar() {
        return cantPorGenerar;
    }

    public void setCantPorGenerar(int cantPorGenerar) {
        this.cantPorGenerar = cantPorGenerar;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Controlador_Cliente getControlador() {
        return controlador;
    }

    public void setControlador(Controlador_Cliente controlador) {
        this.controlador = controlador;
    }
        
}
