/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package trilight_tecnology.models;

/**
 *
 * @author Anvil
 */
public interface Registrable {
    /**
     * Formato que debe tener un objeto para ser registrado
     * en un csv
     * @return Cadena en formato csv con la informacion del objeto
     */
    String recordDb();
}
