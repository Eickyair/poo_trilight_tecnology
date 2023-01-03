/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.models;

import java.util.ArrayList;

import trilight_tecnology.views.Fila;
import trilight_tecnology.views.Tabla;

/**
 * Clase encargada de empaquetar la informacion de un semestre
 * @author Milanesus
 */
public class Semestre extends Tabla{
    public Integer numero;
    public ArrayList<Materia> materias;
    /**
     * Constructor vacio
     */
    public Semestre(){
    }
    /**
     * Inicilazacion del objeto
     * @param numero Numero del semestre
     * @param materias Materias que se cursaron este semestre
     */
    public Semestre(Integer numero, ArrayList<Materia> materias) {
        this.numero = numero;
        this.materias = materias;
    }
    /**
     * Calculo de las materias cursadas
     * @return numero de materias cursadas
     */
    public Integer numMaterias(){
        return materias.size();
    }
    /**
     * Despligue de el semestre como una tabla
     */
    public void mostrarComoTabla(){
        mostrarHeaderTabla();
        for(Materia materia : materias){
            materia.mostrarMateriaComoFila();
        }
        System.out.println(separar(materias.get(0).toListIntegers(), "+"));
    }
    /**
     * Contabilizacion de los creditos sumados por
     * todas las materias cursadas en el semestre
     * @return Numero de creditos obtenidos
     */
    public Integer contarCreditosSemestre(){
        Integer creditosSemestre = 0;
        for(Materia materia : this.materias){
            creditosSemestre+=materia.creditos;
        }
        return creditosSemestre;
    }
    /**
     * Promedio del semestre
     * @return promedio
     */
    public Double promedioPorSemestre(){
        Double suma = 0d;
        for(Materia materia:this.materias){
            suma+=materia.calificacion;
        }
        return suma/this.numMaterias();
    }
    /**
     * Cabecera de la tabla del semestre
     */
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
        Double promedio = promedioPorSemestre();
        String str = promedio.toString();
        Integer top = Math.min(str.indexOf(".")+3, str.length());
        str = str.substring(0,top);
        header.add(str);
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
