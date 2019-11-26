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
    boolean activo = false;
    Controlador_Cliente controlador;
    
    ThreadProductoraAcero(Mina minaProd, Semaphore semaphore, Controlador_Cliente controladorP){
        minaProductora = minaProd;
        semaf = semaphore;
        controlador = controladorP;
        
    }
    
    
    @SuppressWarnings("SleepWhileInLoop")
    @Override
    public void run(){          
        while(true){
            while(activo){
                try {
                    //sleep(minaProductora.tiempo);  PONER CUANDO SIRVA
                    sleep(3000);
                    semaf.tryAcquire(2, TimeUnit.SECONDS);

                    int t = controlador.getCliente().jugador.getAcero();
                    t+=minaProductora.aceroGenerado;
                    System.out.println(t);
                    controlador.getCliente().jugador.setAcero(t);

                    semaf.release();
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(ThreadProductoraAcero.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
            try {
                sleep(1000);
                System.out.println("Estoy esperando a que jueguen");
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadProductoraAcero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
