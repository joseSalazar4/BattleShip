
package Armas;

import Componentes.Componente;
import Componentes.Conector;
import Componentes.EspacioMuerto;
import Componentes.FuentePoder;
import Componentes.Remolino;
import Controlador.Controlador_Cliente;
import Controlador.marcarCasillaEnemigo;
import Cliente.DatosDeAtaque;
import battleship.Oceano;
import java.awt.Point;
import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

public abstract class AbstractArma implements Serializable{
    public int costo, escudo;
    String nombre;
    Oceano oceano;
    DatosDeAtaque datos;
    String jugador;
    boolean escudoActivado = false;
    
    public AbstractArma(){
        
    }
    
    public abstract Oceano atacar(marcarCasillaEnemigo casilla);
    
    public boolean golpear(Componente componente, Oceano oceano, Point point, DatosDeAtaque datos){
        if(componente != null){
            if(componente instanceof Conector){
                oceano.grafo.removeArista(componente.getPoint());
                destruirComponente(componente);
                datos.historialAtaque +=
                    jugador + " destruyó un conector de " 
                    + oceano.enemigo + " en la posición " + point.x  + "," + point.y + " usando " + this.nombre + "\n";
            }
            else if(componente.is1x1){
                if(componente instanceof Remolino) datos.golpeoRemolino = true;
                oceano.grafo.removeVertice(componente.getVertice());
                destruirComponente(componente);
                datos.historialAtaque +=
                    jugador + " destruyó un " + componente.getNombre() + " de "
                    + oceano.enemigo + " en la posición " + point.x  + "," + point.y + " usando " +  this.nombre + "\n";

            }
            else if(componente.is2x2 || !componente.is1x1){
                for(Point golpe : componente.getGolpes()){
                    if(golpe.x == point.x && golpe.y == point.y){
                      datos.historialAtaque +=
                        jugador + " volvió a golpear " + componente.getNombre() + " del oceano de"
                        + oceano.enemigo + " en la posición " + point.x  + "," + point.y + " usando " +  this.nombre + "\n"; 
                       return false;
                    }
                }
                componente.getGolpes().add(point);
                
                datos.historialAtaque += 
                    jugador + " golpeó una "+ componente.getNombre() +" del oceano de " 
                    + oceano.enemigo 
                    + " en la posición (" + point.x  + "," + point.y + ") usando " +  this.nombre + "\n";
                
                int ctdGolpes = 2;
                if(componente.is2x2) ctdGolpes = 4;
                
                if(componente.getGolpes().size() >= ctdGolpes){
                    if(componente instanceof FuentePoder) datos.destryoFuente = true;
                    oceano.grafo.removeVertice(componente.getVertice());
                    destruirComponente(componente);    
                    
                    datos.historialAtaque += 
                    jugador + " destruyó una "+ componente.getNombre() +" del oceano de " 
                    + oceano.enemigo 
                    + " en la posición " + point.x  + "," + point.y + " usando " + nombre + "\n";
                }
            }
        }
        else{
            datos.historialAtaque += 
                    jugador + " falló un disparo en el oceano de " 
                    + oceano.enemigo + "\n";
            return false;
        }
        
        
        return true;
        
        
    }
 
    public void destruirComponente(Componente componente){
        this.oceano.matrizComponentes[componente.getPoint().y][componente.getPoint().x] = new EspacioMuerto();
    }
    
    public boolean cobrarAcero() throws InterruptedException{
        Semaphore semaf = datos.jugador.getSemaforoAcero();
        sleep(100);
        semaf.tryAcquire(8, TimeUnit.SECONDS);
        
        int t = datos.jugador.getAcero();
        
        if(t>=costo){
            datos.jugador.setAcero(t-=costo);
            semaf.release();
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "No tiene suficiente Acero!\nIntentelo de nuevo.        ");
            semaf.release();
            return false;
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Oceano getOceano() {
        return oceano;
    }

    public void setOceano(Oceano oceano) {
        this.oceano = oceano;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public AbstractArma(int costo, int escudo) {
        this.costo = costo;
        this.escudo = escudo;
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    public boolean isEscudoActivado() {
        return escudoActivado;
    }

    public void setEscudoActivado(boolean escudoActivado) {
        this.escudoActivado = escudoActivado;
    }

    public DatosDeAtaque getDatos() {
        return datos;
    }

    public void setDatos(DatosDeAtaque datos) {
        this.datos = datos;
    }
    
    
    
}
