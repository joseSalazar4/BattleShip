/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.GUIAdquisicion;
import battleship.Componente;
import Cliente_Servidor.Cliente.Cliente;
import static battleship.Componente.tipoComponente.Remolino;
import battleship.FactoryComponente;
import battleship.ItemCompra;
import static battleship.ItemCompra.REMOLINO;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

    public class Controlador_Adquisicion {
    Cliente cliente;
    static GUIAdquisicion pantalla; 
    FactoryComponente factoryComponente;
    private int X1, Y1, X2, Y2;
    private Controlador_Cliente controladorCliente;
    public static boolean isComprado = false, isMover = false, isArrIzq = false;
    public static Componente componenteAux = null, componenteAux2 = null;
    public static Componente[][] matrizComponentes = new Componente[20][20];
   
    private int ctdMinas = 0, ctdConectores = 0, ctdMercados = 0, ctdFuentesPoder = 0, ctdTemplos = 0, ctdArmerias = 0;
    
    public Controlador_Adquisicion(Cliente cliente) {
        this.cliente = cliente;
        this.pantalla = new GUIAdquisicion(this);
        this.pantalla.setVisible(true);
        X1= Y1 = 0;
        X2=  Y2 = 900;
        
        cargarDatosDelJugador();
        
        Graphics g = pantalla.getPanelJugador().getGraphics();
        g.drawLine(X1, Y1, X2, Y2);
         
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
        controladorCliente.setMatrizJugadorComp(matrizComponentes);
        pantalla.getButtonMina().setEnabled(false);
        pantalla.getButtonTemplo().setEnabled(false);        
        pantalla.getButtonFuente().setEnabled(false);
        pantalla.getButtonArmeria().setEnabled(false);
        pantalla.getButtonMercado().setEnabled(false);
        pantalla.getButtonConector().setEnabled(false);
        
        cliente.controlador.esperarEnemigos();
        //Conectar con el servidor y decir que listo.
    }
        
    public void agregarElementoComprado(Componente.tipoComponente elemento){
        if(elemento == Componente.tipoComponente.Armeria) this.ctdArmerias++;
        else if(elemento == Componente.tipoComponente.Mina) this.ctdMinas++;
        else if(elemento == Componente.tipoComponente.Mercado) this.ctdMercados++;
        else if(elemento == Componente.tipoComponente.Templo) this.ctdTemplos++;
        else if(elemento == Componente.tipoComponente.Conector) this.ctdConectores++;
        else if(elemento == Componente.tipoComponente.FuenteEnergia) this.ctdFuentesPoder++;
        cargarDatosDelJugador();
        System.out.println(ctdMinas + ctdConectores + ctdMercados +ctdFuentesPoder + ctdTemplos + ctdArmerias);
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
            cliente.jugador.getArmasCompradas().add(componenteAux);             
        }
    }
   
    public void adquirirArma(){
        //Armeria armeria = new Armeria();
    }
    
    public static Componente getComponente(int i, int j){
        return matrizComponentes[i][j]; 
    }
    
    public void colocarRemolino(){
        //Colocar el tornado
        //Obtener un numero realmente aleatorio al darle un seed
        //Primero Remolino
        int numero = 0;
        for(int i = 0;i<cliente.jugador.getNombre().length();i++)  numero = (int) (Math.random() * 18) + 1;  
        pantalla.matrizLabels[numero][numero].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Remolino.png"))); 
        matrizComponentes[numero][numero] = FactoryComponente.crearComponente(REMOLINO, 0);
        
        //Segundo Remolino
        for(int i = 0;i<cliente.jugador.getNombre().length();i++)  numero = (int) (Math.random() * 18) + 1;  
        pantalla.matrizLabels[numero][numero].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Remolino.png"))); 
        matrizComponentes[numero][numero] = FactoryComponente.crearComponente(REMOLINO, 0);        
    }
    
    public void colocarFuentePoder(){
        int numero = 0;
        for(int i = 0;i<cliente.jugador.getNombre().length();i++)  numero = (int) (Math.random() * 18) + 1;  
        pantalla.matrizLabels[numero][numero].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Remolino.png"))); 
        
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
