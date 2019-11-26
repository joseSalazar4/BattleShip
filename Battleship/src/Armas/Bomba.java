/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Armas;

import battleship.Oceano;

/**
 *
 * @author mikom
 */
public class Bomba extends AbstractArma {

    public Bomba(){
        super();
        costo = 2000;
        nombre = "Bomba";
    }
    
    @Override
    public Oceano atacar() {
        
        return this.oceano;
    }    
}
