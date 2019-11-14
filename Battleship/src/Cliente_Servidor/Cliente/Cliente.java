/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Servidor.Cliente;

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
    private Socket socketCliente;
    //private DataInputStream inputStream;
    //private DataOutputStream outputStream;
    
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;    
    
    private String nickName;
    private String HOST;
    private int PORT_HOST;
    private GUICliente pantallaPrincipal;
    private GUIStartUp pantallaStartUp;
    private GUIAdquisicion pantallaAdquisicion;
    private ArrayList<String> enemigos;

    public Cliente(String HOST, int PORT_HOST, GUIStartUp pantalla) {
        this.HOST = HOST;
        this.PORT_HOST = PORT_HOST;
        this.pantallaStartUp = pantalla;
        this.pantallaStartUp.show();
        try {
            socketCliente = new Socket(HOST, PORT_HOST);    
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void iniciarCliente(String nick){
        try { 
            outputStream = new ObjectOutputStream(socketCliente.getOutputStream());

            this.nickName = nick;
            System.out.println("NICKNAME: "+ nick);
            //Enviamos el nickname del jugador al servidor
            outputStream.writeUTF(nick);
            this.pantallaStartUp.setTitle(nick);
            new ThreadCliente(this).start();
            
            outputStream.close();
  
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

    public GUICliente getPantallaPrincipal() {
        return pantallaPrincipal;
    }

    public void setPantallaPrincipal(GUICliente pantallaPrincipal) {
        this.pantallaPrincipal = pantallaPrincipal;
    }

    public GUIStartUp getPantallaStartUp() {
        return pantallaStartUp;
    }

    public void setPantallaStartUp(GUIStartUp pantallaStartUp) {
        this.pantallaStartUp = pantallaStartUp;
    }

    public GUIAdquisicion getPantallaAdquisicion() {
        return pantallaAdquisicion;
    }

    public void setPantallaAdquisicion(GUIAdquisicion pantallaAdquisicion) {
        this.pantallaAdquisicion = pantallaAdquisicion;
    }

    public ArrayList<String> getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(ArrayList<String> enemigos) {
        this.enemigos = enemigos;
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
