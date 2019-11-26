/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Componentes.Componente;
import static Componentes.Componente.tipoComponente.FuenteEnergia;
import java.io.Serializable;

/**
 *
 * @author mikom
 */
public class FuentePoder extends Componente implements Serializable{
    FuentePoder(){
        
        this.is2x2 = true;
        this.is1x1 = false;
        this.tipoComponente = FuenteEnergia;
        this.imagen=new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/Fuente.png"));
    }
    
}
