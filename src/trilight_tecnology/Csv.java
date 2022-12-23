/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trilight_tecnology;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    
    private FileReader reader(String pathFile){
        FileReader fr=null;
        try {
            fr = new FileReader(pathFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Csv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fr;
    }

    public Csv(String pathCsv) {
        this.pathCsv = pathCsv;
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
}
