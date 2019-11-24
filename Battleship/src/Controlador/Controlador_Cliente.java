
package Controlador;

import Cliente_Servidor.Cliente.Cliente;
import Cliente_Servidor.mensajeGenerico;
import Vista.GUIAdquisicion;
import Vista.GUICliente;
import Vista.GUIStartUp;
import battleship.Componente;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.text.DefaultCaret;

public class Controlador_Cliente {
    private Cliente cliente;
    private boolean todosListos;
    private boolean miTurno = false;
    private GUIStartUp pantallaStartUp; 
    private GUICliente pantallaPrincipal;
    private GUIAdquisicion pantallaAdquisicion;
    private Controlador_Adquisicion controladorAdquisicion;
    private JLabel [][] matrizJugadorLbel, matrizEnemigoLbel;
    private Componente [][] matrizJugadorComp, matrizEnemigoComp;

    
    public Controlador_Cliente(){ 
        todosListos = false;
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
    
    public void inciarAdquisicion(){ //SOLO LA PRIMERA VEZ AL INICIAR EL JUEGO
        this.pantallaStartUp.getTxtInfo().setText("Inciando Partida!\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controlador_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.pantallaStartUp.dispose();
        
        this.controladorAdquisicion = new Controlador_Adquisicion(cliente);
        this.pantallaAdquisicion = controladorAdquisicion.getPantalla();        
    }
    
    public void empezarAJugar(){ //SOLO LA PRIMERA VEZ
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
    
    public void reanudarPantallaPrincipal(){
        this.pantallaAdquisicion.setVisible(false);
        this.pantallaPrincipal.setVisible(true);
        
        //Agregar 
    }
    
    public void reanudarPantallaAdquisicion(){
        this.pantallaAdquisicion.setVisible(true);
        this.pantallaPrincipal.setVisible(false);
        
        //Agregar
    }
    
    
    //Codigo de renovar juego 
    public void esperarEnemigos() throws InterruptedException, IOException{
        cliente.finalizoAdquisicion(); //Envia al servidor que ya esta listo
        while(!todosListos){
              sleep(2000);
        }
        
        //Codigo de reanudar juego
        todosListos = false;

        reanudarPantallaPrincipal();
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
    
    public void enviarMensajeJuego(String mensaje) throws IOException{
        cliente.enviarMensajeJuego(mensaje);
    }
    
    public void recibirMensajeJuego(String mensaje){
       this.pantallaPrincipal.getTxtAreaJuego().append(mensaje + "\n");
    }
    
    public void empezarTurno(){
        //Activar turno
        this.miTurno = true;
    }
    
    public void finalizarTurno() throws IOException{
        this.miTurno = false;
        cliente.finalizarTurno();
    }
       
    
    //Getter && Setter
    
    public void setMatrizJugadorLbl(JLabel [][] matrizN){
        matrizJugadorLbel = matrizN;
    
    }
    public void setMatrizJugadorComp(Componente [][] matrizN){
        matrizJugadorComp = matrizN;
    }

    public boolean isTodosListos() {
        return todosListos;
    }

    public void setTodosListos(boolean todosListos) {
        this.todosListos = todosListos;
    }

    public boolean isMiTurno() {
        return miTurno;
    }

    public void setMiTurno(boolean miTurno) {
        this.miTurno = miTurno;
    }
   
    
}
