/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;
import java.util.ArrayList;


import trilight_tecnology.models.Materia;

/**
 *
 * @author chaia
 */
public class CalificacionesView extends Tabla {
    public CalificacionesView(){
    }
    private ArrayList<String> initHeader(){
        ArrayList<String> header = new ArrayList<String>();
        header.add("CLAVE");
        header.add("NOMBRE");
        header.add("CREDITOS");
        header.add("CALIFICACION");
        return header;
    }
    public Integer mostraMaterias(ArrayList<Materia> materias){
        ReaderConsole lectReaderConsole = ReaderConsole.getInstance();
        ArrayList<String> header = initHeader();
        ArrayList<Integer> lens = materias.get(0).toListIntegers();
        Fila fila = new Fila();
        fila.lens = lens;
        fila.top = separar(lens, "+");
        fila.values = header;
        fila.showRow(true, false);
        for(Materia materia : materias){
            materia.mostrarMateriaComoFila();
        }
        System.out.println(separar(lens, "+"));
        System.out.println("Introduce la clave de la materia:");
        return lectReaderConsole.readInteger();
    }
    public Integer mostraMaterias(ArrayList<Materia> materias,Boolean nuevas){
        ReaderConsole lectReaderConsole = ReaderConsole.getInstance();
        ArrayList<String> header = initHeader();
        ArrayList<Integer> lens = materias.get(0).toListIntegers();
        Fila fila = new Fila();
        fila.lens = lens;
        fila.top = separar(lens, "+");
        fila.values = header;
        fila.showRow(true, false);
        for(Materia materia : materias){
            materia.mostrarMateriaComoFila(true);
        }
        System.out.println(separar(lens, "+"));
        System.out.println("Introduce la clave de la materia:");
        return lectReaderConsole.readInteger();
    }
}
