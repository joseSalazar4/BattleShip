/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Armas;

import Componentes.Componente;
import Componentes.EspacioMuerto;
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
        //costo = 500; //Prueba
        costo = 0;
        nombre = "Torpedo";
    }
    
    @Override
    //impacta una sola casilla (1x1). Fabricarlo tiene un costo de 500 Kg.
    public Oceano atacar(marcarCasillaEnemigo casilla) {
        if(casilla != null && oceano != null){
            Point point = new Point(casilla.getJ(), casilla.getI());
            Componente componente = oceano.matrizComponentes[point.y][point.x];
            if(!(componente instanceof EspacioMuerto)){
                try {
                    if(cobrarAcero()) golpear(componente, oceano, point, datos);
                    else datos.historialAtaque += "\n ACERO INSUFICIENTE";
                } catch (InterruptedException ex) {
                    Logger.getLogger(Torpedo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else datos.historialAtaque += "\n SELECCIONE UNA CASILLA QUE NO HAYA SIDO DESTRUIDA";
        }
        else datos.historialAtaque += "\n SELECCIONE UNA CASILLA";
        
        return super.oceano;
    }
}
