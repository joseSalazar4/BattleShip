
package Controlador;

import Cliente_Servidor.Cliente.Cliente;
import Vista.GUIAdquisicion;
import Vista.GUICliente;
import Vista.GUIStartUp;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador_Cliente {
    private GUIStartUp pantallaStartUp;
    private GUIAdquisicion pantallaAdquisicion;
    private GUICliente pantallaPrincipal;
    private Cliente cliente;
    
    public Controlador_Cliente(){
        this.cliente = new Cliente("localhost", 9999, this);
        this.pantallaStartUp = new GUIStartUp(this);
        this.pantallaStartUp.setVisible(true);
        this.pantallaAdquisicion = null;
        this.pantallaPrincipal = null;
    }
    
    public void iniciarCliente(String nickName){
        cliente.iniciarCliente(nickName);
        pantallaStartUp.setTitle(nickName);
        pantallaStartUp.getTxtInfo().setText("Esperando Jugadores...");
        pantallaStartUp.getBtnStart().setVisible(false);
        pantallaStartUp.getjLabelLoadGIF().setVisible(true);
    }
    
    public void inciarAdquisicion(){
        this.pantallaStartUp.getTxtInfo().setText("Inciando Partida!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controlador_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.pantallaStartUp.dispose();
        this.pantallaAdquisicion = new GUIAdquisicion(this);
        this.pantallaAdquisicion.setVisible(true);
    }
    
    
}
