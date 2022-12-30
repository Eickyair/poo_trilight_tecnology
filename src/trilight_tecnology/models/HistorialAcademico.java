/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.models;

import java.util.Hashtable;


/**
 *
 * @author Milanesus
 */
public class HistorialAcademico {
    public Integer idAlumno;
    public double promedio;
    public Hashtable<Integer, Semestre> semestres;
    public Integer semestreActual;
    public HistorialAcademico() {
    }
    
     
    public HistorialAcademico(Integer idAlumno, double promedio, Hashtable<Integer, Semestre> semestres) {
        this.idAlumno = idAlumno;
        this.promedio = promedio;
        this.semestres = semestres;
    }
    
    
}
