/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;
import java.util.ArrayList;


import trilight_tecnology.models.Materia;

/**
 * Despligue del sistema de calificaciones en la consola
 * @author chaia
 */
public class CalificacionesView extends Tabla {
    /**
     * Contructor vacio
     */
    public CalificacionesView(){
    }
    /**
     * Este método inicializa y devuelve una lista de encabezados para una tabla.
     *
     * @return Una lista de encabezados de tipo String.
     */
    private ArrayList<String> initHeader(){
        ArrayList<String> header = new ArrayList<String>();
        header.add("CLAVE");
        header.add("NOMBRE");
        header.add("CREDITOS");
        header.add("CALIFICACION");
        return header;
    }
    /**
     * Este método muestra una lista de materias en forma de tabla y solicita al usuario que introduzca la clave de una materia.
     *
     * @param materias Una lista de materias a mostrar.
     * @return La clave de la materia seleccionada por el usuario.
     */
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
    /**
     * Este método muestra una lista de materias en forma de tabla y solicita
     * al usuario que introduzca la clave de una materia.Este metodo es una sobrecarga
     * para que el campo de las calificaciones aparezca "NAN"
     *
     * @param materias Una lista de materias a mostrar.
     * @return La clave de la materia seleccionada por el usuario.
     */
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
