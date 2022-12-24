/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;

import java.util.Scanner;

/**
 *
 * @author Anvil
 */
public class Menu {
    private String[] op;

    public Menu() {
    }

    public Menu(String[] op) {
        this.op = op;
    }
    
    /**
     * Despliegue de las opciones principales
     */
    public void opcionesPrincipales(){
        Boolean continuar = true;
        while(continuar){
            for (int i = 0; i < op.length; i++) {
                System.out.println(""+(i+1)+") "+op[i]);
            }
            continuar = capturarOpcion();
        }
    }
    
    /**
     * Ejecucion de la tarea seleccionada
     * @return Retorna si se cerro sesion o no
     */
    public Boolean capturarOpcion(){
        //Variables para el MENU PRINCIPAL
        Scanner opt = new Scanner(System.in);
        System.out.println("Escoge una opcion:");
        int op = Integer.parseInt(opt.nextLine());
        switch (op) {
            case 1:
                
                break;
            case 2:
                
                break;            
            case 3:
                
                break;            
            case 4:
                //salir
                return false;
                
            default:
                throw new AssertionError();
        }
        return true;
    }
}
