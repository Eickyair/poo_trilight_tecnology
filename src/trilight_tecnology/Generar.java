/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



package trilight_tecnology;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anvil
 */
public class Generar {
    private String pathDbSrcAlu;
    private String pathMateriasDb;
    private static Boolean single = false;
    
    public Generar() {
    }

    public Generar(String pathDbSrcAlu, String pathMateriasDb) {
        if(single) return;
        single = true;
        this.pathDbSrcAlu = pathDbSrcAlu;
        this.pathMateriasDb = pathMateriasDb;
        generarAlumnos("./src/db/mainAlu.csv");
    }
    private Integer getEdad(String rec){
        StringTokenizer tok = new StringTokenizer(rec,",");
        Integer edad=18;
        int field = 0;
        String value;
        while(tok.hasMoreElements()){
            value = tok.nextToken();
            if(field == 4){
                edad = Integer.parseInt(value);
            }
            field++;
        }
        return edad;
    }
    private void generarAlumnos(String pathDbAlumnos){
        Csv csv = new Csv(pathDbSrcAlu);
        String[] recordsAlumnos = csv.getAllRecords();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ArrayList<Integer> edades = new ArrayList<Integer>();
   
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw;
        try { 
            fw = new FileWriter(pathDbAlumnos);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
        } catch (IOException ex) {
            Logger.getLogger(Generar.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        HashMap<Integer,Integer> toFind = new HashMap<Integer,Integer>();
        Random rand = new Random();
        int maxValue = recordsAlumnos.length;
        while(toFind.size()<500){
            Integer i = rand.nextInt(maxValue);
            if(toFind.containsKey(i)){continue;}
            toFind.put(i, null);
            String record = recordsAlumnos[i.intValue()];
            Integer edad = getEdad(record);
            edades.add(edad);
            ids.add(i+1);
            pw.println(record);
        }
        pw.close();
        generarHistoriales("./src/db/registros",ids, edades);
    }
    
    private HashMap<Integer,ArrayList<String>> mapaSemestres(String[] semestres){
        HashMap<Integer,ArrayList<String>> map = new HashMap<Integer,ArrayList<String>>();
        for(String semestre : semestres){
            StringTokenizer tokens = new StringTokenizer(semestre,",");
            int SEMESTRE = 0;
            while(tokens.hasMoreElements()){
                String value = tokens.nextToken();
                if(SEMESTRE == 3){
                    value = value.trim();
                    Integer numSemestre = Integer.parseInt(value);
                    if(!map.containsKey(numSemestre)){
                        map.put(numSemestre,new ArrayList<String>());
                    }
                    map.get(numSemestre).add(semestre);
                }
                SEMESTRE++;
            }
        }
//        for(Integer x : map.keySet()){
//            System.out.println("Semestre:"+x);
//            for(String line:map.get(x)){
//                System.out.println("\t"+line);
//            }
//        }
        return map;
    }
    private ArrayList<String> deleteMaterias(ArrayList<String> materias, ArrayList<Integer> toDelete){
        ArrayList<String> nuevo = new ArrayList<String>();
        int i = 0;
        int index = 0;
        for(String mat:materias){
            if(i!=toDelete.get(index)){
                nuevo.add(mat);
            }else{index++;}
            i++;
        }
        return nuevo;
    }
    private void generarHistoriales(String pathDbHistoriales, ArrayList<Integer> ids, ArrayList<Integer> edades){
        File carpeta = new File("./src/db/registros");
        for(File file:carpeta.listFiles()){
            file.delete();
        }
        Csv csv = new Csv("./src/db/semestres.csv");
        String[] semestres = csv.getAllRecords();
  
        
        String header = "clave,nombre,creditos,semestre,calificacion";
        int i = 0;
        for(Integer id:ids){
            FileWriter fw;
            BufferedWriter bw;
            PrintWriter pw;
            Integer edad = edades.get(i);
            i++;
            try { 
                fw = new FileWriter("./src/db/registros/"+id.toString()+".csv");
                bw = new BufferedWriter(fw);
                pw = new PrintWriter(bw);
            } catch (IOException ex) {
                Logger.getLogger(Generar.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
            HashMap<Integer,ArrayList<String>> mapSemestres = mapaSemestres(semestres);
            pw.println(header);
            Integer minSemestre = edad-17;
            Random rand = new Random();
            String materiaReprobada  = null;
            Boolean reprobo = false;
            for(Integer semestre = 1;semestre<=minSemestre;semestre++){
                ArrayList<String> materias = mapSemestres.get(semestre);
                reprobo = rand.nextBoolean();
                int index = -1;
                if(reprobo){
                    index = rand.nextInt(materias.size());
                    materiaReprobada = materias.get(index);
                }
                for (int j = 0; j < materias.size(); j++) {
                   if(j==index)continue;
                   String materiaRecord = materias.get(j);
                   StringTokenizer tok = new StringTokenizer(materiaRecord,",");
                   String data = "";
                    for (int k = 0; k < 3; k++){
                        data+=(tok.nextToken()+",");
                    }
                    data+=(semestre+",");
                    double calf = Math.random()*4.0 + 6.0;
                    data+=calf;
                    pw.println(data);
                }
                if(materiaReprobada!=null){
                    StringTokenizer tok = new StringTokenizer(materiaReprobada,",");
                    String data = "";
                    for (int k = 0; k < 3; k++){
                        data+=(tok.nextToken()+",");
                    }
                    data+=(semestre+",");
                    double calf = Math.random()*4.0 + 6.0;
                    data+=calf;
                    pw.println(data);                    
                    materiaReprobada=null;
                }
            }
            pw.close();
        }
    }
}
