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
    DataInputStream inputStream;
    boolean isReady = false;

    public ThreadCliente(Cliente cliente, DataInputStream inputStream) {
        this.cliente = cliente;
        this.inputStream = inputStream;
    }
    
    public void run(){
        /*
        int firstHandShake;
          while(!isReady){
              try {
                  System.out.println("CLIENTE RUN");
                  firstHandShake = inputStream.readInt();
                  if(firstHandShake == 1){
                      try {
                          mensajeGenerico mensaje = (mensajeGenerico) inputStream.readObject();
                          cliente.setEnemigos(mensaje.getContenido());
                          this.isReady = mensaje.isIs();
                          
                      } catch (ClassNotFoundException ex) {
                          Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
              } catch (IOException ex) {
                  Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
              }
              
          }*/
          
          //Todos los jugadores estan conectados y empieza el juego
          
          while(true){
          
            
        }
    }
    
    
    
}
