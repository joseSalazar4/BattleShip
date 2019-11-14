/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Servidor.Servidor;
import Cliente_Servidor.mensajeGenerico;
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
    String nickName;
    String ip;
    
    //DataInputStream inputStream;
    //DataOutputStream outputStream;
    
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream; 
    
    
    
    public ThreadServidor(Socket cliente, int numeroCliente, Servidor servidor) {
        this.numeroCliente = numeroCliente;
        this.cliente = cliente;
        this.servidor = servidor;
        this.ip = cliente.getInetAddress().getHostAddress();  
    }
    
    @Override
    public void run(){                
        try {
            //inputStream = new DataInputStream(this.cliente.getInputStream());
            //outputStream = new DataOutputStream(this.cliente.getOutputStream());
            
            inputStream = new ObjectInputStream(cliente.getInputStream());
            //outputStream = new ObjectOutputStream(cliente.getOutputStream());
            
            //Leemos el nickName que ingreso el usuario
            setNickName((String) inputStream.readUTF());
            servidor.getPantalla().addStatus(".::" + ip + " = " + nickName);
            System.out.println("ENTRO EL " + nickName);
            inputStream.close();
                        
        } catch (IOException ex) {
            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void makeFirstHandshake(){
        mensajeGenerico mensaje = new mensajeGenerico();
        mensaje.setContenido(new ArrayList<>());
        mensaje.setIs(true);
        mensaje.setTipoMensaje(1);
        for (ThreadServidor tc : servidor.getClientes()){
            if(!tc.getNickName().equals(this.nickName))
                mensaje.getContenido().add(tc.nickName);
        }
        try {
            outputStream.writeObject(mensaje);
        } catch (IOException ex) {
            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
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
