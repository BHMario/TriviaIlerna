package Logica;

import java.time.LocalDate;

public class Partida {
    private int id;
    private int idUsuario;
    private LocalDate fecha;
    private int puntaje;

    public Partida(int id, int idUsuario, LocalDate fecha, int puntaje) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.puntaje = puntaje;
    }

    public int getId() {
        return id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}

