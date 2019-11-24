
package Grafo;
import battleship.Conector;
import java.awt.Point;

public class Arista {
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

    
}
