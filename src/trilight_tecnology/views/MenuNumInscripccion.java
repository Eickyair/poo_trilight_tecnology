package trilight_tecnology.views;

import java.util.ArrayList;

import trilight_tecnology.controllers.NumInscriControler;
import trilight_tecnology.controllers.RegistrosAlumnosControler;
import trilight_tecnology.models.DbHistorialAcademico;
import trilight_tecnology.models.NumInscri;
import trilight_tecnology.models.RegistroAlumno;

public class MenuNumInscripccion extends Menu {
    /**
     * Constructor vacio
     */
    public MenuNumInscripccion(){}
    /**
     * Constructor que inicializa la instancia con opcciones para desplegar
     * y un titutlo
     * @param op opcciones a desplegar en el menu
     * @param titulo titulo del menu
     */
    public MenuNumInscripccion(String[] op,String titulo){
        super(op,titulo);
    }

    @Override
    public Boolean capturarOpcion() {
        Integer op = leerOpcion();
        switch (op) {
            case 1:
                //Consultar el numero de Inscripcion de un alumno
                casoUno();
                break;
            case 2:
                //Ver todos los numeros de Inscripcion de los alumnos
                casoDos();
                break;
            case 3:
                //Regresar
                return false;
        }
        return true;
    }
    /**
     * Consultar un numero de Inscripcion
     */
    private void casoUno(){
        RegistrosAlumnosControler registrosAlumnosControler = new RegistrosAlumnosControler();
        DbHistorialAcademico dbHistorialAcademico = new DbHistorialAcademico();
        NumInscriControler numInscriControler = new NumInscriControler(dbHistorialAcademico.historialPerfecto());
        ArrayList<RegistroAlumno> alumnos = registrosAlumnosControler.getAlumnos();
        RegistrosAlumnosView registrosAlumnosView = new RegistrosAlumnosView(alumnos);
        Integer index = registrosAlumnosView.mostrarEnSlides(10);
        RegistroAlumno alumno = alumnos.get(index);
        ReaderConsole lector = ReaderConsole.getInstance();
        NumInscriView numInscriView = new NumInscriView();
        NumInscri seleccionado = numInscriControler.consultarNumInscri(alumno.idAlumno, alumnos);
        numInscriView.mostrarUnNumero(seleccionado);
        lector.espera();
    }
    /**
     * Consultar todos los numeros de inscripcion
     */
    private void casoDos(){
        RegistrosAlumnosControler registrosAlumnosControler = new RegistrosAlumnosControler();
        DbHistorialAcademico dbHistorialAcademico = new DbHistorialAcademico();
        NumInscriControler numInscriControler = new NumInscriControler(dbHistorialAcademico.historialPerfecto());
        ArrayList<RegistroAlumno> alumnos = registrosAlumnosControler.getAlumnos();
        ReaderConsole lector = ReaderConsole.getInstance();
        NumInscriView numInscriView = new NumInscriView();
        ArrayList<NumInscri> seleccionados = numInscriControler.consultarNumerosInscri(alumnos);
        numInscriView.mostrarNumeros(seleccionados);
        lector.espera();
    }
}
