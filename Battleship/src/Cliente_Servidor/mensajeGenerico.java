/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Servidor;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Personal
 */
public class mensajeGenerico implements Serializable{
    int tipoMensaje;
    String descripcion;
    ArrayList<String> contenido;
    boolean is;

    public mensajeGenerico() {
        tipoMensaje = 0;
        this.descripcion = "";
        this.contenido = null;
        is = false;
    }

    public int getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(int tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<String> getContenido() {
        return contenido;
    }

    public void setContenido(ArrayList<String> contenido) {
        this.contenido = contenido;
    }

    public boolean isIs() {
        return is;
    }

    public void setIs(boolean is) {
        this.is = is;
    }
    
    
    
    
    
}
