/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.controllers;

import java.util.Arrays;
import java.util.StringTokenizer;
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
        alumnos = new RegistroAlumno[todosLosRegistros.length];
        for (int i = 0; i < alumnos.length; i++) {
            parseRegistroAlumno(todosLosRegistros[i]);
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
    private void parseRegistroAlumno(String rec){
        alumno = new RegistroAlumno();
        int i=0;
        StringTokenizer tok = new StringTokenizer(rec,",");
        while(tok.hasMoreElements()){
            switch (i) {
                case 0:
                    alumno.idAlumno = Integer.parseInt(tok.nextToken());                    
                    break;
                case 1:
                    alumno.nombre = tok.nextToken();
                    break;
                case 2:
                    alumno.apellido = tok.nextToken();
                    break;
                case 3:
                    alumno.direccion = tok.nextToken();
                    break;
                case 4:
                    alumno.edad = Integer.parseInt(tok.nextToken());
            }
            i++;
        }
    }
    public Boolean borrarAlumno(Integer id){
        Csv csv = new Csv("./db/mainAlu.csv");
        String[] data = csv.getAllRecords();
        for (int i = 0; i < data.length; i++) {
            parseRegistroAlumno(data[i]);
            if(alumno.idAlumno == id){
               return csv.elimarRegistro(i);
            }
        }
        return false;
    }
    public RegistroAlumno busqueda(Integer idAlumno){
        Csv csv = new Csv("./db/mainAlu.csv");
        String[] alumnos = csv.getAllRecords();
        for (int renglon = 0; renglon < alumnos.length; renglon++) {
            parseRegistroAlumno(alumnos[renglon]);
            if(alumno.idAlumno==idAlumno)return alumno;
        }
        return null;
    }
}
