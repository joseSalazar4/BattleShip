/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Armas;

import Componentes.Componente;
import Componentes.EspacioMuerto;
import Controlador.Controlador_Cliente;
import Controlador.marcarCasillaEnemigo;
import java.awt.Point;

/**
 *
 * @author mikom
 */
public class Trumpedo extends AbstractArma {

    public Trumpedo(Controlador_Cliente controlador){
        super(controlador);
        costo = 5000;
        nombre = "Trumpedo";
    }
    public void atacar() {
        if(cobrarAcero()){
            
            marcarCasillaEnemigo casilla = controlador.getLabelEnemigoSeleccionado();
            if(casilla != null && controlador.getOceanoEnemigo() != null){
                Point point = new Point(casilla.getJ(), casilla.getI());
                Componente componente = controlador.getOceanoEnemigo().matrizComponentes[point.y][point.x];
                if(!(componente instanceof EspacioMuerto)){
                    golpear(componente, controlador.getOceanoEnemigo(), point);   
                }
                else controlador.recibirMensajeJuego("SELECCIONE UNA CASILLA QUE NO HAYA SIDO DESTRUIDA");
            }
            else controlador.recibirMensajeJuego("SELECCIONE UNA CASILLA");
        
            
        }
        else controlador.recibirMensajeJuego("ACERO INSUFICIENTE");
    }
    
}
