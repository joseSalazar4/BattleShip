/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;
import Cliente.*;
/**
 *
 * @author mikom
 */
public class Jugador {
    String nombre;
    boolean perdio;
    int dinero;
    Barco barcos[];
    Fabrica fabricas[];
    Arma armas[];
    Componente componentes[];

    Jugador(){
        nombre = "";
        perdio = false;
        dinero = 4000;
        fabricas[0] = new Fabrica();
        componentes[0] = new Componente();
    }
    
}
