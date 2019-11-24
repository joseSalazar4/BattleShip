/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.GUIAdquisicion;
import battleship.Componente;
import Cliente_Servidor.Cliente.Cliente;
import Grafo.Grafo;
import Grafo.Vertice;
import static battleship.Componente.tipoComponente.Remolino;
import static battleship.Componente.tipoComponente.Conector;
import battleship.FactoryComponente;
import battleship.ItemCompra;
import static battleship.ItemCompra.REMOLINO;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

    public class Controlador_Adquisicion {
    Cliente cliente;
    static GUIAdquisicion pantalla; 
    FactoryComponente factoryComponente;
    private int X1, Y1, X2, Y2;
    private Controlador_Cliente controladorCliente;
    public static boolean isComprado = false, isMover = false, isArrIzq = false;
    public static Componente componenteAux = null;
    public static Componente[][] matrizComponentes = new Componente[20][20];
    public static Grafo grafo = new Grafo();
   
    private int ctdMinas = 0, ctdConectores = 0, ctdMercados = 0, ctdFuentesPoder = 0, ctdTemplos = 0, ctdArmerias = 0, ctdTotalElementos = 0;
    
    public Controlador_Adquisicion(Cliente cliente) {
        this.cliente = cliente;
        this.pantalla = new GUIAdquisicion(this);
        this.pantalla.setVisible(true);
        X1= Y1 = 0;
        X2=  Y2 = 900;
        
        cargarDatosDelJugador();
        
        
         
        colocarMercado();
        colocarRemolino();
        colocarFuentePoder();

        
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
        controladorCliente.setMatrizJugadorComp(matrizComponentes);
        pantalla.getButtonMina().setEnabled(false);
        pantalla.getButtonTemplo().setEnabled(false);        
        pantalla.getButtonFuente().setEnabled(false);
        pantalla.getButtonArmeria().setEnabled(false);
        pantalla.getButtonMercado().setEnabled(false);
        pantalla.getButtonConector().setEnabled(false);
        
        try {
            cliente.controlador.esperarEnemigos();
            //Conectar con el servidor y decir que listo.
        } catch (IOException ex) {
            Logger.getLogger(Controlador_Adquisicion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    
    
    
    public void ejecutarCompra(int precio, ItemCompra item, boolean isVert){
        
        if(this.cliente.jugador.getDinero()< precio) JOptionPane.showMessageDialog(null, "No Tiene suficiente dinero!");
        else if(isComprado) JOptionPane.showMessageDialog(null, "Termine la compra antes de colocar otra ficha!"); //todo: cambiar esto para desactivar los botones o algo asi
        else{
            cliente.jugador.setDinero(cliente.jugador.getDinero()-precio);
            
            int extra = verificarOpcionExtra(item);
            componenteAux = FactoryComponente.crearComponente(item, extra);
            
            if(isVert) componenteAux.setIsVertical(isVert);
            isComprado=true;
            
            componenteAux.getNombre();
            pantalla.getLabelInstruccion().setVisible(true);
            
            agregarElementoComprado(componenteAux.getTipoComponente());
            pantalla.getLblDinero().setText("Dinero: $" + cliente.jugador.getDinero());
            
            //Agregar el arma comprada al jugador
            esta metiendo todo al combox armas , tenemos un array de todo lo que tiene el men?
            cliente.jugador.getArmasCompradas().add(componenteAux);             
        }
    }
   
    public static Componente getComponente(int i, int j){
        return matrizComponentes[i][j]; 
    }
    
    public void trazarConexiones(){
        for(int i =0 ;i<this.ctdTotalElementos;i++){
            for(int j = 0 ;j<this.ctdTotalElementos ;j++){
                
                Componente comp = matrizComponentes[i][j];
                Vertice vertice= comp.getVertice();
                if(comp.getTipoComponente() != Conector && matrizComponentes[i][j]!=null){
                    for(int k = 0 ;k<vertice.getAristas().size()  ;k++){
                        Componente dest = vertice.getAristas().get(k).getDestination().getComponente();
                        pintarConexion(comp.getPoint().x,comp.getPoint().y,dest.getPoint().x,dest.getPoint().y);
                    }
                }
            }
        }
    }
    
    public void pintarConexion(int x1,int  y1,int x2,int y2){
        Graphics graf = pantalla.getPanelJugador().getGraphics();
        graf.drawLine(x1, y1, x2, y2);
    }
    
    public void trazarConexionesConectores(){
        
    }
    
    public void colocarFuentePoder(){
        int numero = 0;
        for(int i = 0;i<cliente.jugador.getNombre().length();i++)  numero = (int) (Math.random() * 18) + 1;  
        if(pantalla.matrizLabels[numero][numero].getIcon() == null
                && pantalla.matrizLabels[numero][numero+1].getIcon() == null
                && pantalla.matrizLabels[numero+1][numero].getIcon() == null
                && pantalla.matrizLabels[numero+1][numero+1].getIcon() == null){
            
            pantalla.matrizLabels[numero][numero].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Fuente.png")));
            pantalla.matrizLabels[numero+1][numero].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Fuente.png")));
            pantalla.matrizLabels[numero][numero+1].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Fuente.png")));
            pantalla.matrizLabels[numero+1][numero+1].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Fuente.png")));
            
        } 
        else colocarFuentePoder();
    }
    public void colocarRemolino(){
        //Colocar el tornado
        //Obtener un numero realmente aleatorio al darle un seed
        //Primero Remolino
        int numero = 0;
        for(int i = 0;i<cliente.jugador.getNombre().length();i++)  numero = (int) (Math.random() * 18) + 1;  
        if(pantalla.matrizLabels[numero][numero].getIcon() == null){
        pantalla.matrizLabels[numero][numero].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Remolino.png"))); 
        matrizComponentes[numero][numero] = FactoryComponente.crearComponente(REMOLINO, 0);
        }
        else colocarRemolino();
        //Segundo Remolino
        for(int i = 0;i<cliente.jugador.getNombre().length();i++)  numero = (int) (Math.random() * 18) + 1;  
        if(pantalla.matrizLabels[numero][numero].getIcon() == null){
        pantalla.matrizLabels[numero][numero].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Remolino.png"))); 
        matrizComponentes[numero][numero] = FactoryComponente.crearComponente(REMOLINO, 0);        
        }
        else colocarRemolino();        
    }
    public void colocarMercado(){
        int numero = 0;
        for(int i = 0;i<cliente.jugador.getNombre().length();i++)  numero = (int) (Math.random() * 18) + 1;  
        if(numero<19 &&
                pantalla.matrizLabels[numero][numero].getIcon() == null
                && pantalla.matrizLabels[numero][numero+1].getIcon() == null){
                    
                pantalla.matrizLabels[numero][numero].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Mercado.png")));
                pantalla.matrizLabels[numero][numero+1].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Mercado.png")));
        }
        else colocarMercado();
        
    }
     
      
    public int verificarOpcionExtra(ItemCompra item){
        if(item.equals("ARMERIA")) return pantalla.getComboBoxArmeria().getSelectedIndex();
        else if(item.equals("MINA"))  return pantalla.getComboBoxMina().getSelectedIndex();
        //Si no es ninguna no debemos hacer nada difernete
        else return 0;
    }
    
    //Getter && Settter
    public GUIAdquisicion getPantalla() {
        return pantalla;
    }

    public void setPantalla(GUIAdquisicion pantalla) {
        this.pantalla = pantalla;
    }
    
    public String getNomJugador(){
       return cliente.jugador.getNombre();
    }
     
}
