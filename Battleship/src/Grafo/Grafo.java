package Grafo;
import battleship.Conector;
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
    
    public void addArista(Vertice origen, Vertice destino, Conector conector){
        Arista aristaOrigen = new Arista(origen, destino, origen.getComponente().getPoint().distance(destino.getComponente().getPoint()));
        aristaOrigen.setConector(conector);
        origen.addArista(aristaOrigen);
        
        Arista aristaDestino = new Arista(destino, origen, destino.getComponente().getPoint().distance(origen.getComponente().getPoint()));
        aristaDestino.setConector(conector);
        destino.addArista(aristaDestino);
    }
   
    public void removeArista(Point point){
        for (Vertice vertice : vertices){
            for (Arista arista : vertice.getAristas()) {
              if(arista.getConector().getPoint().x == point.x && arista.getConector().getPoint().y == point.y) 
                  vertice.getAristas().remove(arista);
            }
        }
    }
    
    public String toString(){
        String str = "---GRAFO---";
        for(Vertice vertice : this.vertices)
            str += vertice.toString();
        
        return str;
    }
}
