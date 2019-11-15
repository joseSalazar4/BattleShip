/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Cliente_Servidor.Cliente.Cliente;
import Vista.GUIAdquisicion;
import javax.swing.JComboBox;

public class Controlador_Adquisicion {
    Cliente cliente;
    GUIAdquisicion pantalla; 

    public Controlador_Adquisicion(Cliente cliente) {
        this.cliente = cliente;
        this.pantalla = new GUIAdquisicion(this);
        this.pantalla.setVisible(true);
        
        
        JComboBox comboBoxMina = new JComboBox();

        comboBoxMina.addItem("Nivel 1");
        comboBoxMina.addItem("Nivel 2");
        comboBoxMina.addItem("Nivel 3");
        comboBoxMina.addItem("Nivel 4");
        comboBoxMina.addItem("Nivel 5");
        
        
        JComboBox comboBoxArmeria = new JComboBox();
        comboBoxArmeria.addItem("Bomba"); 
        comboBoxArmeria.addItem("Torpedo");
        comboBoxArmeria.addItem("Trumpedo");
        comboBoxArmeria.addItem("Multi-shot");
        
        
        
        this.pantalla.setComboBoxArmeria(comboBoxArmeria);
        this.pantalla.setComboBoxMina(comboBoxMina);
    }

    public void cargarDatosDelJugador(){
        pantalla.getLblnickName().setText(cliente.jugador.getNombre());
        pantalla.getLblDinero().setText("Dinero: " + cliente.jugador.getDinero());
        
    }
    
    //Getter && Settter
    public GUIAdquisicion getPantalla() {
        return pantalla;
    }

    public void setPantalla(GUIAdquisicion pantalla) {
        this.pantalla = pantalla;
    }
}
