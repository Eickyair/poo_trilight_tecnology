package trilight_tecnology.controllers;


import trilight_tecnology.models.HistorialAcademico;
import trilight_tecnology.models.Materia;
import trilight_tecnology.models.Semestre;

public class HistorialAcademicoControler {
    public HistorialAcademico historial = null;
    public HistorialAcademicoControler() {
    }
    public HistorialAcademicoControler(HistorialAcademico historial){
    }

    public Boolean buscarUnaMateria(Materia materia,HistorialAcademico h){
        if(h==null)return false;
        SemestreControler semestreControler = new SemestreControler();
        for(Semestre semestre : h.semestres.values()){
            Integer i = semestreControler.buscarMateria(semestre, materia);
            if(i!=-1)return true;
        }
        return false;
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
