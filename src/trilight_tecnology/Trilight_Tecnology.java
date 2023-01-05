/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trilight_tecnology;

import trilight_tecnology.controllers.Generar;
import trilight_tecnology.controllers.LogAdminControl;
import trilight_tecnology.views.LimpiarConsola;
import trilight_tecnology.views.LogAdminView;
import trilight_tecnology.views.Menu;
import trilight_tecnology.views.Presentacion;

/**
 *
 * @author Anvil
 */
public class Trilight_Tecnology {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LimpiarConsola limpiador = new LimpiarConsola();
        // Descomentar las siguientes lineas si es que deseas generar nuevos alumnos
        // Generar x = new Generar("./db/alumnos.csv");
        // x.generarAlumnos("./db/mainAlu.csv");
        limpiador.limpiarTodo();
        Presentacion.presentacion();
        LogAdminControl logCo = new LogAdminControl();
        LogAdminView logView = new LogAdminView();
        String[] data = logView.getInfoLog();
        Boolean valido = logCo.validarUsuario(data[0], data[1]);
        if(!valido){
            System.out.println("Usuario o contrasenia incorrecto");
            return;
        }
        limpiador.limpiarTodo();
        String[] op = {
            "Gestion de registros de los alumnos",
            "Gestion de calificaciones",
            "Gestion de los numeros de inscripccion",
            "Salir"
        };
        Menu m = new Menu(op,"__OPCIONES PRINCIPALES__");
        m.opcionesPrincipales();
    }
}
