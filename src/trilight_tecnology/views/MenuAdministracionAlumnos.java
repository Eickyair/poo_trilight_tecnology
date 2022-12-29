/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;

import java.util.Scanner;
import trilight_tecnology.controllers.RegistrosAlumnosControler;

/**
 *
 * @author Anvil
 */
public class MenuAdministracionAlumnos extends Menu{

    public MenuAdministracionAlumnos() {
    }

    public MenuAdministracionAlumnos(String[] op) {
        super(op);
    }
     
    @Override
    public Boolean capturarOpcion(){
        //Variables para el MENU PRINCIPAL
        Scanner opt = new Scanner(System.in);
        System.out.println("Escoge una opcion:");
        int op = Integer.parseInt(opt.nextLine());
        RegistrosAlumnosControler controler = new RegistrosAlumnosControler();
        switch (op) {
            case 1:
                // Crear Alumno
                break;
            case 2:
                // Consultar un alumno
                break;
            case 3:
                // Actualizar un alumno
                break;
            case 4:
                // Eliminar un alumno
                break;
            case 5:
                return false;
            default:
                throw new AssertionError();
        }
        return true;
    }
    
}
