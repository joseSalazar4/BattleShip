
package Cliente_Servidor;
import java.io.Serializable;

public class mensajeGenerico implements Serializable{
    public String mensaje;
    public String emisor;
    public String destinatario;

    public mensajeGenerico(String mensaje, String emisor) {
        this.mensaje = mensaje;
        this.emisor = emisor;
    }

    public mensajeGenerico(String mensaje, String emisor, String destinatario) {
        this.mensaje = mensaje;
        this.emisor = emisor;
        this.destinatario = destinatario;
    }  
}
