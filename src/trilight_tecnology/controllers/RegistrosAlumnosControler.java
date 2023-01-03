/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.controllers;

import java.util.ArrayList;


import trilight_tecnology.models.RegistroAlumno;

/**
 * CRUD de los alumnos
 * @author Anvil
 */
public class RegistrosAlumnosControler {
    public RegistrosAlumnosControler(){
    }
    /**
     * Obtencion de todos los registros de los alumnos
     * @return Lista con todas los registros de los alumnos
     */
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


    /**
     * Eliminacion de un alumno en el sistema
     * @param id alumon a eliminar
     * @return status de la operacion
     */
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
    /**
     * Obtencion de un solo alumon por su id
     * @param id del alumno
     * @return null si hubo un error, registro del alumno en otro caso
     */
    public RegistroAlumno getAlumno(Integer id){
        ArrayList<RegistroAlumno> alumnos = getAlumnos();
        for(RegistroAlumno alumno : alumnos){
            if(alumno.idAlumno.intValue()==id.intValue()){
                return alumno;
            }
        }
        return null;
    }
    /**
     * Creacion de un nuevo registro de alumno, tambien se auto genera su historial
     * @param alumno Informacion de alumno
     * @return status de la operacion
     */
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
    /**
     * Actualizacion de la informacion de un alumno
     * @param nuevo nueva informacion a escribir
     * @return status de la operacion
     */
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
