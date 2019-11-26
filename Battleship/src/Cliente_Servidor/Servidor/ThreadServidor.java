/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Servidor.Servidor;
import Cliente_Servidor.mensajeGenerico;
import Vista.GUIServidor;
import battleship.Oceano;
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
    boolean activo = true, estoyListo= false, miTurno = false;
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
                        this.estoyListo = true;
                        boolean todosListos = true;
                        for(ThreadServidor thread : servidor.getClientes()){
                            if(!thread.estoyListo) todosListos = false;
                        }
                        if(todosListos){
                            for(ThreadServidor thread2 : servidor.getClientes()){
                                thread2.reanudarJuego();
                                thread2.estoyListo = false;
                            }    
                        }
                    break;
                    case 5: //Terminar mi turno
                        this.miTurno = false;
                        servidor.siguienteTurno();
                    break;
                        
                    case 7: //Buscar Oceano Enemigo
                        String nickEnemigo = (String) inputStream.readUTF();
                        for(ThreadServidor thread : servidor.getClientes()){
                            if(thread.nickName.equals(nickEnemigo)) thread.enviarOceano();
                        }
                    break;
                        
                    case 8: //Enviar mi Oceano
                        Oceano oceano = (Oceano) inputStream.readObject();
                        for(ThreadServidor thread : servidor.getClientes()){
                            if(thread.isMiTurno()) thread.recibirOceano(oceano);
                        }
                    break;
                        
                    case 9:
                        Oceano oceanoActualizacion = (Oceano) inputStream.readObject();
                        for(ThreadServidor thread : servidor.getClientes()){
                            if(thread.nickName.equals(oceanoActualizacion.enemigo)) 
                                thread.actualizarMiOceano(oceanoActualizacion);
                        }
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
        outputStream.flush();
        
    }
    
    public void enviarMensaje(mensajeGenerico mensaje) throws IOException{
        outputStream.writeInt(2);
        outputStream.writeObject(mensaje);
        outputStream.flush();
    }
    
    public void enviarMensajeJuego(String mensaje) throws IOException{
        outputStream.writeInt(3);
        outputStream.writeUTF(mensaje);
        outputStream.flush();
    }
    
    public void reanudarJuego() throws IOException{
        System.out.println("REANUDAR JUEGO");
        outputStream.writeInt(4);
        outputStream.flush();
    }
    
    void empezarTurno() throws IOException {
        this.miTurno = true;
        outputStream.writeInt(5);
        outputStream.flush();
    }
    
    public void reanudarAdquisicion() throws IOException{
        outputStream.writeInt(6);
        outputStream.flush();
    }

    //Busqueda de Oceano Enemigo
    
    public void recibirOceano(Oceano oceano) throws IOException{
        outputStream.writeInt(7);
        outputStream.writeObject(oceano);
        outputStream.flush();
    }
    
    public void enviarOceano() throws IOException{
        outputStream.writeInt(8);
        outputStream.flush();
    }
    
    public void actualizarMiOceano(Oceano oceano) throws IOException{
        outputStream.writeInt(9);
        outputStream.writeObject(oceano);
        outputStream.flush();
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

    public boolean isMiTurno() {
        return miTurno;
    }

    public void setMiTurno(boolean miTurno) {
        this.miTurno = miTurno;
    }
    
    
    

    
}
