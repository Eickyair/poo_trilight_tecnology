/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;

/**
 *
 * @author chaia
 */
public class MenuCalificaciones extends Menu{

    public MenuCalificaciones() {
    }

    public MenuCalificaciones(String[] op,String titulo) {
        super(op,titulo);
    }

    @Override
    public Boolean capturarOpcion() {
        Integer op = leerOpcion();
        switch (op) {
            case 1:
                // Consultar calificación
                break;
            case 2:
                // Actualizar calificación
                break;
            case 3:
                return false;
        }
        return true;
    }
}
