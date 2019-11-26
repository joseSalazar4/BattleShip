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
import battleship.Oceano;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikom
 */
public class Torpedo extends AbstractArma {

    public Torpedo(){
        super();
        costo = 500;
        nombre = "Torpedo";
        escudo = this.controlador.getCliente().jugador.getEscudo();
    }
    
    @Override
    //impacta una sola casilla (1x1). Fabricarlo tiene un costo de 500 Kg.
    public Oceano atacar() {
        if(casilla != null && oceano != null){
            Point point = new Point(casilla.getJ(), casilla.getI());
            Componente componente = oceano.matrizComponentes[point.y][point.x];
            if(!(componente instanceof EspacioMuerto)){
                try {
                    if(cobrarAcero()) golpear(componente, oceano, point);
                    else oceano.historialAtaque += "\n ACERO INSUFICIENTE";
                } catch (InterruptedException ex) {
                    Logger.getLogger(Torpedo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else oceano.historialAtaque += "\n SELECCIONE UNA CASILLA QUE NO HAYA SIDO DESTRUIDA";
        }
        else oceano.historialAtaque += "\n SELECCIONE UNA CASILLA";
        
        return oceano;
    }
    
}
