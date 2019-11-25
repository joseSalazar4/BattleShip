/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Controlador.Controlador_Cliente;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikom
 */
public class ThreadProductoraAcero extends Thread{
    Mina minaProductora;
    Semaphore semaf;
    boolean activo = true;
    Controlador_Cliente controlador;
    
    ThreadProductoraAcero(Mina minaProd, Semaphore semaphore, Controlador_Cliente controladorP){
        minaProductora = minaProd;
        semaf = semaphore;
        controlador = controladorP;
        
    }
    
     @Override
    @SuppressWarnings("SleepWhileInLoop")
     
    public void run(){                
        while(activo){
            try {
                sleep(minaProductora.tiempo); 
                
                semaf.acquire();
                
                int t = controlador.getCliente().jugador.getAcero();
                t+=minaProductora.aceroGenerado;
                controlador.getCliente().jugador.setAcero(t);
                
                semaf.release();
            }
            catch (InterruptedException ex) {
                Logger.getLogger(ThreadProductoraAcero.class.getName()).log(Level.SEVERE, null, ex);
            }   
            
        }
    }
}
