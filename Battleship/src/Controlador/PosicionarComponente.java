/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Componentes.Componente.tipoComponente.Remolino;
import Grafo.Vertice;
import Componentes.Conector;
import Componentes.FuentePoder;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class PosicionarComponente implements MouseListener{
    int i, j;
    int otroI = 0, OtroJ = 0;
    JLabel label;
    JLabel[][] matrizLabels;
    Controlador_Adquisicion controlador;
    private double y;
    
    public PosicionarComponente(JLabel label, JLabel[][] matrizLabels, int i, int j,Controlador_Adquisicion _controlador){
        this.label = label;
        this.matrizLabels = matrizLabels;
        label.addMouseListener(this);
        this.controlador = _controlador;
        this.i=i;
        this.j=j;        
    }

    @Override
    public void mouseClicked(MouseEvent e){
        
        if(controlador.isConectar && controlador.getComponente(i, j) != null){ 
            if(controlador.getComponente(i, j) instanceof Conector)
            {   
                //Establecer el conector que se va a usar
                controlador.conectorAux = (Conector) controlador.getComponente(i, j);
            }
            
            else if(controlador.getComponente(i, j) instanceof FuentePoder
            && controlador.conectorAux != null)
            {   
                //Establecer la fuente
                //Un conector puede cambiar de fuente ? 
                controlador.conectorAux.setFuente( (FuentePoder) controlador.getComponente(i, j));
            }
            
            else if(controlador.conectorAux != null
            &&  controlador.conectorAux.getFuente() != null 
            &&  controlador.conectorAux.getTipoComponente() != Remolino)
            {   
                //Agregar el destino y crear la arista
                //Si este componente ya habia sido agregado no se hace nada
                boolean fueAgregado =  controlador.conectorAux.addDestino(controlador.getComponente(i, j));
                if(fueAgregado){
                    controlador.grafo.addArista
                        (controlador.conectorAux.getFuente().getVertice(), 
                        controlador.getComponente(i, j).getVertice(), 
                        controlador.conectorAux);
                    
                    controlador.conectorAux = null;
                    controlador.setIsConectar();
                    
                    controlador.trazarConexiones();
                    
                    
                } else System.out.println("Ya habia sido agregado");
                
            }
        }
        
        else if(controlador.isComprado){ //Compro un componente y lo va a posicionar
            if(controlador.componenteAux != null){ // Verifica si donde lo va a mover esté vacio
                if(controlador.getComponente(i, j) == null){
                    mover();
                    controlador.trazarConexiones();
                }                                    
                //ERROR
            }
            //ERROR
        }
        else{
            if(controlador.isMover){ //Va a mover un componente de la matriz a este label
                if(controlador.componenteAux != null){ 
                    if(controlador.getComponente(i, j) == null){
                       mover(); 
                       controlador.trazarConexiones();
                    }
                        
                }
            }
            
            else if(controlador.getComponente(i, j) != null && controlador.getComponente(i, j).getTipoComponente()!= Remolino ){ //Va a mover este elemento
                controlador.isMover = true;
                controlador.componenteAux = controlador.getComponente(i, j);
                
                
                
                //CUANDO ES 4X4 
                if(controlador.componenteAux instanceof FuentePoder){
                    if(i<19 && j<19 &&
                    controlador.getComponente(i, j) instanceof FuentePoder &&
                    controlador.getComponente(i, j+1) instanceof FuentePoder &&
                    controlador.getComponente(i+1, j) instanceof FuentePoder &&
                    controlador.getComponente(i+1, j+1) instanceof FuentePoder )
                    {
                        controlador.matrizComponentes[i][j] = null;
                        matrizLabels[i][j].setIcon(null);  
                        
                        controlador.matrizComponentes[i][j+1] = null;
                        matrizLabels[i][j+1].setIcon(null);  
                        
                        controlador.matrizComponentes[i+1][j] = null;
                        matrizLabels[i+1][j].setIcon(null);  
                        
                        controlador.matrizComponentes[i+1][j+1] = null;
                        matrizLabels[i+1][j+1].setIcon(null);  
                    
                    } else {
                        controlador.componenteAux = null;
                        controlador.isMover = false;
                        return;
                    }
                }
                
                else if(!controlador.componenteAux.isIs1x1()){
                    if(controlador.componenteAux.isIsVertical()){
                        if(i>=0 && 
                        controlador.getComponente(i+1, j)!=null && 
                        controlador.getComponente(i+1, j).getTipoComponente() == 
                        controlador.componenteAux.getTipoComponente())
                            
                        {
                                controlador.isArrIzq = true;
                                controlador.matrizComponentes[i+1][j] = null;
                                matrizLabels[i+1][j].setIcon(null);  
                                
                                controlador.matrizComponentes[i][j] = null;
                                matrizLabels[i][j].setIcon(null);
                                
                        } else{
                            controlador.componenteAux = null;
                            controlador.isMover = false;
                            return;
                        }
   
                    }
                    else{ //ES HORIZONTAL
                        if(j>=0 &&
                            controlador.getComponente(i, j+1)!=null&&
                            controlador.getComponente(i, j+1).getTipoComponente() == 
                            controlador.componenteAux.getTipoComponente())
                        {
                            controlador.isArrIzq = true;
                            controlador.matrizComponentes[i][j+1] = null;
                            matrizLabels[i][j+1].setIcon(null);
                            
                            controlador.matrizComponentes[i][j] = null;
                            matrizLabels[i][j].setIcon(null);
                            
                        } else{
                            controlador.componenteAux = null;
                            controlador.isMover = false;
                            return;
                        }       
                    }
                }
                controlador.matrizComponentes[i][j] = null;
                matrizLabels[i][j].setIcon(null);
                //controlador.getPantalla().getPanelJugador().setBackground(Color.red);
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
        if(controlador.componenteAux.isIs1x1()){
            Point pointThis = posicionar_ij(this.label);
            this.i = (int) pointThis.getY();
            this.y = (int) pointThis.getX();
            if(controlador.getComponente(this.i, this.j) == null){
               this.label.setIcon(controlador.componenteAux.getImagen());
                controlador.matrizComponentes[i][j] = controlador.componenteAux; 
            }
            else return;
        }
        //CUANDO ES 4X4 TODO TERRENO TOYOTA FUENTE DE PODER
        
        else if(controlador.componenteAux instanceof FuentePoder){
            if(i<19 && j<19 &&
            controlador.getComponente(i, j) == null &&
            controlador.getComponente(i, j+1) == null &&
            controlador.getComponente(i+1, j) == null &&
            controlador.getComponente(i+1, j+1) == null){
                
                JLabel otroLabel;
                Point otroPoint;
                
                //Muevo las primer casilla
                Point pointThis = posicionar_ij(this.label);
                this.i = (int) pointThis.getY();
                this.y = (int) pointThis.getX();
                this.label.setIcon(controlador.componenteAux.getImagen());
                controlador.matrizComponentes[i][j] = controlador.componenteAux;
                
                //Muevo j+1
                otroLabel = matrizLabels[i][j+1];
                otroPoint = posicionar_ij(otroLabel);
                this.otroI = (int) otroPoint.getY();
                this.OtroJ = (int) otroPoint.getX();         
                otroLabel.setIcon(controlador.componenteAux.getImagen());
                controlador.matrizComponentes[otroI][OtroJ] = controlador.componenteAux;
                
                //Muevo i+1
                otroLabel = matrizLabels[i+1][j];
                otroPoint = posicionar_ij(otroLabel);
                this.otroI = (int) otroPoint.getY();
                this.OtroJ = (int) otroPoint.getX();         
                otroLabel.setIcon(controlador.componenteAux.getImagen());
                controlador.matrizComponentes[otroI][OtroJ] = controlador.componenteAux;
                
                //Muevo i+1, j+1
                otroLabel = matrizLabels[i+1][j+1];
                otroPoint = posicionar_ij(otroLabel);
                this.otroI = (int) otroPoint.getY();
                this.OtroJ = (int) otroPoint.getX();         
                otroLabel.setIcon(controlador.componenteAux.getImagen());
                controlador.matrizComponentes[otroI][OtroJ] = controlador.componenteAux;
                
            } else return;
        }
        
        //TODOS LOS DEMÁS
        else{
                      
            if(controlador.componenteAux.isIsVertical()){
                if(i<19 && controlador.getComponente(i+1, j) == null){
                    Point pointThis = posicionar_ij(this.label);
                    this.i = (int) pointThis.getY();
                    this.y = (int) pointThis.getX();
                    
                    if((controlador.componenteAux.isIsVertical()&&i==19)
                    ||(!controlador.componenteAux.isIsVertical()&&j==19)) return;

                    if(controlador.getComponente(i, j) != null) return;

                    this.label.setIcon(controlador.componenteAux.getImagen());

                    controlador.matrizComponentes[i][j] = controlador.componenteAux;
                    
                    //LA SEGUNDO LABEL ES EL DE ABAJO
                    JLabel otroLabel = matrizLabels[i+1][j];
                    Point otroPoint = posicionar_ij(otroLabel);
                    this.otroI = (int) otroPoint.getY();
                    this.OtroJ = (int) otroPoint.getX();
                    
                    otroLabel.setIcon(controlador.componenteAux.getImagen());
                    controlador.matrizComponentes[otroI][OtroJ] = controlador.componenteAux;
                }
                else return;
        
            }
            
            else{
                //ES HORIZANTAL
                if(j<19 && controlador.getComponente(i, j+1) == null){
                    Point pointThis = posicionar_ij(this.label);
                    this.i = (int) pointThis.getY();
                    this.y = (int) pointThis.getX();
                    if((controlador.componenteAux.isIsVertical()&&i==19)||(!controlador.componenteAux.isIsVertical()&&j==19))
                        return;

                    if(controlador.getComponente(i, j) != null) return;

                    this.label.setIcon(controlador.componenteAux.getImagen());
                    controlador.matrizComponentes[i][j] = controlador.componenteAux;
                    
                    //LA SEGUNDO LABEL ES EL DE DERECHA
                    JLabel otroLabel = matrizLabels[i][j+1];
                    Point otroPoint = posicionar_ij(otroLabel);
                    this.otroI = (int) otroPoint.getY();
                    this.OtroJ = (int) otroPoint.getX();
                    
                    otroLabel.setIcon(controlador.componenteAux.getImagen());
                    controlador.matrizComponentes[this.otroI][this.OtroJ] = controlador.componenteAux;
                }
                else return;
                 
            }
        }
        controlador.componenteAux.getPoint().setLocation(j, i);
        if(controlador.isComprado && !(controlador.componenteAux instanceof Conector)){ //Creo el vertice
            Vertice vertice = new Vertice(controlador.componenteAux);
            controlador.componenteAux.setVertice(vertice);
            controlador.grafo.addVertice(vertice);
            System.out.println("Se creo un Vertice:  Cordenada: " +  vertice.getComponente().getPoint().y + "," + vertice.getComponente().getPoint().x);
        }
        
        controlador.componenteAux = null;
        controlador.isComprado = false;
        controlador.isMover = false;
        Controlador_Adquisicion.pantalla.getLabelInstruccion().setVisible(false);
        //controlador.getPantalla().getPanelJugador().setBackground(Color.blue);
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
