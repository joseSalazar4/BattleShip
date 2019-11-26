/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;
import Componentes.Componente;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
/**
 *
 * @author mikom
 */
public class Jugador {
    //Usar atributos privados y programar los getter && setter de los atributos que lo ocupen
    
    private int dinero, acero, escudo ;
    private String nombre;
    private boolean perdio;
    private Semaphore semaforoAcero;
    private ArrayList<String> enemigos;
    private ArrayList<Componente> armasCompradas;
    
    public Jugador(String nombreJugador){
        dinero = 200000;
        
        int m = 0;
        for(int i=0;i<10;i++) m = (int) (Math.random() * 4) + 2;
        
        escudo  = m;
        acero = 0 ;
        perdio = false;
        enemigos = null;
        nombre = nombreJugador;
        enemigos = new ArrayList<String>();
        armasCompradas = new ArrayList<Componente>();
        semaforoAcero = new Semaphore(1);

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

    public Semaphore getSemaforoAcero() {
        return semaforoAcero;
    }

    public void setSemaforoAcero(Semaphore semaforoAcero) {
        this.semaforoAcero = semaforoAcero;
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
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

    public int getAcero() {
        return acero;
    }

    public void setAcero(int acero) {
        this.acero = acero;
    }
    
    
    
}
