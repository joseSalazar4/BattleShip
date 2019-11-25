/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Componentes.Componente;

/**
 *
 * @author mikom
 */
public class EspacioMuerto extends Componente {
    
    EspacioMuerto(){
        is1x1 = true;
        imagen = new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/golpe.png"));
    }
}
