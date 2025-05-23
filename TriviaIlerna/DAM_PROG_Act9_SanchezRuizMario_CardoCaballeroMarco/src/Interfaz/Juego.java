package Interfaz;

import BBDD.*;
import Logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.List;

import Utilidades.Estilos;

public class Juego extends JFrame {
    private Usuario usuario;
    private List<Pregunta> preguntas;
    private int indicePregunta = 0;
    private int puntaje = 0;

    private JLabel enunciadoLabel;
    private JButton[] botonesRespuestas;

    public Juego(Usuario usuario, String categoria, String dificultad) {
        this.usuario = usuario;

        setTitle("Trivia en juego");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        Estilos.aplicarTema(this);

        // Enunciado de la pregunta
        enunciadoLabel = new JLabel("", SwingConstants.CENTER);
        enunciadoLabel.setFont(new Font("Arial", Font.BOLD, 18));
        enunciadoLabel.setForeground(Color.WHITE);
        enunciadoLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        add(enunciadoLabel, BorderLayout.NORTH);

        // Panel de respuestas
        JPanel panelRespuestas = new JPanel(new GridLayout(2, 2, 15, 15));
        panelRespuestas.setBackground(new Color(30, 30, 47));
        panelRespuestas.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));

        botonesRespuestas = new JButton[4];
        for (int i = 0; i < 4; i++) {
            botonesRespuestas[i] = Estilos.crearBoton("Respuesta " + (i + 1), new Color(100, 149, 237));
            botonesRespuestas[i].setFont(new Font("Arial", Font.PLAIN, 14));
            botonesRespuestas[i].addActionListener(new RespuestaListener());
            panelRespuestas.add(botonesRespuestas[i]);
        }

        add(panelRespuestas, BorderLayout.CENTER);

        cargarPreguntas(categoria, dificultad);
        mostrarPregunta();

        setVisible(true);
    }

    private void cargarPreguntas(String categoria, String dificultad) {
        PreguntaBBDD preguntaBBDD = new PreguntaBBDD();
        preguntas = preguntaBBDD.obtenerPreguntasPorCategoriaYDificultad(categoria, dificultad, 5);
    }

    private void mostrarPregunta() {
        if (indicePregunta >= preguntas.size()) {
            finalizarJuego();
            return;
        }

        Pregunta actual = preguntas.get(indicePregunta);
        enunciadoLabel.setText("<html><div style='text-align: center;'>" + actual.getEnunciado() + "</div></html>");

        RespuestaBBDD respuestaBBDD = new RespuestaBBDD();
        List<Respuesta> respuestas = respuestaBBDD.obtenerRespuestasPorPregunta(actual.getId());

        for (int i = 0; i < botonesRespuestas.length; i++) {
            if (i < respuestas.size()) {
                botonesRespuestas[i].setText(respuestas.get(i).getTexto());
                botonesRespuestas[i].putClientProperty("respuesta", respuestas.get(i));
                botonesRespuestas[i].setEnabled(true);
                botonesRespuestas[i].setBackground(new Color(100, 149, 237)); // reset color
            } else {
                botonesRespuestas[i].setVisible(false);
            }
        }
    }

    private void finalizarJuego() {
        JOptionPane.showMessageDialog(this, "Juego terminado.\nPuntaje final: " + puntaje);

        PartidaBBDD partidaBBDD = new PartidaBBDD();
        partidaBBDD.registrarPartida(new Partida(0, usuario.getId(), LocalDate.now(), puntaje));

        this.dispose();
        new Resultado(usuario, puntaje);
    }

    private class RespuestaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            Respuesta respuesta = (Respuesta) boton.getClientProperty("respuesta");

            boolean esCorrecta = respuesta.isEsCorrecta();
            if (esCorrecta) {
                puntaje += 10;
                boton.setBackground(new Color(56, 176, 0)); // verde
                JOptionPane.showMessageDialog(null, "¡Correcto!");
            } else {
                boton.setBackground(new Color(220, 20, 60)); // rojo
                JOptionPane.showMessageDialog(null, "Incorrecto.");
            }

            indicePregunta++;
            mostrarPregunta();
        }
    }
}
