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
    /**
     * Menu para la gestion de alumnos
     * @param op Array de opcciones
     * @param titulo Titulo del menu
     */
    public MenuAdministracionAlumnos(String[] op, String titulo){
        super(op,titulo);
    }
    @Override
    public Boolean capturarOpcion(){
        Integer op = leerOpcion();
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
        }
        return true;
    }
}
