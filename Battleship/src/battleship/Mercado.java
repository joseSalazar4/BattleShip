/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import Cliente.Jugador;
import static battleship.Componente.tipoComponente.Mercado;

/**
 *
 * @author mikom
 */
public class Mercado extends Componente {
    Jugador comprador, vendedor;
    Componente objetoVenta, objetoComprado;

            
   public Mercado(){
       this.tipoComponente = Mercado;
        nombre = "Mercado";
        this.imagen=new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/Mercado.png"));
        objetoVenta = objetoComprado = null;
        comprador = vendedor = null;
        this.is1x1 = false;
    }
}
