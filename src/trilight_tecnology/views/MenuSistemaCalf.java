package trilight_tecnology.views;

import java.util.ArrayList;

import trilight_tecnology.controllers.CalificacionesController;
import trilight_tecnology.controllers.RegistrosAlumnosControler;
import trilight_tecnology.models.DbMateria;
import trilight_tecnology.models.Materia;
import trilight_tecnology.models.RegistroAlumno;
/**
 * Clase encargada de las operaciones del sistema
 * de calificaciones
 */
public class MenuSistemaCalf extends Menu{
    /**
     * Constructor vacio
     */
    public MenuSistemaCalf() {
    }
    /**
    * Constructor de la clase Menu.
    * @param op Arreglo de opciones que se mostrarán en el menú
    * @param titulo Título del menú
    */
    public MenuSistemaCalf(String[] op, String titulo) {
        super(op,titulo);
    }

    @Override
    public Boolean capturarOpcion() {
        Integer op = leerOpcion();
        switch (op) {
            case 1:
                // Subir Calificaciones
                casoUno();
                break;
            case 2:
                // Modificar calificaciones
                casoDos();
                break;
            case 3:
                // Regresar al Menu Anterior
                return false;
        }
        return true;
    }
    /**
     * Proceso para subir calificaciones
     */
    private void casoUno(){
        ReaderConsole lReaderConsole = ReaderConsole.getInstance();
        RegistrosAlumnosControler registrosAlumnosControler = new RegistrosAlumnosControler();
        ArrayList<RegistroAlumno> alumnos = registrosAlumnosControler.getAlumnos();
        RegistrosAlumnosView registrosAlumnosView = new RegistrosAlumnosView(alumnos);
        Integer index = registrosAlumnosView.mostrarEnSlides(10);
        RegistroAlumno alumno = alumnos.get(index);
        DbMateria dbMateria = new DbMateria();
        CalificacionesController calificacionesController = new CalificacionesController();
        ArrayList<Materia> materiasSubir = dbMateria.materiaSinCalificacion(alumno.idAlumno);
        if(materiasSubir==null){
            System.out.println("El Alumno tiene Todas sus Materias con Calificacion");
            lReaderConsole.espera();
            return;
        }
        CalificacionesView calificacionesView = new CalificacionesView();
        Integer clave = calificacionesView.mostraMaterias(materiasSubir,true);
        if(clave==null){
            status(false);
            return;
        }
        Materia materia = calificacionesController.buscarMateriaEnArray(materiasSubir, clave);
        if(materia==null){
            status(false);
            return;
        }
        materia.semestre = alumno.edad-17+1;
        System.out.println("Cual es la Calificacion?");
        Double calf = lReaderConsole.readCalif();
        if(calf==null){
            status(false);
            return;
        }
        materia.calificacion = calf;
        Boolean res = calificacionesController.guardarMateria(materia, alumno.idAlumno);
        status(res);
    }
    /**
     * Proceso para actualizar calificaciones
     */
    private void casoDos(){
        ReaderConsole lReaderConsole = ReaderConsole.getInstance();
        RegistrosAlumnosControler registrosAlumnosControler = new RegistrosAlumnosControler();
        ArrayList<RegistroAlumno> alumnos = registrosAlumnosControler.getAlumnos();
        RegistrosAlumnosView registrosAlumnosView = new RegistrosAlumnosView(alumnos);
        Integer index = registrosAlumnosView.mostrarEnSlides(10);
        RegistroAlumno alumno = alumnos.get(index);
        DbMateria dbMateria = new DbMateria();
        CalificacionesController calificacionesController = new CalificacionesController();
        ArrayList<Materia> materiasCalf = dbMateria.materiasSemestreActual(alumno.idAlumno);
        if(materiasCalf==null){
            System.out.println("Primero Debes Subir Calificaciones");
            lReaderConsole.espera();
            return;
        }
        CalificacionesView calificacionesView = new CalificacionesView();
        Integer clave = calificacionesView.mostraMaterias(materiasCalf);
        if(clave==null){
            status(false);
            return;
        }
        Materia materia = calificacionesController.buscarMateriaEnArray(materiasCalf, clave);
        if(materia==null){
            status(false);
            return;
        }
        System.out.println("Cual es la Calificacion?");
        Double calf = lReaderConsole.readCalif();
        if(calf==null){
            status(false);
            return;
        }
        materia.calificacion = calf;
        Boolean res = calificacionesController.actualizarMateria(materia, alumno.idAlumno);
        status(res);
    }
}
