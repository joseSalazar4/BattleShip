
package Armas;

import Componentes.Componente;
import Componentes.Conector;
import Componentes.EspacioMuerto;
import Controlador.Controlador_Cliente;
import battleship.Oceano;
import java.awt.Point;
import java.io.Serializable;

public abstract class AbstractArma implements Serializable{
    int costo;
    String nombre;
    Controlador_Cliente controlador;
    
    public AbstractArma(Controlador_Cliente controlador){
        super();
        this.controlador = controlador;
    }
    
    public abstract void atacar();
    
    public boolean golpear(Componente componente, Oceano oceano, Point point){
        if(componente != null){
            if(componente instanceof Conector){
                oceano.grafo.removeArista(componente.getPoint());
                destruirComponente(componente);
                controlador.enviarMensajeJuego(
                    controlador.getCliente().jugador.getNombre() + " destruyó un conector de " 
                    + controlador.getOceanoEnemigo().enemigo 
                    + " en la posición " + point.x  + "," + point.y + " usando " + nombre);
            }
            else if(componente.is1x1){
                oceano.grafo.removeVertice(componente.getVertice());
                destruirComponente(componente);
                controlador.enviarMensajeJuego(
                    controlador.getCliente().jugador.getNombre() + " destruyó un "+ componente.getNombre() +" de " 
                    + controlador.getOceanoEnemigo().enemigo 
                    + " en la posición " + point.x  + "," + point.y + " usando " + nombre);

            }
            else if(componente.is2x2 || !componente.is1x1){
                for(Point golpe : componente.getGolpes()){
                    if(golpe.x == point.x && golpe.y == point.y){
                       controlador.enviarMensajeJuego(
                            controlador.getCliente().jugador.getNombre() + " volvio a golpear la "+ componente.getNombre() +" del oceano de " 
                            + controlador.getOceanoEnemigo().enemigo 
                            + " en la posición " + point.x  + "," + point.y + " usando " + nombre); 
                       return false;
                    }
                }
                componente.getGolpes().add(point);
                
                controlador.enviarMensajeJuego(
                    controlador.getCliente().jugador.getNombre() + " golpeó una "+ componente.getNombre() +" del oceano de " 
                    + controlador.getOceanoEnemigo().enemigo 
                    + " en la posición " + point.x  + "," + point.y + " usando " + nombre);
                
                int ctdGolpes = 2;
                if(componente.is2x2) ctdGolpes = 4;
                
                if(componente.getGolpes().size() >= ctdGolpes){
                    oceano.grafo.removeVertice(componente.getVertice());
                    destruirComponente(componente);    
                    
                    controlador.enviarMensajeJuego(
                    controlador.getCliente().jugador.getNombre() + " destruyó una "+ componente.getNombre() +" del oceano de " 
                    + controlador.getOceanoEnemigo().enemigo 
                    + " en la posición " + point.x  + "," + point.y + " usando " + nombre);
                }
            }
        }
        else{
            controlador.enviarMensajeJuego(
                    controlador.getCliente().jugador.getNombre() + " fallo un disparo usando " + nombre + " al oceano de " 
                    + controlador.getOceanoEnemigo().enemigo);
            return false;
        }
        
        
        return true;
        
        
    }
 
    public void destruirComponente(Componente componente){
        this.controlador.getOceanoEnemigo().matrizComponentes[componente.getPoint().y][componente.getPoint().x] = new EspacioMuerto();
    }
    
    public boolean cobrarAcero(){
        return true;
        
    }

    public Controlador_Cliente getControlador() {
        return controlador;
    }

    public void setControlador(Controlador_Cliente controlador) {
        this.controlador = controlador;
    }
    
    
    
    

}
