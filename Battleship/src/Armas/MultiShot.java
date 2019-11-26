/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Armas;

import Componentes.Componente;
import Componentes.EspacioMuerto;
import Controlador.Controlador_Cliente;
import Controlador.marcarCasillaEnemigo;
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author mikom
 */
public class MultiShot extends AbstractArma  {
    Random random = new Random();
    public MultiShot(Controlador_Cliente controlador){
        super(controlador);
        costo = 1000;
        nombre = "Multishot";
    }
    @Override
        //Si impacta una casilla genera 4 tiros aleatorios más recursivamente. Por cada 
    public void atacar() {
        marcarCasillaEnemigo casilla = controlador.getLabelEnemigoSeleccionado();
        if(casilla != null && controlador.getOceanoEnemigo() != null){
            Point point = new Point(casilla.getJ(), casilla.getI());
            Componente componente = controlador.getOceanoEnemigo().matrizComponentes[point.y][point.x];
            if(!(componente instanceof EspacioMuerto)){
                if(cobrarAcero()){
                    boolean golpe = golpear(componente, controlador.getOceanoEnemigo(), point);
                    if(golpe){
                        controlador.enviarMensajeJuego(
                        controlador.getCliente().jugador.getNombre() + " obtuvo CUATRO torpedos"); 
                        ataqueMultiShot();
                    }
                    
                }
                else controlador.recibirMensajeJuego("ACERO INSUFICIENTE");
                
            }
            else controlador.recibirMensajeJuego("SELECCIONE UNA CASILLA QUE NO HAYA SIDO DESTRUIDA");
        }
        else controlador.recibirMensajeJuego("SELECCIONE UNA CASILLA");
    }
    
    public void ataqueMultiShot(){
        for(int i = 0; i<4; i++){
            Point pointRandom = new Point(random.nextInt(19), random.nextInt(19));
            Componente componente = controlador.getOceanoEnemigo().matrizComponentes[pointRandom.y][pointRandom.x];
            if(!(componente instanceof EspacioMuerto)){
             golpear(componente, controlador.getOceanoEnemigo(), pointRandom);     
            } 
        }
    } 
}
    

