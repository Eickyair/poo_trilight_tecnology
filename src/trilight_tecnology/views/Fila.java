/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;

import java.util.ArrayList;

/**
 *
 * @author Anvil
 */
public class Fila extends Tabla{
    public  String top;
    public  String bottom;
    public  ArrayList<String> values;
    public  ArrayList<Integer> lens;
    public  String[] formats;

    public Fila() {
    }

    public Fila(String top, ArrayList<String> values, ArrayList<Integer> lens) {
        this.top = top;
        this.values = values;
        this.lens = lens;
        this.bottom = this.top;
        initFormat();
    }
     
    public Fila(String top, String bottom, ArrayList<String> values, ArrayList<Integer> lens) {
        this.top = top;
        this.bottom = bottom;
        this.values = values;
        this.lens = lens;
        this.formats = new String[values.size()];
        initFormat();
    }
    public void initFormat(){
        this.formats = new String[lens.size()];
        for (int i = 0; i < lens.size(); i++) {
            formats[i]=wrap(lens.get(i));
        }
    }
    public void showFormat(){
        System.out.print("|");
        for (int i = 0; i < values.size(); i++) {
            System.out.format(formats[i], values.get(i));
        }
        System.out.print("\n");
    }
    public void showRow(Boolean mostrarTop, Boolean mostrarBottom){
        if(mostrarTop) System.out.println(top);
        showFormat();
        if(mostrarBottom)System.out.println(bottom);
    }
}
