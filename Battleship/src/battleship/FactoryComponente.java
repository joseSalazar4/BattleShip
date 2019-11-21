/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author mikom
 */

//{Armeria,Mina, Templo, Mercado, Conectores, FuenteEnergia
public class FactoryComponente {
    
    public static Componente crearComponente(ItemCompra num, int opcionExtra){
        switch(num){
            case ARMERIA:
                return new Armeria(opcionExtra);
                    
            case MINA:
                return new Mina(opcionExtra+1);  //Porque viene index desde 0-4
                
            case TEMPLO:
                return new Templo();
                
            case MERCADO:
                return new Mercado();
            
        }
        System.out.println("ERROR AL CREAR EN FctoryComponente REVISAR ");
        return null;
    }    
}
