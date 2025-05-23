package BBDD;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Logica.Partida;

public class PartidaBBDD {

    public boolean registrarPartida(Partida partida) {
        Connection conn = Conexion.getConexion();
        boolean exito = false;

        try {
            String sql = "INSERT INTO partidas (id_usuario, fecha, puntaje) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, partida.getIdUsuario());
            stmt.setDate(2, Date.valueOf(partida.getFecha()));
            stmt.setInt(3, partida.getPuntaje());

            exito = stmt.executeUpdate() > 0;
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exito;
    }

    public List<Partida> obtenerPartidasPorUsuario(int idUsuario) {
        List<Partida> partidas = new ArrayList<>();
        Connection conn = Conexion.getConexion();

        try {
            String sql = "SELECT * FROM partidas WHERE id_usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                int puntaje = rs.getInt("puntaje");

                Partida p = new Partida(id, idUsuario, fecha, puntaje);
                partidas.add(p);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return partidas;
    }
}
