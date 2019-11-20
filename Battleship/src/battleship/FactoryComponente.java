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
    
    public static Componente crearComponente(int num, int opcionExtra){
        switch(num){
            case 1:
                return new Armeria(opcionExtra);
                    
            case 2:
                return new Mina(opcionExtra);
                
            case 3:
                return new Templo();
                
            case 4:
                return new Fabrica();
                //CREO QUE LAS DE ABAJO NO SON NECESARIAS
            case 5:
              //  return new Fuente();
            case 6:
              //  return new Conector();
        }
        System.out.println("ERROR AL CREAR EN FctoryComponente REVISAR ");
        return null;
    }    
}
