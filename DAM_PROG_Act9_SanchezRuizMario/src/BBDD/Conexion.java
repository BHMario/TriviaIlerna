package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/trivia";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = ""; // o "root" si tienes contraseña

    private static Connection conexion;

    // Metodo para establecer conexión
    public static Connection getConexion() {
        if (conexion == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
                System.out.println("Conexión exitosa a la base de datos.");
            } catch (ClassNotFoundException e) {
                System.out.println("Error al cargar el controlador.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Error en la conexion.");
                e.printStackTrace();
            }
        }
        return conexion;
    }

    // Metodo para cerrar la conexión
    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión.");
        }
    }
}

