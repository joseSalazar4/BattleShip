package Grafo;
import Componentes.Conector;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

public class Grafo implements Serializable{
    private ArrayList<Vertice> vertices;

    public Grafo(){
        vertices = new ArrayList<>();
    }
    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }
    
    public void removeVertice(Point vertice){
       for(Vertice v : this.vertices){
           if(v.getComponente().getPoint().x == vertice.x &&
              v.getComponente().getPoint().y == vertice.y){
               for(Arista a : v.getAristas()){
                   for(Arista aDestino: a.getDestination().getAristas()){
                       if(aDestino.getDestination().equals(v)){
                           a.getDestination().getAristas().remove(aDestino);
                       }
                   }
               }
               
               this.vertices.remove(v);
               return;
           }
       }
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
              if(arista.getConector().getPoint().x == point.x && arista.getConector().getPoint().y == point.y){
                 vertice.getAristas().remove(arista); 
                 return;
                }     
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
