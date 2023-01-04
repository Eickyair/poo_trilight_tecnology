/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.models;

import java.util.ArrayList;
import java.util.Hashtable;
import trilight_tecnology.controllers.Csv;
import trilight_tecnology.controllers.RegistrosAlumnosControler;





/**
 * Clase encargada de hacer consultas de informacion sobre los historiales
 * @author Anvil
 */
public class DbHistorialAcademico {
    private String pathDbHistoriales = "./db/registros/";

    public DbHistorialAcademico() {
    }
    /**
     * Determinacion del historial de referencia
     * a la hora de calcular numeros de inscripcion
     * @return HistorialAcademico ordinario
     */
    public HistorialAcademico historialPerfecto(){
        Csv csv = new Csv("./db/semestres.csv");
        String[] planEstudios = csv.getAllRecords();
        for(Integer i = 0;i<planEstudios.length;i++){
            planEstudios[i]+=",-1.00";
        }
        HistorialAcademico historial = convertirHistorial(planEstudios);
        return historial;
    }
    /**
     * Eliminacion del archivo con el historial de un alumno
     * @param idAlumno Alumno al que sera eliminado el historial
     * @return Status de la operacion
     */
    public Boolean eliminarHistorial(Integer idAlumno){
        Csv csv = new Csv();
        return csv.eliminarAchivo(idAlumno);
    }
    /**
     * Consulta la informacion del historial de un alumno
     * @param idAlumno Alumno al que se le hace la consulta
     * @return Historial academico asociado al alumno
     */
    public HistorialAcademico consultarHistorial(Integer idAlumno){

        HistorialAcademico consulta = null;
        String rutaArchivo = pathDbHistoriales+idAlumno+".csv";
        Csv csv = new Csv(rutaArchivo);
        String[] informacionConvertir = csv.getAllRecords();
        consulta = convertirHistorial(informacionConvertir);
        consulta.idAlumno = idAlumno;
        RegistrosAlumnosControler registrosAlumnosControler = new RegistrosAlumnosControler();
        RegistroAlumno alumno = registrosAlumnosControler.getAlumno(idAlumno);
        consulta.semestreActual = alumno.edad-17+1;
        return consulta;
    }
    /**
     * Parseador de informacion en texto plano del archivo donde
     * se guarda el historial de un alumno
     * @param informacion informacion del archivo csv
     * @return Objeto historial academico construido a partir de esa informacion
     */
    public HistorialAcademico convertirHistorial(String[] informacion){
        HistorialAcademico h = new HistorialAcademico();
        //En el indice 0 esta la cabecera o header
        Hashtable<Integer,Semestre> historial = new Hashtable<Integer,Semestre>();
        Materia materia = null;
        ArrayList<Materia> listaMaterias = null;
        Semestre s= null;
        Integer numSemestre = 1;
        Double suma = 0d;
        Integer numMaterias = 0;
        DbMateria dbMateria = new DbMateria();
        for (int i = 0; i < informacion.length; i++) {
            String rec = informacion[i];
            materia = dbMateria.casteo(rec);
            numSemestre = materia.semestre;
            if(!historial.containsKey(materia.semestre)){
                listaMaterias = new ArrayList<Materia>();
                s = new Semestre(numSemestre,listaMaterias);
                historial.put(numSemestre,s);
            }
            historial.get(numSemestre).materias.add(materia);
            suma+=materia.calificacion;
            numMaterias++;
        }
        h.semestres = historial;
        h.promedio = suma/numMaterias;
        return h;
    }
}
