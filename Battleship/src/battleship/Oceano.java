/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import Componentes.Componente;
import Grafo.Grafo;
import java.io.Serializable;

/**
 *
 * @author Personal
 */
public class Oceano implements Serializable {
    public String enemigo;
    public Grafo grafo;
    public Componente[][] matrizComponentes;
}
