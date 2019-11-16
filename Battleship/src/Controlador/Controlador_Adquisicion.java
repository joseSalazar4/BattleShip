/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import battleship.*;
import Vista.GUIAdquisicion;
import javax.swing.JComboBox;
import Cliente_Servidor.Cliente.Cliente;
import javax.swing.JLabel;

public class Controlador_Adquisicion {
    Cliente cliente;
    GUIAdquisicion pantalla; 

    public Controlador_Adquisicion(Cliente cliente) {
        this.cliente = cliente;
        this.pantalla = new GUIAdquisicion(this);
        this.pantalla.setVisible(true);
        cargarDatosDelJugador();
        
        JComboBox comboBoxMina = this.pantalla.getComboBoxMina();;
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
    }

    public void cargarDatosDelJugador(){
        pantalla.getLblnickName().setText(cliente.jugador.getNombre());
        pantalla.getLblDinero().setText("Dinero: $" + cliente.jugador.getDinero());
        
    }
    
    public void adquirirMina(){
        Mina mina = new Mina(); 
        pantalla.matrizLabels[7][14].setIcon(pantalla.imagenMina.getIcon());
        
        Movimiento movilidad = new Movimiento(pantalla.matrizLabels[7][14]);
    }
    
    public void adquirirTemplo(){
        Templo templo = new Templo();
    }
    public void adquirirMercado(){
        
    }
    
    public void adquirirArma(){
        Armeria armeria = new Armeria();
    }
    
    
    
    //Getter && Settter
    public GUIAdquisicion getPantalla() {
        return pantalla;
    }

    public void setPantalla(GUIAdquisicion pantalla) {
        this.pantalla = pantalla;
    }
    
     
}
