package trilight_tecnology.models;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Anvil
 */
public class RegistroAlumno implements Registrable,ToList {
    public Integer idAlumno;
    public String nombre;
    public String apellido;
    public String direccion;
    public Integer edad;
    /**
     * Este atributo se determina a partir de cada historial(hay que hacer
     * una consulta)
     * ya que habra que ver cual es el ultimo semestre registrado
     * y sumarle 1 a ese valor
     */
    public Integer semestreEnCurso;

    public RegistroAlumno() {
    }
    /**
     * Construccion de un Registro de un alumno
     * @param idAlumno Numero de cuenta del alumno
     * @param nombre Nombre del alumno
     * @param apellido Apellido del alumno
     * @param direccion Direccion en donde habita el alumno
     * @param edad 
     */
    public RegistroAlumno(Integer idAlumno, String nombre, String apellido, String direccion, Integer edad) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
    }

    /**
     * Retorna el formato en que debe ser escrito
     * en los csv los objetos Registro alumno
     * @return Devuelve la cadena con la informacion que
     * tiene este objeto para ser escrita en un csv
     */
    @Override
    public String recordDb() {
        String record;
        record = ""+idAlumno+","+nombre+","+apellido+","+direccion+","+edad;
        return record;
    }

    @Override
    public String toString() {
        String s = ""+idAlumno+"\t"+nombre+"\t"+apellido+"\t"+direccion+"\t"+edad;
        return s;
    }

    @Override
    public ArrayList<String> toListStrings() {
        ArrayList<String> a = new ArrayList<String>();
        a.add(idAlumno.toString());
        a.add(nombre);
        a.add(apellido);
        a.add(edad.toString());
        return a;
    }
     
     
}
