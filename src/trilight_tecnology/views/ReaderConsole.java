
package trilight_tecnology.views;
import java.util.Scanner;

import trilight_tecnology.models.RegistroAlumno;

public class ReaderConsole {
    private static ReaderConsole single = null;
    private Scanner input = null;
    private ReaderConsole(){
        input = new Scanner(System.in);
    }
    public static ReaderConsole getInstance(){
        if(single == null){
            return new ReaderConsole();
        }
        return single;
    }

    public Integer readInteger(){
        String line = input.nextLine();
        Integer result = null;
        try {
            result = Integer.parseInt(line);
        } catch (Exception e) {
            return null;
        }
        return result;
    }
    public RegistroAlumno leerUnRegistroAlumno(){
        RegistroAlumno alumno = new RegistroAlumno();
        int NUM_ATRRS = 4;
        String[] mensajes = {
            "Cual es el Nombre del Alumno?",
            "Cual es el Apellido del Alumno?",
            "Cual es la Dirreccion del Alumno?",
            "Cual es la Edad del Alumno?"
        };
        for(int attr = 0;attr<NUM_ATRRS;attr++){
            System.out.println(mensajes[attr]);
            System.out.println("Solo de un Enter si es que quiere dejar el valor indefinido");
            String line = input.nextLine();
            if(line.isEmpty()) continue;
            switch (attr) {
                case 0:
                    alumno.nombre = line;
                    break;
                case 1:
                    alumno.apellido = line;
                case 2:
                    alumno.direccion = line;
                case 3:
                    alumno.edad = Integer.parseInt(line);
            }
        }
        return alumno;
    }
}
