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
                // Gestion de alumnos
                String[] opcionesMenuAlu = {
                    "Crear un Alumno",
                    "Consultar la informacion de un Alumno",
                    "Actualizar la informarion de un Alumno",
                    "Eliminar el registro de un Alumno",
                    "Regresar"
                };
                MenuAdministracionAlumnos ma = new MenuAdministracionAlumnos(opcionesMenuAlu);
                ma.opcionesPrincipales();
                break;
            case 2:
                // Gestion de materias
                String[] opcionesMenuMate = {
                    "Consultar el historial academico de un Alumno",
                    "Actualizar el historial academico de un Alumno",
                    "Regresar"
                };
                MenuCalificaciones mc = new MenuCalificaciones(opcionesMenuMate);
                mc.opcionesPrincipales();
                break;            
            case 3:
                // Determinar numeros de inscripccions
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
