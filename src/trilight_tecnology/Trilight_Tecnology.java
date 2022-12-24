/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trilight_tecnology;

import trilight_tecnology.controllers.Generar;
import java.util.InputMismatchException;
import java.util.Scanner;
import trilight_tecnology.controllers.LogAdminControl;
import trilight_tecnology.views.LogAdminView;
import trilight_tecnology.views.Menu;

/**
 *
 * @author Anvil
 */
public class Trilight_Tecnology {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Generar x = new Generar("./src/db/alumnos.csv","");
        LogAdminControl logCo = new LogAdminControl();
        LogAdminView logView = new LogAdminView();
        String[] data = logView.getInfoLog();
        Boolean valido = logCo.validarUsuario(data[0], data[1]);
         
        if(!valido){
            System.out.println("Usuario o contrasenia incorrecto");
            return;
        }
        String[] op = {
            "Consultar registros",
            "Consultar datos personales",
            "Consultar numero de inscripccion",
            "Salir"
        };
        Menu m = new Menu(op);
        m.opcionesPrincipales();
    }
}
