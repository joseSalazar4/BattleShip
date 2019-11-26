/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Grafo.Grafo;
import Grafo.Vertice;
import java.awt.Color;
import java.awt.Graphics;
import Vista.GUIAdquisicion;
import Componentes.Componente;
import Componentes.Conector;
import Componentes.ItemCompra;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Componentes.FactoryComponente;
import static Componentes.ItemCompra.*;
import Cliente_Servidor.Cliente.Cliente;
import Componentes.Armeria;
import static Componentes.Componente.tipoComponente.Mina;
import Componentes.Mina;
import Componentes.ThreadProductoraAcero;
import java.awt.Point;

    public class Controlador_Adquisicion {
    Cliente cliente;
    public static GUIAdquisicion pantalla; 
    FactoryComponente factoryComponente;  
    private Controlador_Cliente controladorCliente;
    public boolean isComprado = false, isMover = false, isArrIzq = false, isConectar = false;
    public  Componente componenteAux = null;
    public  Conector conectorAux = null;
    public Componente[][] matrizComponentes = new Componente[20][20];
    public static Grafo grafo = new Grafo();
   
    private int ctdMinas = 0, ctdConectores = 0, ctdMercados = 0, ctdFuentesPoder = 0, ctdTemplos = 0, ctdArmerias = 0, ctdTotalElementos = 0;
    
    public Controlador_Adquisicion(Cliente cliente, Controlador_Cliente controladorC) {
        this.cliente = cliente;
        this.pantalla = new GUIAdquisicion(this);
        this.pantalla.setVisible(true);
        this.controladorCliente = controladorC;

        
        cargarDatosDelJugador();
        
        
        colocarFuentePoder();
        colocarMercado();
        colocarRemolino();

    }
    
    public void cargarDatosDelJugador(){
        pantalla.getLblnickName().setText(cliente.jugador.getNombre());
        pantalla.getLblDinero().setText("Dinero: $" + cliente.jugador.getDinero());
        pantalla.getjLabelCantArmeria().setText("Armerias: " + this.ctdArmerias);
        pantalla.getjLabelCantMina().setText("Minas: " + this.ctdMinas);
        pantalla.getjLabelCantTemplos().setText("Templos: " + this.ctdTemplos);
        pantalla.getjLabelCantMercado().setText("Mercados: " + this.ctdMercados);
        pantalla.getjLabelCantConectores().setText("Conectores: " + this.ctdConectores);
        pantalla.getjLabelCantFuentePoder().setText("Fuente Poder: " + this.ctdFuentesPoder);    
    }
       
    public void iniciarPartida() throws InterruptedException{
        pantalla.getjLabelCarga().setVisible(true);
        pantalla.getButtonMina().setEnabled(false);
        pantalla.getBtnConectar().setEnabled(false);
        pantalla.getButtonTemplo().setEnabled(false);        
        pantalla.getButtonFuente().setEnabled(false);
        pantalla.getButtonArmeria().setEnabled(false);
        pantalla.getButtonMercado().setEnabled(false);
        pantalla.getButtonConector().setEnabled(false);
        pantalla.getjLabelInstruccionColocado().setText("Esperando Jugadores...");
        
        try {
            cliente.controlador.esperarEnemigos(); 
            pantalla.getjLabelCarga().setVisible(true);
            
            //Conectar con el servidor y decir que listo.
        } catch (IOException ex) {
            Logger.getLogger(Controlador_Adquisicion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarMatrizComponentes(){
        if(controladorCliente.getMatrizJugadorComp() != null)
            this.matrizComponentes = controladorCliente.getMatrizJugadorComp();        
        pantalla.getButtonMina().setEnabled(true);
        pantalla.getButtonTemplo().setEnabled(true);        
        pantalla.getButtonFuente().setEnabled(true);
        pantalla.getButtonArmeria().setEnabled(true);
        pantalla.getButtonMercado().setEnabled(true);
        pantalla.getButtonConector().setEnabled(true);
        
        for(int i= 0; i<20; i++){
            for(int j=0; j<20; j++){
                if(this.matrizComponentes[i][j] != null){
                    this.pantalla.matrizLabels[i][j].setIcon(this.matrizComponentes[i][j].getImagen());
                }
                else this.pantalla.matrizLabels[i][j].setIcon(null);
            }
        }
        this.trazarConexiones();
    }
        
    public void agregarElementoComprado(Componente.tipoComponente elemento){
        if(elemento == Componente.tipoComponente.Armeria) this.ctdArmerias++;
        else if(elemento == Componente.tipoComponente.Mina) this.ctdMinas++;
        else if(elemento == Componente.tipoComponente.Mercado) this.ctdMercados++;
        else if(elemento == Componente.tipoComponente.Templo) this.ctdTemplos++;
        else if(elemento == Componente.tipoComponente.Conector) this.ctdConectores++;
        else if(elemento == Componente.tipoComponente.FuenteEnergia) this.ctdFuentesPoder++;
        ctdTotalElementos++;
        cargarDatosDelJugador();
        System.out.println(ctdMinas +" "+ ctdConectores +" "+ ctdMercados +" "+ ctdFuentesPoder +" "+ ctdTemplos +" "+ ctdArmerias);
    }
    
 
    public int verificarOpcionExtra(ItemCompra item){
        if(item == ItemCompra.ARMERIA) return (pantalla.getComboBoxArmeria().getSelectedIndex()+1);
        else if(item == ItemCompra.MINA)  return (pantalla.getComboBoxMina().getSelectedIndex()+1);
        //Si no es ninguna no debemos hacer nada difernete
        else return 0;
    }
    
    public void ejecutarCompra(int precio, ItemCompra item, boolean isVert){
        
        if(this.cliente.jugador.getDinero()< precio) JOptionPane.showMessageDialog(null, "No Tiene suficiente dinero!");
        else if(isComprado) JOptionPane.showMessageDialog(null, "Termine la compra antes de colocar otra ficha!"); //todo: cambiar esto para desactivar los botones o algo asi
        else{
            cliente.jugador.setDinero(cliente.jugador.getDinero()-precio);
        
            int extra = verificarOpcionExtra(item);
            componenteAux = FactoryComponente.crearComponente(item, extra);
            System.out.println(extra);
        
            if(item== ItemCompra.ARMERIA){
                Armeria armeriaAux = (Armeria) componenteAux;
                armeriaAux.arma.setControlador(controladorCliente);
                componenteAux = armeriaAux;
                
            }
            
             if(item == ItemCompra.MINA){
                Mina minaAux =(Mina) componenteAux;
                ThreadProductoraAcero threadAux = new ThreadProductoraAcero(minaAux, this.controladorCliente.getCliente().jugador.getSemaforoAcero(),this.controladorCliente);
                minaAux.setThreadProductor(threadAux);
                this.controladorCliente.getThreadsProductores().add(threadAux);
                threadAux.start();
            }
            
            if(isVert) componenteAux.setIsVertical(isVert);
            isComprado=true;
        
            pantalla.getLabelInstruccion().setVisible(true);
            
            agregarElementoComprado(componenteAux.getTipoComponente());
            pantalla.getLblDinero().setText("Dinero: $" + cliente.jugador.getDinero());
                         
        }
    }
   
    public  Componente getComponente(int i, int j){
        return matrizComponentes[i][j]; 
    }
    
    public void trazarConexiones(){
        this.pantalla.getPanelJugador().repaint();
    }
 
    public void pintarConexion(int x1,int  y1,int x2,int y2){
        Graphics graf = pantalla.getPanelJugador().getGraphics();
        graf.drawLine(x1*pantalla.getTAMANNO(), y1*pantalla.getTAMANNO(), x2* pantalla.getTAMANNO(), y2* pantalla.getTAMANNO());
        System.out.println("x1: "+x1*pantalla.getTAMANNO()+" y1: "+ y1*pantalla.getTAMANNO()+" x2: "+ x2* pantalla.getTAMANNO()+" y2: "+y2* pantalla.getTAMANNO());
    }
    
    public void colocarFuentePoder(){
        
        Componente componenteNuevo = FactoryComponente.crearComponente(FUENTEDEENERGIA, 0);
        Vertice vertice = new Vertice(componenteNuevo);
        componenteNuevo.setVertice(vertice);
        grafo.addVertice(vertice);
        
        int numero = 0;
        for(int i = 0;i<cliente.jugador.getNombre().length();i++)  numero = (int) (Math.random() * 18) + 1;  
        if(pantalla.matrizLabels[numero][numero].getIcon() == null
                && pantalla.matrizLabels[numero][numero+1].getIcon() == null
                && pantalla.matrizLabels[numero+1][numero].getIcon() == null
                && pantalla.matrizLabels[numero+1][numero+1].getIcon() == null){
            
            matrizComponentes[numero][numero] = componenteNuevo;
            matrizComponentes[numero][numero+1] = componenteNuevo;
            matrizComponentes[numero+1][numero] = componenteNuevo;
            matrizComponentes[numero+1][numero+1] = componenteNuevo; 
            
            componenteNuevo.setPoint(new Point(numero,numero));
            
            pantalla.matrizLabels[numero][numero].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Fuente.png")));
            pantalla.matrizLabels[numero+1][numero].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Fuente.png")));
            pantalla.matrizLabels[numero][numero+1].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Fuente.png")));
            pantalla.matrizLabels[numero+1][numero+1].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Fuente.png")));
            
        } 
        else colocarFuentePoder();
    }
    public void colocarRemolino(){
        
        Componente componenteNuevo = FactoryComponente.crearComponente(REMOLINO, 0);
        Vertice vertice = new Vertice(componenteNuevo);
        componenteNuevo.setVertice(vertice);
        grafo.addVertice(vertice);
        
        int numero = 0;
        for(int i = 0;i<cliente.jugador.getNombre().length();i++)  numero = (int) (Math.random() * 18) + 1;  
        while(pantalla.matrizLabels[numero][numero].getIcon() != null) {
            for(int i = 0;i<cliente.jugador.getNombre().length();i++)  numero = (int) (Math.random() * 18) + 1;  
        }
        pantalla.matrizLabels[numero][numero].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Remolino.png"))); 
        matrizComponentes[numero][numero] = componenteNuevo; 
        componenteNuevo.setPoint(new Point(numero,numero));
   
        for(int i = 0;i<cliente.jugador.getNombre().length();i++)  numero = (int) (Math.random() * 18) + 1;  
        
        
        while(pantalla.matrizLabels[numero][numero].getIcon() != null) {
            for(int i = 0;i<cliente.jugador.getNombre().length();i++)  numero = (int) (Math.random() * 18) + 1;  
        }
        
        pantalla.matrizLabels[numero][numero].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Remolino.png"))); 
        matrizComponentes[numero][numero] = componenteNuevo;        
        componenteNuevo.setPoint(new Point(numero,numero));
    }
    
    public void colocarMercado(){
        
        Componente componenteNuevo = FactoryComponente.crearComponente(MERCADO, 0);
        Vertice vertice = new Vertice(componenteNuevo);
        componenteNuevo.setVertice(vertice);
        grafo.addVertice(vertice);
        
        int numero = 0;
        for(int i = 0;i<cliente.jugador.getNombre().length();i++)  numero = (int) (Math.random() * 18) + 1;  
        if(numero<19 &&
                pantalla.matrizLabels[numero][numero].getIcon() == null
                && pantalla.matrizLabels[numero][numero+1].getIcon() == null){
                    
                matrizComponentes[numero][numero] = componenteNuevo;
                matrizComponentes[numero][numero+1] = componenteNuevo;
                
                componenteNuevo.setPoint(new Point(numero,numero));
                
                pantalla.matrizLabels[numero][numero].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Mercado.png")));
                pantalla.matrizLabels[numero][numero+1].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Mercado.png")));
        }
        else colocarMercado();
        
    }
    
    //Getter && Settter

    public  boolean isIsConectar() {
        return isConectar;
    }

    public  void setIsConectar() {
        this.isConectar = !isConectar;
        if(isConectar && !isMover && !isComprado){
           pantalla.getBtnConectar().setText("Conectando");
           pantalla.getBtnConectar().setBackground(Color.green);
        }
            
        else{
           isConectar = false;
           pantalla.getBtnConectar().setText("Conectar");
           pantalla.getBtnConectar().setBackground(Color.red);
        } 
          
    }
    
    public GUIAdquisicion getPantalla() {
        return pantalla;
    }
    
    public void setPantalla(GUIAdquisicion pantalla) {
        this.pantalla = pantalla;
    }
    
    public String getNomJugador(){
       return cliente.jugador.getNombre();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FactoryComponente getFactoryComponente() {
        return factoryComponente;
    }

    public void setFactoryComponente(FactoryComponente factoryComponente) {
        this.factoryComponente = factoryComponente;
    }

    public Controlador_Cliente getControladorCliente() {
        return controladorCliente;
    }

    public void setControladorCliente(Controlador_Cliente controladorCliente) {
        this.controladorCliente = controladorCliente;
    }

    public boolean isIsComprado() {
        return isComprado;
    }

    public void setIsComprado(boolean isComprado) {
        this.isComprado = isComprado;
    }

    public boolean isIsArrIzq() {
        return isArrIzq;
    }

    public void setIsArrIzq(boolean isArrIzq) {
        this.isArrIzq = isArrIzq;
    }

    public Componente getComponenteAux() {
        return componenteAux;
    }

    public void setComponenteAux(Componente componenteAux) {
        this.componenteAux = componenteAux;
    }

    public Conector getConectorAux() {
        return conectorAux;
    }

    public void setConectorAux(Conector conectorAux) {
        this.conectorAux = conectorAux;
    }

    public Componente[][] getMatrizComponentes() {
        return matrizComponentes;
    }

    public void setMatrizComponentes(Componente[][] matrizComponentes) {
        this.matrizComponentes = matrizComponentes;
    }

    public static Grafo getGrafo() {
        return grafo;
    }

    public static void setGrafo(Grafo grafo) {
        Controlador_Adquisicion.grafo = grafo;
    }

    public int getCtdMinas() {
        return ctdMinas;
    }

    public void setCtdMinas(int ctdMinas) {
        this.ctdMinas = ctdMinas;
    }

    public int getCtdFuentesPoder() {
        return ctdFuentesPoder;
    }

    public void setCtdFuentesPoder(int ctdFuentesPoder) {
        this.ctdFuentesPoder = ctdFuentesPoder;
    }

    public int getCtdTemplos() {
        return ctdTemplos;
    }

    public void setCtdTemplos(int ctdTemplos) {
        this.ctdTemplos = ctdTemplos;
    }

    public int getCtdArmerias() {
        return ctdArmerias;
    }

    public void setCtdArmerias(int ctdArmerias) {
        this.ctdArmerias = ctdArmerias;
    }

    public int getCtdTotalElementos() {
        return ctdTotalElementos;
    }

    public void setCtdTotalElementos(int ctdTotalElementos) {
        this.ctdTotalElementos = ctdTotalElementos;
    }
     
}
