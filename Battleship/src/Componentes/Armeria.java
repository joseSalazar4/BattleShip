/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Armas.AbstractArma;
import static Componentes.Componente.tipoComponente.Armeria;

/**
 *
 * @author mikom
 */

//USAR FACTORY METHOD
public class Armeria extends Componente{
    public AbstractArma arma;
    public Armeria(int tipoArmaProducir){
        this.tipoComponente = Armeria;
        this.is1x1 = false;
        this.is2x2 = false;
        this.imagen=new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/Armeria.png"));
        
        //Torpedo, Multi-Shot, Bomba, Trumpedo
        switch(tipoArmaProducir){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
           
        }
        
    }
    
    public void setTipoComponente(tipoComponente comp){
        this.tipoComponente = comp;
    }
}
