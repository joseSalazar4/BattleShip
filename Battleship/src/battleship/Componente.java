
package battleship;

public class Componente implements Cloneable{
    String nombre;
    int costo;
    public enum tipoComponente {Armeria,Mina, Templo, Mercado, Conectores, FuenteEnergia}
    tipoComponente tipoComponente;
            
            

    public Componente(){
        nombre = "";
    }
    public void setTipoComponente(tipoComponente comp){
        this.tipoComponente = comp;
    }
    
    public tipoComponente getTipoComponente(){
        return tipoComponente;
    }
}
