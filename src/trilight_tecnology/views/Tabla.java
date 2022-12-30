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
