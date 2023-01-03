package trilight_tecnology.controllers;


import trilight_tecnology.models.HistorialAcademico;
import trilight_tecnology.models.Semestre;

public class HistorialAcademicoControler {
    public HistorialAcademico historial = null;
    public HistorialAcademicoControler(HistorialAcademico historial){
    }


    public Integer contarCreditosTotales(){
        Integer creditosTotales = 0;
        for (Semestre semestre : historial.semestres.values()) {
            creditosTotales+=semestre.contarCreditosSemestre();
        }
        return creditosTotales;
    }



    public Integer numMateriasTotales(){
        Integer numMaterias = 0;
        for(Semestre semestre : historial.semestres.values()){
            numMaterias+=semestre.numMaterias();
        }
        return numMaterias;
    }
}
