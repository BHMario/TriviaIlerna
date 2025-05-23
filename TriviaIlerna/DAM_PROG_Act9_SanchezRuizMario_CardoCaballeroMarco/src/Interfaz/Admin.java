package Interfaz;

import BBDD.PreguntaBBDD;
import BBDD.RespuestaBBDD;
import Logica.Pregunta;
import Logica.Respuesta;
import Logica.Usuario;
import Utilidades.Estilos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Admin extends JFrame {

    private JTextField campoEnunciado, campoCategoria, campoDificultad;
    private JTextField[] camposRespuestas = new JTextField[4];
    private JRadioButton[] radios = new JRadioButton[4];
    private ButtonGroup grupoRadios = new ButtonGroup();

    public Admin(Usuario admin) {
        setTitle("Agregar Pregunta");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        Estilos.aplicarTema(this);

        JLabel titulo = Estilos.crearTitulo("Nueva Pregunta");
        titulo.setBounds(50, 10, 400, 40);
        add(titulo);

        // Campos de entrada
        JLabel lblEnunciado = new JLabel("Enunciado:");
        lblEnunciado.setForeground(Color.WHITE);
        lblEnunciado.setBounds(30, 60, 100, 25);
        add(lblEnunciado);

        campoEnunciado = new JTextField();
        campoEnunciado.setBounds(140, 60, 300, 25);
        add(campoEnunciado);

        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setForeground(Color.WHITE);
        lblCategoria.setBounds(30, 100, 100, 25);
        add(lblCategoria);

        campoCategoria = new JTextField();
        campoCategoria.setBounds(140, 100, 300, 25);
        add(campoCategoria);

        JLabel lblDificultad = new JLabel("Dificultad:");
        lblDificultad.setForeground(Color.WHITE);
        lblDificultad.setBounds(30, 140, 100, 25);
        add(lblDificultad);

        campoDificultad = new JTextField();
        campoDificultad.setBounds(140, 140, 300, 25);
        add(campoDificultad);

        JLabel lblResp = new JLabel("Respuestas:");
        lblResp.setForeground(Color.WHITE);
        lblResp.setBounds(30, 180, 100, 25);
        add(lblResp);

        int y = 210;
        for (int i = 0; i < 4; i++) {
            camposRespuestas[i] = new JTextField();
            camposRespuestas[i].setBounds(140, y, 230, 25);
            add(camposRespuestas[i]);

            radios[i] = new JRadioButton("Correcta");
            radios[i].setBounds(380, y, 100, 25);
            radios[i].setBackground(new Color(30, 30, 47));
            radios[i].setForeground(Color.WHITE);
            grupoRadios.add(radios[i]);
            add(radios[i]);

            y += 35;
        }

        JButton btnGuardar = Estilos.crearBoton("Guardar", new Color(56, 176, 0));
        btnGuardar.setBounds(190, 370, 120, 40);
        btnGuardar.addActionListener(e -> guardarPregunta());
        add(btnGuardar);

        setVisible(true);
    }

    private void guardarPregunta() {
        String enunciado = campoEnunciado.getText().trim();
        String categoria = campoCategoria.getText().trim();
        String dificultad = campoDificultad.getText().trim();

        if (enunciado.isEmpty() || categoria.isEmpty() || dificultad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos de la pregunta.");
            return;
        }

        List<String> respuestas = new ArrayList<>();
        int correcta = -1;

        for (int i = 0; i < 4; i++) {
            String texto = camposRespuestas[i].getText().trim();
            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Completa todas las respuestas.");
                return;
            }
            respuestas.add(texto);
            if (radios[i].isSelected()) correcta = i;
        }

        if (correcta == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona cuál respuesta es la correcta.");
            return;
        }

        PreguntaBBDD gestorPreguntas = new PreguntaBBDD();
        Pregunta nueva = new Pregunta(0, enunciado, categoria, dificultad);
        if (!gestorPreguntas.insertarPregunta(nueva)) {
            JOptionPane.showMessageDialog(this, "Error al guardar la pregunta.");
            return;
        }

        // Obtener el ID recién creado
        int idPregunta = gestorPreguntas.obtenerPreguntasPorCategoriaYDificultad(categoria, dificultad, 1).get(0).getId();

        RespuestaBBDD gestorRespuestas = new RespuestaBBDD();
        for (int i = 0; i < 4; i++) {
            gestorRespuestas.insertarRespuesta(new Respuesta(0, idPregunta, respuestas.get(i), i == correcta));
        }

        JOptionPane.showMessageDialog(this, "Pregunta agregada con éxito.");
        dispose();
        new MenuAdmin(new Usuario(0, "admin", "", "admin")); // volver al menú
    }
}
