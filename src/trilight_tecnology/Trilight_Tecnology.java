/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trilight_tecnology;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Anvil
 */
public class Trilight_Tecnology {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Generar x = new Generar("./src/db/alumnos.csv","");
        
        //Variables para el MENU PRINCIPAL
        Scanner opt = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        
        //Variables para el USUARIO
        Scanner ingreso = new Scanner(System.in);
        String usuario, contraseña;
        
        //Menu de acceso
        System.out.println("Ingrese su nombre de usuario:");
        usuario = ingreso.nextLine();
        System.out.println("Ingrese su contraseña:");
        contraseña = ingreso.nextLine();
        
        if(usuario.equals("AdminTT") && contraseña.equals("POO01")) {
            System.out.println("¡Bienvenido administrador TT!");
            
            //Menu principal del programa
            while(!salir){
                System.out.println("\n BASE DE REGISTROS ACADÉMICOS (v.1.0.0)");
                System.out.println("1. Consultar registros");
                System.out.println("2. Consultar datos personales");
                System.out.println("3. Consultar numero de inscripción");
                System.out.println("4. Salir");
                System.out.println("Escoja una opción: ");
                
                try{
                opcion = opt.nextInt();
                
                switch(opcion)
                {
                    case 1 -> {
                        System.out.println("CONSULTA DE REGISTROS ACADÉMICOS");
                        System.out.println("Ingrese el número de cuenta:");
                        }
                    case 2 -> {
                        System.out.println("CONSULTA DE DATOS PERSONALES");
                        System.out.println("Ingrese el número de cuenta:");
                        }
                    case 3 -> {
                        System.out.println("CONSULTA DE NÚMERO DE INSCRIPCIÓN");
                        System.out.println("Ingrese el número de cuenta:");
                        }
                    case 4 -> {
                        salir = true;
                        }
                    default -> System.out.println("La opción seleccionada no existe");
                }
                }catch(InputMismatchException e){
                    System.out.println("Debes introducir un número");
                    opt.next();
                }
            }
        }else{
            System.out.println("El usuario y/o la contraseña son incorrectos");
        }
    }
    
}
