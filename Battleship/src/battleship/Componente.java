
package battleship;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Componente implements Cloneable{
    String nombre;
    int costo;
    ArrayList aristas;
    public boolean isVertical=false, is1x1, is2x2;  
    public enum tipoComponente {Armeria,Mina, Templo, Mercado, Conectores, FuenteEnergia}
    tipoComponente tipoComponente;
    ImageIcon imagen;
            
    public Componente(){
        nombre = "";
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
    
    
    
    
}
