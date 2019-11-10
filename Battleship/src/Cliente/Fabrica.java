
package Cliente;

/**
 *
 * @author mikom
 */

//Las dimensiones son 2x1 o 1x2
public class Fabrica {
    
    String nombre;
    int costo;
        
    //DEBERIAMOS HACER VARIOS CONSTRUCTORES DEPENDIENDO DE LA FABRICA? 
    
    //ES QUE SON MUY especificos casi no se parecen los atributos osea 
    
    //mercado es una vara que vende a las otras entonces creo que necesita su propia clase.
    Fabrica(){
        nombre = "";
        costo = 0; 
    }
}
