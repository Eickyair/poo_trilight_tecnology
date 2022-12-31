package trilight_tecnology.controllers;

public class Casteador {

    public String notNullString(Object o){
        if(o==null)return "/";
        return o.toString();
    }
}
