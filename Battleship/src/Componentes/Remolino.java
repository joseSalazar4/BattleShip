/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Componentes.Componente;
import Componentes.Armeria;
import static Componentes.Componente.tipoComponente.Remolino;
import java.io.Serializable;

/**
 *
 * @author mikom
 */

public class Remolino extends Componente implements Serializable{
    
    Armeria armaUsada;
    
    public Remolino(){      
        this.tipoComponente = Remolino;
        armaUsada = null;
        this.is1x1 = true;
        nombre = "Remolino";
        this.imagen=new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/Remolino.png"));
    }
}
