/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author mikom
 */
public class Conector extends Componente {
    
    Conector(){
        nombre = "Conector";
        this.is1x1 = true;
        this.imagen = new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/Conector.png"));
        
    }
}
