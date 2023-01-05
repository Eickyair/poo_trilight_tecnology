package trilight_tecnology.controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import trilight_tecnology.models.DbHistorialAcademico;
import trilight_tecnology.models.HistorialAcademico;
import trilight_tecnology.models.NumInscri;
import trilight_tecnology.models.RegistroAlumno;
import trilight_tecnology.models.Semestre;


/**
 * Contrlador de los numeros de inscripcion
 * @author Anvil
 */
public class NumInscriControler {
    private HistorialAcademico historialPerfecto;
    /**
     * Construtor que inyecta
     * @param historialAcademico el historial perfecto que sirve como referencia
     */
    public NumInscriControler(HistorialAcademico historialAcademico) {
        this.historialPerfecto = historialAcademico;
    }
    /**
     * Calculo del indice escolar para un alumno
     * @param alumno al que se desea calcular su numero de inscripcion
     * @return NumIscri que contine el numero de inscripcion
     */
    private NumInscri calIndiceEscolar(RegistroAlumno alumno){
        DbHistorialAcademico dbHistorialAcademico = new DbHistorialAcademico();
        HistorialAcademico historialAcademico = dbHistorialAcademico.consultarHistorial(alumno.idAlumno);
        Double promedio = historialAcademico.promedio;
        Double escolaridad = escolaridad(historialAcademico);
        Double velocidad = velocidad(historialAcademico);
        Double num = promedio*escolaridad*velocidad;
        NumInscri numInscri = new NumInscri(alumno, num);
        return numInscri;
    }

    /**
     * Calculo de la escolaridad
     * @param historialAcademico historial de donde extrar la informacion
     * @return valor de la escolaridad
     */
    private Double escolaridad(HistorialAcademico historialAcademico){
        Double materiasAprobadas = 0d;
        Double materiasInscritas = 0d;
        for(Integer numSemestre = 1;numSemestre<historialAcademico.semestreActual;numSemestre++){
            Semestre semestreReferencia = historialPerfecto.semestres.get(numSemestre);
            Semestre semestreAlumno = historialAcademico.semestres.get(numSemestre);
            materiasAprobadas+=semestreAlumno.numMaterias();
            materiasInscritas+=semestreReferencia.numMaterias();
        }
        Double escolaridad = materiasAprobadas/materiasInscritas;
        return escolaridad*100d;
    }
    /**
     * Calculo de la velocidad
     * @param historialAcademico historial de donde extrar la informacion
     * @return valor de la velocidad
     */
    private Double velocidad(HistorialAcademico historialAcademico){
        Double creditosAlumno = 0d;
        Double creditosReferencia = 0d;
        for(Integer numSemestre = 1;numSemestre<historialAcademico.semestreActual;numSemestre++){
            Semestre semestreReferencia = historialPerfecto.semestres.get(numSemestre);
            Semestre semestreAlumno = historialAcademico.semestres.get(numSemestre);
            creditosAlumno+=semestreAlumno.contarCreditosSemestre();
            creditosReferencia+=semestreReferencia.contarCreditosSemestre();
        }
        Double velocidad = creditosAlumno/creditosReferencia;
        return velocidad*100d;
    }
    /**
     * Deteriminacion de el numero de inscripcion de un alumno
     * @param idAlu alumno al que se desea calcular el numero
     * @param alumnos Conjunto de todos los alumnos
     * @return Numero de inscripcion
     */
    public NumInscri consultarNumInscri(Integer idAlu,ArrayList<RegistroAlumno> alumnos){
        ArrayList<NumInscri> numeros = consultarNumerosInscri(alumnos);
        if(numeros == null) return null;
        for(NumInscri numInscri : numeros){
            if(numInscri.alumno.idAlumno.intValue() == idAlu.intValue()){
                return numInscri;
            }
        }
        return null;
    }
    /**
     * Consulta de todos los numeros de inscripcion
     * @param alumnos Conjunto de todos los alumnos
     * @return Lista con todos los numeros de inscripcion
     */
    public ArrayList<NumInscri> consultarNumerosInscri(ArrayList<RegistroAlumno> alumnos){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter("db/numeros-inscripcion.csv");
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (Exception e) {
            return null;
        }
        ArrayList<NumInscri> numeros = calIndicesEscolares(alumnos);
        Integer num = 1;
        printWriter.println("numero,id-alumno");
        for(NumInscri numInscri : numeros){
            numInscri.num = num;
            num++;
            printWriter.println(numInscri.recordDb());
        }
        printWriter.close();
        return numeros;
    }
    /**
     * Determinacion de todos los indices escolares
     * @param alumnos Lista de alumnos a determinar indices escolares
     * @return Lista de numeros de inscricpcion con indecies determinados
     */
    private ArrayList<NumInscri> calIndicesEscolares(ArrayList<RegistroAlumno> alumnos){
        ArrayList<NumInscri> numeros = new ArrayList<NumInscri>();
        for(RegistroAlumno alumno : alumnos){
            numeros.add(calIndiceEscolar(alumno));
        }
        numeros = ordenarNumeros(numeros);
        return numeros;
    }
    /**
     * Ordenamiento en base a los indices escolares de los numeros de inscripcion
     * de manera descendente
     * @param toSortArrayList
     * @return
     */
    private ArrayList<NumInscri> ordenarNumeros(ArrayList<NumInscri> toSortArrayList){
        toSortArrayList.sort((a,b)-> {
            if(a.indiceEscolar.compareTo(b.indiceEscolar)==-1)return 1;
            if(a.indiceEscolar.compareTo(b.indiceEscolar)==1) return -1;
            return 0;
        });
        return toSortArrayList;
    }
}
