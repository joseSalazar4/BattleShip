
package Controlador;

import Cliente_Servidor.Cliente.Cliente;
import Cliente_Servidor.mensajeGenerico;
import Vista.GUIAdquisicion;
import Vista.GUICliente;
import Vista.GUIStartUp;
import battleship.Componente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.text.DefaultCaret;

public class Controlador_Cliente {
    private GUIStartUp pantallaStartUp;
    private GUIAdquisicion pantallaAdquisicion; 
    private GUICliente pantallaPrincipal;
    private Cliente cliente;
    private JLabel [][] matrizJugadorLbel, matrizEnemigoLbel;
    private Componente [][] matrizJugadorComp, matrizEnemigoComp;
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
        pantallaStartUp.getTxtInfo().setText("Buscando...");
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
        //empezarAJugar();
        
    }
    
    public void empezarAJugar(){
        pantallaPrincipal = new GUICliente(this);
        pantallaPrincipal.setVisible(true);
        for(int i = 0;i<cliente.jugador.getArmasCompradas().size();i++)
            pantallaPrincipal.getComboBoxArmas().addItem(cliente.jugador.getArmasCompradas().get(i).getNombre());
        
        String enemigos = "---Empiza la Batalla---\n";
        enemigos += "Tus enemigos: \n";
        
        for(String enemigo: cliente.jugador.getEnemigos())
            enemigos += enemigo + "\n";
        
        pantallaPrincipal.getTxtAreaJuego().append(enemigos);
       
        DefaultCaret caret = (DefaultCaret)this.pantallaPrincipal.getTxtAreaChat().getCaret();
        caret.setUpdatePolicy(DefaultCaret.OUT_BOTTOM);
    }
    
    public void usarArma(){
        String armaUtilizada = (String) pantallaPrincipal.getComboBoxArmas().getSelectedItem();
        if(armaUtilizada == "Torpedo"){
            
        }
        else if (armaUtilizada == "Trumpedo"){
            
        }
        else if(armaUtilizada == "Bomba"){
            
        }
        
        else if(armaUtilizada == "Multi-shot"){
            
        }
        
        else if(armaUtilizada == "Barco"){
            
        }
        else{
            System.out.println("ERROR AL UTILIZAR ARMA");
        }
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
    
    public void setMatrizJugadorLbl(JLabel [][] matrizN){
        matrizJugadorLbel = matrizN;
    
    }
    public void setMatrizJugadorComp(Componente [][] matrizN){
        matrizJugadorComp = matrizN;
    }
//    
//    //Codigo de renovar juego 
//    public 
//    {
//        
//        while(!listo){
//            sleep(2000);
//        }
            //Codigo de reanudar juego
            
            //listo = false;
//    }
}
