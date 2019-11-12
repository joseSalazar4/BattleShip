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
        origen.addArista(new Arista(origen, destino, origen.getCoordenada().distance(destino.getCoordenada())));
        origen.addArista(new Arista(destino, origen, destino.getCoordenada().distance(origen.getCoordenada())));
    }
   
    public void removeArista(Point point){
        for (Vertice vertice : vertices){
            for (Arista arista : vertice.getAristas()) {
              if(arista.getCoordenada().x == point.x && arista.getCoordenada().y == point.y) 
                  vertice.getAristas().remove(arista);
            }
        }
    }
    
    @Override
    public String toString(){
        return "Grafo: {Vertices: " + vertices + "}";
    }
}
