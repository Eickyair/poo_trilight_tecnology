package trilight_tecnology.views;

public class LimpiarConsola {
    public void limpiarTodo(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
