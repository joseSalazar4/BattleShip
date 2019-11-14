/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Servidor.Cliente;

import Cliente.Jugador;
import Vista.GUICliente;
import Vista.GUIStartUp;
import Vista.GUIAdquisicion;
import java.io.*;
import java.net.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    public Jugador jugador;
    public Controlador.Controlador_Cliente controlador;
    
    private Socket socketCliente;
   
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;    
    
    private String nickName;
    private String HOST;
    private int PORT_HOST;
    private ThreadCliente thread;
    

    public Cliente(String HOST, int PORT_HOST, Controlador.Controlador_Cliente controlador) {
        this.jugador = new Jugador("");
        this.HOST = HOST;
        this.PORT_HOST = PORT_HOST;
        this.controlador = controlador;
    }
    
    public void iniciarCliente(String nick){
        try { 
            socketCliente = new Socket(HOST, PORT_HOST); 
            outputStream = new ObjectOutputStream(socketCliente.getOutputStream());
            inputStream  = new ObjectInputStream(socketCliente.getInputStream());
            
            nickName = nick;
            this.jugador.setNombre(nick);
            outputStream.writeObject(nick);             //Enviamos el nickname del jugador al servidor
            thread = new ThreadCliente(this, inputStream);
            thread.start();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Servidor no disponible" + ex);
        }
    }

    public Socket getSocketCliente() {
        return socketCliente;
    }

    public void setSocketCliente(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public ObjectInputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(ObjectInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public ObjectOutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(ObjectOutputStream outputStream) {
        this.outputStream = outputStream;
    }
    
    
    
}
