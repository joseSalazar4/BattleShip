/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Armas;

import Controlador.marcarCasillaEnemigo;
import battleship.Oceano;

public class Bomba extends AbstractArma {

    public Bomba(){
        costo = 2000;
        nombre = "Bomba";
    }
    
    @Override
    
    //ALCANCE DE 2X1 O 1X2 tons una linea de dos bloques Tratara igual que las imagenes derecha y abajo tons menos validaciones
    public Oceano atacar(marcarCasillaEnemigo casilla) {
        
        return this.oceano;
    }    
}
