/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Controlador.Controlador_Cliente;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikom
 */
public class ThreadComodin extends Thread {
    Semaphore semaf;
    boolean activo = false;
    Controlador_Cliente controlador;
    
    public ThreadComodin(Semaphore semaphore, Controlador_Cliente controladorP){
        
        semaf = semaphore;
        controlador = controladorP;
    }
    
        @SuppressWarnings("SleepWhileInLoop")
    @Override
    public void run(){          
        while(true){
            while(activo){
                try {
                    int m = 0;
                    for(int i=0;i<6;i++) m = (int) (Math.random() * 4) + 2;
        
                    semaf.tryAcquire(4, TimeUnit.SECONDS);
                    
                    controlador.setCantEscudo(m);
                    controlador.setEscudoAct(true);
                    
                    semaf.release();
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(ThreadProductoraAcero.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
            try {

                sleep(300000);  
                activo = true;
                System.out.println("Pasaron los 5 mins tenemos COMODIN");
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadProductoraAcero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    
}
