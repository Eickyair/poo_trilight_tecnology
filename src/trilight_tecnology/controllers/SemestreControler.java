package trilight_tecnology.controllers;

import java.util.ArrayList;

import trilight_tecnology.models.Materia;
import trilight_tecnology.models.Semestre;
/**
 * Clase encargada de manipular la informacion de un semestre
 */
public class SemestreControler {

    /**
     * Constructor vacio
     */
    public SemestreControler() {
    }
    /**
     * Busqueda de una materia en un semestre
     * @param semestre semestre en el cual buscar
     * @param materiaBuscar materia a buscar
     * @return -1 si no se encuentra, el indice en el que se encuentra la materia
     */
    public Integer buscarMateria(Semestre semestre,Materia materiaBuscar){
        ArrayList<Materia> materias = semestre.materias;
        Materia materia = null;
        for(Integer i = 0;i<materias.size();i++){
            materia = materias.get(i);
            if(materia.clave.intValue()==materiaBuscar.clave.intValue()){
                return i;
            }
        }
        return -1;
    }
}
