import javax.swing.SwingUtilities;
import Interfaz.Login;

public class Main {
    public static void main(String[] args) {
        // Lanzar el programa en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            new Login();
        });
    }
}
