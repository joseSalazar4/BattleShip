/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Servidor.Cliente;

import Cliente.Jugador;
import Cliente_Servidor.mensajeGenerico;
import battleship.Oceano;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Serializable{
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
    
    
    public void finalizoAdquisicion() throws IOException{ //EStoy Listo
        outputStream.writeInt(4);
        System.out.println("LO ENVIO AL SERVIDOR");
        outputStream.flush();

    }
    
    public void finalizarTurno() throws IOException{
        outputStream.writeInt(5);
        outputStream.flush();
    }
    
    public void buscarOceanoEnemigo(String enemigo) throws IOException{
        outputStream.writeInt(7);
        outputStream.writeUTF(enemigo);
        outputStream.flush();
    }
    
    public void enviarMiOceano(Oceano oceano) throws IOException{
        outputStream.writeInt(8);
        outputStream.writeObject(oceano);
        outputStream.flush();
    }
    
    public void actualizarDatos(Oceano oceano) throws IOException{
        System.out.println("Envie la actualizacion");
        outputStream.writeInt(9);
        outputStream.writeObject(oceano);
        outputStream.flush();
    }
    
    
    //Getter && Setter

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
