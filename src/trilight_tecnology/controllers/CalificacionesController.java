/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.controllers;

import java.util.ArrayList;

import trilight_tecnology.models.Materia;

/**
 * Manipulacion de la informacion de las calificaciones
 * @author chaia
 */
public class CalificacionesController {
    /**
     * Constructor vacio
     */
    public CalificacionesController(){}
    /**
     * Guardado de una materia en el historial del alumno
     * @param toSave Materia a guardar en el csv
     * @param idAlumno alumno a quien pertenece esta informacion
     * de la materia
     * @return status de la operacion
     */
    public Boolean guardarMateria(Materia toSave,Integer idAlumno){
        Csv csv = new Csv("./db/registros/"+idAlumno.toString()+".csv");
        String record = toSave.recordDb();
        return csv.insertarUnRegistro(record);
    }
    /**
     * Determinacion de si una materia esta en una lista de materias a
     * apartir de su clave
     * @param materias lista en donde buscar
     * @param clave clave a buscar
     * @return null si no se encontro, un objeto materia con la clave otorgada
     */
    public Materia buscarMateriaEnArray(ArrayList<Materia> materias,Integer clave){
        for(Materia materia : materias){
            if(materia.clave.intValue() == clave.intValue())return materia;
        }
        return null;
    }
    /**
     * Actulizacion del archivo con la informacion del historial de un alumno
     * en cuanto a una materia ya registrada
     * @param nuevo Nueva informacion del registro
     * @param idAlumno Alumno quien recibira la informacion
     * @return status de la operacion
     */
    public Boolean actualizarMateria(Materia nuevo,Integer idAlumno){
        Csv csv = new Csv("./db/registros/"+idAlumno.toString()+".csv");
        String[] records = csv.getAllRecords();
        Materia materia = null;
        Casteador casteador = new Casteador();
        for (int i = 0; i < records.length; i++) {
            materia = casteador.castMateria(records[i]);
            if(materia.clave.intValue()==nuevo.clave.intValue()){
                return csv.actualizarUnRegistro(nuevo.recordDb(),i);
            }
        }
        return false;
    }
}
