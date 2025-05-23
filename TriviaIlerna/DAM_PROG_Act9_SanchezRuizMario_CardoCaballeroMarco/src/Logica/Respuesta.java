package Logica;

public class Respuesta {
    private int id;
    private int idPregunta;
    private String texto;
    private boolean esCorrecta;

    public Respuesta(int id, int idPregunta, String texto, boolean esCorrecta) {
        this.id = id;
        this.idPregunta = idPregunta;
        this.texto = texto;
        this.esCorrecta = esCorrecta;
    }

    public int getId() {
        return id;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public String getTexto() {
        return texto;
    }

    public boolean isEsCorrecta() {
        return esCorrecta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setEsCorrecta(boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }
}

