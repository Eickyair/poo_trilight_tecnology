package trilight_tecnology.views;

public class MenuNumerosInscr extends Menu{
    public MenuNumerosInscr(){}
    public MenuNumerosInscr(String[] op, String titulo){
        super(op,titulo);
    }
    @Override
    public Boolean capturarOpcion() {
        Integer op = leerOpcion();
        switch (op) {
            case 1:
                //consulatar numero de inscriccion
                break;
            case 2:
                //Obtener todos los numeros de inscriccion
                break;
            case 3:
                //regresar
                return false;
        }
        return true;
    }
}
