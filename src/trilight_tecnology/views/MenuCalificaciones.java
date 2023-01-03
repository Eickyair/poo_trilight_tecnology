/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;

import java.util.ArrayList;

import trilight_tecnology.controllers.CalificacionesController;
import trilight_tecnology.controllers.RegistrosAlumnosControler;
import trilight_tecnology.models.DbMateria;
import trilight_tecnology.models.Materia;
import trilight_tecnology.models.RegistroAlumno;

/**
 *
 * @author chaia
 */
public class MenuCalificaciones extends Menu {

    public MenuCalificaciones() {
    }

    public MenuCalificaciones(String[] op, String titulo) {
        super(op, titulo);
    }

    @Override
    public Boolean capturarOpcion() {
        Integer op = leerOpcion();
        switch (op) {
            case 1:
                casoUno();
                break;
            case 2:
                // Actualizar calificación
                break;
            case 3:
                return false;
        }
        return true;
    }

    private void casoUno(){
        RegistrosAlumnosControler registrosAlumnosControler = new RegistrosAlumnosControler();
        CalificacionesController calificacionesController = new CalificacionesController();
        ReaderConsole lReaderConsole = ReaderConsole.getInstance();
        ArrayList<RegistroAlumno> alumnos = registrosAlumnosControler.getAlumnos();
        RegistrosAlumnosView registrosAlumnosView = new RegistrosAlumnosView(alumnos);
        Integer index = registrosAlumnosView.mostrarEnSlides(10);
        RegistroAlumno alumno = alumnos.get(index);
        DbMateria dbMateria = new DbMateria();
        ArrayList<Materia> materiasSinCalf = dbMateria.materiaSinCalificacion(index);
        CalificacionesView calificacionesView = new CalificacionesView();
        index = calificacionesView.mostraMaterias(materiasSinCalf, true);
        Materia seleccionada = materiasSinCalf.get(index);
        if(index==null){
            status(false);
            lReaderConsole.espera();
            return;
        }
        seleccionada.mostrarMateriaComoFila(true);
        String bottomLine = registrosAlumnosView.separar(seleccionada.toListIntegers(), "+");
        System.out.println(bottomLine);
        System.out.println("Cual es la Calificacion de esta Materia?");
        Double calf = lReaderConsole.readCalif();
        if(calf==null){
            status(false);
            lReaderConsole.espera();
            return;
        }
        seleccionada.calificacion = calf;
        Boolean res = calificacionesController.guardarMateria(seleccionada, alumno.idAlumno);
        status(res);
        lReaderConsole.espera();
    }

    public void casoDos(){
        RegistrosAlumnosControler registrosAlumnosControler = new RegistrosAlumnosControler();
        CalificacionesController calificacionesController = new CalificacionesController();
        ReaderConsole lReaderConsole = ReaderConsole.getInstance();
        ArrayList<RegistroAlumno> alumnos = registrosAlumnosControler.getAlumnos();
        RegistrosAlumnosView registrosAlumnosView = new RegistrosAlumnosView(alumnos);
        Integer index = registrosAlumnosView.mostrarEnSlides(10);
        RegistroAlumno alumno = alumnos.get(index);
        DbMateria dbMateria = new DbMateria();
        ArrayList<Materia> materiasSemestreActual = dbMateria.materiasSemestreActual(index);
        CalificacionesView calificacionesView = new CalificacionesView();
        index = calificacionesView.mostraMaterias(materiasSemestreActual);
        Materia seleccionada = materiasSemestreActual.get(index);
        if(index==null){
            status(false);
            lReaderConsole.espera();
            return;
        }
        seleccionada.mostrarMateriaComoFila(true);
        String bottomLine = registrosAlumnosView.separar(seleccionada.toListIntegers(), "+");
        System.out.println(bottomLine);
        System.out.println("Cual es la Calificacion de esta Materia?");
        Double calf = lReaderConsole.readCalif();
        if(calf==null){
            status(false);
            lReaderConsole.espera();
            return;
        }
        seleccionada.calificacion = calf;
        Boolean res = calificacionesController.actualizarMateria(seleccionada, alumno.idAlumno);
        status(res);
        lReaderConsole.espera();
    }
}
