package trilight_tecnology.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import trilight_tecnology.models.RegistroAlumno;

/**
 * Clase encargada de la generacion de alumnos
 * @author Anvil
 */
public class Generar {
    private String pathDbSrcAlu;
    private String[] semestres = null;
    private String header = "clave,nombre,creditos,semestre,calificacion";
    private HashMap<Integer, ArrayList<String>> mapSemestres = null;
    public static Integer autoID;
    /**
     * Constructor der generador de alumnos
     * @param pathDbSrcAlu informacion de la cual consumir para generar los
     * registros
     */
    public Generar(String pathDbSrcAlu) {
        this.pathDbSrcAlu = pathDbSrcAlu;
        Csv csv = new Csv("./db/semestres.csv");
        this.semestres = csv.getAllRecords();
        this.mapSemestres = mapaSemestres(this.semestres);
    }
    /**
     * Obtencion de el idAutomatico para un nuevo registro
     * @return id
     */
    public static Integer getAutoID() {
        if(autoID==null){
            RegistrosAlumnosControler registrosAlumnosControler = new RegistrosAlumnosControler();
            ArrayList<RegistroAlumno> alumnos = registrosAlumnosControler.getAlumnos();
            Integer max = -1;
            for(RegistroAlumno alumno : alumnos){
                max = Math.max(alumno.idAlumno, max);
            }
            autoID = max;
        }
        autoID++;
        return autoID;
    }
    /**
     * Dado un registro en formato csv de alumno
     * se extrae el token que representa la edad
     * y se castea a Integer
     * @param rec Registro de un alumno en formato csv
     * con la siguiente estructura:
     * id,nombre,apellido,direccion,edad
     * @return Valor del edad que posee este alumno
     */
    private Integer getEdad(String rec) {
        StringTokenizer tok = new StringTokenizer(rec, ",");
        Integer edad = 18;
        int field = 0;
        String value;
        while (tok.hasMoreElements()) {
            value = tok.nextToken();
            if (field == 4) {
                edad = Integer.parseInt(value);
            }
            field++;
        }
        return edad;
    }

    /**
     * Metodo que selecciona 500 registros
     * aleatorios del archivo pathDbSrcAlu
     * para ser reescritos en pathDbAlumnos
     * @param pathDbAlumnos Ruta donde se van a
     * escribir los 500 alumnos seleccionados
     * aleatoriamente
     */
    public void generarAlumnos(String pathDbAlumnos) {
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

        HashMap<Integer, Integer> toFind = new HashMap<Integer, Integer>();
        Random rand = new Random();
        int maxValue = recordsAlumnos.length;
        pw.println("id,nombre,apellido,direccion,edad");
        while (toFind.size() < 500) {
            Integer i = rand.nextInt(maxValue);
            if (toFind.containsKey(i)) {
                continue;
            }
            toFind.put(i, null);
            String record = recordsAlumnos[i.intValue()];
            Integer edad = getEdad(record);
            edades.add(edad);
            ids.add(i + 1);
            pw.println(record);
        }
        pw.close();
        generarHistoriales("./db/registros", ids, edades);
        autoID = Collections.max(ids);

    }

    /**
     * Conversion de un array de Strings que
     * posee la informacion de las materias de cada semestre
     * @param semestres combinacion de todas las materias
     * que posee cada semestre
     * @return mapa que tiene como llave el numero del
     * semestre y como valor un array con todas las materias
     * de este semestre
     */
    private HashMap<Integer, ArrayList<String>> mapaSemestres(String[] semestres) {
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        for (String semestre : semestres) {
            StringTokenizer tokens = new StringTokenizer(semestre, ",");
            int SEMESTRE = 0;
            while (tokens.hasMoreElements()) {
                String value = tokens.nextToken();
                if (SEMESTRE == 3) {
                    value = value.trim();
                    Integer numSemestre = Integer.parseInt(value);
                    if (!map.containsKey(numSemestre)) {
                        map.put(numSemestre, new ArrayList<String>());
                    }
                    map.get(numSemestre).add(semestre);
                }
                SEMESTRE++;
            }
        }
        return map;
    }

    /**
     * Generacion de un historial para cada id
     * @param pathDbHistoriales directiorio donde se
     * van a escribir las historiales
     * @param ids conjunto de ids de los alumnos
     * @param edades edad de cada alumno, en base a la edad
     * se calcula el semestre que cursa el alumno
     */
    private void generarHistoriales(String pathDbHistoriales, ArrayList<Integer> ids, ArrayList<Integer> edades) {
        File carpeta = new File("./db/registros");
        for (File file : carpeta.listFiles()) {
            file.delete();
        }


        int i = 0;
        for (i=0;i<ids.size();i++) {
            Integer id = ids.get(i);
            Integer edad = edades.get(i);
            Boolean res = generarUnHistorial(id, edad);
            if(res == false)i--;
        }
    }
    /**
     * Generacion de todo un historial para un alumno
     * @param id del alumno al que pertenece el historial
     * @param edad la edad del alumno
     * @return status de la operacion
     */
    public Boolean generarUnHistorial(Integer id, Integer edad) {
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw;
        try {
            fw = new FileWriter("./db/registros/" + id.toString() + ".csv");
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
        } catch (IOException ex) {
            return false;
        }
        pw.println(this.header);
        Integer minSemestre = edad - 17;
        Random rand = new Random();
        String materiaReprobada = null;
        Boolean reprobo = false;
        for (Integer semestre = 1; semestre <= minSemestre; semestre++) {
            ArrayList<String> materias = this.mapSemestres.get(semestre);
            reprobo = rand.nextBoolean();
            int index = -1;
            if (reprobo) {
                index = rand.nextInt(materias.size());
                materiaReprobada = materias.get(index);
            }
            for (int j = 0; j < materias.size(); j++) {
                if (j == index)
                    continue;
                String materiaRecord = materias.get(j);
                StringTokenizer tok = new StringTokenizer(materiaRecord, ",");
                String data = "";
                for (int k = 0; k < 3; k++) {
                    data += (tok.nextToken() + ",");
                }
                data += (semestre + ",");
                Double calf = Math.random() * 4.0 + 6.0;
                String str = calf.toString();
                data+=str.substring(0,str.indexOf(".")+3);
                pw.println(data);
            }
            if (materiaReprobada != null && semestre.intValue()!=minSemestre.intValue()) {
                StringTokenizer tok = new StringTokenizer(materiaReprobada, ",");
                String data = "";
                for (int k = 0; k < 3; k++) {
                    data += (tok.nextToken() + ",");
                }
                Integer local = semestre + 1;
                data += (local + ",");
                Double calf = Math.random() * 4.0 + 6.0;
                String str = calf.toString();
                data+=str.substring(0,str.indexOf(".")+3);
                pw.println(data);
                materiaReprobada = null;
            }
        }
        pw.close();
        return true;
    }
}
