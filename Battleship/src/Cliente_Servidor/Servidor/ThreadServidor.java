/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Servidor.Servidor;
import Cliente_Servidor.mensajeGenerico;
import Vista.GUIServidor;
import java.io.*;

import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Personal
 */
public class ThreadServidor extends Thread{
    Servidor servidor; //
    Socket cliente; 
    int numeroCliente;
    String nickName = "";
    String ip;
    GUIServidor pantalla;
    boolean activo = true, estoyListo= false;
    int opcion;
    
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream; 

    public ThreadServidor(Socket cliente, int numeroCliente, Servidor servidor, GUIServidor pantalla) {
        this.numeroCliente = numeroCliente;
        this.cliente = cliente;
        this.servidor = servidor;
        this.ip = cliente.getInetAddress().getHostAddress();  
        this.pantalla = pantalla;
        
    }
    
    @Override
    public void run(){                
        try {
            inputStream = new ObjectInputStream(cliente.getInputStream());
            outputStream = new ObjectOutputStream(cliente.getOutputStream());
            
            String nick = (String) inputStream.readObject();
            setNickName(nick);
            pantalla.addStatus(".::" + ip + " = " + nickName);
            
            while(activo){
                opcion = (int) inputStream.readInt();
                System.out.println("Opcion: " + opcion);
                switch(opcion){
                    case 1: //IDK
                        System.out.println("IDK");
                    break;
                    case 2: //Envia un mensaje del chat a todos los jugadores
                        mensajeGenerico mensaje = (mensajeGenerico) inputStream.readObject();
                        for(ThreadServidor cliente: servidor.getClientes())
                            cliente.enviarMensaje(mensaje);    
                    break;
                    case 3: //Envia un mensaje del juego a todos los jugadores
                        String mensajeJuego = (String) inputStream.readUTF();
                        for(ThreadServidor cliente: servidor.getClientes())
                            cliente.enviarMensajeJuego(mensajeJuego); 
                    break;
                    case 4:
                        System.out.println("ME CAGO EN LA PUTA");
                    break;
                    case 5: //Terminar mi turno
                        servidor.siguienteTurno();
                    break;
                        
                    // Opcion es el metodo que quiere que el servidor haga 
                }
            }
                        
        } catch (IOException ex) {
            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ASÍ ESTÁ LA PICHA: " + ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void enviarEnemigos() throws IOException{
        ArrayList<String> enemigos = new ArrayList<>();
        for(ThreadServidor enemigo: servidor.getClientes()){
            if(!(enemigo.getNickName().equals(this.nickName)))
                enemigos.add(enemigo.getNickName());
        }
        outputStream.writeInt(1);
        outputStream.writeObject(enemigos);
        
    }
    
    public void enviarMensaje(mensajeGenerico mensaje) throws IOException{
        outputStream.writeInt(2);
        outputStream.writeObject(mensaje);
    }
    
    public void enviarMensajeJuego(String mensaje) throws IOException{
        outputStream.writeInt(3);
        outputStream.writeUTF(mensaje);
    }
    
    public void reanudarJuego() throws IOException{
        System.out.println("REANUDAR JUEGO");
        outputStream.writeInt(4);
    }
    
    void empezarTurno() throws IOException {
        outputStream.writeInt(5);
    }
    
    public void reanudarAdquisicion() throws IOException{
        outputStream.writeInt(6);
    }
    
   

    
    //----Getter && Setter----
    
    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    

    
}
