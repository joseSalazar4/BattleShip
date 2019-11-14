/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Servidor.Servidor;
import Cliente_Servidor.mensajeGenerico;
import Vista.GUIServidor;
import Vista.GUIStartUp;
import java.io.*;
import java.net.*;

import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Personal
 */
public class ThreadServidor extends Thread{
    Servidor servidor;
    Socket cliente;
    int numeroCliente;
    String nickName = "";
    String ip;
    GUIServidor pantalla;
    boolean activo = true;
    
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
                sleep(1);
            }
                        
        } catch (IOException ex) {
            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ASÍ ESTÁ LA PICHA: " + ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void enviarEnemigos() throws IOException{
        ArrayList<String> enemigos = new ArrayList<>();
        for(ThreadServidor enemigo: servidor.getClientes()) enemigos.add(enemigo.getNickName());
        outputStream.writeInt(1);
        outputStream.writeObject(enemigos);
        
    }
    
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
