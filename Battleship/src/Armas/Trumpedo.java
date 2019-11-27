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

public class Trumpedo extends AbstractArma {
    public boolean comprado = false;
    public int torpedosRestantes = 10;
    public Trumpedo(){
        super();
        //costo = 5000;
        costo = 200;

        nombre = "Trumpedo";
        
    }
    
    public Oceano atacar(marcarCasillaEnemigo casilla){
        try {
            if(casilla != null && oceano != null){
                Point point = new Point(casilla.getJ(), casilla.getI());
                Componente componente = oceano.matrizComponentes[point.y][point.x];
                if(!(componente instanceof EspacioMuerto)){  
                    if(comprado){
                      datos.historialAtaque += "Torpedo #" +torpedosRestantes + "\n";
                      golpear(componente, oceano, point, datos);  
                      if(torpedosRestantes > 1) torpedosRestantes--;
                      else comprado = false;
                    }      
                    else if(cobrarAcero() && torpedosRestantes > 0){
                      datos.historialAtaque += "Trumpedo Comprado...\n";
                      torpedosRestantes = 10;
                      datos.historialAtaque += "Torpedo #" +torpedosRestantes + "\n";
                      golpear(componente, oceano, point, datos);  
                      comprado = true;
                    }     
                    else datos.historialAtaque += "\n ACERO INSUFICIENTE"; 
                }
                else datos.historialAtaque += "\n SELECCIONE UNA CASILLA QUE NO HAYA SIDO DESTRUIDA"; 
            }
            else datos.historialAtaque += "\n SELECCIONE UNA CASILLA QUE NO HAYA SIDO DESTRUIDA";
        } catch (InterruptedException ex) {
            Logger.getLogger(Trumpedo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return oceano;
    } 
    
}
