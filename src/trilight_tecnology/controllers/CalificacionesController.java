/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.controllers;

import java.util.ArrayList;

import trilight_tecnology.models.Materia;

/**
 * CRUD de las calificaciones
 * @author chaia
 */
public class CalificacionesController {
    public CalificacionesController(){}
    public Boolean guardarMateria(Materia toSave,Integer idAlumno){
        Csv csv = new Csv("./db/registros/"+idAlumno.toString()+".csv");
        String record = toSave.recordDb();
        return csv.insertarUnRegistro(record);
    }

    public Materia buscarMateriaEnArray(ArrayList<Materia> materias,Integer clave){
        for(Materia materia : materias){
            if(materia.clave.intValue() == clave.intValue())return materia;
        }
        return null;
    }
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
