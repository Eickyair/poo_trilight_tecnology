/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package trilight_tecnology.views;
import java.util.ArrayList;

import trilight_tecnology.controllers.Casteador;
import trilight_tecnology.models.RegistroAlumno;

/**
 *
 * @author Anvil
 */
public class RegistrosAlumnosView extends Tabla {
    public ArrayList<RegistroAlumno> toPrint;

    public RegistrosAlumnosView(ArrayList<RegistroAlumno> toPrint) {
        this.toPrint = toPrint;
    }
    private ArrayList<String> initHeader(){
        ArrayList<String> header = new ArrayList<String>();
        header.add("ROW");
        header.add("ID_ALU");
        header.add("NOMBRE");
        header.add("APELLIDO");
        header.add("EDAD");
        header.add("DIRECCION");
        return header;
    }
    /**
     * Muestra una serie de elementos en una serie de diapositivas
     * permitiendo al usuario navegar entre ellas utilizando el teclado.
     * @param numItemPorSlide El número de elementos a mostrar en cada diapositiva.
     * @return El número de fila del elemento seleccionado por el usuario, o null si no se seleccionó ningún elemento.
     */
    public Integer mostrarEnSlides(Integer numItemPorSlide) {
        if (toPrint == null) {
            System.out.println("No Hay Alumnos");
            return null;
        }
        toPrint.sort((a,b)->a.nombre.compareTo(b.nombre));
        Integer row = null;
        Casteador cast = new Casteador();
        Integer slide = 0;
        Integer maxSlide = toPrint.size()/numItemPorSlide;
        if(toPrint.size()%numItemPorSlide!=0)maxSlide++;
        Integer first = null;
        Integer end = null;
        ReaderConsole lector = ReaderConsole.getInstance();
        while(true){
            first = numItemPorSlide*slide;
            end = Math.min(toPrint.size(), first+numItemPorSlide);
            System.out.println();
            mostrarSlide(first, end);
            System.out.println("INSRUCCIONES:Ingresa +/- para Moverte Entre las Tablas");
            System.out.println("Selecciona el Alumno por la Fila de la Tabla");
            String input = lector.readLine();
            if(cast.castIntegerString(input)!=null){
                row = cast.castIntegerString(input);
                return row;
            }
            if(input.equals("+")){
                slide = aumentarSlide(maxSlide, slide);
            }
            if(input.equals("-")){
                slide = decrementarSlide(maxSlide, slide);
            }
        }
    }
    private void mostrarSlide(Integer first,Integer end){
        LimpiarConsola limpiarConsola = new LimpiarConsola();
        limpiarConsola.limpiarTodo();
        Fila fila = new Fila();
        Integer ROW_COL = 8;
        Integer col_direccion = 25;
        ArrayList<String> header = initHeader();
        ArrayList<Integer> cols = toPrint.get(0).toListIntegers();
        cols.add(0, ROW_COL);
        cols.add(col_direccion);
        ArrayList<String> values = null;
        RegistroAlumno registroAlumno = null;
        fila.top = separar(cols, "+");
        fila.bottom = fila.top;
        fila.values = header;
        fila.lens = cols;
        fila.showRow(true, false);
        for (Integer i = first;i<end;i++){
            registroAlumno = toPrint.get(i);
            values = registroAlumno.toListStrings();

            values.add(0, i.toString());

            values.add(registroAlumno.direccion);

            fila.values = values;
            fila.showRow(true, false);
        }
        System.out.println(fila.bottom);
    }
}
