
package Cliente_Servidor.Cliente;

import Cliente_Servidor.mensajeGenerico;
import java.io.*;
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
                        
                    case 1: //Inicia el Juego y Recibe un Array con los nicknames de los enemigos
                        cliente.jugador.setEnemigos((ArrayList<String>) inputStream.readObject());
                        for(String enemigo: cliente.jugador.getEnemigos()) System.out.println(enemigo + ", ");
                        cliente.controlador.inciarAdquisicion();
                        break;
                    case 2: //Recibe un mensaje del chat
                        mensajeGenerico mensaje = (mensajeGenerico) inputStream.readObject();
                        cliente.controlador.recibirMensaje(mensaje);
                        break;
                        
                    case 3: //Recibe un mensaje del juego
                        String mensajeJuego = (String) inputStream.readUTF();
                        cliente.controlador.recibirMensajeJuego(mensajeJuego);
                        break;
                    case 4: 
                        //cliente.controlador; pregunt
                        cliente.controlador.setTodosListos(true);
                        break;
                    case 5: //Comienza el turno de este Jugador
                        cliente.controlador.empezarTurno();
                        break;
                    case 6:
                        cliente.controlador.reanudarPantallaAdquisicion();
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
