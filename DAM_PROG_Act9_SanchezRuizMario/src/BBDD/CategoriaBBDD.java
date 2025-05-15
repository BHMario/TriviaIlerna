package BBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaBBDD {

    public List<String> obtenerCategorias() {
        List<String> categorias = new ArrayList<>();
        Connection conn = Conexion.getConexion();

        try {
            String sql = "SELECT nombre FROM categorias";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                categorias.add(rs.getString("nombre"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categorias;
    }

    public boolean insertarCategoria(String nombre) {
        Connection conn = Conexion.getConexion();
        boolean exito = false;

        try {
            String sql = "INSERT INTO categorias (nombre) VALUES (?)";
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
