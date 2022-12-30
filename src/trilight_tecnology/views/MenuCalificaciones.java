/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;

import java.util.Scanner;
import trilight_tecnology.controllers.CalificacionesController;

/**
 *
 * @author chaia
 */
public class MenuCalificaciones extends Menu{

    public MenuCalificaciones() {
    }

    public MenuCalificaciones(String[] op) {
        super(op);
    }

    @Override
    public Boolean capturarOpcion() {
        //Variables para el MENU PRINCIPAL
        Scanner opt = new Scanner(System.in);
        System.out.println("Escoge una opcion:");
        int op = Integer.parseInt(opt.nextLine());
        CalificacionesController controler = new CalificacionesController();
        switch (op) {
            case 1:
                // Consultar calificación
                controler.mostrarCalificaciones();
                break;
            case 2:
                // Actualizar calificación
                break;
            case 3:
                return false;
            default:
                throw new AssertionError();
        }
        return true;
    }
    
}
