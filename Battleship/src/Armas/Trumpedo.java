/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Armas;

import Componentes.Componente;
import Componentes.EspacioMuerto;
import battleship.Oceano;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Trumpedo extends AbstractArma {

    public Trumpedo(){
        super();
        costo = 5000;
        nombre = "Trumpedo";
    }
    
    public Oceano atacar() {
        try {
            if(cobrarAcero()){
                
                if(casilla != null && oceano != null){
                    Point point = new Point(casilla.getJ(), casilla.getI());
                    Componente componente = oceano.matrizComponentes[point.y][point.x];
                    if(!(componente instanceof EspacioMuerto)){   
                        golpear(componente, oceano, point);
                    }
                    else oceano.historialAtaque += "\n SELECCIONE UNA CASILLA QUE NO HAYA SIDO DESTRUIDA";
                    
                }
                else oceano.historialAtaque += "\n SELECCIONE UNA CASILLA QUE NO HAYA SIDO DESTRUIDA";
            }
            else oceano.historialAtaque += "\n ACERO INSUFICIENTE";
        } catch (InterruptedException ex) {
            Logger.getLogger(Trumpedo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return oceano;
    } 
    
}
