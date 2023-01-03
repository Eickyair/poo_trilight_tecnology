package trilight_tecnology.controllers;

import java.util.ArrayList;

import trilight_tecnology.models.DbHistorialAcademico;
import trilight_tecnology.models.HistorialAcademico;
import trilight_tecnology.models.NumInscri;
import trilight_tecnology.models.RegistroAlumno;
import trilight_tecnology.models.Semestre;

public class NumInscriControler {
    private HistorialAcademico historialPerfecto;
    public NumInscriControler(HistorialAcademico historialAcademico) {
        this.historialPerfecto = historialAcademico;
    }
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

    public NumInscri consultarNumInscri(Integer idAlu,ArrayList<RegistroAlumno> alumnos){
        Integer num = 1;
        ArrayList<NumInscri> numeros = calIndicesEscolares(alumnos);
        for(NumInscri numInscri : numeros){
            if(numInscri.alumno.idAlumno.intValue() == idAlu.intValue()){
                numInscri.num = num;
                return numInscri;
            }
            num++;
        }
        return null;
    }
    public ArrayList<NumInscri> consultarNumerosInscri(ArrayList<RegistroAlumno> alumnos){
        ArrayList<NumInscri> numeros = calIndicesEscolares(alumnos);
        Integer num = 1;
        for(NumInscri numInscri : numeros){
            numInscri.num = num;
            num++;
        }
        return numeros;

    }
    private ArrayList<NumInscri> calIndicesEscolares(ArrayList<RegistroAlumno> alumnos){
        ArrayList<NumInscri> numeros = new ArrayList<NumInscri>();
        for(RegistroAlumno alumno : alumnos){
            numeros.add(calIndiceEscolar(alumno));
        }
        numeros = ordenarNumeros(numeros);
        return numeros;
    }

    private ArrayList<NumInscri> ordenarNumeros(ArrayList<NumInscri> toSortArrayList){
        toSortArrayList.sort((a,b)-> {
            if(a.indiceEscolar.compareTo(b.indiceEscolar)==-1)return 1;
            if(a.indiceEscolar.compareTo(b.indiceEscolar)==1) return -1;
            return 0;
        });
        return toSortArrayList;
    }
}
