
package Grafo;

public class Arista {
    private Vertice origin;
    private Vertice destination;
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
 
    @Override
    public String toString() {
        return "\n Arista [origin=" + origin.getComponente()+ ", destination=" + destination.getComponente()+ ", distance="
                + distance + "]";
    }
}
