/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.controllers;

import java.util.StringTokenizer;
import trilight_tecnology.models.Materia;
import trilight_tecnology.views.CalificacionesView;

/**
 * CRUD de las calificaciones
 * @author chaia
 */
public class CalificacionesController {
    private Materia[] calificaciones = null;
    private Materia prom;
    
    public CalificacionesController(){
        Csv  csv = new Csv("./db/mainAlu.csv");
        String[] todosLosRegistros = csv.getAllRecords();
        calificaciones = new Materia[todosLosRegistros.length];
        for (int i = 0; i < calificaciones.length; i++) {
            parseMateria(todosLosRegistros[i]);
            calificaciones[i] = prom;
        }
    }
    
    public void mostrarCalificaciones(){
        CalificacionesView view = new CalificacionesView(calificaciones);
        view.mostrarEnSlides(20);
    }
    
    private void parseMateria(String rec){
        prom = new Materia();
        int i=0;
        StringTokenizer tok = new StringTokenizer(rec,",");
        while(tok.hasMoreElements()){
            switch (i) {
                case 0 -> prom.clave = Integer.valueOf(tok.nextToken());
                case 1 -> prom.nombre = tok.nextToken();
                case 2 -> prom.creditos = Integer.valueOf(tok.nextToken());
                case 3 -> prom.semestre = Integer.valueOf(tok.nextToken());
                case 4 -> prom.calificacion = Integer.parseInt(tok.nextToken());
            }
            i++;
        }
    }
}
