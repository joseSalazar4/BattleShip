
package Grafo;
import Componentes.Conector;
import java.awt.Point;
import java.io.Serializable;

public class Arista implements Serializable{
    private Vertice origin;
    private Vertice destination;
    private Conector conector;
    private double distance;
    
 
    public Arista(Vertice origin, Vertice destination, double distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }
 
    public Vertice getOrigin() {
        return origin;
    }
 
    public void setOrigin(Vertice origin) {
        this.origin = origin;
    }
 
    public Vertice getDestination() {
        return destination;
    }
 
    public void setDestination(Vertice destination) {
        this.destination = destination;
    }
 
    public double getDistance() {
        return distance;
    }
 
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Conector getConector() {
        return conector;
    }

    public void setConector(Conector conector) {
        this.conector = conector;
    }

    public String toString(){
        return origin.getComponente().getTipoComponente().toString() 
        + "-> " + distance 
        + " -> " + destination.getComponente().getTipoComponente().toString() + "\n";
    }
    
}
