/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Componentes.Componente;
import static Componentes.Componente.tipoComponente.Templo;

/**
 *
 * @author mikom
 */
public class Templo extends Componente{
    
    public Templo(){
        tipoComponente = Templo;
        this.nombre = "Templo";
        this.imagen=new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/Templo.png"));
    }
}
