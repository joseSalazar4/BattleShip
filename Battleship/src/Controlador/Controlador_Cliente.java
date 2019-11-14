
package Controlador;

import Cliente_Servidor.Cliente.Cliente;
import Vista.GUIAdquisicion;
import Vista.GUICliente;
import Vista.GUIStartUp;

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
    }
    
    public void inciarAdquisicion(){
        this.pantallaStartUp.dispose();
        this.pantallaAdquisicion = new GUIAdquisicion(this);
        this.pantallaAdquisicion.setVisible(true);
    }
    
    
}
