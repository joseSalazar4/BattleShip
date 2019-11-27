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
    
    public  BarcoEspia(Controlador_Cliente controladorP){
        controlador  = controladorP;
        i = j = 0;
    }
    
    @Override 
    public void run(){
        while(true){
            while(activo){
                try {
                    System.out.println("AQUI VAMOS Mandando el barquitooo ");
                    sleep(90000);
                    i = controlador.getLabelEnemigoSeleccionado().getI();
                    j = controlador.getLabelEnemigoSeleccionado().getJ();
                    obtenerInformacion(i, j);
                    activo = false;
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
        
        iAux = i-3;
        jAux = j-3;
        System.out.println("ENTRE A OBTENER INFO");

        
        //Escenario donde no se sale de ningun borde (Mejor escenario)
        if(i>=3 && j>=3 && i<17 && j<17){
            System.out.println("IF 1");
            for(int k = iAux;k<iAux+7;k++){
                for(int l = jAux;l<jAux+7;l++){
                    //if((iAux+7)/2 == (jAux+7)/2) textoEspia += " BarcoEspia ";
                    
                    if(controlador.getOceanoEnemigo().matrizComponentes[k][l] == null) textoEspia+="--N/A--";
                    else textoEspia+="--"+controlador.getOceanoEnemigo().matrizComponentes[k][l].getNombre()+"--";
                    
                }
                textoEspia+="\n";
            }
        }
        
        //Escenario donde se pone mas a la izq
        else if(iAux<0){
            
            //Muy a la izquierda y muy arriba
            //CORRECTO
            if(jAux<0){
                for(int k = 0;k<iAux+7;k++){
                    for(int l = 0;l<jAux+7;l++){
                        if(k == l) textoEspia+=" BarcoEspia ";
                        else{
                            if(controlador.getOceanoEnemigo().matrizComponentes[k][l] == null) textoEspia+="N/A";
                            else textoEspia+=controlador.getOceanoEnemigo().matrizComponentes[k][l].getNombre()+" ";
                        }
                    }
                    textoEspia+="\n";
            
                }   
            }
            //Muy a la izquierda y muy abajo
            else if(j+3>19){
                for(int k = iAux;k<iAux+7;k++){
                    for(int l = jAux;l<jAux+7;l++){
                        if(k == l) textoEspia+=" BarcoEspia ";
                        else{
                            if(controlador.getOceanoEnemigo().matrizComponentes[k][l] == null) textoEspia+="N/A";
                            else textoEspia+=controlador.getOceanoEnemigo().matrizComponentes[k][l].getNombre()+" ";
                        }
                    }
                    textoEspia+="\n";
            
                }
            }
            //Solo esta muy a la izquierda
            else{
                for(int k = iAux;k<iAux+7;k++){
                    for(int l = jAux;l<jAux+7;l++){
                        if(k == l) textoEspia+=" BarcoEspia ";
                        else{
                            if(controlador.getOceanoEnemigo().matrizComponentes[k][l] == null) textoEspia+="N/A";
                            else textoEspia+=controlador.getOceanoEnemigo().matrizComponentes[k][l].getNombre()+" ";
                        }
                    }
                    textoEspia+="\n";
            
                }
            }
        }
            
        //Escenario donde se pone mas a la Derecha
        else if(i+3>19){
            
            //Ademas, esta mas arriba
            if(jAux<0){
                for(int k = iAux;k<iAux+7;k++){
                    for(int l = jAux;l<jAux+7;l++){
                        if(k == l) textoEspia+=" BarcoEspia ";
                        else{
                            if(controlador.getOceanoEnemigo().matrizComponentes[k][l] == null) textoEspia+="N/A";
                            else textoEspia+=controlador.getOceanoEnemigo().matrizComponentes[k][l].getNombre()+" ";
                        }
                    }
                    textoEspia+="\n";
                }
            }
            //Ademas, esta mas abajo
            //CORRECTO
            else if(j+3>19){
                for(int k = iAux;k<iAux+7;k++){
                    for(int l = jAux;l<jAux+7;l++){
                        if(k == l) textoEspia+=" BarcoEspia ";
                        else{
                            if(controlador.getOceanoEnemigo().matrizComponentes[k][l] == null) textoEspia+="N/A";
                            else textoEspia+=controlador.getOceanoEnemigo().matrizComponentes[k][l].getNombre()+" ";
                        }
                    }
                    textoEspia+="\n";
            
                }
            }
            
            //Solo esta muy a la derecha
            else{
                for(int k = iAux;k<iAux+7;k++){
                    for(int l = jAux;l<jAux+7;l++){
                        if(k == l) textoEspia+=" BarcoEspia ";
                        else{
                            if(controlador.getOceanoEnemigo().matrizComponentes[k][l] == null) textoEspia+=" N/A ";
                            else textoEspia+=controlador.getOceanoEnemigo().matrizComponentes[k][l].getNombre()+" ";
                        }
                    }
                    textoEspia+="\n";
                }
            }
        }
        System.out.println(textoEspia);
        JOptionPane.showMessageDialog(null, textoEspia);
    }
    
}
