
package Cliente_Servidor.Cliente;

import Cliente_Servidor.mensajeGenerico;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadCliente extends Thread{
    Cliente cliente;
    ObjectInputStream inputStream;
    boolean activo = true;
    int opcion;
    

    public ThreadCliente(Cliente cliente, ObjectInputStream inputStream) {
        this.cliente = cliente;
        this.inputStream = inputStream;
    }
    
    @Override
    public void run(){
        while(activo){
            try {
                opcion = inputStream.readInt();
                
                switch(opcion){
                    
                    case 0:
                        System.out.println("ESPERANDO JUGADORES");
                        break;
                        
                    case 1:
                        cliente.setEnemigos((ArrayList<String>) inputStream.readObject());
                        for(String enemigo: cliente.getEnemigos()) System.out.println(enemigo + ", ");
                        break;
                        
                        
                }
            } catch (IOException ex) {
                Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
} 
