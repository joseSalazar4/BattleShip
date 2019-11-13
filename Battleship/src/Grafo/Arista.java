
package Grafo;
import java.awt.Point;

public class Arista {
    private Vertice origin;
    private Vertice destination;
    private double distance;
    private Point coordenada;
 
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

    public Point getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Point coordenada) {
        this.coordenada = coordenada;
    }
}
