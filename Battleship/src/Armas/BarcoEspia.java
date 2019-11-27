/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Armas;

import Controlador.Controlador_Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mikom
 */
public class BarcoEspia extends Thread {
    public boolean activo = false;
    int i,j;
    Controlador_Cliente controlador;
    
    BarcoEspia(Controlador_Cliente controladorP){
        controlador  = controladorP;
        i = j = 0;
    }
    
    @Override 
    public void run(){
        while(true){
            while(activo){
                try {
                    //sleep(90000);  DESOCOMENTAR CUANDO FUNCIONE
                    sleep(1000);
                    i = controlador.getLabelEnemigoSeleccionado().getI();
                    j = controlador.getLabelEnemigoSeleccionado().getJ();
                    obtenerInformacion(i, j);
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(BarcoEspia.class.getName()).log(Level.SEVERE, null, ex);
                }
   
            }
            try {
                sleep(1000);
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(BarcoEspia.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    public void obtenerInformacion(int i, int j){
        int iAux, jAux;
        String textoEspia = "";
        
        
        //Escenario donde no se sale de ningun borde (Mejor escenario)
        if(i>=3 && j>=3 && i<17 && j<17){
            iAux = i-3;
            jAux = j-3;
            for(int k = iAux;k<7;k++){
                for(int l = jAux;l<7;l++){
                    if(k == l) textoEspia+=" BarcoEspia ";
                    else{
                        if(controlador.getOceanoEnemigo().matrizComponentes[k][l] == null) textoEspia+="N/A";
                        else textoEspia+=controlador.getOceanoEnemigo().matrizComponentes[k][l].getNombre()+" ";
                    }
                }
                textoEspia+="\n";
            }
        }
        else if(true){
            
        }
        else if(true){
            
        }
        
        
        JOptionPane.showMessageDialog(null, textoEspia);
    }
    
}
