package BBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DificultadBBDD {

    public List<String> obtenerDificultades() {
        List<String> dificultades = new ArrayList<>();
        Connection conn = Conexion.getConexion();

        try {
            String sql = "SELECT nombre FROM dificultades";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                dificultades.add(rs.getString("nombre"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dificultades;
    }

    public boolean insertarDificultad(String nombre) {
        Connection conn = Conexion.getConexion();
        boolean exito = false;

        try {
            String sql = "INSERT INTO dificultades (nombre) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);

            exito = stmt.executeUpdate() > 0;
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exito;
    }
}
