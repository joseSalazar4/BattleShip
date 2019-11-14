/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;
import battleship.Fabrica;
import battleship.Componente;
import battleship.Armeria;
import java.util.ArrayList;
/**
 *
 * @author mikom
 */
public class Jugador {
    //Usar atributos privados y programar los getter && setter de los atributos que lo ocupen
    
    private int dinero;
    //public Armeria armas[];
    private String nombre;
    private boolean perdio;
    private ArrayList<String> enemigos;
   // public Fabrica fabricas[];
   // public Componente componentes[];

    //Creo que este nunca se usaria, lo mejor seria pasarle los parametros
    
    
    public Jugador(String nombreJugador){
        nombre = nombreJugador;
        perdio = false;
        dinero = 4000;
        enemigos = null;

    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isPerdio() {
        return perdio;
    }

    public void setPerdio(boolean perdio) {
        this.perdio = perdio;
    }

    public ArrayList<String> getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(ArrayList<String> enemigos) {
        this.enemigos = enemigos;
    }
    
    
    
}
