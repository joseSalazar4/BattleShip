/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class PosicionarComponente implements MouseListener{
    int i, j;
    int otroI = 0, OtroJ = 0;
    JLabel label;
    JLabel[][] matrizLabels;
    private double y;
    
    public PosicionarComponente(JLabel label, JLabel[][] matrizLabels, int i, int j){
        this.label = label;
        this.matrizLabels = matrizLabels;
        label.addMouseListener(this);
        this.i=i;
        this.j=j;        
    }

    @Override
    public void mouseClicked(MouseEvent e){
        
        if(Controlador_Adquisicion.isComprado){ //Compro un componente y lo va a posicionar
            if(Controlador_Adquisicion.componenteAux != null){ // Verifica si donde lo va a mover esté vacio
                if(Controlador_Adquisicion.getComponente(i, j) == null)                  
                    mover();
                //ERROR
            }
            //ERROR
        }
        else{
            if(Controlador_Adquisicion.isMover){ //Va a mover un componente de la matriz a este label
                if(Controlador_Adquisicion.componenteAux != null){ 
                    if(Controlador_Adquisicion.getComponente(i, j) == null)
                        mover();
                }
            }
            
            else if(Controlador_Adquisicion.getComponente(i, j) != null){ //Va a mover este elemento
                if(!Controlador_Adquisicion.componenteAux.isIs1x1()){
                    if(Controlador_Adquisicion.componenteAux.isIsVertical()){
                        if(i>=0 && 
                        Controlador_Adquisicion.getComponente(i+1, j)!=null && 
                        Controlador_Adquisicion.getComponente(i+1, j).getTipoComponente() == 
                        Controlador_Adquisicion.componenteAux.getTipoComponente())
                            
                        {
                                Controlador_Adquisicion.isArrIzq = true;
                                Controlador_Adquisicion.matrizComponentes[i+1][j] = null;
                                matrizLabels[i-1][j].setIcon(null);  
                                
                                Controlador_Adquisicion.matrizComponentes[i][j] = null;
                                matrizLabels[i][j].setIcon(null);
                                
                        } else return;
   
                    }
                    else{ //ES HORIZONTAL
                        if(j>=0 &&
                            Controlador_Adquisicion.getComponente(i, j+1)!=null&&
                            Controlador_Adquisicion.getComponente(i, j+1).getTipoComponente() == 
                            Controlador_Adquisicion.componenteAux.getTipoComponente())
                        {
                            Controlador_Adquisicion.isArrIzq = true;
                            Controlador_Adquisicion.matrizComponentes[i][j+1] = null;
                            matrizLabels[i][j-1].setIcon(null);
                            
                            Controlador_Adquisicion.matrizComponentes[i][j] = null;
                            matrizLabels[i][j].setIcon(null);
                            
                        } else return;       
                    }
                }
                
                Controlador_Adquisicion.isMover = true;
                Controlador_Adquisicion.componenteAux = Controlador_Adquisicion.getComponente(i, j);
                
                Controlador_Adquisicion.matrizComponentes[i][j] = null;
                matrizLabels[i][j].setIcon(null);
            }
        }
    }
    
    public Point posicionar_ij(JLabel _label){
        
        int _i = (int) _label.getLocation().getY() / 30;
        int _j = (int) _label.getLocation().getX() / 30;
        return new Point(_j, _i);
        
    }
    
    public void mover(){
       // QUE NO SE PUEDA PONER EN EL 20;
        if(Controlador_Adquisicion.componenteAux.isIs1x1()){
            Point pointThis = posicionar_ij(this.label);
            this.i = (int) pointThis.getY();
            this.y = (int) pointThis.getX();
            if(Controlador_Adquisicion.getComponente(this.i, this.j) == null){
               this.label.setIcon(Controlador_Adquisicion.componenteAux.getImagen());
                Controlador_Adquisicion.matrizComponentes[i][j] = Controlador_Adquisicion.componenteAux; 
            }
            else return;
        }
        else{
                      
            if(Controlador_Adquisicion.componenteAux.isIsVertical()){
                if(i<19 && Controlador_Adquisicion.getComponente(i+1, j) == null){
                    Point pointThis = posicionar_ij(this.label);
                    this.i = (int) pointThis.getY();
                    this.y = (int) pointThis.getX();
                    
                    if((Controlador_Adquisicion.componenteAux.isIsVertical()&&i==19)
                    ||(!Controlador_Adquisicion.componenteAux.isIsVertical()&&j==19)) return;

                    if(Controlador_Adquisicion.getComponente(i, j) != null) return;

                    this.label.setIcon(Controlador_Adquisicion.componenteAux.getImagen());

                    Controlador_Adquisicion.matrizComponentes[i][j] = Controlador_Adquisicion.componenteAux;
                    
                    //LA SEGUNDO LABEL ES EL DE ABAJO
                    JLabel otroLabel = matrizLabels[i+1][j];
                    Point otroPoint = posicionar_ij(otroLabel);
                    this.otroI = (int) otroPoint.getY();
                    this.OtroJ = (int) otroPoint.getX();
                    
                    otroLabel.setIcon(Controlador_Adquisicion.componenteAux.getImagen());
                    Controlador_Adquisicion.matrizComponentes[otroI][OtroJ] = Controlador_Adquisicion.componenteAux;
                }
                else return;
        
            }
            
            else{
                //ES HORIZANTAL
                if(j<19 && Controlador_Adquisicion.getComponente(i, j+1) == null){
                    Point pointThis = posicionar_ij(this.label);
                    this.i = (int) pointThis.getY();
                    this.y = (int) pointThis.getX();
                    if((Controlador_Adquisicion.componenteAux.isIsVertical()&&i==19)||(!Controlador_Adquisicion.componenteAux.isIsVertical()&&j==19))
                        return;

                    if(Controlador_Adquisicion.getComponente(i, j) != null) return;

                    this.label.setIcon(Controlador_Adquisicion.componenteAux.getImagen());
                    Controlador_Adquisicion.matrizComponentes[i][j] = Controlador_Adquisicion.componenteAux;
                    
                    //LA SEGUNDO LABEL ES EL DE DERECHA
                    JLabel otroLabel = matrizLabels[i][j+1];
                    Point otroPoint = posicionar_ij(otroLabel);
                    this.otroI = (int) otroPoint.getY();
                    this.OtroJ = (int) otroPoint.getX();
                    
                    otroLabel.setIcon(Controlador_Adquisicion.componenteAux.getImagen());
                    Controlador_Adquisicion.matrizComponentes[this.otroI][this.OtroJ] = Controlador_Adquisicion.componenteAux;
                }
                else return;
                 
            }
        }
        System.out.println("Cordenada Label: " + i + "," + j);
        System.out.println("Cordenada Otro Label: " +  this.otroI +"," + this.OtroJ);
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
