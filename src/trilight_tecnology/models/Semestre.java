/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.models;

import java.util.ArrayList;

import trilight_tecnology.views.Fila;
import trilight_tecnology.views.Tabla;

/**
 *
 * @author Milanesus
 */
public class Semestre extends Tabla{
    public Integer numero;
    public ArrayList<Materia> materias;
    public Semestre(){
    }
    public Semestre(Integer numero, ArrayList<Materia> materias) {
        this.numero = numero;
        this.materias = materias;
    }

    public Integer numMaterias(){
        return materias.size();
    }
    public void mostrarComoTabla(){
        mostrarHeaderTabla();
        for(Materia materia : materias){
            materia.mostrarMateriaComoFila();
        }
        System.out.println(separar(materias.get(0).toListIntegers(), "+"));
    }
    public Integer contarCreditosSemestre(){
        Integer creditosSemestre = 0;
        for(Materia materia : this.materias){
            creditosSemestre+=materia.creditos;
        }
        return creditosSemestre;
    }
    public Double promedioPorSemestre(){
        Double suma = 0d;
        for(Materia materia:this.materias){
            suma+=materia.calificacion;
        }
        return suma/this.numMaterias();
    }
    private void mostrarHeaderTabla(){
        ArrayList<Integer> lens = new ArrayList<Integer>();
        lens.add(10);
        lens.add(50);
        lens.add(10);
        lens.add(15);
        Fila fila = new Fila();
        fila.lens = lens;
        fila.top = separar(lens, "+");
        ArrayList<String> header = new ArrayList<String>();
        header.add("SEMESTRE");
        header.add("NUMERO: "+numero.toString());
        header.add(contarCreditosSemestre().toString());
        header.add(promedioPorSemestre().toString());
        fila.values = header;
        fila.showRow(true, false);

        header.clear();
        header.add("CLAVE");
        header.add("NOMBRE");
        header.add("CREDITOS");
        header.add("CALIFICACION");
        fila.bottom = fila.top;
        fila.showRow(true, false);
    }
}
