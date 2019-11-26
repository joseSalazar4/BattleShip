/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Armas;

import Controlador.Controlador_Cliente;

/**
 *
 * @author mikom
 */
public class Trumpedo extends AbstractArma {

    public Trumpedo(Controlador_Cliente controlador){
        super(controlador);
        costo = 5000;
        nombre = "Trumpedo";
    }
    @Override
    public void atacar() {
        
    }
    
}
