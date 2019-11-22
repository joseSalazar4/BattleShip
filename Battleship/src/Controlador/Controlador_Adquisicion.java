/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.GUIAdquisicion;
import battleship.Componente;
import javax.swing.JComboBox;
import Cliente_Servidor.Cliente.Cliente;
import battleship.FactoryComponente;
import battleship.ItemCompra;
import javax.swing.JOptionPane;

public class Controlador_Adquisicion {
    Cliente cliente;
    static GUIAdquisicion pantalla; 
    FactoryComponente factoryComponente;
    
    public static boolean isComprado = false, isMover = false, isArrIzq = false;
    public static Componente componenteAux = null, componenteAux2 = null;
    public static Componente[][] matrizComponentes = new Componente[20][20];
 

    public Controlador_Adquisicion(Cliente cliente) {
        this.cliente = cliente;
        this.pantalla = new GUIAdquisicion(this);
        this.pantalla.setVisible(true);
        cargarDatosDelJugador();
        
        JComboBox comboBoxMina = this.pantalla.getComboBoxMina();
        comboBoxMina.removeAllItems(); //Eliminar los default
        
        comboBoxMina.addItem("Nivel 1");
        comboBoxMina.addItem("Nivel 2");
        comboBoxMina.addItem("Nivel 3");
        comboBoxMina.addItem("Nivel 4");
        comboBoxMina.addItem("Nivel 5");
        
        JComboBox comboBoxArmeria = this.pantalla.getComboBoxArmeria();
        comboBoxArmeria.removeAllItems();//Eliminar los defaults
        
        comboBoxArmeria.addItem("Bomba"); 
        comboBoxArmeria.addItem("Torpedo");
        comboBoxArmeria.addItem("Trumpedo");
        comboBoxArmeria.addItem("Multi-shot");
        
        JComboBox comboBoxPosicion = this.pantalla.getComboBoxPos();
        
        comboBoxPosicion.removeAllItems();//Eliminar los defaults 
        
        comboBoxPosicion.addItem("Horizontal");
        comboBoxPosicion.addItem("Vertical");
    }

    public void cargarDatosDelJugador(){
        pantalla.getLblnickName().setText(cliente.jugador.getNombre());
        pantalla.getLblDinero().setText("Dinero: $" + cliente.jugador.getDinero());
        
    }
    
    
    public void adquirirTemplo(){
        //Templo templo = new Templo();
    }
    
    public void adquirirMercado(){
        
    }
    
    public void iniciarPartida(){
        pantalla.getButtonMina().setEnabled(false);
        pantalla.getButtonTemplo().setEnabled(false);        
        pantalla.getButtonArmeria().setEnabled(false);
        pantalla.getButtonMercado().setEnabled(false);
    }
    
    public void ejecutarCompra(int precio, ItemCompra item, boolean isVert){
        
        if(this.cliente.jugador.getDinero()< precio) JOptionPane.showMessageDialog(null, "No Tiene suficiente dinero!");
        else if(isComprado) JOptionPane.showMessageDialog(null, "Termine la compra antes de colocar otra ficha!"); //todo: cambiar esto para desactivar los botones o algo asi
        else{
            cliente.jugador.setDinero(cliente.jugador.getDinero()-precio);
            int extra = verificarOpcionExtra(item);
            componenteAux = FactoryComponente.crearComponente(item, extra);
            if(isVert) componenteAux.setIsVertical(isVert);
            isComprado=true;
            pantalla.getLabelInstruccion().setVisible(true);
            pantalla.getLblDinero().setText("Dinero: $" + cliente.jugador.getDinero());
            //factory.Comprar();
        }
    }
    public void activarBotonesCompra(){
        Controlador_Adquisicion.pantalla.getButtonMina().setEnabled(true);
        Controlador_Adquisicion.pantalla.getButtonFuente().setEnabled(true);        
        Controlador_Adquisicion.pantalla.getButtonTemplo().setEnabled(true);        
        Controlador_Adquisicion.pantalla.getButtonArmeria().setEnabled(true);
        Controlador_Adquisicion.pantalla.getButtonMercado().setEnabled(true);
        Controlador_Adquisicion.pantalla.getButtonConector().setEnabled(true);

    }
    
    public void desactivarBotonesCompra(){
        Controlador_Adquisicion.pantalla.getButtonMina().setEnabled(false);
        Controlador_Adquisicion.pantalla.getButtonFuente().setEnabled(false);
        Controlador_Adquisicion.pantalla.getButtonTemplo().setEnabled(false);        
        Controlador_Adquisicion.pantalla.getButtonArmeria().setEnabled(false);
        Controlador_Adquisicion.pantalla.getButtonMercado().setEnabled(false);
        Controlador_Adquisicion.pantalla.getButtonConector().setEnabled(false);
        
    }
    public void adquirirArma(){
        //Armeria armeria = new Armeria();
    }
    
    public static Componente getComponente(int i, int j){
        return matrizComponentes[i][j]; 
    }
      
    public int verificarOpcionExtra(ItemCompra item){
        if(item.equals("ARMERIA")) return pantalla.getComboBoxArmeria().getSelectedIndex();
        else if(item.equals("MINA"))  return pantalla.getComboBoxMina().getSelectedIndex();
        //Si no es ninguna no debemos hacer nada difernete
        else return 0;
    }
    
    //Getter && Settter
    public GUIAdquisicion getPantalla() {
        return pantalla;
    }

    public void setPantalla(GUIAdquisicion pantalla) {
        this.pantalla = pantalla;
    }
    
     
}
