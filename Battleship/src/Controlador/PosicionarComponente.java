/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class PosicionarComponente implements MouseListener{
    JLabel label;
    int i, j;
    public PosicionarComponente(JLabel label, JLabel[][] matrizLabels){
        this.label = label;
        label.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(Controlador_Adquisicion.isComprado){ //Compro un componente y lo va a posicionar
            if(Controlador_Adquisicion.componenteAux != null){ // Verifica si donde lo va a mover esté vacio
                if(Controlador_Adquisicion.getComponente(i, j) == null){
                    //Mover 
                    Controlador_Adquisicion.isComprado = false;
                }
                //ERROR
            }
            //ERROR
        }
        else{
            if(Controlador_Adquisicion.isMover){ //Va a mover un componente de la matriz a este label
                if(Controlador_Adquisicion.componenteAux != null){ 
                    if(Controlador_Adquisicion.getComponente(i, j) == null){
                        //Mover
                        Controlador_Adquisicion.isMover = false;
                    }
                }
                //ERROR
            }
            
            if(Controlador_Adquisicion.getComponente(i, j) != null){ //Va a mover este elemento
                Controlador_Adquisicion.isMover = true;
                Controlador_Adquisicion.componenteAux = Controlador_Adquisicion.getComponente(i, j);
            }
        }
    }
    
    public void mover(){
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
