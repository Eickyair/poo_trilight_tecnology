/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.models;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;

import trilight_tecnology.controllers.HistorialAcademicoControler;
import trilight_tecnology.controllers.SemestreControler;

/**
 * Clase encargada de manipular la informacion de el
 * sistema de calificaciones
 * @author Anvil
 */
public class DbMateria {
    /**
     * Constructor vacio
     */
    public DbMateria() {
    }

    /**
     * Transformacion de la informacion de texto a un objeto Materia
     * @param registroCsv informacion en formato csv
     * @return Objeto Materia con el caste hecho
     */
    public Materia casteo(String registroCsv){
        Materia materia = new Materia();
        int CLAVE = 0;
        int NOMBRE = 1;
        int CREDITOS = 2;
        int SEMESTRE = 3;
        int CALIFICACION = 4;
        int CAMPO = 0;
        StringTokenizer tok = new StringTokenizer(registroCsv,",");
        while(tok.hasMoreElements()){
            String token = tok.nextToken();
            if(CAMPO==CLAVE){
                materia.clave = Integer.parseInt(token);
            }else if(CAMPO==NOMBRE){
                materia.nombre = token;
            }else if(CAMPO==CREDITOS){
                materia.creditos = Integer.parseInt(token);
            }else if(CAMPO==SEMESTRE){
                materia.semestre = Integer.parseInt(token);
            }else if(CAMPO==CALIFICACION){
                materia.calificacion = Double.parseDouble(token);
            }
            CAMPO++;
        }
        return materia;
    }
    /**
     * Consulta de la materias que curso el alumno o debe en el semestre
     * actual pero que aun no hay registro
     * @param idAlumno Alumno a quien pertenece estas materias
     * @return Lista de materias sin registro que debe,null si ya no debe ninguna materia
     * en la carrera
     */
    public ArrayList<Materia> materiaSinCalificacion(Integer idAlumno){
        ArrayList<Materia> materias = new ArrayList<Materia>();
        DbHistorialAcademico dbHistorialAcademico = new DbHistorialAcademico();
        HistorialAcademico historialPerfecto = dbHistorialAcademico.historialPerfecto();
        HistorialAcademico historialAlumno = dbHistorialAcademico.consultarHistorial(idAlumno);
        Hashtable<Integer, Semestre> infoSemestres = historialAlumno.semestres;
        Hashtable<Integer, Semestre> infoPerfecto = historialPerfecto.semestres;
        SemestreControler semestreControler = new SemestreControler();
        for(Integer semestre = 1;semestre<historialAlumno.semestreActual;semestre++){
            Semestre semestrePerfecto = infoPerfecto.get(semestre);
            Semestre semestreAlu = infoSemestres.get(semestre);
            for(Materia materia : semestrePerfecto.materias){
                Integer i = semestreControler.buscarMateria(semestreAlu, materia);
                if(i.intValue()==-1)materias.add(materia);
            }
        }
        ArrayList<Materia> aux = new ArrayList<Materia>();
        HistorialAcademicoControler historialAcademicoControler = new HistorialAcademicoControler();
        for(Materia materia : materias){
            Boolean materiaYaCalificada = historialAcademicoControler.buscarUnaMateria(materia, historialAlumno);
            if(!materiaYaCalificada)aux.add(materia);
        }
        materias.clear();
        materias.addAll(aux);
        if(infoPerfecto.containsKey(historialAlumno.semestreActual)){
            for(Materia materia : infoPerfecto.get(historialAlumno.semestreActual).materias){
                Boolean materiaYaCalificada = historialAcademicoControler.buscarUnaMateria(materia, historialAlumno);
                if(materiaYaCalificada)continue;
                materias.add(materia);
            }
        }
        if(materias.size()==0)return null;
        return materias;
    }
    /**
     * Materias que se cursan en el semestre actual y que ya poseen calificacion
     * @param idAlumno alumno asociado a estas materias
     * @return Lista de materias del semestre actul con calificacion, null si aun no se suben las
     * materias al sistema
     */
    public ArrayList<Materia> materiasSemestreActual(Integer idAlumno){
        DbHistorialAcademico dbHistorialAcademico = new DbHistorialAcademico();
        HistorialAcademico historialAcademico = dbHistorialAcademico.consultarHistorial(idAlumno);
        Integer semestreActual = historialAcademico.semestreActual;
        if(historialAcademico.semestres.containsKey(semestreActual)==true)
            return historialAcademico.semestres.get(semestreActual).materias;
        return null;
    }

}
