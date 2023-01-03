/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.controllers;

import java.util.StringTokenizer;

/**
 * Contralador de el inicio de sesion de un admin
 * @author Anvil
 */
public class LogAdminControl {
    /**
     * Constructor vacio
     */
    public LogAdminControl() {
    }
    /**
     * Busqueda en la base de datos de los administradores
     * si existe el correo y contrasenia recibidos
     * @param correo Correo del administrador
     * @param pass Contrasenia del administrador
     * @return Respuesta de la busqueda
     */
    public Boolean validarUsuario(String correo, String pass){
        Csv csv = new Csv("./db/admins.csv");
        String emailAdmi = null;
        String passAdmi = null;
        String[] admins =csv.getAllRecords();
        for (int i = 0; i < admins.length; i++) {
            String rec = admins[i];
            emailAdmi = getEmail(rec);
            passAdmi = getPass(rec);
            if(correo.equals(emailAdmi) && pass.equals(passAdmi)){
                return true;
            }
        }
        return false;
    }

    /**
     * Extraccion de el token que representa el
     * correo del admin en el registro
     * @param rec Registro del que se extra el email
     * @return El valor del email para este registro
     */
    private String getEmail(String rec){
        int EMAIL = 1,i=0;
        StringTokenizer tok = new StringTokenizer(rec,",");
        String email = null;
        while(tok.hasMoreElements()){
            String value = tok.nextToken();
            if(i == EMAIL){
                email = value;
            }
            i++;
        }
        return email;
    }
    
    /**
     * Extraccion de el token que representa la
     * contrasenia del admin en el registro
     * @param rec Registro del cual extraer
     * @return Valor de este campo
     */
    private String getPass(String rec){
        int PASS = 2,i=0;
        StringTokenizer tok = new StringTokenizer(rec,",");
        String pass = null;
        while(tok.hasMoreElements()){
            String value = tok.nextToken();
            if(i == PASS){
                pass = value;
            }
            i++;
        }
        return pass;
    }
}
