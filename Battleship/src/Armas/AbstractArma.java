
package Armas;

import java.io.Serializable;

public abstract class AbstractArma implements Serializable{
    int costo;
    
    public abstract void atacar();
}
