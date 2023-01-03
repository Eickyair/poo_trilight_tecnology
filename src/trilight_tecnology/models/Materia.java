/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.models;

import java.util.ArrayList;



import trilight_tecnology.controllers.Casteador;
import trilight_tecnology.views.Fila;
import trilight_tecnology.views.Tabla;

/**
 * Clase que enpaqueta la informacion de una materia
 * cursada
 * @author Milanesus
 */
public class Materia implements ToList,Registrable{
    public Integer clave;
    public String nombre;
    public Integer creditos;
    public Integer semestre;
    public Double calificacion;
    /**
     * Constructor vacio
     */
    public Materia() {
    }
    /**
     * Constructor que inicializa el objeto con
     * @param clave Clave de la materia
     * @param nombre Nombre de la materia
     * @param creditos Creditos que otorga la materia
     * @param semestre Semestre en que fue cursada
     * @param calificacion Calificacion obtenida
     */
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
        ArrayList<String> values=new ArrayList<String>();
        values.add(clave.toString());
        values.add(nombre);
        values.add(creditos.toString());
        values.add(calificacion.toString());
        return values;
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
    /**
     * Despligue de la materia como renglon de una tabla
     */
    public void mostrarMateriaComoFila(){
        Tabla tabla = new Tabla();
        ArrayList<String> values = toListStrings();
        ArrayList<Integer> lens = toListIntegers();
        Fila fila = new Fila();
        fila.values = values;
        fila.lens = lens;
        fila.top = tabla.separar(lens, "+");
        fila.showRow(true, false);
    }
    /**
     * Despliegue de la materia como renglon de una tabla pero 
     * omitiendo su calificacion y sustituyendo por NAN
     * @param actualizar
     */
    public void mostrarMateriaComoFila(Boolean actualizar){
        Tabla tabla = new Tabla();
        ArrayList<String> values = toListStrings();
        values.remove(3);
        values.add("NAN");
        ArrayList<Integer> lens = toListIntegers();
        Fila fila = new Fila();
        fila.values = values;
        fila.lens = lens;
        fila.top = tabla.separar(lens, "+");
        fila.showRow(true, false);
    }
    @Override
    public ArrayList<Integer> toListIntegers() {
        ArrayList<Integer> lens = new ArrayList<Integer>();
        lens.add(10);
        lens.add(50);
        lens.add(10);
        lens.add(15);
        return lens;
    }

}
