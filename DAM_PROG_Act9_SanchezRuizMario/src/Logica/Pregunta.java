package Logica;

public class Pregunta {
    private int id;
    private String enunciado;
    private String categoria;
    private String dificultad;

    public Pregunta(int id, String enunciado, String categoria, String dificultad) {
        this.id = id;
        this.enunciado = enunciado;
        this.categoria = categoria;
        this.dificultad = dificultad;
    }

    public int getId() {
        return id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
}

