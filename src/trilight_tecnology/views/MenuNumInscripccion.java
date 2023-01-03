package trilight_tecnology.views;

public class MenuNumInscripccion extends Menu {
    public MenuNumInscripccion(){}
    public MenuNumInscripccion(String[] op,String titulo){
        super(op,titulo);
    }

    @Override
    public Boolean capturarOpcion() {
        Integer op = leerOpcion();
        switch (op) {
            case 1:
                //Consultar el numero de Inscripcion de un alumno
                break;
            case 2:
                //Ver todos los numeros de Inscripcion de los alumnos
                break;
            case 3:
                //Regresar
                return false;
        }
        return true;
    }
    private void casoUno(){

    }
    private void casoDos(){
        
    }
}
