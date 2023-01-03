package trilight_tecnology.views;

import java.util.ArrayList;

import trilight_tecnology.models.NumInscri;

public class NumInscriView {
    public NumInscriView(){
    }
    private ArrayList<String> initHeader(){
        ArrayList<String> header = new ArrayList<String>();
        header.add("NUMERO");
        header.add("NOMBRE");
        header.add("APELLIDO");
        return header;
    }
    private void mostraHeader(NumInscri numInscri){
        ArrayList<String> header = initHeader();
        ArrayList<Integer> lens = numInscri.alumno.toListIntegers();
        lens.remove(3);
        Fila fila = new Fila();
        fila.top = fila.separar(lens, "+");
        fila.bottom = fila.top;
        fila.lens = lens;
        fila.values = header;
        fila.showRow(true, false);
    }
    public void mostrarUnNumero(NumInscri numInscri){
        mostraHeader(numInscri);
        ArrayList<Integer> lens = numInscri.alumno.toListIntegers();
        lens.remove(3);
        Fila fila = new Fila();
        ArrayList<String> values = numInscri.alumno.toListStrings();
        values.remove(3);
        values.remove(0);
        values.add(0, numInscri.num.toString());
        fila.values = values;
        fila.lens=lens;
        fila.top = fila.separar(lens, "+");
        fila.bottom = fila.top;
        fila.showRow(true, true);
    }
    private void mostrarUnNumero(NumInscri numInscri,Boolean bottom){
        ArrayList<Integer> lens = numInscri.alumno.toListIntegers();
        lens.remove(3);
        Fila fila = new Fila();
        ArrayList<String> values = numInscri.alumno.toListStrings();
        values.remove(3);
        values.remove(0);
        values.add(0, numInscri.num.toString());
        fila.values = values;
        fila.lens=lens;
        fila.top = fila.separar(lens, "+");
        fila.bottom = fila.top;
        fila.showRow(true, false);
    }

    public void mostrarNumeros(ArrayList<NumInscri> toShow){
        if(toShow==null)return;
        if(toShow.size()==0)return;
        mostraHeader(toShow.get(0));
        for(NumInscri numInscri:toShow){
            mostrarUnNumero(numInscri, true);
        }
    }
}
