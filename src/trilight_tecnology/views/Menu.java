/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;

import java.util.Scanner;

/**
 *
 * @author Anvil
 */
public class Menu {
    private String[] op;
    private String titulo=null;
    public Menu() {
    }
    public void mostraTitulo(){
        if(titulo == null) return;
        if(titulo.isEmpty()) return;
        System.out.println(titulo);
    }
    public Menu(String[] op,String titulo) {
        this.op = op;
        this.titulo = titulo;
    }

    /**
     * Despliegue de las opciones principales
     */
    public void opcionesPrincipales(){
        LimpiarConsola limpiador = new LimpiarConsola();
        Boolean continuar = true;
        while(continuar){
            limpiador.limpiarTodo();
            mostraTitulo();
            for (int i = 0; i < op.length; i++) {
                System.out.println(""+(i+1)+") "+op[i]);
            }
            continuar = capturarOpcion();
        }
    }
    public Integer leerOpcion(){
        Integer response = null;
        ReaderConsole reader = ReaderConsole.getInstance();
        while(response==null){
            System.out.println("Escoge una opccion:");
            response = reader.readInteger();
        }
        return response;
    }
    /**
     * Ejecucion de la tarea seleccionada
     * @return Retorna si se cerro sesion o no
     */
    public Boolean capturarOpcion(){
        Integer op = leerOpcion();
        switch (op) {
            case 1:
                // Gestion de alumnos
                String[] opcionesMenuAlu = {
                    "Registrar un Nuevo Alumno al Sistema",
                    "Consultar la Informacion de un Alumno",
                    "Actualizar la Informarion de un Alumno",
                    "Eliminar el Registro de un Alumno",
                    "Regresar al Menu Anterior"
                };
                MenuAdministracionAlumnos ma =
                    new MenuAdministracionAlumnos(opcionesMenuAlu,"__ADMINISTRACION DE ALUMNOS__");
                ma.opcionesPrincipales();
                break;
            case 2:
                // Sistema de calificaciones
                String[] opcionesMenuCalf = {
                    "Subir Calificaciones al Sistema",
                    "Modificar Calificaciones",
                    "Regresar al Menu Anterior"
                };
                MenuSistemaCalf sistemaCalf =
                    new MenuSistemaCalf(opcionesMenuCalf,"__SISTEMA DE CALIFICACIONES__");
                sistemaCalf.opcionesPrincipales();
                break;
            case 3:
                // Gestion de numeros de Inscriccion
                String[] opcionesMenuNums = {
                    "Consultar el Numero de Inscriccion de un Alumno",
                    "Obtener Todos los Numeros de Inscriccion",
                    "Regresar"
                };
                MenuNumInscripccion numInscripccion = 
                    new MenuNumInscripccion(opcionesMenuNums,"__NUMEROS DE INSCRICCION__");
                numInscripccion.opcionesPrincipales();
                break;
            case 4:
                //salir
                return false;
        }
        return true;
    }
}
