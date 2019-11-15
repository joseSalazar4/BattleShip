
package Cliente_Servidor.Servidor;

import Vista.GUIServidor;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Thread{
    private ServerSocket socketServidor = null;
    private ArrayList<ThreadServidor> clientes;
    private GUIServidor pantalla;
    private int PORT;
    private boolean encendido = true;
    private int numeroClientes;
    
    public Servidor(int PORT, GUIServidor pantalla){
        clientes = new ArrayList<>();
        this.PORT = PORT;
        this.pantalla = pantalla;
        this.pantalla.show();
    }
    
    @Override
    public void run(){
        iniciarServidor(this.numeroClientes);
    }
        
    //Param: numero Clientes 
    public void iniciarServidor(int numeroClientes){
        try {
            this.socketServidor = new ServerSocket(PORT);
            System.out.println("ENTRO A INCIAR SERVIDOR");
            this.pantalla.addStatus("----Iniciando servidor----");
            this.pantalla.addStatus("Esperando usuarios... ");
            int numeroCliente = 1; 

            while(numeroCliente <= numeroClientes){
                Socket socketCliente = socketServidor.accept();
                ThreadServidor thread = new ThreadServidor(socketCliente, numeroCliente, this, this.pantalla);
                clientes.add(thread);
                thread.start();
                this.pantalla.addStatus(".::Cliente #" + String.valueOf(numeroCliente)+"  IP: " + socketCliente.getInetAddress().getHostAddress());
                numeroCliente++;
            }
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.pantalla.addStatus("Jugadores Completos");
            this.pantalla.addStatus("Empezando partida...");
            
            for(ThreadServidor thread: clientes) thread.enviarEnemigos();

            //Hacemos el primer handShake de todos los clientes


        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            this.pantalla.addStatus("Error en el servidor: " + ex);
        }
                
    }
   
    
    //Getter & Setter

    public ServerSocket getSocketServidor() {
        return socketServidor;
    }

    public void setSocketServidor(ServerSocket socketServidor) {
        this.socketServidor = socketServidor;
    }

    public ArrayList<ThreadServidor> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<ThreadServidor> clientes) {
        this.clientes = clientes;
    }

    public GUIServidor getPantalla() {
        return pantalla;
    }

    public void setPantalla(GUIServidor pantalla) {
        this.pantalla = pantalla;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public int getNumeroClientes() {
        return numeroClientes;
    }

    public void setNumeroClientes(int numeroClientes) {
        this.numeroClientes = numeroClientes;
    }
    
    
    
}