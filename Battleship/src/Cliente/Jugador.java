/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;
import Componentes.Componente;
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
    private boolean perdio, turnoAtacar;
    private ArrayList<String> enemigos;
    private ArrayList<Componente> armasCompradas;
    
    
    
    public Jugador(String nombreJugador){
        dinero = 200000;
        perdio = false;
        enemigos = null;
        nombre = nombreJugador;
        enemigos = new ArrayList<String>();
        armasCompradas = new ArrayList<Componente>();

    }
    
    public ArrayList<Componente>getArmasCompradas(){
        return armasCompradas;
    }
    
    public void setArmasCompradas(ArrayList<Componente> armasCompradasN){
        armasCompradas = armasCompradasN;
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
