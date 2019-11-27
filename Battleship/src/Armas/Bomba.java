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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bomba extends AbstractArma {
    public boolean comprado = false;
    public int bombasRestantes = 3;
    Random random =  new Random();
    public Bomba(){
        costo = 2000;
        nombre = "Bomba";
    }
    
    @Override
    
    //ALCANCE DE 2X1 O 1X2 tons una linea de dos bloques Tratara igual que las imagenes derecha y abajo tons menos validaciones
    public Oceano atacar(marcarCasillaEnemigo casilla){
        try {
            if(casilla != null && oceano != null){
                Point point = new Point(casilla.getJ(), casilla.getI());
                Componente componente = oceano.matrizComponentes[point.y][point.x];
                if(!(componente instanceof EspacioMuerto)){  
                    if(comprado){
                        datos.historialAtaque += bombasRestantes + "-";
                        datos.historialAtaque += "Bomba #"+bombasRestantes+"\n";
                        golpear(componente, oceano, point, datos); 
                        golpear(componente, oceano, getNextPoint(point), datos);
                        if(bombasRestantes > 1) bombasRestantes--;
                        else comprado = false;
                    }      
                    else if(cobrarAcero() && bombasRestantes > 0){
                        datos.historialAtaque += "Bomba Comprada...\n";
                        bombasRestantes = 3;
                        datos.historialAtaque += "Bomba #"+bombasRestantes+"\n";
                        datos.historialAtaque += bombasRestantes + "-";
                        golpear(componente, oceano, point, datos);  
                        golpear(componente, oceano, getNextPoint(point), datos);
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
    
    
    public Point getNextPoint(Point point){
        int direccion = random.nextInt(4);
        switch(direccion){
            case 0:
                return new Point(point.x, point.y+1);
            case 1:
                return new Point(point.x+1, point.y);
            case 2:
                return new Point(point.x, point.y-1);
            case 3:
                return new Point(point.x-1, point.y);
                
            default: return new Point(point.x-1, point.y);
      }
    }
}
