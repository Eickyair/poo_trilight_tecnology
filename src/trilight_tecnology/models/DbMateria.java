/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.models;

import java.util.StringTokenizer;

/**
 *
 * @author Anvil
 */
public class DbMateria {

    public DbMateria() {
    }
     
    public Materia casteo(String registroCsv){
        Materia materia = new Materia();
        int CLAVE = 0;
        int NOMBRE = 1;
        int CREDITOS = 2;
        int SEMESTRE = 3;
        int CALIFICACION = 4;
        int CAMPO = 0;
        StringTokenizer tok = new StringTokenizer(registroCsv,",");
        while(tok.hasMoreElements()){
            String token = tok.nextToken();
            if(CAMPO==CLAVE){
                materia.clave = Integer.parseInt(token);
            }else if(CAMPO==NOMBRE){
                materia.nombre = token;
            }else if(CAMPO==CREDITOS){
                materia.creditos = Integer.parseInt(token);
            }else if(CAMPO==SEMESTRE){
                materia.semestre = Integer.parseInt(token);
            }else if(CAMPO==CALIFICACION){
                materia.calificacion = Double.parseDouble(token);
            }
            CAMPO++;
        }
        return materia;
    }
}
