/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.controllers;

import java.util.ArrayList;


import trilight_tecnology.models.RegistroAlumno;
import trilight_tecnology.views.RegistrosAlumnosView;

/**
 * CRUD de los alumnos
 * @author Anvil
 */
public class RegistrosAlumnosControler {
    public RegistrosAlumnosControler(){
    }

    public ArrayList<RegistroAlumno> getAlumnos(){
        Csv csv = new Csv("./db/mainAlu.csv");
        String[] infos = csv.getAllRecords();
        RegistroAlumno alumno = null;
        ArrayList<RegistroAlumno> alumnos = new ArrayList<RegistroAlumno>();
        Casteador casteador = new Casteador();
        for(String info : infos){
            alumno = casteador.castRegistroAlumno(info);
            alumnos.add(alumno);
        }
        return alumnos;
    }



    public Boolean borrarAlumno(Integer id){
        Csv csv = new Csv("./db/mainAlu.csv");
        String[] data = csv.getAllRecords();
        Casteador caster = new Casteador();
        RegistroAlumno alumno = null;
        for (int i = 0; i < data.length; i++) {
            alumno = caster.castRegistroAlumno(data[i]);
            if(alumno.idAlumno.intValue() == id.intValue()){
                Boolean res = csv.elimarRegistro(i);
                return res;
            }
        }
        return false;
    }

    public Boolean guardarAlumno(RegistroAlumno alumno){
        Csv csv = new Csv("./db/mainAlu.csv");
        Generar generar = new Generar("./db/alumnos.csv");
        alumno.idAlumno = Generar.getAutoID();
        Generar.setAutoID(alumno.idAlumno+1);

        Boolean res = generar.generarUnHistorial(alumno.idAlumno, alumno.edad);
        if(res==false)return false;
        String record = alumno.recordDb();
        return csv.insertarUnRegistro(record);
    }
    public Boolean actualizarAlumno(RegistroAlumno nuevo){
        Csv csv = new Csv("./db/mainAlu.csv");
        String[] records = csv.getAllRecords();
        RegistroAlumno alumno = null;
        Casteador casteador = new Casteador();
        for(Integer row=0;row<records.length;row++){
            alumno = casteador.castRegistroAlumno(records[row]);
            if(alumno.idAlumno.intValue()==nuevo.idAlumno.intValue()){
                String record = nuevo.recordDb();
                Boolean res = csv.actualizarUnRegistro(record,row);
                return res;
            }
        }
        return false;
    }
}
