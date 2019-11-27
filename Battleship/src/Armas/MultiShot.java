/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Armas;

import Componentes.Componente;
import Componentes.EspacioMuerto;
import Cliente.DatosDeAtaque;
import Controlador.marcarCasillaEnemigo;
import battleship.Oceano;
import java.awt.Point;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikom
 */
public class MultiShot extends AbstractArma  {
    Random random = new Random();
    public MultiShot(){
        super();
        costo = 1000;
        super.nombre = "Multishot";
    }
    
    
    @Override
        //Si impacta una casilla genera 4 tiros aleatorios más recursivamente. Por cada 
    
    
    
    public Oceano atacar(marcarCasillaEnemigo casilla) {
        if(casilla != null && oceano != null){
            Point point = new Point(casilla.getJ(), casilla.getI());
            Componente componente = oceano.matrizComponentes[point.y][point.x];
            if(!(componente instanceof EspacioMuerto)){
                try {
                    if(cobrarAcero()){
                        boolean golpe = golpear(componente, oceano, point, datos);
                        if(golpe){
                            datos.historialAtaque += "\n" + jugador + "obtuvo CUATRO torpedos";
                            ataqueMultiShot();
                        }
                    }
                    else datos.historialAtaque += "\n ACERO INSUFICIENTE";                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(MultiShot.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else datos.historialAtaque += "\n SELECCIONE UNA CASILLA QUE NO HAYA SIDO DESTRUIDA";
        }
        else datos.historialAtaque += "\n SELECCIONE UNA CASILLA";
        
        return super.oceano;
    }
    
    public void ataqueMultiShot(){
        for(int i = 0; i<4; i++){
            Point pointRandom = new Point(random.nextInt(19), random.nextInt(19));
            Componente componente = oceano.matrizComponentes[pointRandom.y][pointRandom.x];
            if(!(componente instanceof EspacioMuerto)){
             golpear(componente, oceano, pointRandom, datos);     
            } 
        }
    } 
}
    

