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
public class Tabla {

    public Tabla() {
    }
    public Integer aumentarSlide(Integer maxSlide, Integer slide) {
        if ((slide + 1) == maxSlide)
            return 0;
        return slide + 1;
    }

    public Integer decrementarSlide(Integer maxSlide, Integer slide) {
        if ((slide - 1) == -1)
            return (maxSlide - 1);
        return slide - 1;
    }
    public String separar(Integer[] cols,String tok){
        String res = tok;
        for(Integer col:cols){
            res+=wrapLine(col)+tok;
        }
        return res;
    }
    public String separar(ArrayList<Integer> cols,String tok){
        String res = tok;
        for(Integer col:cols){
            res+=wrapLine(col)+tok;
        }
        return res;
    }
    public String wrapFormat(ArrayList<Integer> cols){
        String format = "";
        for(Integer len:cols){
            format+=wrap(len);
        }
        return format;
    }
    public String wrap(int len){
        return "%"+len+"s|";
    }
    public String wrapLine(int len){
        String line = "";
        for (int i = 0; i < len; i++) {
            line+="-";
        }
        return line;
    }
}
