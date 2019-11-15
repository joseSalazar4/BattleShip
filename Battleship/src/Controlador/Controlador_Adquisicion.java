/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Cliente_Servidor.Cliente.Cliente;
import Vista.GUIAdquisicion;

public class Controlador_Adquisicion {
    Cliente cliente;
    GUIAdquisicion pantalla;

    public Controlador_Adquisicion(Cliente cliente) {
        this.cliente = cliente;
        this.pantalla = new GUIAdquisicion(this);
        this.pantalla.setVisible(true);
        cargarDatosDelJugador();
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
