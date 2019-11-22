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
    int i, j;
    JLabel label;
    JLabel[][] matrizLabels;
    
    public PosicionarComponente(JLabel label, JLabel[][] matrizLabels, int i, int j){
        this.label = label;
        this.matrizLabels = matrizLabels;
        label.addMouseListener(this);
        this.i=i;
        this.j=j;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(Controlador_Adquisicion.isComprado){ //Compro un componente y lo va a posicionar
            if(Controlador_Adquisicion.componenteAux != null){ // Verifica si donde lo va a mover esté vacio
                if(Controlador_Adquisicion.getComponente(i, j) == null){
                        
                    mover();
//                    Controlador_Adquisicion.isComprado=false;
//                    Controlador_Adquisicion.componenteAux=null;
//                    Controlador_Adquisicion.pantalla.getLabelInstruccion().setVisible(false);
                }
                //ERROR
                System.out.println("Error Mouse clicked Method Linea 37");
            }
            //ERROR
            System.out.println("Error Mouse clicked Method Linea 40");
        }
        else{
            if(Controlador_Adquisicion.isMover){ //Va a mover un componente de la matriz a este label
                if(Controlador_Adquisicion.componenteAux != null){ 
                    if(Controlador_Adquisicion.getComponente(i, j) == null){
                        mover();
                        //Controlador_Adquisicion.isMover=false;
                        //Controlador_Adquisicion.componenteAux=null; 
                    }
                }
                System.out.println("Error Mouse clicked Method linea 51");                       
            }
            
            else if(Controlador_Adquisicion.getComponente(i, j) != null){ //Va a mover este elemento
                Controlador_Adquisicion.isMover = true;
                Controlador_Adquisicion.componenteAux = Controlador_Adquisicion.getComponente(i, j);
                if(!Controlador_Adquisicion.componenteAux.isIs1x1()){
                    if(Controlador_Adquisicion.componenteAux.isIsVertical()){
                        if(i>0 && 
                                Controlador_Adquisicion.getComponente(i-1, j)!=null && 
                                Controlador_Adquisicion.getComponente(i-1, j).getTipoComponente() == Controlador_Adquisicion.componenteAux.getTipoComponente()){
                            Controlador_Adquisicion.isArrIzq = true;
                            Controlador_Adquisicion.matrizComponentes[i-1][j] = null;
                            matrizLabels[i-1][j].setIcon(null);
                            
                        }else{
                            Controlador_Adquisicion.isArrIzq = false;
                            Controlador_Adquisicion.matrizComponentes[i+1][j] = null;
                            matrizLabels[i+1][j].setIcon(null);
                        }
                        Controlador_Adquisicion.matrizComponentes[i][j] = null;
                        matrizLabels[i][j].setIcon(null);
                        
                    }
                    else{
                        if(j>0 &&
                                Controlador_Adquisicion.getComponente(i, j-1)!=null&&
                                Controlador_Adquisicion.getComponente(i, j-1).getTipoComponente() == 
                                Controlador_Adquisicion.componenteAux.getTipoComponente()){
                            Controlador_Adquisicion.isArrIzq = true;
                            Controlador_Adquisicion.matrizComponentes[i][j-1] = null;
                            matrizLabels[i][j-1].setIcon(null);
                            
                        }else{
                            Controlador_Adquisicion.isArrIzq = false;
                            Controlador_Adquisicion.matrizComponentes[i][j+1] = null;
                            matrizLabels[i][j+1].setIcon(null);
                        }
                        Controlador_Adquisicion.matrizComponentes[i][j] = null;
                        matrizLabels[i][j].setIcon(null);
                    }
                }
                Controlador_Adquisicion.matrizComponentes[i][j] = null;
                matrizLabels[i][j].setIcon(null);
            }
        }
    }
    
    public void posicionar_ij(JLabel label){
        //this.i = (int) label.getLocation().getY();
        //this.j = (int) label.getLocation().getX();
        
    }
    
    public void mover(){
       // QUE NO SE PUEDA PONER EN EL 20;
        if(Controlador_Adquisicion.componenteAux.isIs1x1()){
            posicionar_ij(this.label);
            this.label.setIcon(Controlador_Adquisicion.componenteAux.getImagen());
            Controlador_Adquisicion.matrizComponentes[i][j] = Controlador_Adquisicion.componenteAux;
        }
        else{
            posicionar_ij(this.label);
            if((Controlador_Adquisicion.componenteAux.isIsVertical()&&i==19)||(!Controlador_Adquisicion.componenteAux.isIsVertical()&&j==19))
                return;
            
            this.label.setIcon(Controlador_Adquisicion.componenteAux.getImagen());
            //this.label.setOpaque(true);
            Controlador_Adquisicion.matrizComponentes[i][j] = Controlador_Adquisicion.componenteAux;
            
            if(Controlador_Adquisicion.componenteAux.isIsVertical()){
                //COMPONENTE ES VERTICAL
                 if(Controlador_Adquisicion.isArrIzq && i>0 && Controlador_Adquisicion.getComponente(i-1, j) == null){
                    //LA SEGUNDO LABEL ES EL DE ARRIBA
                    JLabel otroLabel = matrizLabels[i-1][j];
                    posicionar_ij(otroLabel);
                    otroLabel.setIcon(Controlador_Adquisicion.componenteAux.getImagen());
                    //otroLabel.setOpaque(true);
                    Controlador_Adquisicion.matrizComponentes[i][j] = Controlador_Adquisicion.componenteAux;
                }
                else if(!Controlador_Adquisicion.isArrIzq && i<19 && Controlador_Adquisicion.getComponente(i+1, j) == null){
                    //LA SEGUNDO LABEL ES EL DE ABAJO
                    JLabel otroLabel = matrizLabels[i+1][j];
                    posicionar_ij(otroLabel);
                    otroLabel.setIcon(Controlador_Adquisicion.componenteAux.getImagen());
                    //otroLabel.setOpaque(true);
                    Controlador_Adquisicion.matrizComponentes[i][j] = Controlador_Adquisicion.componenteAux;
                }
                else{//NO HAY CAMPO}
                    return;
                } 
            }
            
            else{
                //ES HORIZANTAL
                if(Controlador_Adquisicion.isArrIzq && j>0 && Controlador_Adquisicion.getComponente(i, j-1) == null){
                    //LA SEGUNDO LABEL ES EL DE LA IZQUIERDA
                    JLabel otroLabel = matrizLabels[i][j-1];
                    posicionar_ij(otroLabel);
                    otroLabel.setIcon(Controlador_Adquisicion.componenteAux.getImagen());
                    //otroLabel.setOpaque(true);
                    Controlador_Adquisicion.matrizComponentes[i][j] = Controlador_Adquisicion.componenteAux;
                }
                else if(!Controlador_Adquisicion.isArrIzq && j<19 && Controlador_Adquisicion.getComponente(i, j+1) == null){
                    //LA SEGUNDO LABEL ES EL DE DERECHA
                    JLabel otroLabel = matrizLabels[i][j+1];
                    posicionar_ij(otroLabel);
                    otroLabel.setIcon(Controlador_Adquisicion.componenteAux.getImagen());
                    //otroLabel.setOpaque(true);
                    Controlador_Adquisicion.matrizComponentes[i][j] = Controlador_Adquisicion.componenteAux;
                }
                else{//NO HAY CAMPO}
                    return;
                }  
            }
        }
        Controlador_Adquisicion.componenteAux = null;
        Controlador_Adquisicion.isComprado = false;
        Controlador_Adquisicion.isMover = false;
        Controlador_Adquisicion.pantalla.getLabelInstruccion().setVisible(false);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
