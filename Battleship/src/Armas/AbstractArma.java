
package Armas;

import java.io.Serializable;

public abstract class AbstractArma implements Serializable{
    int costo;
    String nombre;
    
    public abstract void atacar();
}
