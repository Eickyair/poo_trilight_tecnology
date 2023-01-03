package trilight_tecnology.models;

/**
 * Modelo que empaqueta la informacion de un numero de inscripcion
 * @author Anvil
 */
public class NumInscri {
    public RegistroAlumno alumno;
    public Double indiceEscolar;
    public Integer num;
    /**
     * Inicializacion con
     * @param alumno Informacion del alumno
     * @param indiceEscolar valor de su indice escolar
     */
    public NumInscri(RegistroAlumno alumno,Double indiceEscolar) {
        this.alumno = alumno;
        this.indiceEscolar = indiceEscolar;
    }
}
