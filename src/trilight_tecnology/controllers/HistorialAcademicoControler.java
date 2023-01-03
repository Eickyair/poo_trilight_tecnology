package trilight_tecnology.controllers;


import trilight_tecnology.models.HistorialAcademico;
import trilight_tecnology.models.Materia;
import trilight_tecnology.models.Semestre;

/**
 * Clase encargada de administrar la informacion de los Historiales
 * @author Anvil
 */
public class HistorialAcademicoControler {
    public HistorialAcademico historial = null;
    /**
     * Constructor vacio
     */
    public HistorialAcademicoControler() {
    }
    /**
     * Costructor que inyecta el historial a manipular
     * @param historial
     */
    public HistorialAcademicoControler(HistorialAcademico historial){
    }
    /**
     * Busqueda de una materia en un historial
     * @param materia Materia a buscar
     * @param h historial en donde buscar
     * @return true si esta dentro, false en otro caso
     */
    public Boolean buscarUnaMateria(Materia materia,HistorialAcademico h){
        if(h==null)return false;
        SemestreControler semestreControler = new SemestreControler();
        for(Semestre semestre : h.semestres.values()){
            Integer i = semestreControler.buscarMateria(semestre, materia);
            if(i!=-1)return true;
        }
        return false;
    }
    /**
     * Contabiliza todos los creditos del historial inyectodo
     * @return
     */
    public Integer contarCreditosTotales(){
        Integer creditosTotales = 0;
        for (Semestre semestre : historial.semestres.values()) {
            creditosTotales+=semestre.contarCreditosSemestre();
        }
        return creditosTotales;
    }

    /**
     * Contabiliza todas la materias cursadas
     * @return
     */

    public Integer numMateriasTotales(){
        Integer numMaterias = 0;
        for(Semestre semestre : historial.semestres.values()){
            numMaterias+=semestre.numMaterias();
        }
        return numMaterias;
    }
}
