/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;
import battleship.Fabrica;
import battleship.Componente;
import battleship.Armeria;
/**
 *
 * @author mikom
 */
public class Jugador {
    int dinero;
    Armeria armas[];
    String nombre;
    boolean perdio;
    Fabrica fabricas[];
    Componente componentes[];

    //Creo que este nunca se usaria, lo mejor seria pasarle los parametros
    Jugador(){
        nombre = "";
        perdio = false;
        dinero = 4000;
        fabricas[0] = new Fabrica();
        componentes[0] = new Componente();
    }
    
    Jugador(String nombreJugador){
        nombre = nombreJugador;
        perdio = false;
        dinero = 4000;
        fabricas[0] = new Fabrica("Mercado");
        componentes[0] = new Componente();
    }
    
}
