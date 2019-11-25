
package Controlador;

import Cliente_Servidor.Cliente.Cliente;
import Cliente_Servidor.mensajeGenerico;
import static Controlador.Controlador_Adquisicion.pantalla;
import Grafo.Vertice;
import Vista.GUIAdquisicion;
import Vista.GUICliente;
import Vista.GUIStartUp;
import Componentes.Componente;
import battleship.Oceano;
import java.awt.Color;
import java.awt.Graphics;
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
    private JLabel [][] matrizJugadorLbel = new JLabel[20][20], matrizEnemigoLbel = new JLabel[20][20];
    private Componente [][] matrizJugadorComp;
    private Oceano oceanoEnemigo;

    
    public Controlador_Cliente(){ 
        todosListos = false;
        this.cliente = new Cliente("localhost", 9999, this); 
        this.pantallaStartUp = new GUIStartUp(this);
        this.pantallaStartUp.setVisible(true);
        this.pantallaAdquisicion = null;
        this.pantallaPrincipal = new GUICliente(this);
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
        
        this.controladorAdquisicion = new Controlador_Adquisicion(cliente, this);
        this.pantallaAdquisicion = controladorAdquisicion.getPantalla();  
        
        this.empezarAJugar();

    }
    
    public void empezarAJugar(){ //SOLO LA PRIMERA VEZ
        for(int i = 0;i<cliente.jugador.getArmasCompradas().size();i++)
            pantallaPrincipal.getComboBoxArmas().addItem(cliente.jugador.getArmasCompradas().get(i).getNombre());
        
        crearMatrizJugadorLabels();
        
        for(String enemigo: cliente.jugador.getEnemigos())
            this.pantallaPrincipal.getjComboBoxEnemigos().addItem(enemigo);
            
        DefaultCaret caret = (DefaultCaret)this.pantallaPrincipal.getTxtAreaChat().getCaret();
        caret.setUpdatePolicy(DefaultCaret.OUT_BOTTOM);
    }
    
    public void crearMatrizJugadorLabels(){
        for(int i = 0; i<20 ;i++){
            for(int j = 0; j<20 ;j++){
                JLabel labelNuevo = new JLabel();
                labelNuevo.setOpaque(false);
                labelNuevo.setSize(30, 30);
                labelNuevo.setLocation(j*30, i*30);
                this.matrizJugadorLbel[i][j] = labelNuevo;
                this.pantallaPrincipal.getjPanelJugador().add(labelNuevo);
            }
        }
    }
    
    public void trazarConexiones(){
        this.pantallaPrincipal.getjPanelJugador().setBackground(Color.blue);
            for(Vertice vertice: this.controladorAdquisicion.grafo.getVertices()){        
                for(int k = 0 ;k<vertice.getAristas().size()  ;k++){
                    Componente orig = vertice.getAristas().get(k).getOrigin().getComponente();
                    Componente dest = vertice.getAristas().get(k).getDestination().getComponente();
                    pintarConexion(orig.getPoint().x, orig.getPoint().y, vertice.getAristas().get(k).getConector().getPoint().x, vertice.getAristas().get(k).getConector().getPoint().y);
                    pintarConexion(vertice.getAristas().get(k).getConector().getPoint().x, vertice.getAristas().get(k).getConector().getPoint().y, dest.getPoint().x, dest.getPoint().y);
                }
            }
        }
    
    public void pintarConexion(int x1,int  y1,int x2,int y2){
        Graphics graf = this.pantallaPrincipal.getjPanelJugador().getGraphics();
        graf.drawLine(x1*30, y1*30, x2* 30, y2* 30);
    }
    
    public void cagarMiOceano(){
        for(int i= 0; i<20; i++){
            for(int j=0; j<20; j++){
                if(this.matrizJugadorComp[i][j] != null)
                    this.matrizJugadorLbel[i][j].setIcon(this.matrizJugadorComp[i][j].getImagen());
            }
        }
        trazarConexiones();
    }
    
    public void reanudarPantallaPrincipal(){
        this.pantallaAdquisicion.getjLabelCarga().setVisible(false);
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controlador_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.cagarMiOceano();
        
        this.pantallaAdquisicion.setVisible(false);
        this.pantallaPrincipal.setVisible(true);
        
        
    }
    
    public void cargarEnemigoComboBox(){
        for(String enemigo: this.cliente.jugador.getEnemigos())
        pantallaPrincipal.getjComboBoxEnemigos().addItem(enemigo);
    }
    
    public void reanudarPantallaAdquisicion(){
        this.pantallaAdquisicion.setVisible(true);
        this.pantallaPrincipal.setVisible(false);
        
        //Agregar
    }
    
    
    //METODOS DE PEDIR DATOS DEL ENEMIGO
    
    public void buscarOceanoEnemigo() throws IOException{
        String enemigoBuscado = this.pantallaPrincipal.getjComboBoxEnemigos().getSelectedItem().toString();
        cliente.buscarOceanoEnemigo(enemigoBuscado);
    }
    
    public void setOceanoEnemigo(Oceano oceano){
        this.oceanoEnemigo = oceano;
    }
    
    public void mostrarOceanoEnemigo(){
        //Recorrer la matriz o el grafo del enemigo y mostrar los componentes
        //que no esten conectados a una fuente de poder.
    }
    
    
    
    //Codigo de renovar juego 
    public void esperarEnemigos() throws InterruptedException, IOException{
        cliente.finalizoAdquisicion(); //Envia al servidor que ya esta listo
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
    
    //Metodos del manejo de turnos
    
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

    public Cliente getCliente() {
        return cliente;
    }

    public GUIStartUp getPantallaStartUp() {
        return pantallaStartUp;
    }

    public GUICliente getPantallaPrincipal() {
        return pantallaPrincipal;
    }

    public GUIAdquisicion getPantallaAdquisicion() {
        return pantallaAdquisicion;
    }

    public Controlador_Adquisicion getControladorAdquisicion() {
        return controladorAdquisicion;
    }

    public JLabel[][] getMatrizJugadorLbel() {
        return matrizJugadorLbel;
    }

    public JLabel[][] getMatrizEnemigoLbel() {
        return matrizEnemigoLbel;
    }

    public Componente[][] getMatrizJugadorComp() {
        return matrizJugadorComp;
    }

    public Oceano getOceanoEnemigo() {
        return oceanoEnemigo;
    }
    
    
       
}
