/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Armas;

/**
 *
 * @author mikom
 */
public class MultiShot extends AbstractArma  {
    MultiShot(){
        costo = 1000;
    }
    @Override
        //Si impacta una casilla genera 4 tiros aleatorios más recursivamente. Por cada 
    public void atacar() {
	
    }
    
}