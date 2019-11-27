
package Controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class marcarCasillaEnemigo implements MouseListener, Serializable{
    JLabel label;
    Controlador_Cliente controlador;
    int i, j;
    ImageIcon image;
    ImageIcon imageAnterior;
    
    public marcarCasillaEnemigo(JLabel label, int i, int j, Controlador_Cliente controlador, ImageIcon image){
        this.label = label;
        this.controlador = controlador;
        this.label.addMouseListener(this);
        this.image = image;

        this.i = i;
        this.j = j;
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("MOUSE CLICKED"); 
        if(controlador.getLabelEnemigoSeleccionado() != null){
            controlador.getLabelEnemigoSeleccionado().getLabel().setIcon(controlador.getImageAnterior());
        }
        controlador.setLabelEnemigoSeleccionado(this);
        controlador.setImageAnterior((ImageIcon) label.getIcon());
        this.label.setIcon(image);
        
    }

    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public Controlador_Cliente getControlador() {
        return controlador;
    }

    public void setControlador(Controlador_Cliente controlador) {
        this.controlador = controlador;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
    
    
    
}
