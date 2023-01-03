package trilight_tecnology.controllers;

import java.util.StringTokenizer;

import trilight_tecnology.models.Materia;
import trilight_tecnology.models.RegistroAlumno;
/**
 * Cast de informacion en texto de varios objetos del sistema
 * @author Anvil
 */
public class Casteador {
    private String nullToken = "/";
    /**
     * Casteo de valor null a nuestor token nulo
     * @param o Objeto a castear
     * @return Cadena con el token nulo o la representacion
     * en cadena del objeto
     */
    public String notNullString(Object o){
        if(o==null)return "/";
        return o.toString();
    }
    public Integer castIntegerString(String input){
        Integer res = null;
        try {
            res = Integer.parseInt(input);
        } catch (Exception e) {
            return null;
        }
        return res;
    }
    /**
     * Coversion de un registro en Csv de un alumno
     * a un objeto tipo RegistroAlumno.
     * En caso de que un token se igual al valor de
     * nullToken se asignara null al atributo correspondiente
     * @param info Registro en formato csv de un alumno
     * @return Representacion en objeto tipo RegistroAlumno
     * del record en formato csv
     */
    public RegistroAlumno castRegistroAlumno(String info){
        RegistroAlumno alumno = new RegistroAlumno();
        int i = 0;
        StringTokenizer tok = new StringTokenizer(info,",");
        while(tok.hasMoreElements()){
            String token = tok.nextToken();
            if(token.equals(nullToken)){
                i++;
                continue;
            }
            switch (i) {
                case 0:
                    alumno.idAlumno = Integer.parseInt(token);
                    break;
                case 1:
                    alumno.nombre = token;
                    break;
                case 2:
                    alumno.apellido = token;
                    break;
                case 3:
                    alumno.direccion = token;
                    break;
                case 4:
                    alumno.edad = Integer.parseInt(token);
            }
            i++;
        }
        return alumno;
    }
    /**
     * Conversion de un registro en formato csv a
     * un objeto Materia
     * @param data Cadena en formato csv con los tokens
     * del objeto
     * @return Objeto con sus atributos seteados deacuerdo a los tokens
     */
    public Materia castMateria(String data){
        Materia materia = new Materia();
        int i=0;
        StringTokenizer tok = new StringTokenizer(data,",");
        while(tok.hasMoreElements()){
            String token = tok.nextToken();
            if(token.equals(nullToken)){
                i++;
                continue;
            }
            switch (i) {
                case 0 -> {
                    materia.clave = Integer.parseInt(token);
                }
                case 1 -> {
                    materia.nombre = token;
                }
                case 2 -> {
                    materia.creditos = Integer.parseInt(token);
                }
                case 3 -> {
                    materia.semestre = Integer.parseInt(token);
                }
                case 4 -> {
                    materia.calificacion = Double.parseDouble(token);
                }
            }
            i++;
        }
        return materia;
    }
}
