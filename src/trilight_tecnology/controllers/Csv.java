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
 *
 * @author Anvil
 */
public class Csv {
    private String pathCsv;

    public Csv() {
    }
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
    private FileReader reader(String pathFile){
        FileReader fr=null;
        try {
            fr = new FileReader(pathFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Csv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fr;
    }
    
    private FileWriter writer(String pathFile){
        FileWriter fw = null;
        try {
            fw = new FileWriter(pathFile);
        } catch (IOException ex) {
            Logger.getLogger(Csv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fw;
    }
    public Csv(String pathCsv) {
        this.pathCsv = pathCsv;
    }
    public Boolean eliminarAchivo(){
        File file = new File(pathCsv);
        return file.delete();
    }
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
