/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;

import java.util.Scanner;
import trilight_tecnology.models.RegistroAlumno;

/**
 *
 * @author Anvil
 */
public class RegistrosAlumnosView {
    private RegistroAlumno[] toPrint;

    public RegistrosAlumnosView(RegistroAlumno[] toPrint) {
        this.toPrint = toPrint;
    }
    private Integer min(Integer a, Integer b){
        if(a<b)return a;
        return b;
    }
    private Integer max(Integer a,Integer b){
        if(a>b)return a;
        return b;
    }
    private Integer aumentarSlide(Integer numSlides,Integer paginaActual){
        System.out.println("Entro a +");
        if((paginaActual+1) == numSlides)return 0;
        return paginaActual+1;
    }
    private Integer decrementarSlide(Integer numSlides, Integer paginaActual){
        System.out.println("Entro a -");
        if((paginaActual-1)==-1)return (numSlides-1);
        return paginaActual-1;
    }
    public Integer mostrarEnSlides(Integer numSlides){
        Integer numItemsPorSlide = toPrint.length/numSlides;
        numItemsPorSlide = max(numItemsPorSlide,1);
        Integer len = toPrint.length;
        if(len%numSlides!=0)numSlides++;
        Integer paginaActual = 0;
        Scanner input = new Scanner(System.in);
        while(true){
            Integer inicio = paginaActual*numItemsPorSlide;
            Integer end = min(len,inicio+numItemsPorSlide);
            mostrarPagina(inicio,end);
            System.out.println("Escribe +/- para moverte entre los slides");
            System.out.println("Escribe el numero de la fila para seleccionar el alumno");
            String aws = input.nextLine();
            if(aws.compareTo("+")==0)paginaActual = aumentarSlide(numSlides,paginaActual);
            if(aws.compareTo("-")==0)paginaActual = decrementarSlide(numSlides,paginaActual);
            if(aws.matches("[+-]?\\d*(\\.\\d+)?"))return Integer.parseInt(aws);
        }
    }
    private String wrap(int len){
        return "%"+len+"s|";
    }
    private String wrapLine(int len){
        String line = "";
        for (int i = 0; i < len; i++) {
            line+="-";
        }
        return line;
    }
    private void mostrarPagina(Integer inicio, Integer end){
        int ROW = 5;
        int ID_ALUMNO = 6;
        int NOMBRE = 15;
        int APELLIDO = 15;
        int DIRECCION = 30;
        int EDAD = 8;
        Integer[] lens = {
            ROW,
            ID_ALUMNO,
            NOMBRE,
            APELLIDO,
            DIRECCION,
            EDAD
        };
        String line = "+";
        String format = "|";
        for(Integer len:lens){
            format+=wrap(len);
            line+=wrapLine(len);
            line+="+";
        }
        System.out.println(line);
        System.out.format(format+"\n","ROW","ID_ALU","NOMBRE","APELLIDO","DIRECCION","EDAD");
        for (int i = inicio; i < end; i++) {
            System.out.println(line);
            RegistroAlumno x = toPrint[i];
            String row = ""+i;
            System.out.format(format+"\n",row,x.idAlumno.toString(),x.nombre,x.apellido,x.direccion,x.edad.toString());
        }
        System.out.println(line);
    }
}
