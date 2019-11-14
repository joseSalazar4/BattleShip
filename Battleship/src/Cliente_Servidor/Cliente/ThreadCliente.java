/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Servidor.Cliente;

import Cliente_Servidor.mensajeGenerico;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Personal
 */
public class ThreadCliente extends Thread{
    Cliente cliente;
    boolean isReady = false;

    public ThreadCliente(Cliente cliente) {
        this.cliente = cliente;
        try {
            this.cliente.setInputStream(new ObjectInputStream(this.cliente.getSocketCliente().getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run(){
        while(!isReady){    
            try {
                mensajeGenerico mensaje = null;
                try {
                    mensaje = (mensajeGenerico) cliente.getInputStream().readObject();
                } catch (IOException ex) {
                    Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                cliente.setEnemigos(mensaje.getContenido());
                this.isReady = mensaje.isIs();
                
                for(String nickEnemigo: cliente.getEnemigos()) System.out.println("Enemigo: " + nickEnemigo);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        }
          //Todos los jugadores estan conectados y empieza el juego
                   
          
          
          while(true){
          
            
        }
    }
    
    
    
}
