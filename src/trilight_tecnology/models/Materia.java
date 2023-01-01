/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.models;

import java.lang.reflect.Field;
import java.util.ArrayList;

import trilight_tecnology.controllers.Casteador;

/**
 *
 * @author Milanesus
 */
public class Materia implements ToList,Registrable{
    public Integer clave;
    public String nombre;
    public Integer creditos;
    public Integer semestre;
    public Double calificacion;

    public Materia() {
    }

    public Materia(Integer clave, String nombre, Integer creditos, Integer semestre, double calificacion) {
        this.clave = clave;
        this.nombre = nombre;
        this.creditos = creditos;
        this.semestre = semestre;
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Materia{" + "clave=" + clave + ", nombre=" + nombre + ", creditos=" + creditos + ", semestre=" + semestre + ", calificacion=" + calificacion + '}';
    }

    @Override
    public ArrayList<String> toListStrings() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String recordDb() {
        String record = "";
        Casteador cast = new Casteador();
        record+=cast.notNullString(this.clave)+",";
        record+=cast.notNullString(this.nombre)+",";
        record+=cast.notNullString(this.creditos)+",";
        record+=cast.notNullString(this.semestre)+",";
        record+=cast.notNullString(this.calificacion);
        return record;
    }

}
