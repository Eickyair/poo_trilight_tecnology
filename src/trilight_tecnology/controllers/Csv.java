/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * clase encargada de manipular achivos csv
 * @author Anvil
 */
public class Csv {
    private String pathCsv;

    /**
     * Constructor vacio
     */
    public Csv() {
    }
    /**
     * Obtencion del header de un csv,SUPONIENDO que esta en el primer renglon
     * @return Header del archivo,null si hubo algun error
     */
    public String getHeader(){
        FileReader fr = reader(pathCsv);
        try (BufferedReader br = new BufferedReader(fr)) {
            String header = br.readLine();
            br.close();
            return header;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Apertura de un archivo en formato lectura
     * @param pathFile ruta del archivo
     * @return objeto file reader 
     */
    private FileReader reader(String pathFile){
        FileReader fr=null;
        try {
            fr = new FileReader(pathFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Csv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fr;
    }
    /**
     * Apertura de un achivo en formato escritura
     * @param pathFile ruta del archivo
     * @return Objeto FileWriter para hacer la escritura
     */
    private FileWriter writer(String pathFile){
        FileWriter fw = null;
        try {
            fw = new FileWriter(pathFile);
        } catch (IOException ex) {
            Logger.getLogger(Csv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fw;
    }
    /**
     * Constructor que inicializa la ruta del archivo
     * csv a manipular
     * @param pathCsv ruta del archivo
     */
    public Csv(String pathCsv) {
        this.pathCsv = pathCsv;
    }
    /**
     * Eliminacion del archivo que manipula este
     * objeto
     * @return
     */
    public Boolean eliminarAchivo(){
        File file = new File(pathCsv);
        return file.delete();
    }
    /**
     * Obtiene todas las lineas del archivo csv sin el header
     * @return Array con todas las filas,null en caso de error
     */
    public String[] getAllRecords(){
        try {
            ArrayList<String> data = new ArrayList<String>();
            FileReader fr = reader(pathCsv);
            BufferedReader br = new BufferedReader(fr);
            String record = br.readLine();//header
            record = br.readLine();
            while(record!=null){
                data.add(record);
                record = br.readLine();
            }
            String[] records = new String[data.size()];
            int i = 0;
            for(String line : data){
                records[i] = line;
                i++;
            }
            return records;
        } catch (IOException ex) {
            Logger.getLogger(Csv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * Elimininacion de un registro que se ubica en
     * una fila en particular
     * @param fila fila a eliminar
     * @return status de la operacion
     */
    public Boolean elimarRegistro(Integer fila){
        String header = getHeader();
        if(header == null) return false;
        String[] data = getAllRecords();
        if(data==null)return false;
        FileWriter fw = writer("./db/mainAlu.csv");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pr = new PrintWriter(bw);
        pr.println(header);
        for (int i = 0; i < data.length; i++){
            if(i==fila)continue;
            pr.println(data[i]);
        }
        pr.close();
        return true;
    }
    /**
     * Inserta al final del archivo un registro
     * @param record valor del registro en formato csv
     * @return status de la operacion
     */
    public Boolean insertarUnRegistro(String record){
        String header = getHeader();
        if(header == null) return false;
        String[] cache = getAllRecords();
        if(cache == null) return false;
        FileWriter fw = null;
        BufferedWriter br = null;
        PrintWriter pw = null;
        try {
            fw = writer(pathCsv);
            br = new BufferedWriter(fw);
            pw = new PrintWriter(br);
        } catch (Exception e) {
            return false;
        }
        pw.println(header);
        for(String line:cache){
            pw.println(line);
        }
        pw.println(record);
        pw.close();
        return true;
    }
    /**
     * Reescritura de un registro para su actualizacion
     * @param record nueva informacion
     * @param row fila a ser reescrita
     * @return status de la operacion
     */
    public Boolean actualizarUnRegistro(String record, Integer row){
        String header = getHeader();
        if(header == null) return false;
        String[] cache = getAllRecords();
        if(cache == null) return false;
        FileWriter fw = null;
        BufferedWriter br = null;
        PrintWriter pw = null;
        try {
            fw = writer(pathCsv);
            br = new BufferedWriter(fw);
            pw = new PrintWriter(br);
        } catch (Exception e) {
            return false;
        }
        pw.println(header);
        Integer i = 0;
        for(String line:cache){
            if(i==row){
                pw.println(record);
            }else{
                pw.println(line);
            }
            i++;
        }
        pw.close();
        return true;
    }
}
