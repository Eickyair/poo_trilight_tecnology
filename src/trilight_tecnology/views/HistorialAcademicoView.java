/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;

import java.util.ArrayList;
import trilight_tecnology.controllers.RegistrosAlumnosControler;
import trilight_tecnology.models.HistorialAcademico;
import trilight_tecnology.models.RegistroAlumno;

/**
 *
 * @author Anvil
 */
public class HistorialAcademicoView extends Tabla{
    private HistorialAcademico h;
    
    
    
    
    private Integer SEMESTRE = 8;
    private Integer MATERIAS = 50;
    private ArrayList<Integer> colHeaderSemestres = new ArrayList<Integer>();
    
    
    
    public HistorialAcademicoView(){
    }

    public HistorialAcademicoView(HistorialAcademico h) {
        this.h = h;
    }
    
    public void mostraEnConsola(){
        mostrarDatosAlumno();
        mostraHeaderSemestres();
    }
    
    
    
    public void mostraHeaderSemestres(){
        colHeaderSemestres.add(SEMESTRE);
        colHeaderSemestres.add(MATERIAS);
        ArrayList<String> header = new ArrayList<String>();
        header.add("SEMESTRE");
        header.add("MATERIAS");
        String top = separar(colHeaderSemestres,"+");
        String bottom = separar(colHeaderSemestres,"+");
        Fila f = new Fila(top,bottom,header,colHeaderSemestres);
        f.showRow(true, true);
    }
    
    
    
    public void mostrarDatosAlumno(){
        RegistrosAlumnosControler control = new RegistrosAlumnosControler();
        RegistroAlumno alu = control.busqueda(h.idAlumno);
        ArrayList<Integer> lens = new ArrayList<Integer>();
        lens.add(8);lens.add(15);lens.add(15);lens.add(10);lens.add(10);
        ArrayList<String> values = new ArrayList<String>();
        String top = separar(lens,"+");
        values.add("ID_ALU");values.add("NOMBRE");values.add("APELLIDO");values.add("EDAD");values.add("SA");
        Fila f = new Fila(top,values,lens);
        f.showRow(true,false);
        values.clear();
        values = alu.toListStrings();values.add(h.semestreActual.toString());
        f.values = values;
        f.showRow(true,true);
    }
}
