
package Grafo;
import java.util.ArrayList;
import java.util.List;

import battleship.Componente;
import java.awt.Point;

public class Vertice {
    private Componente componente;
    private List<Arista> aristas;
    private Point coordenada;

    public Vertice(Componente componente) {
        this.componente = componente;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(List<Arista> aristas) {
        this.aristas = aristas;
    }
    
    public void addArista(Arista arista){
        if(aristas == null) aristas = new ArrayList<>();
        aristas.add(arista);
    }

    public Point getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Point coordenada) {
        this.coordenada = coordenada;
    } 
}
