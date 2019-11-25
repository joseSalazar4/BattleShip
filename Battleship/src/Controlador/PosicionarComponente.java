/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Grafo.Vertice;
import battleship.Conector;
import battleship.FuentePoder;
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
        
        if(Controlador_Adquisicion.isConectar && Controlador_Adquisicion.getComponente(i, j) != null){ 
            if(Controlador_Adquisicion.getComponente(i, j) instanceof Conector)
            {   
                //Establecer el conector que se va a usar
                Controlador_Adquisicion.conectorAux = (Conector) Controlador_Adquisicion.getComponente(i, j);
            }
            
            else if(Controlador_Adquisicion.getComponente(i, j) instanceof FuentePoder
            && Controlador_Adquisicion.conectorAux != null)
            {   
                //Establecer la fuente
                //Un conector puede cambiar de fuente ? 
                Controlador_Adquisicion.conectorAux.setFuente( (FuentePoder) Controlador_Adquisicion.getComponente(i, j));
            }
            
            else if(Controlador_Adquisicion.conectorAux != null
            &&  Controlador_Adquisicion.conectorAux.getFuente() != null)
            {   
                //Agregar el destino y crear la arista
                //Si este componente ya habia sido agregado no se hace nada
                boolean fueAgregado =  Controlador_Adquisicion.conectorAux.addDestino(Controlador_Adquisicion.getComponente(i, j));
                if(fueAgregado){
                    Controlador_Adquisicion.grafo.addArista
                        (Controlador_Adquisicion.conectorAux.getFuente().getVertice(), 
                        Controlador_Adquisicion.getComponente(i, j).getVertice(), 
                        Controlador_Adquisicion.conectorAux);
                    
                    Controlador_Adquisicion.conectorAux = null;
                    Controlador_Adquisicion.setIsConectar();
                    
                    System.out.println(Controlador_Adquisicion.grafo.toString());
                    
                    
                    
                } else System.out.println("Ya habia sido agregado");
            }
        }
        
        else if(Controlador_Adquisicion.isComprado){ //Compro un componente y lo va a posicionar
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
                Controlador_Adquisicion.isMover = true;
                Controlador_Adquisicion.componenteAux = Controlador_Adquisicion.getComponente(i, j);
                
                //CUANDO ES 4X4 
                if(Controlador_Adquisicion.componenteAux instanceof FuentePoder){
                    if(i<19 && j<19 &&
                    Controlador_Adquisicion.getComponente(i, j) instanceof FuentePoder &&
                    Controlador_Adquisicion.getComponente(i, j+1) instanceof FuentePoder &&
                    Controlador_Adquisicion.getComponente(i+1, j) instanceof FuentePoder &&
                    Controlador_Adquisicion.getComponente(i+1, j+1) instanceof FuentePoder )
                    {
                        Controlador_Adquisicion.matrizComponentes[i][j] = null;
                        matrizLabels[i][j].setIcon(null);  
                        
                        Controlador_Adquisicion.matrizComponentes[i][j+1] = null;
                        matrizLabels[i][j+1].setIcon(null);  
                        
                        Controlador_Adquisicion.matrizComponentes[i+1][j] = null;
                        matrizLabels[i+1][j].setIcon(null);  
                        
                        Controlador_Adquisicion.matrizComponentes[i+1][j+1] = null;
                        matrizLabels[i+1][j+1].setIcon(null);  
                    
                    } else {
                        Controlador_Adquisicion.componenteAux = null;
                        Controlador_Adquisicion.isMover = false;
                        return;
                    }
                }
                
                else if(!Controlador_Adquisicion.componenteAux.isIs1x1()){
                    if(Controlador_Adquisicion.componenteAux.isIsVertical()){
                        if(i>=0 && 
                        Controlador_Adquisicion.getComponente(i+1, j)!=null && 
                        Controlador_Adquisicion.getComponente(i+1, j).getTipoComponente() == 
                        Controlador_Adquisicion.componenteAux.getTipoComponente())
                            
                        {
                                Controlador_Adquisicion.isArrIzq = true;
                                Controlador_Adquisicion.matrizComponentes[i+1][j] = null;
                                matrizLabels[i+1][j].setIcon(null);  
                                
                                Controlador_Adquisicion.matrizComponentes[i][j] = null;
                                matrizLabels[i][j].setIcon(null);
                                
                        } else{
                            Controlador_Adquisicion.componenteAux = null;
                            Controlador_Adquisicion.isMover = false;
                            return;
                        }
   
                    }
                    else{ //ES HORIZONTAL
                        if(j>=0 &&
                            Controlador_Adquisicion.getComponente(i, j+1)!=null&&
                            Controlador_Adquisicion.getComponente(i, j+1).getTipoComponente() == 
                            Controlador_Adquisicion.componenteAux.getTipoComponente())
                        {
                            Controlador_Adquisicion.isArrIzq = true;
                            Controlador_Adquisicion.matrizComponentes[i][j+1] = null;
                            matrizLabels[i][j+1].setIcon(null);
                            
                            Controlador_Adquisicion.matrizComponentes[i][j] = null;
                            matrizLabels[i][j].setIcon(null);
                            
                        } else{
                            Controlador_Adquisicion.componenteAux = null;
                            Controlador_Adquisicion.isMover = false;
                            return;
                        }       
                    }
                }
                               
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
        //CUANDO ES 4X4 TODO TERRENO TOYOTA FUENTE DE PODER
        
        else if(Controlador_Adquisicion.componenteAux instanceof FuentePoder){
            if(i<19 && j<19 &&
            Controlador_Adquisicion.getComponente(i, j) == null &&
            Controlador_Adquisicion.getComponente(i, j+1) == null &&
            Controlador_Adquisicion.getComponente(i+1, j) == null &&
            Controlador_Adquisicion.getComponente(i+1, j+1) == null){
                
                JLabel otroLabel;
                Point otroPoint;
                
                //Muevo las primer casilla
                Point pointThis = posicionar_ij(this.label);
                this.i = (int) pointThis.getY();
                this.y = (int) pointThis.getX();
                this.label.setIcon(Controlador_Adquisicion.componenteAux.getImagen());
                Controlador_Adquisicion.matrizComponentes[i][j] = Controlador_Adquisicion.componenteAux;
                
                //Muevo j+1
                otroLabel = matrizLabels[i][j+1];
                otroPoint = posicionar_ij(otroLabel);
                this.otroI = (int) otroPoint.getY();
                this.OtroJ = (int) otroPoint.getX();         
                otroLabel.setIcon(Controlador_Adquisicion.componenteAux.getImagen());
                Controlador_Adquisicion.matrizComponentes[otroI][OtroJ] = Controlador_Adquisicion.componenteAux;
                
                //Muevo i+1
                otroLabel = matrizLabels[i+1][j];
                otroPoint = posicionar_ij(otroLabel);
                this.otroI = (int) otroPoint.getY();
                this.OtroJ = (int) otroPoint.getX();         
                otroLabel.setIcon(Controlador_Adquisicion.componenteAux.getImagen());
                Controlador_Adquisicion.matrizComponentes[otroI][OtroJ] = Controlador_Adquisicion.componenteAux;
                
                //Muevo i+1, j+1
                otroLabel = matrizLabels[i+1][j+1];
                otroPoint = posicionar_ij(otroLabel);
                this.otroI = (int) otroPoint.getY();
                this.OtroJ = (int) otroPoint.getX();         
                otroLabel.setIcon(Controlador_Adquisicion.componenteAux.getImagen());
                Controlador_Adquisicion.matrizComponentes[otroI][OtroJ] = Controlador_Adquisicion.componenteAux;
                
            } else return;
        }
        
        //TODOS LOS DEMÁS
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
        Controlador_Adquisicion.componenteAux.getPoint().setLocation(j, i);
        if(Controlador_Adquisicion.isComprado && !(Controlador_Adquisicion.componenteAux instanceof Conector)){ //Creo el vertice
            Vertice vertice = new Vertice(Controlador_Adquisicion.componenteAux);
            Controlador_Adquisicion.componenteAux.setVertice(vertice);
            Controlador_Adquisicion.grafo.addVertice(vertice);
            System.out.println("Se creo un Vertice:  Cordenada: " +  vertice.getComponente().getPoint().y + "," + vertice.getComponente().getPoint().x);
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
