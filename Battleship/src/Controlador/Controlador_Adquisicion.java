/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.GUIAdquisicion;
import battleship.Componente;
import Cliente_Servidor.Cliente.Cliente;
import battleship.FactoryComponente;
import battleship.ItemCompra;
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
    public static boolean isComprado = false, isMover = false, isArrIzq = false;
    public static Componente componenteAux = null, componenteAux2 = null;
    public static Componente[][] matrizComponentes = new Componente[20][20];
    public Graphics g = pantalla.getPanelJugador().getGraphics();

    public Controlador_Adquisicion(Cliente cliente) {
        this.cliente = cliente;
        this.pantalla = new GUIAdquisicion(this);
        this.pantalla.setVisible(true);
        X1= Y1 = 0;
        X2=  Y2 = 900;
        
        cargarDatosDelJugador();
         

         

        g.setColor(Color.red);
        g.drawLine(X1, Y1, X2, Y2);
        g.drawRect(X1, X1, 20, 40);
        colocarRemolino();
        
    }

    
    public void cargarDatosDelJugador(){
        pantalla.getLblnickName().setText(cliente.jugador.getNombre());
        pantalla.getLblDinero().setText("Dinero: $" + cliente.jugador.getDinero());
        
    }
    
    JPanel panel = new JPanel() {
       @Override
    public void paintComponent(Graphics g) {
           super.paintComponent(g);
           g.setColor(Color.BLACK);                   
           g.drawLine(0,0,300,300);
       }
    }
    
    public void adquirirTemplo(){
        //Templo templo = new Templo();
    }
    
    public void adquirirMercado(){
        
    }
    
    public void iniciarPartida(){
        pantalla.getButtonMina().setEnabled(false);
        pantalla.getButtonTemplo().setEnabled(false);        
        pantalla.getButtonArmeria().setEnabled(false);
        pantalla.getButtonMercado().setEnabled(false);
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
            pantalla.getLabelInstruccion().setVisible(true);
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
        //pantalla.matrizComponentes[numero][numero].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Tornado.png"))); 
        
        //Segundo Remolino
        for(int i = 0;i<cliente.jugador.getNombre().length();i++)  numero = (int) (Math.random() * 18) + 1;  
        pantalla.matrizLabels[numero][numero].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Remolino.png"))); 
        //pantalla.matrizComponentes[numero][numero].setIcon(new ImageIcon(getClass().getResource("/Vista/Resources/Tornado.png"))); 
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
