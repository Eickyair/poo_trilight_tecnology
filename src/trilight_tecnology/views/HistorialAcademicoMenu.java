/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;

import java.util.Scanner;
import trilight_tecnology.controllers.HistorialAcademicoControler;

/**
 *
 * @author Milanesus
 */
public class HistorialAcademicoMenu extends Menu{
    
    public HistorialAcademicoMenu(){
        
    }
    
    public HistorialAcademicoMenu(String[] op) {
        super(op);
    }
    
    @Override
    public Boolean capturarOpcion(){
        //Variables para el MENU PRINCIPAL
        Scanner opt = new Scanner(System.in);
        System.out.println("Escoge una opcion:");
        int op = Integer.parseInt(opt.nextLine());
        HistorialAcademicoControler controler = new HistorialAcademicoControler();
        switch (op) {
            case 1:
                // Consultar Historial
                break;
            case 2:
                // Seleccionar Alumno
            case 3:
                return false;
            default:
                throw new AssertionError();
        }
        return true;
    }
}
