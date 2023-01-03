/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package trilight_tecnology.models;

import java.util.ArrayList;

/**
 * Interfaz para objetos que deban ser mostrados en tablas
 * @author Anvil
 */
public interface ToList {
    /**
     * Valores que deben ser mostrados en formato tabla del objeto
     * @return Lista de valores
     */
    public ArrayList<String> toListStrings();
    /**
     * Para ser desplegado como tabla un objeto, se debe determinar
     * el formato o tamaño de las columnas
     * @return Lista con el tamaño de las columnas
     */
    public ArrayList<Integer> toListIntegers();
}
