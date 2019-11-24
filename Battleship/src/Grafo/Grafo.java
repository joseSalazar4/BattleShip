package Grafo;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private List<Vertice> vertices;

    public Grafo(){
        vertices = new ArrayList<>();
    }
    public List<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }
    
    public void addVertice(Vertice vertice){
        vertices.add(vertice);
    }
    
    public void addArista(Vertice origen, Vertice destino){
        origen.addArista
        (new Arista(origen, destino, origen.getComponente().getPoint().distance(destino.getComponente().getPoint())));
        destino.addArista
        (new Arista(destino, origen, destino.getComponente().getPoint().distance(origen.getComponente().getPoint())));
    }
   
    public void removeArista(Point point){
        for (Vertice vertice : vertices){
            for (Arista arista : vertice.getAristas()) {
              if(arista.getConector().getPoint().x == point.x && arista.getConector().getPoint().y == point.y) 
                  vertice.getAristas().remove(arista);
            }
        }
    }
}
