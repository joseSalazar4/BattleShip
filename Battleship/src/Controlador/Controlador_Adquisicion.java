/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.GUIAdquisicion;
import battleship.Componente;
import javax.swing.JComboBox;
import Cliente_Servidor.Cliente.Cliente;
import javax.swing.JOptionPane;

public class Controlador_Adquisicion {
    Cliente cliente;
    GUIAdquisicion pantalla; 
    
    public static boolean isComprado = false, isMover = false, isArrIzq = false;
    public static Componente componenteAux = null, componenteAux2 = null;
    public static Componente[][] matrizComponentes = new Componente[20][20];
 

    public Controlador_Adquisicion(Cliente cliente) {
        this.cliente = cliente;
        this.pantalla = new GUIAdquisicion(this);
        this.pantalla.setVisible(true);
        cargarDatosDelJugador();
        
        JComboBox comboBoxMina = this.pantalla.getComboBoxMina();
        comboBoxMina.removeAllItems(); //Eliminar los default
        
        comboBoxMina.addItem("Nivel 1");
        comboBoxMina.addItem("Nivel 2");
        comboBoxMina.addItem("Nivel 3");
        comboBoxMina.addItem("Nivel 4");
        comboBoxMina.addItem("Nivel 5");
        
        JComboBox comboBoxArmeria = this.pantalla.getComboBoxArmeria();
        comboBoxArmeria.removeAllItems();//Eliminar los defaults
        
        comboBoxArmeria.addItem("Bomba"); 
        comboBoxArmeria.addItem("Torpedo");
        comboBoxArmeria.addItem("Trumpedo");
        comboBoxArmeria.addItem("Multi-shot");
        
        JComboBox comboBoxPosicion = this.pantalla.getComboBoxPos();
        
        comboBoxArmeria.removeAllItems();//Eliminar los defaults

        comboBoxPosicion.addItem("Horizontal");
        comboBoxPosicion.addItem("Vertical");
    }

    public void cargarDatosDelJugador(){
        pantalla.getLblnickName().setText(cliente.jugador.getNombre());
        pantalla.getLblDinero().setText("Dinero: $" + cliente.jugador.getDinero());
        
    }
    
    
    public void adquirirTemplo(){
        Templo templo = new Templo();
    }
    
    public void adquirirMercado(){
        
    }
    
    public void ejecutarCompra(int precio){
        if(this.cliente.jugador.getDinero()< precio) JOptionPane.showMessageDialog(null, "No Tiene suficiente dinero!");
        else{
        cliente.jugador.setDinero(cliente.jugador.getDinero()-precio);
        pantalla.getLabelInstruccion().setVisible(true);
        //factory.Comprar();
        }
    }
    
    public void adquirirArma(){
        Armeria armeria = new Armeria();
    }
    
    public static Componente getComponente(int i, int j){
        return matrizComponentes[i][j]; 
    }
      
    //Getter && Settter
    public GUIAdquisicion getPantalla() {
        return pantalla;
    }

    public void setPantalla(GUIAdquisicion pantalla) {
        this.pantalla = pantalla;
    }
    
     
}
