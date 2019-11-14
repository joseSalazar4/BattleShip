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
    }
    
    public void run(){
        try {
            this.cliente.setInputStream(new ObjectInputStream(this.cliente.getSocketCliente().getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(!isReady){
            try {
                int opcion = (Integer)cliente.getInputStream().readInt();
                if(opcion == 1){
                    //mensajeGenerico mensaje = null;
                    String holi = (String) cliente.getInputStream().readUTF();
                    //cliente.setEnemigos(mensaje.getContenido());
                    //this.isReady = mensaje.isIs();
                    isReady = true;
                    //for(String nickEnemigo: cliente.getEnemigos()) System.out.println("Enemigo: " + nickEnemigo);
                    System.out.println(holi);
                }
                
            } catch (IOException ex) {
                    Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        //Todos los jugadores estan conectados y empieza el juego
                   
          
          
          while(true){
          
            
        }
    }
}
