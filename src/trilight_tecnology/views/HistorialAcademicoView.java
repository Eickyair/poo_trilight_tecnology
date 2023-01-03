/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;

import java.util.ArrayList;
import trilight_tecnology.models.HistorialAcademico;
import trilight_tecnology.models.RegistroAlumno;
import trilight_tecnology.models.Semestre;

/**
 *
 * @author Anvil
 */
public class HistorialAcademicoView extends Tabla{
    private HistorialAcademico h;

    public HistorialAcademicoView(){
    }

    public HistorialAcademicoView(HistorialAcademico h) {
        this.h = h;
    }

    public void mostraEnConsola(RegistroAlumno alumno){
        mostrarDatosAlumno(alumno);
        for(Semestre semestre : h.semestres.values()){
            semestre.mostrarComoTabla();
            System.out.println();
        }
    }
    public void mostraEnConsola(){
        for(Semestre semestre : h.semestres.values()){
            semestre.mostrarComoTabla();
            System.out.println();
        }
    }
    public ArrayList<String> initHeader(){
        ArrayList<String> header = new ArrayList<String>();
        header.add("ID_ALU");
        header.add("NOMBRE");
        header.add("APELLIDO");
        header.add("EDAD");
        return header;
    }
    public void mostrarDatosAlumno(RegistroAlumno alumno){
        Fila fila = new Fila();
        ArrayList<String> header = initHeader();
        fila.lens = alumno.toListIntegers();
        fila.top = separar(fila.lens, "+");
        fila.bottom = separar(fila.lens, "-");
        fila.values = header;
        fila.showRow(true, true);
        fila.values = alumno.toListStrings();
        fila.showRow(false, true);
    }
}
