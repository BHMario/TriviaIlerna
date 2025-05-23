package BBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Logica.Usuario;

public class UsuarioBBDD {

    public Usuario obtenerUsuario(String nombre, String contrasena) {
        Connection conn = Conexion.getConexion();
        Usuario usuario = null;

        try {
            String sql = "SELECT * FROM usuarios WHERE nombre = ? AND contrasena = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, contrasena);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo_usuario");
                usuario = new Usuario(id, nombre, contrasena, tipo);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public List<Usuario> obtenerTodos() {
        List<Usuario> lista = new ArrayList<>();
        try {
            Connection conn = Conexion.getConexion();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("contrasena"),
                        rs.getString("tipo_usuario")
                );
                lista.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }


    public boolean registrarUsuario(Usuario usuario) {
        Connection conn = Conexion.getConexion();
        boolean exito = false;

        try {
            String sql = "INSERT INTO usuarios (nombre, contrasena, tipo_usuario) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getContrasena());
            stmt.setString(3, usuario.getTipo());

            int filas = stmt.executeUpdate();
            exito = filas > 0;

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exito;
    }

    public boolean existeUsuario(String nombre) {
        Connection conn = Conexion.getConexion();
        boolean existe = false;

        try {
            String sql = "SELECT id FROM usuarios WHERE nombre = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);

            ResultSet rs = stmt.executeQuery();
            existe = rs.next();

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;
    }

    public boolean eliminarUsuario(int id) {
        boolean eliminado = false;
        try {
            Connection conn = Conexion.getConexion();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            stmt.setInt(1, id);
            eliminado = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eliminado;
    }
}
