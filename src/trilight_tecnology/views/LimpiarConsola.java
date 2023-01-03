package trilight_tecnology.views;
/**
 * Esta es la clase LimpiarConsola. Proporciona un método para limpiar toda la consola.
 *
 * @author Anvil
 */
public class LimpiarConsola {
    /**
     * Este método limpia toda la consola.
     */
    public void limpiarTodo(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
