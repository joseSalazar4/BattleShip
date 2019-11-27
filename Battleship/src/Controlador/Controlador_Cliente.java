
package Controlador;

import Armas.*;
import Cliente_Servidor.Cliente.Cliente;
import Cliente_Servidor.mensajeGenerico;
import Componentes.Armeria;
import Grafo.Vertice;
import Vista.GUIAdquisicion;
import Vista.GUICliente;
import Vista.GUIStartUp;
import Componentes.Componente;
import static Componentes.Componente.tipoComponente.Armeria;
import Componentes.Conector;
import Componentes.EspacioMuerto;
import Componentes.FuentePoder;
import Componentes.Remolino;
import Componentes.ThreadProductoraAcero;
import Grafo.Arista;
import Cliente.DatosDeAtaque;
import battleship.Oceano;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;

public class Controlador_Cliente implements Serializable{

    ImageIcon imageAnterior;
    private Cliente cliente;
    private boolean todosListos;
    private Oceano oceanoEnemigo;
    private boolean miTurno = false;
    private boolean escudoAct = false;
    private int cantEscudo = 0;
    private GUIStartUp pantallaStartUp; 
    private GUICliente pantallaPrincipal;
    private boolean actualizarEnemigo = false;
    private BarcoEspia barcoEspia;
    private Componente [][] matrizJugadorComp;
    private GUIAdquisicion pantallaAdquisicion;
    private marcarCasillaEnemigo labelEnemigoSeleccionado;
    private Controlador_Adquisicion controladorAdquisicion;
    private ArrayList<Armeria> armerias = new ArrayList<>();
    private ArrayList<ThreadProductoraAcero> threadsProductores = new ArrayList<>();
    private JLabel [][] matrizJugadorLbel = new JLabel[20][20], matrizEnemigoLbel = new JLabel[20][20];
    private String oceanoBuscadoEnemigo = "";
    private boolean yaAtacado = false, barcoActivo = false;
    
    
    public Controlador_Cliente(){ 
        todosListos = false;
        this.cliente = new Cliente("localhost", 9999, this); 
        this.pantallaStartUp = new GUIStartUp(this);
        this.pantallaStartUp.setVisible(true);
        this.pantallaAdquisicion = null;
        this.pantallaPrincipal = new GUICliente(this);
        this.barcoEspia = new BarcoEspia(this);
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
        crearMatrizJugadorLabels();
        crearMatrizEnemigoLabels();
        
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
    
    public void mostrarInfoCompraPrivada(String fraseCompra){
        String[] options = {"Comprar", "Denegar"};
        int opcionCompra = JOptionPane.showOptionDialog(null, fraseCompra, "Información de compra",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if(opcionCompra == 1){
            //llamar a alguien o maybe llamar esto desde el server y
            //luego return algo segun lo que eligio?
        }
        else{
            
        }
    }
    
    public void crearMatrizEnemigoLabels(){
        ImageIcon imagen = new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/Cursor.png"));
        for(int i = 0; i<20 ;i++){
            for(int j = 0; j<20 ;j++){
                JLabel labelNuevo = new JLabel();
                labelNuevo.setOpaque(false);
                labelNuevo.setSize(30, 30);
                labelNuevo.setLocation(j*30, i*30);
                this.matrizEnemigoLbel[i][j] = labelNuevo;
                this.pantallaPrincipal.getjPanelEnemigo().add(labelNuevo);
                new marcarCasillaEnemigo(labelNuevo, i, j, this, imagen);
            }
        }
    }
    
    public void trazarConexiones(){
        this.pantallaPrincipal.getjPanelJugador().setBackground(Color.blue);
            for(Vertice vertice: controladorAdquisicion.grafo.getVertices()){        
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
    
    public void habilitarPanelArmas(Componente comp){
        if(comp.getTipoComponente()==Armeria){
            Armeria armaTemp = (Armeria) comp;
            if(armaTemp.arma instanceof Torpedo){
                this.pantallaPrincipal.getjPanelTorpedo().setVisible(true);
                this.pantallaPrincipal.getjLabelTextoFabricar().setVisible(true);
            }
            else if(armaTemp.arma instanceof MultiShot){
                this.pantallaPrincipal.getjPanelMultiShot().setVisible(true);
                this.pantallaPrincipal.getjLabelTextoFabricar().setVisible(true);                
            }
            else if(armaTemp.arma instanceof Trumpedo){
                this.pantallaPrincipal.getjPanelTrumpedo().setVisible(true);
                this.pantallaPrincipal.getjLabelTextoFabricar().setVisible(true);                
            }
            else if(armaTemp.arma instanceof Bomba){
                this.pantallaPrincipal.getjPanelBomba().setVisible(true);
                this.pantallaPrincipal.getjLabelTextoFabricar().setVisible(true);                
            }
            armerias.add(armaTemp);
        }
        else return;
    }
    
    public void Bomba(){
        
    }
    
    public void MultiShot(){
        
    }
    
    public void Torpedo() throws InterruptedException{
        if(this.oceanoEnemigo != null){
            for(Armeria armeria : this.armerias){
                if(armeria.getArma().getNombre().equals("Torpedo")){
                    if(this.escudoAct) armeria.getArma().escudo = this.cantEscudo;
                    armeria.getArma().setEscudoActivado(escudoAct);
                    DatosDeAtaque datos = new DatosDeAtaque();
                    datos.jugador = this.cliente.jugador;
                    datos.golpeoRemolino = false;
                    datos.destryoFuente = false;
                    armeria.getArma().setOceano(oceanoEnemigo);
                    armeria.getArma().setDatos(datos);
                    armeria.getArma().setJugador(this.cliente.getNickName());
                            
                    Oceano oceanoNuevo = armeria.getArma().atacar(this.labelEnemigoSeleccionado);
                    if(oceanoNuevo != null){
                        this.oceanoEnemigo = oceanoNuevo;
                        System.out.println("GRAFO NUEVO");
                        System.out.println(this.oceanoEnemigo.grafo);
                    }
                    else System.out.println("OCEANO NUEVO ES NULL");
                    if(datos.golpeoRemolino){
                        System.out.println("Golpeo un remolino");
                    }
                    if(datos.destryoFuente){
                        System.out.println("Destruyo una fuente");
                    }
                    
                    this.cliente.jugador = datos.jugador;
                    enviarMensajeJuego(datos.historialAtaque);
                    
                    mostrarOceanoEnemigo();
                    cargarRecursos();
                    
                    this.yaAtacado = true;
                    return;
                    
                }  
            } 
            System.out.println("NO SE ENCONTRO EL ARMA");
            return;
        }
        System.out.println("OCEANO ES NULL");
        return;
    }
    
    public void Trumpedo(){
        
    }
    
    public void Barco() throws InterruptedException{
        int din = this.cliente.jugador.getDinero();
        if(din<2500) JOptionPane.showMessageDialog(null, "No tiene suficiente dinero para comprar un barco!");
        else{
            this.cliente.jugador.setDinero(din-2500);
            this.cargarRecursos();
            this.barcoEspia.activo = true;
        }

    }
    
    public void cargarMiOceano(){
        for(int i= 0; i<20; i++){
            for(int j=0; j<20; j++){
                if(this.controladorAdquisicion.matrizComponentes[i][j] != null){
                    habilitarPanelArmas(controladorAdquisicion.matrizComponentes[i][j]);
                    this.matrizJugadorLbel[i][j].setIcon(this.controladorAdquisicion.matrizComponentes[i][j].getImagen());
                }
                else this.matrizJugadorLbel[i][j].setIcon(null);
            }
        }
        trazarConexiones();
    }
    
    public void reanudarProdAcero(){
        for(ThreadProductoraAcero thread : this.threadsProductores) thread.setActivo(true);
    }
    
    public void detenerProdAcero(){
        for(ThreadProductoraAcero thread : this.threadsProductores) thread.setActivo(false);
    }
    
    public void reanudarPantallaPrincipal() throws InterruptedException{
        this.pantallaAdquisicion.getjLabelCarga().setVisible(false);
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controlador_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.cargarMiOceano();
        
        this.pantallaAdquisicion.setVisible(false);
        
        this.pantallaPrincipal.setVisible(true);
        this.reanudarProdAcero();
        cargarRecursos();
        
    }
        
    public void comprarBarco(){
        
    }
    
    public void reanudarPantallaAdquisicion() throws InterruptedException{
        this.controladorAdquisicion.actualizarMatrizComponentes();
        this.pantallaAdquisicion.setVisible(true);
        this.pantallaPrincipal.setVisible(false);
        this.pantallaAdquisicion.getBtnConectar().setEnabled(true);
        this.detenerProdAcero();
        cargarRecursos();
        //Agregar
    }
    
    //METODOS DE PEDIR DATOS DEL ENEMIGO
    
    public void cargarRecursos() throws InterruptedException{
        Semaphore semaf = cliente.jugador.getSemaforoAcero();
        sleep(100);
        semaf.tryAcquire(8, TimeUnit.SECONDS);
        this.pantallaPrincipal.getjLabelAcero().setText("Acero: "+this.cliente.jugador.getAcero());
        this.pantallaPrincipal.getjLabelDinero().setText("Dinero: "+this.cliente.jugador.getDinero());        
        semaf.release();
    }
    
    public void buscarOceanoEnemigo() throws IOException {
        if(miTurno && !yaAtacado){
            String enemigoBuscado = this.pantallaPrincipal.getjComboBoxEnemigos().getSelectedItem().toString();
            if(!enemigoBuscado.equals(this.oceanoBuscadoEnemigo)){
                this.oceanoBuscadoEnemigo = enemigoBuscado;
                System.out.println("Buscando oceano enemigo");
                cliente.buscarOceanoEnemigo(enemigoBuscado); 
            }   
        }
    }
    
    public void setOceanoEnemigo(Oceano oceano){
        this.oceanoEnemigo = oceano;
        this.actualizarEnemigo = true;
        if(oceanoEnemigo == null) System.out.println("Oceano enemigo is NULL");
        //Pintar oceano enemigo
//        oceanoEnemigo.grafo = (Grafo) oceanoEnemigo.grafo;
//        for(Vertice vertice : oceanoEnemigo.grafo.getVertices()){
//           vertice = (Vertice) vertice;
//           for(Arista arista : vertice.getAristas()){
//               arista = (Arista) arista;
//           }
//        }
        mostrarOceanoEnemigo();
        System.out.println("Recibi Oceano");
        System.out.println(oceano.grafo);
    }
    
    public void encenderEscudo(){
        escudoAct = true;
    }
    
    public void enviarMiOceano() throws IOException{
        if(!miTurno){
            if(this.controladorAdquisicion.matrizComponentes == null) System.out.println("Matriz is NULL");
            Oceano miOceano = new Oceano();
            miOceano.grafo = controladorAdquisicion.grafo;
            this.controladorAdquisicion.matrizComponentes = this.controladorAdquisicion.matrizComponentes;
            miOceano.matrizComponentes = this.controladorAdquisicion.matrizComponentes;
            miOceano.enemigo = this.cliente.jugador.getNombre();
            if(miOceano.matrizComponentes != null){
                cliente.enviarMiOceano(miOceano);
                System.out.println("ENVIE MI GRAFO: ");
                System.out.println(miOceano.grafo); 
            }  
        }
    }
    
    public void mostrarOceanoEnemigo(){
        for(int i = 0; i<20 ;i++){
            for(int j = 0; j<20 ;j++){
                Componente componenteEnemigo = null;
                JLabel labelEnemigo = this.matrizEnemigoLbel[i][j];
                try {
                    componenteEnemigo = oceanoEnemigo.matrizComponentes[i][j];
                    if(componenteEnemigo.isMuerto()){
                        componenteEnemigo = new EspacioMuerto();
                        labelEnemigo.setIcon(componenteEnemigo.getImagen());
                        return;
                    }
                } catch (Exception e) {}
                if(componenteEnemigo != null){
                    labelEnemigo.setIcon(componenteEnemigo.getImagen()); // Si NO esta conectado
                    if(componenteEnemigo instanceof EspacioMuerto){
                        labelEnemigo.setIcon(componenteEnemigo.getImagen()); // Si NO esta conectado
                        System.out.println("ES UN ESPACIO MUERTO");
                        return;
                    }
                    else if(componenteEnemigo instanceof Conector){
                        Conector conectorEnemigo = (Conector) componenteEnemigo;
                        if(conectorEnemigo.getFuente() != null){
                           labelEnemigo.setIcon(null); 
                        }                                
                    }
                    else{ //Si no es un conector
                        if(componenteEnemigo instanceof FuentePoder || componenteEnemigo instanceof Remolino){
                           labelEnemigo.setIcon(null);
                        }
                        else{
                            //Cuando no es una Fuente de Poder
                            if(componenteEnemigo.getVertice().getAristas() != null &&
                            !componenteEnemigo.getVertice().getAristas().isEmpty()){
                                for(Arista arista : componenteEnemigo.getVertice().getAristas()){
                                    System.out.println("SI HAY ARISTAS");
                                    if(arista.getDestination().getComponente() != null){
                                       labelEnemigo.setIcon(null);
                                    }        
                                }
                            }
                        }
                    }
                }
                else labelEnemigo.setIcon(null);
            }
        }
    }
  
    //Enviar Actualizacion de Datos
    public void enviarActualizacion() throws IOException{
        cliente.actualizarDatos(oceanoEnemigo);
    }
    
    public void actualizarMiOceano(Oceano oceano){
        this.controladorAdquisicion.matrizComponentes = oceano.matrizComponentes;
        this.controladorAdquisicion.grafo = oceano.grafo;
        cargarMiOceano();
        System.out.println(oceano.grafo);
    }
        
    //Codigo de renovar juego 
    public void esperarEnemigos() throws InterruptedException, IOException{
        cliente.finalizoAdquisicion(); //Envia al servidor que ya esta listo
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
    
    public void enviarMensajeJuego(String mensaje){
        try {
            cliente.enviarMensajeJuego(mensaje);
        } catch (IOException ex) {
            Logger.getLogger(Controlador_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        if(miTurno){
           this.miTurno = false;
            if(actualizarEnemigo) this.enviarActualizacion();
            cliente.finalizarTurno();
            this.yaAtacado = false;
            this.oceanoBuscadoEnemigo = "";
            this.actualizarEnemigo = false; 
        }  
    }
       
    
    //Getter && Setter
    
    public void setMatrizJugadorLbl(JLabel [][] matrizN){
        matrizJugadorLbel = matrizN;
    
    }
    
    public void setMatrizJugadorComp(Componente [][] matrizN){
        controladorAdquisicion.matrizComponentes = matrizN;
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

    public marcarCasillaEnemigo getLabelEnemigoSeleccionado() {
        return labelEnemigoSeleccionado;
    }

    public void setLabelEnemigoSeleccionado(marcarCasillaEnemigo labelEnemigoSeleccionado) {
        this.labelEnemigoSeleccionado = labelEnemigoSeleccionado;
    }

    public int getCantEscudo() {
        return cantEscudo;
    }

    public void setCantEscudo(int cantEscudo) {
        this.cantEscudo = cantEscudo;
    }



    public ImageIcon getImageAnterior() {
        return imageAnterior;
    }

    public void setImageAnterior(ImageIcon imageAnterior) {
        this.imageAnterior = imageAnterior;
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

    public boolean isEscudoAct() {
        return escudoAct;
    }

    public void setEscudoAct(boolean escudoAct) {
        this.escudoAct = escudoAct;
    }

    public JLabel[][] getMatrizEnemigoLbel() {
        return matrizEnemigoLbel;
    }

    public Componente[][] getMatrizJugadorComp() {
        return controladorAdquisicion.matrizComponentes;
    }

    public Oceano getOceanoEnemigo() {
        return oceanoEnemigo;
    }

    public boolean isActualizarEnemigo() {
        return actualizarEnemigo;
    }

    public void setActualizarEnemigo(boolean actualizarEnemigo) {
        this.actualizarEnemigo = actualizarEnemigo;
    }

    public ArrayList<Armeria> getArmerias() {
        return armerias;
    }

    public void setArmerias(ArrayList<Armeria> armerias) {
        this.armerias = armerias;
    }

    public ArrayList<ThreadProductoraAcero> getThreadsProductores() {
        return threadsProductores;
    }

    public void setThreadsProductores(ArrayList<ThreadProductoraAcero> threadsProductores) {
        this.threadsProductores = threadsProductores;
    }
    
    
}
