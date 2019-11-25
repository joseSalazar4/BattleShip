
package Componentes;

import Grafo.Vertice;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Componente implements Cloneable, Serializable{
    String nombre;
    int costo;
    public boolean isVertical=false, is1x1, is2x2;  
    public enum tipoComponente {Armeria,Mina, Templo, Mercado, Conector, FuenteEnergia, Remolino}
    tipoComponente tipoComponente;
    Point point = new Point();
    ArrayList<Point> golpes;
    ImageIcon imagen;
    
    Vertice vertice;
            
    public Componente(){
        nombre = "";
        golpes = new ArrayList<Point>();
    }
    
    public void setTipoComponente(tipoComponente comp){
        this.tipoComponente = comp;
    }
    
    public tipoComponente getTipoComponente(){
        return tipoComponente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public boolean isIsVertical() {
        return isVertical;
    }

    public void setIsVertical(boolean isVertical) {
        this.isVertical = isVertical;
    }

    public boolean isIs1x1() {
        return is1x1;
    }

    public void setIs1x1(boolean is1x1) {
        this.is1x1 = is1x1;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public Vertice getVertice() {
        return vertice;
    }

    public void setVertice(Vertice vertice) {
        this.vertice = vertice;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
    
    
    
    
    
}
