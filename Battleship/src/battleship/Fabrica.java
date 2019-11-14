
package battleship;

/**
 *
 * @author mikom
 */

//Las dimensiones son 2x1 o 1x2
public class Fabrica extends Componente {
    
    String nombre;
    final int costo;
        
    //DEBERIAMOS HACER VARIOS CONSTRUCTORES DEPENDIENDO DE LA FABRICA? 
    
    //ES QUE SON MUY especificos casi no se parecen los atributos osea 
    
    //mercado es una vara que vende a las otras entonces creo que necesita su propia clase.
    
    //Mae y si corre el que dice Cliente.java y luego el servidor.java los maes se envian mensajes
    //Bueno y si llego aca pues ola.
    public Fabrica(){
        nombre = "";
        costo = 0; 
    }
    
    public Fabrica(String nombreFabrica){
        nombre = nombreFabrica;
        if(nombreFabrica == "Mercado"){
            costo = 2000;
        }
        else if(nombreFabrica == "Mina"){
            costo = 1000;
        }
        else if(nombreFabrica == "Armeria"){
            costo = 1500;
        }                
        else costo = 2500;           
    }
}
