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
                    sleep(300000);  
                    semaf.tryAcquire(4, TimeUnit.SECONDS);
                    controlador.getCantEscudo();
                    controlador.cargarRecursos();

                    semaf.release();
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(ThreadProductoraAcero.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
            try {
                sleep(2000);
                System.out.println("Estoy esperando a que jueguen");
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadProductoraAcero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    
    
    
}
