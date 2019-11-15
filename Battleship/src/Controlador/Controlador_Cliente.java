
package Controlador;

import Cliente_Servidor.Cliente.Cliente;
import Cliente_Servidor.mensajeGenerico;
import Vista.GUIAdquisicion;
import Vista.GUICliente;
import Vista.GUIStartUp;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultCaret;

public class Controlador_Cliente {
    private GUIStartUp pantallaStartUp;
    private GUIAdquisicion pantallaAdquisicion;
    private GUICliente pantallaPrincipal;
    private Cliente cliente;
    
    private Controlador_Adquisicion controladorAdquisicion;
    
    public Controlador_Cliente(){
        this.cliente = new Cliente("localhost", 9999, this);
        this.pantallaStartUp = new GUIStartUp(this);
        this.pantallaStartUp.setVisible(true);
        this.pantallaAdquisicion = null;
        this.pantallaPrincipal = null;
    }
    
    public void iniciarCliente(String nickName){
        cliente.iniciarCliente(nickName);
        pantallaStartUp.setTitle(nickName);
        pantallaStartUp.getTxtInfo().setText("Esperando Jugadores...");
        pantallaStartUp.getBtnStart().setVisible(false);
        pantallaStartUp.getjLabelLoadGIF().setVisible(true);
    }
    
    public void inciarAdquisicion(){
        this.pantallaStartUp.getTxtInfo().setText("Inciando Partida!\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controlador_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.pantallaStartUp.dispose();
        
        this.controladorAdquisicion = new Controlador_Adquisicion(cliente);
        this.pantallaAdquisicion = controladorAdquisicion.getPantalla();
       
        
        //SOLO PARA PRUEBA
        empezarAJugar();
        
    }
    
    public void empezarAJugar(){
        this.pantallaPrincipal = new GUICliente(this);
        this.pantallaPrincipal.setVisible(true);
        String enemigos = "---Empiza la Batalla---\n";
        enemigos += "Tus enemigos: \n";
        for(String enemigo: cliente.jugador.getEnemigos())
            enemigos += enemigo + "\n";
        this.pantallaPrincipal.getTxtAreaJuego().append(enemigos);
       
        DefaultCaret caret = (DefaultCaret)this.pantallaPrincipal.getTxtAreaChat().getCaret();
        caret.setUpdatePolicy(DefaultCaret.OUT_BOTTOM);
    }
    
    
    
    
    //Metodos del Chat
    
    public void enviarMensaje() throws IOException{
        String cuerpoMensaje = this.pantallaPrincipal.getTxtFieldMensajes().getText();
        this.pantallaPrincipal.getTxtFieldMensajes().setText("");  
        String emisor = this.cliente.getNickName();
        mensajeGenerico mensaje = new mensajeGenerico(cuerpoMensaje, emisor);
        this.cliente.enviarMensaje(mensaje);
    }
    
    public void recibirMensaje(mensajeGenerico mensaje){
        String mensajeCompleto = "";
        if(mensaje.emisor.equals(cliente.jugador.getNombre())) mensajeCompleto += "Yo: ";
        else mensajeCompleto += mensaje.emisor + ": ";
        mensajeCompleto += mensaje.mensaje;
        
        this.pantallaPrincipal.getTxtAreaChat().append(mensajeCompleto + "\n");
    }
     
    //Metodos de los mensajes de informacion del juego
    public void recibirMensajeJuego(mensajeGenerico mensaje){
        
    }
}
