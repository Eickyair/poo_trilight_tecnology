/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;

import java.util.Scanner;
import java.util.StringTokenizer;
import trilight_tecnology.controllers.Csv;

/**
 *
 * @author Anvil
 */
public class LogAdminView {
    
    /**
     * Captura de la informacion necesaria
     * para loggearte como admin
     * @return Array con contrasenia y usuario 
     */
    public String[] getInfoLog(){
        String[] data = new String[2];
        //Variables para el USUARIO
        Scanner input = new Scanner(System.in);
        String usuario, contrasenia;
        System.out.println("Ingresa el correo:");
        usuario = input.nextLine();
        System.out.println("Ingresar la contrasenia");
        contrasenia = input.nextLine();
        data[0] = usuario; data[1] = contrasenia;
        return data;
    }
}
