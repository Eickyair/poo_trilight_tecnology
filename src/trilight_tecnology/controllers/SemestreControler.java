package trilight_tecnology.controllers;

import java.util.ArrayList;

import trilight_tecnology.models.Materia;
import trilight_tecnology.models.Semestre;

public class SemestreControler {


    public SemestreControler() {
    }

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
