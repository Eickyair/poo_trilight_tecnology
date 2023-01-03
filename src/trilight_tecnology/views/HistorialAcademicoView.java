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
 * Esta es la clase HistorialAcademicoView.
 * Proporciona una vista para mostrar un historial académico en la consola.
 *
 * @author Anvil
 */
public class HistorialAcademicoView extends Tabla{
    private HistorialAcademico h;
    /**
     * Este es el constructor de la clase HistorialAcademicoView. Inicializa una instancia vacía.
     */
    public HistorialAcademicoView(){
    }
    /**
     * Este es el constructor de la clase HistorialAcademicoView. Inicializa una instancia con el historial académico especificado.
     *
     * @param h El historial académico que se mostrará.
     */
    public HistorialAcademicoView(HistorialAcademico h) {
        this.h = h;
    }
    /**
     * Este método muestra el historial académico en la consola, incluyendo los datos del alumno especificado.
     *
     * @param alumno El alumno cuyos datos se mostrarán junto con el historial académico.
     */
    public void mostraEnConsola(RegistroAlumno alumno){
        mostrarDatosAlumno(alumno);
        for(Semestre semestre : h.semestres.values()){
            semestre.mostrarComoTabla();
            System.out.println();
        }
    }
    /**
     * Este método muestra el historial académico en la consola.
     */
    public void mostraEnConsola(){
        for(Semestre semestre : h.semestres.values()){
            semestre.mostrarComoTabla();
            System.out.println();
        }
    }
    /**
     * Este método inicializa el encabezado para la tabla que se muestra en la vista del historial académico.
     *
     * @return Una lista de cadenas con los encabezados de la tabla.
     */
    public ArrayList<String> initHeader(){
        ArrayList<String> header = new ArrayList<String>();
        header.add("ID_ALU");
        header.add("NOMBRE");
        header.add("APELLIDO");
        header.add("EDAD");
        return header;
    }
    /**
     * Este método muestra los datos del alumno especificado en una tabla en la consola.
     *
     * @param alumno El alumno cuyos datos se mostrarán en la tabla.
     */
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
