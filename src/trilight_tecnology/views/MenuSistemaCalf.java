package trilight_tecnology.views;

import java.util.Scanner;

public class MenuSistemaCalf extends Menu{
    public MenuSistemaCalf() {
    }
    public MenuSistemaCalf(String[] op, String titulo) {
        super(op,titulo);
    }

    @Override
    public Boolean capturarOpcion() {
        Integer op = leerOpcion();
        switch (op) {
            case 1:
                // Subir Calificaciones
                break;
            case 2:
                // Modificar calificaciones
                break;
            case 3:
                // Regresar al Menu Anterior
                return false;
        }
        return true;
    }
}
