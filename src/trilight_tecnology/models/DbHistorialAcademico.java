/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.models;

import java.util.ArrayList;
import java.util.Hashtable;
import trilight_tecnology.controllers.Csv;





/**
 *
 * @author Anvil
 */
public class DbHistorialAcademico {
    private String pathDbHistoriales = "./db/registros/";

    public DbHistorialAcademico() {
    }
    
    public HistorialAcademico consultarHistorial(Integer idAlumno){
        HistorialAcademico consulta = null;
        String rutaArchivo = pathDbHistoriales+idAlumno+".csv";
        Csv csv = new Csv(rutaArchivo);
        String[] informacionConvertir = csv.getAllRecords();
        consulta = convertirHistorial(informacionConvertir);
        consulta.idAlumno = idAlumno;
        return consulta;
    }
    
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
        for (int i = 1; i < informacion.length; i++) {
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
        h.semestreActual = Math.min(10, numSemestre+1);
        h.semestres = historial;
        h.promedio = suma/numMaterias;
        return h;
    }
}
