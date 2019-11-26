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
public class Torpedo extends AbstractArma {

    public Torpedo(){
        costo = 500;
        nombre = "Torpedo";
    }
    @Override
    //impacta una sola casilla (1x1). Fabricarlo tiene un costo de 500 Kg.
    public void atacar() {
        

    }
    
}
