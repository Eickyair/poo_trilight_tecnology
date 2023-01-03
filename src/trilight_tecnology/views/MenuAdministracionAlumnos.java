/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;

import java.util.ArrayList;

import trilight_tecnology.controllers.RegistrosAlumnosControler;
import trilight_tecnology.models.DbHistorialAcademico;
import trilight_tecnology.models.HistorialAcademico;
import trilight_tecnology.models.RegistroAlumno;

/**
 *
 * @author Anvil
 */
public class MenuAdministracionAlumnos extends Menu{

    public MenuAdministracionAlumnos() {
    }
    /**
     * Menu para la gestion de alumnos
     * @param op Array de opcciones
     * @param titulo Titulo del menu
     */
    public MenuAdministracionAlumnos(String[] op, String titulo){
        super(op,titulo);
    }
    @Override
    public Boolean capturarOpcion(){
        Integer op = leerOpcion();
        switch (op) {
            case 1:
                casoUno();
                break;
            case 2:
                casoDos();
                break;
                case 3:
                casoTres();
                break;
            case 4:
                casoCuatro();
                break;
            case 5:
                return false;
        }
        return true;
    }
    public void casoUno(){
        ReaderConsole lector = ReaderConsole.getInstance();
        RegistrosAlumnosControler registrosAlumnosControler = new RegistrosAlumnosControler();
        RegistroAlumno alumno = new RegistroAlumno();
        alumno = lector.leerUnRegistroAlumno();
        if(alumno==null){
            status(false);
            return;
        }
        Boolean res = registrosAlumnosControler.guardarAlumno(alumno);
        status(res);
    }
    public void casoDos(){
        ReaderConsole lector = ReaderConsole.getInstance();
        RegistrosAlumnosControler registrosAlumnosControler = new RegistrosAlumnosControler();
        ArrayList<RegistroAlumno> alumnos = registrosAlumnosControler.getAlumnos();
        RegistrosAlumnosView registrosAlumnosView = new RegistrosAlumnosView(alumnos);
        Integer index = registrosAlumnosView.mostrarEnSlides(10);
        RegistroAlumno alumno = alumnos.get(index);
        DbHistorialAcademico dbHistorialAcademico = new DbHistorialAcademico();
        HistorialAcademico historialAcademico = dbHistorialAcademico.consultarHistorial(alumno.idAlumno);
        HistorialAcademicoView historialAcademicoView = new HistorialAcademicoView(historialAcademico);
        historialAcademicoView.mostraEnConsola(alumno);
        lector.espera();
    }
    public void casoTres(){
        RegistrosAlumnosControler registrosAlumnosControler = new RegistrosAlumnosControler();
        ArrayList<RegistroAlumno> alumnos = registrosAlumnosControler.getAlumnos();
        RegistrosAlumnosView registrosAlumnosView = new RegistrosAlumnosView(alumnos);
        Integer index = registrosAlumnosView.mostrarEnSlides(10);
        RegistroAlumno alumno = alumnos.get(index);
        ReaderConsole lector = ReaderConsole.getInstance();
        RegistroAlumno update = lector.leerActualizacion(alumno);
        Boolean res = registrosAlumnosControler.actualizarAlumno(update);
        status(res);
    }
    public void casoCuatro(){
        RegistrosAlumnosControler registrosAlumnosControler = new RegistrosAlumnosControler();
        DbHistorialAcademico dbHistorialAcademico = new DbHistorialAcademico();
        ArrayList<RegistroAlumno> alumnos = registrosAlumnosControler.getAlumnos();
        RegistrosAlumnosView registrosAlumnosView = new RegistrosAlumnosView(alumnos);
        Integer index = registrosAlumnosView.mostrarEnSlides(10);
        RegistroAlumno alumno = alumnos.get(index);
        Boolean res = registrosAlumnosControler.borrarAlumno(alumno.idAlumno);
        if(res==false){
            status(res);
            return;
        }
        res = dbHistorialAcademico.eliminarHistorial(alumno.idAlumno);
        if(res==false){
            status(res);
            return;
        }
        status(res);
    }
}
