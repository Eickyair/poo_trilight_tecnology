/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.views;


/**
 * Objeto para solicitar informacion del admin
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
        ReaderConsole lReaderConsole = ReaderConsole.getInstance();
        String usuario, contrasenia;
        System.out.println("Ingresa el correo:");
        usuario = lReaderConsole.readLine();
        System.out.println("Ingresar la contrasenia");
        contrasenia = lReaderConsole.readLine();
        data[0] = usuario; data[1] = contrasenia;
        return data;
    }
}
