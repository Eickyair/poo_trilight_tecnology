/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.models;

import java.util.Hashtable;


/**
 * Clase encargada de enpaquetar la informacion de un historial
 * @author Milanesus
 */
public class HistorialAcademico {
    public Integer idAlumno;
    public double promedio;
    public Hashtable<Integer, Semestre> semestres;
    public Integer semestreActual;
    /**
     * Constructor vacio
     */
    public HistorialAcademico() {
    }
    /**
     * Costructor que inicializa el objeto con
     * @param idAlumno Alumno al que pertenece este historial
     * @param promedio Promedio general del alumno
     * @param semestres Informacion de cada uno de los semestres
     */
    public HistorialAcademico(Integer idAlumno, double promedio, Hashtable<Integer, Semestre> semestres) {
        this.idAlumno = idAlumno;
        this.promedio = promedio;
        this.semestres = semestres;
    }
    
}
