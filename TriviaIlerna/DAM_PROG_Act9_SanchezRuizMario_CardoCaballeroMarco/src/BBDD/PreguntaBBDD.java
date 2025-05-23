package BBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Logica.Pregunta;

public class PreguntaBBDD {

    public List<Pregunta> obtenerPreguntasAleatorias(int cantidad) {
        List<Pregunta> preguntas = new ArrayList<>();
        Connection conn = Conexion.getConexion();

        try {
            String sql = "SELECT * FROM preguntas ORDER BY RAND() LIMIT ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cantidad);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String enunciado = rs.getString("enunciado");
                String categoria = rs.getString("categoria");
                String dificultad = rs.getString("dificultad");

                Pregunta p = new Pregunta(id, enunciado, categoria, dificultad);
                preguntas.add(p);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preguntas;
    }

    public List<Pregunta> obtenerPreguntasPorCategoriaYDificultad(String categoria, String dificultad, int cantidad) {
        List<Pregunta> preguntas = new ArrayList<>();
        Connection conn = Conexion.getConexion();

        try {
            String sql = "SELECT * FROM preguntas WHERE categoria = ? AND dificultad = ? ORDER BY RAND() LIMIT ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria);
            stmt.setString(2, dificultad);
            stmt.setInt(3, cantidad);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pregunta p = new Pregunta(
                        rs.getInt("id"),
                        rs.getString("enunciado"),
                        rs.getString("categoria"),
                        rs.getString("dificultad")
                );
                preguntas.add(p);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preguntas;
    }

    public boolean insertarPregunta(Pregunta pregunta) {
        Connection conn = Conexion.getConexion();
        boolean exito = false;

        try {
            String sql = "INSERT INTO preguntas (enunciado, categoria, dificultad) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pregunta.getEnunciado());
            stmt.setString(2, pregunta.getCategoria());
            stmt.setString(3, pregunta.getDificultad());

            exito = stmt.executeUpdate() > 0;
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exito;
    }

    public boolean eliminarPregunta(int id) {
        Connection conn = Conexion.getConexion();
        boolean exito = false;

        try {
            String sql = "DELETE FROM preguntas WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            exito = stmt.executeUpdate() > 0;
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exito;
    }
}
