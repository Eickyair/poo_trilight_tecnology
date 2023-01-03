/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;

import java.util.ArrayList;

/**
 * Esta es la clase Fila. Proporciona una estructura para representar y
 * mostrar una fila de una tabla.
 *
 * @author Anvil
 */
public class Fila extends Tabla {
    /**
     * Una cadena que representa la línea superior de la fila.
     */
    public String top;
    /**
     * Una cadena que representa la línea inferior de la fila.
     */
    public String bottom;
    /**
     * Una lista de valores de tipo String que representan los datos de la fila.
     */
    public ArrayList<String> values;
    /**
     * Una lista de valores de tipo entero que representan los anchos de las columnas de la fila.
     */
    public ArrayList<Integer> lens;
    /**
     * Una matriz de formatos de tipo String que se utilizan para mostrar los datos de la fila.
     */
    private String[] formats;
    /**
     * Este es el constructor de la clase Fila. Inicializa una instancia vacía.
     */
    public Fila() {
    }
    /**
     * Este es el constructor de la clase Fila. Inicializa una instancia con la línea superior, los datos y los anchos de las columnas especificados.
     *
     * @param top La línea superior de la fila.
     * @param values Los datos de la fila.
     * @param lens Los anchos de las columnas de la fila.
     */
    public Fila(String top, ArrayList<String> values, ArrayList<Integer> lens) {
        this.top = top;
        this.values = values;
        this.lens = lens;
        this.bottom = this.top;
        initFormat();
    }
    /**
     * Este es el constructor de la clase Fila. Inicializa una instancia con la línea superior, la línea inferior, los datos y los anchos de las columnas especificados.
     *
     * @param top La línea superior de la fila.
     * @param bottom La línea inferior de la fila.
     * @param values Los datos de la fila.
     * @param lens Los anchos de las columnas de la fila.
     */
    public Fila(String top, String bottom, ArrayList<String> values, ArrayList<Integer> lens) {
        this.top = top;
        this.bottom = bottom;
        this.values = values;
        this.lens = lens;
        this.formats = new String[values.size()];
        initFormat();
    }
    /**
     * Este método inicializa la matriz de formatos de la fila.
     */
    private void initFormat() {
        this.formats = new String[lens.size()];
        for (int i = 0; i < lens.size(); i++) {
            formats[i] = wrap(lens.get(i));
        }
    }
    /**
     * Este método muestra la fila con los formatos especificados.
     */
    private void showFormat() {
        if (lens == null) {
            System.out.println("-------------------------------");
            return;
        }
        if(formats==null)initFormat();
        System.out.print("|");
        for (int i = 0; i < values.size(); i++) {
            System.out.format(formats[i], values.get(i));
        }
        System.out.print("\n");
    }
    /**
     * Este método muestra la fila con o sin la línea superior y la línea inferior.
     *
     * @param mostrarTop Indica si se debe mostrar la línea superior de la fila.
     * @param mostrarBottom Indica si se debe mostrar la línea inferior de la fila.
     */
    public void showRow(Boolean mostrarTop, Boolean mostrarBottom) {
        if (mostrarTop)
            System.out.println(top);
        showFormat();
        if (mostrarBottom)
            System.out.println(bottom);
    }
}
