/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.models;

import java.util.ArrayList;

/**
 *
 * @author Milanesus
 */
public class Materia implements ToList{
    public Integer clave;
    public String nombre;
    public Integer creditos;
    public Integer idAlumno;
    public Integer semestre;
    public Double calificacion;

    public Materia() {
    }

     
    public Materia(Integer clave, String nombre, Integer creditos, Integer idAlumno, double calificacion) {
        this.clave = clave;
        this.nombre = nombre;
        this.creditos = creditos;
        this.idAlumno = idAlumno;
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Materia{" + "clave=" + clave + ", nombre=" + nombre + ", creditos=" + creditos + ", idAlumno=" + idAlumno + ", semestre=" + semestre + ", calificacion=" + calificacion + '}';
    }

    @Override
    public ArrayList<String> toListStrings() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
