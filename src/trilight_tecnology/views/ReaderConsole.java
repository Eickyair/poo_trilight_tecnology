
package trilight_tecnology.views;
import java.util.Scanner;

import trilight_tecnology.models.RegistroAlumno;

public class ReaderConsole {
    private static ReaderConsole single = null;
    private Scanner input = null;
    private ReaderConsole(){
        input = new Scanner(System.in);
    }
    public Double readCalif(){
        String line = input.nextLine();
        Double calf = null;
        try {
            calf = Double.parseDouble(line);
        } catch (Exception e) {
            return null;
        }
        if(calf.doubleValue()<0 || calf.doubleValue()>10)return null;
        return calf;
    }
    public static ReaderConsole getInstance(){
        if(single == null){
            return new ReaderConsole();
        }
        return single;
    }
    public void espera(){
        System.out.println("Presiones Enter para Continuar");
        input.nextLine();
    }
    public RegistroAlumno leerActualizacion(RegistroAlumno old){
        RegistroAlumno nuevo = new RegistroAlumno();
        nuevo.apellido = old.apellido;
        nuevo.nombre = old.nombre;
        nuevo.idAlumno = old.idAlumno;
        nuevo.edad = old.edad;
        nuevo.direccion = old.direccion;
        int NUM_ATRRS = 3;
        String[] mensajes = {
            "Cual es el nuevo Nombre del Alumno?",
            "Cual es el nuevo Apellido del Alumno?",
            "Cual es la nueva Dirreccion del Alumno?",
        };
        for(int attr = 0;attr<NUM_ATRRS;attr++){
            System.out.println(mensajes[attr]);
            System.out.println("Solo de un Enter si es que NO quiere actualizar el valor");
            String line = input.nextLine();
            if(line.isEmpty()) continue;
            switch (attr) {
                case 0:
                    nuevo.nombre = line;
                    break;
                case 1:
                    nuevo.apellido = line;
                    break;
                case 2:
                    nuevo.direccion = line;
                    break;
            }
        }
        return nuevo;
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
            System.out.println("VALOR REQUERIDO");
            String line = input.nextLine();
            if(line.isEmpty()) return null;
            switch (attr) {
                case 0:
                    alumno.nombre = line;
                    break;
                case 1:
                    alumno.apellido = line;
                    break;
                case 2:
                    alumno.direccion = line;
                    break;
                case 3:
                    Integer edad = null;
                    try {
                        edad = Integer.parseInt(line);
                    } catch (Exception e) {
                        System.out.println("El formato de la edad es invalida");
                        return null;
                    }
                    alumno.edad = edad;
                    break;
            }
        }
        return alumno;
    }

    public String readLine(){
        return input.nextLine();
    }
}
