/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.Serializable;

/**
 *
 * @author Personal
 */
public class DatosDeAtaque implements Serializable{
    public Jugador jugador;
    public String historialAtaque = "";
    public boolean golpeoRemolino = false;
    public boolean destryoFuente = false;
}
