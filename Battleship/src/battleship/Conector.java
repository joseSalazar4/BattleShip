/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import static battleship.Componente.tipoComponente.Conector;
import java.util.ArrayList;
/**
 *
 * @author mikom
 */
public class Conector extends Componente {
    
    FuentePoder fuente;
    ArrayList<Componente> destinos;
    
    Conector(){
        this.tipoComponente = Conector;
        nombre = "Conector";
        destinos = new ArrayList<>();
        this.is1x1 = true;
        this.imagen = new javax.swing.ImageIcon(getClass().getResource("/Vista/Resources/Conector.png"));   
    }

    public FuentePoder getFuente() {
        return fuente;
    }

    public void setFuente(FuentePoder fuente) {
        this.fuente = fuente;
    }

    public ArrayList<Componente> getDestinos() {
        return destinos;
    }

    public void setDestinos(ArrayList<Componente> destinos) {
        this.destinos = destinos;
    }
    
    public boolean addDestino(Componente componente){
        if(!this.destinos.contains(componente)){
            this.destinos.add(componente);
            return true;
        } 
        else return false;
    }
}
