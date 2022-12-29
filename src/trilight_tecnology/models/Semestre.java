/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.models;

import java.util.ArrayList;

/**
 *
 * @author Milanesus
 */
public class Semestre {
    public Integer numero;
    public ArrayList<Materia> materias;

    public Semestre(Integer numero, ArrayList<Materia> materias) {
        this.numero = numero;
        this.materias = materias;
    }
    
    
}
