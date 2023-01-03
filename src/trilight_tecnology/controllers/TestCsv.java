package trilight_tecnology.controllers;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Anvil
 */
public class TestCsv {
    public void TesEliminarRegistro(){
        Csv csv = new Csv("./db/mainAlu.csv");
        Boolean res = csv.elimarRegistro(0);
        if(res){
            System.out.println("Borrado correctamente");
        }else System.out.println("No se pudo eliminar");
    }
}
