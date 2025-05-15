package BBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Logica.Respuesta;

public class RespuestaBBDD {

    public List<Respuesta> obtenerRespuestasPorPregunta(int idPregunta) {
        List<Respuesta> respuestas = new ArrayList<>();
        Connection conn = Conexion.getConexion();

        try {
            String sql = "SELECT * FROM respuestas WHERE id_pregunta = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPregunta);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String texto = rs.getString("texto");
                boolean esCorrecta = rs.getBoolean("es_correcta");

                Respuesta r = new Respuesta(id, idPregunta, texto, esCorrecta);
                respuestas.add(r);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return respuestas;
    }

    public boolean insertarRespuesta(Respuesta respuesta) {
        Connection conn = Conexion.getConexion();
        boolean exito = false;

        try {
            String sql = "INSERT INTO respuestas (id_pregunta, texto, es_correcta) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, respuesta.getIdPregunta());
            stmt.setString(2, respuesta.getTexto());
            stmt.setBoolean(3, respuesta.isEsCorrecta());

            exito = stmt.executeUpdate() > 0;
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exito;
    }

    public boolean eliminarRespuestasPorPregunta(int idPregunta) {
        Connection conn = Conexion.getConexion();
        boolean exito = false;

        try {
            String sql = "DELETE FROM respuestas WHERE id_pregunta = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPregunta);

            exito = stmt.executeUpdate() > 0;
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exito;
    }
}
