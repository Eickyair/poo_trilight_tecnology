/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.controllers;

import java.util.Arrays;

import trilight_tecnology.models.RegistroAlumno;
import trilight_tecnology.views.RegistrosAlumnosView;

/**
 * CRUD de los alumnos
 * @author Anvil
 */
public class RegistrosAlumnosControler {
    private RegistroAlumno[] alumnos  = null;
    private RegistroAlumno alumno;

    public RegistrosAlumnosControler(){
        Csv  csv = new Csv("./db/mainAlu.csv");
        String[] todosLosRegistros = csv.getAllRecords();
        Casteador cast = new Casteador();
        alumnos = new RegistroAlumno[todosLosRegistros.length];
        for (int i = 0; i < alumnos.length; i++) {
            alumno = cast.castRegistroAlumno(todosLosRegistros[i]);
            alumnos[i] = alumno;
        }
    }
    public void ordenarPorNombre(){
        Arrays.sort(alumnos,(first,second) -> {
            if(first.nombre.compareTo(second.nombre)<0) return -1;
            return 1;
        });
    }
    public void mostrarAlumnos(){
        RegistrosAlumnosView view = new RegistrosAlumnosView(alumnos);
        view.mostrarEnSlides(20);
    }

    public Boolean borrarAlumno(Integer id){
        Csv csv = new Csv("./db/mainAlu.csv");
        String[] data = csv.getAllRecords();
        Casteador caster = new Casteador();
        for (int i = 0; i < data.length; i++) {
            alumno = caster.castRegistroAlumno(data[i]);
            if(alumno.idAlumno == id){
               return csv.elimarRegistro(i);
            }
        }
        return false;
    }
    public RegistroAlumno busqueda(Integer idAlumno){
        Csv csv = new Csv("./db/mainAlu.csv");
        String[] alumnos = csv.getAllRecords();
        Casteador cast = new Casteador();
        for (int renglon = 0; renglon < alumnos.length; renglon++) {
            alumno = cast.castRegistroAlumno(alumnos[renglon]);
            if(alumno.idAlumno==idAlumno)return alumno;
        }
        return null;
    }

    public Boolean guardarAlumno(RegistroAlumno alumno){
        Csv csv = new Csv("./db/mainAlu.csv");
        String record = alumno.recordDb();
        return csv.insertarUnRegistro(record);
    }
    public Boolean actualizarAlumno(RegistroAlumno nuevo){
        borrarAlumno(nuevo.idAlumno);
        return guardarAlumno(nuevo);
    }
}
