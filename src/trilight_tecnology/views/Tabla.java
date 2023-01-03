/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;

import java.util.ArrayList;


/**
 * Clase encargada de heredar ciertas funciones a
 * diferentes objetos que desean desplegar su informacion
 * en tablas
 * @author Anvil
 */
public class Tabla {
    /**
     * Constructor de la clase Tabla.
     */
    public Tabla() {
    }
    /**
     * Aumenta el valor del parámetro slide en uno, si el resultado es igual al valor del
     * parámetro maxSlide, entonces devuelve 0.
     *
     * @param maxSlide El valor máximo que puede tomar slide.
     * @param slide El valor actual de slide.
     * @return El valor de slide aumentado en uno, o 0 si se alcanzó maxSlide.
     */
    public Integer aumentarSlide(Integer maxSlide, Integer slide) {
        if ((slide + 1) == maxSlide)
            return 0;
        return slide + 1;
    }
    /**
     * Decrementa el valor del parámetro slide en uno, si el resultado es -1, entonces
     * devuelve maxSlide - 1.
     *
     * @param maxSlide El valor máximo que puede tomar slide.
     * @param slide El valor actual de slide.
     * @return El valor de slide decrementado en uno, o maxSlide - 1 si slide es 0.
     */
    public Integer decrementarSlide(Integer maxSlide, Integer slide) {
        if ((slide - 1) == -1)
            return (maxSlide - 1);
        return slide - 1;
    }

    /**
     * Devuelve una cadena compuesta por el valor de la cadena tok, seguida de una
     * línea de guiones (-) de la longitud especificada por cada elemento del arreglo cols,
     * y seguida de nuevo del valor de la cadena tok.
     *
     * @param cols Arreglo de enteros que especifican la longitud de cada línea de guiones.
     * @param tok Cadena que se coloca al principio y al final de cada línea de guiones.
     * @return Cadena con las líneas de guiones separadas por el valor de tok.
     */
    public String separar(Integer[] cols,String tok){
        String res = tok;
        for(Integer col:cols){
            res+=wrapLine(col)+tok;
        }
        return res;
    }
    /**
     * Devuelve una cadena compuesta por el valor de la cadena tok, seguida de una
     * línea de guiones (-) de la longitud especificada por cada elemento de la lista cols,
     * y seguida de nuevo del valor de la cadena tok.
     *
     * @param cols Lista de enteros que especifican la longitud de cada línea de guiones.
     * @param tok Cadena que se coloca al principio y al final de cada línea de guiones.
     * @return Cadena con las líneas de guiones separadas por el valor de tok.
     */
    public String separar(ArrayList<Integer> cols,String tok){
        String res = tok;
        for(Integer col:cols){
            res+=wrapLine(col)+tok;
        }
        return res;
    }
    /**
     * Devuelve una cadena compuesta por el formato para imprimir una línea con las
     * columnas de tamaño especificado en la lista cols. El formato de cada columna es
     * "%len s|", donde len es el tamaño de la columna.
     *
     * @param cols Lista de enteros que especifican el tamaño de cada columna.
     * @return Cadena con el formato para imprimir una línea con columnas del tamaño especificado.
     */
    public String wrapFormat(ArrayList<Integer> cols){
        String format = "";
        for(Integer len:cols){
            format+=wrap(len);
        }
        return format;
    }
    /**
     * Devuelve una cadena en formato "%len s|", donde len es el valor del parámetro len.
     *
     * @param len Entero que especifica el tamaño de la columna.
     * @return Cadena con el formato para imprimir una columna del tamaño especificado.
     */
    public String wrap(int len){
        return "%"+len+"s|";
    }
    /**
     * El método wrapLine toma un entero y devuelve una cadena de guiones (-)
     * con la longitud especificada por el entero proporcionado.
     * @param len numero de guiones
     * @return Cadena formada de guiones
     */
    public String wrapLine(int len){
        String line = "";
        for (int i = 0; i < len; i++) {
            line+="-";
        }
        return line;
    }
}
