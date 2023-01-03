package trilight_tecnology.views;

import java.util.ArrayList;

import trilight_tecnology.models.NumInscri;
/**
 * Clase encargada de mostrar los numeros
 * de inscripccion
 * @author Anvil
 */
public class NumInscriView {
    /**
     * Constructor vacio
     */
    public NumInscriView(){
    }
    /**
     * Este método inicializa y devuelve una lista de encabezados para una tabla.
     *
     * @return Una lista de encabezados de tipo String.
     */
    private ArrayList<String> initHeader(){
        ArrayList<String> header = new ArrayList<String>();
        header.add("NUMERO");
        header.add("NOMBRE");
        header.add("APELLIDO");
        return header;
    }
    /**
     * Muestra el header de la tabla
     * @param numInscri Inyeccion de dependencia para extraer los formatos
     */
    private void mostraHeader(NumInscri numInscri){
        ArrayList<String> header = initHeader();
        ArrayList<Integer> lens = numInscri.alumno.toListIntegers();
        lens.remove(3);
        Fila fila = new Fila();
        fila.top = fila.separar(lens, "+");
        fila.bottom = fila.top;
        fila.lens = lens;
        fila.values = header;
        fila.showRow(true, false);
    }
    /**
     * Mostrar los datos de un alumno y su numero de inscripccion
     * @param numInscri Modelo que envulve la informacion necesaria y que
     * sera mostrada
     */
    public void mostrarUnNumero(NumInscri numInscri){
        mostraHeader(numInscri);
        ArrayList<Integer> lens = numInscri.alumno.toListIntegers();
        lens.remove(3);
        Fila fila = new Fila();
        ArrayList<String> values = numInscri.alumno.toListStrings();
        values.remove(3);
        values.remove(0);
        values.add(0, numInscri.num.toString());
        fila.values = values;
        fila.lens=lens;
        fila.top = fila.separar(lens, "+");
        fila.bottom = fila.top;
        fila.showRow(true, true);
    }
    /**
     * Mostrar los datos de un alumno y su numero de inscripccion
     * @param numInscri Modelo que envulve la informacion necesaria y que
     * sera mostrada
     * @param bottom Boleano que permite saber si mostrar la linea inferiror de 
     * la tabla
     */
    private void mostrarUnNumero(NumInscri numInscri,Boolean bottom){
        ArrayList<Integer> lens = numInscri.alumno.toListIntegers();
        lens.remove(3);
        Fila fila = new Fila();
        ArrayList<String> values = numInscri.alumno.toListStrings();
        values.remove(3);
        values.remove(0);
        values.add(0, numInscri.num.toString());
        fila.values = values;
        fila.lens=lens;
        fila.top = fila.separar(lens, "+");
        fila.bottom = fila.top;
        fila.showRow(true, false);
    }
    /**
     * Muestra todos los numeros en formato tabla
     * @param toShow los numeros a mostrar
     */
    public void mostrarNumeros(ArrayList<NumInscri> toShow){
        if(toShow==null)return;
        if(toShow.size()==0)return;
        mostraHeader(toShow.get(0));
        for(NumInscri numInscri:toShow){
            mostrarUnNumero(numInscri, true);
        }
    }
}
