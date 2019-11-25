/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import static Componentes.Componente.tipoComponente.Armeria;

/**
 *
 * @author mikom
 */

//USAR FACTORY METHOD
public class Armeria extends Componente{
    
    public Armeria(int tipoArmaProducir){
        this.tipoComponente = Armeria;
        this.is1x1 = false;
        this.is2x2 = false;
        this.imagen=new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/Armeria.png"));
        
    }
    
    public void setTipoComponente(tipoComponente comp){
        this.tipoComponente = comp;
    }
}
