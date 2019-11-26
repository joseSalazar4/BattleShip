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
    public MultiShot(){
        costo = 1000;
        nombre = "Multishot";
    }
    @Override
        //Si impacta una casilla genera 4 tiros aleatorios más recursivamente. Por cada 
    public void atacar() {
	
    }
    
}
