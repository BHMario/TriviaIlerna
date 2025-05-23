package Interfaz;

import BBDD.PreguntaBBDD;
import BBDD.RespuestaBBDD;
import Logica.Pregunta;
import Logica.Respuesta;
import Utilidades.Estilos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ModificarPregunta extends JFrame {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JTextField campoEnunciado, campoCategoria, campoDificultad;
    private JTextField[] camposRespuestas = new JTextField[4];
    private JRadioButton[] radios = new JRadioButton[4];
    private ButtonGroup grupoRadios = new ButtonGroup();
    private int idPreguntaActual = -1;

    public ModificarPregunta() {
        setTitle("Modificar Pregunta");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        Estilos.aplicarTema(this);

        JLabel titulo = Estilos.crearTitulo("Selecciona una pregunta");
        titulo.setBounds(50, 10, 500, 40);
        add(titulo);

        modelo = new DefaultTableModel(new String[]{"ID", "Enunciado"}, 0);
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(30, 60, 530, 130);
        add(scroll);
        cargarPreguntas();

        tabla.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) cargarDatosPregunta();
        });

        campoEnunciado = new JTextField();
        campoCategoria = new JTextField();
        campoDificultad = new JTextField();

        JLabel l1 = new JLabel("Enunciado:"); l1.setForeground(Color.WHITE);
        JLabel l2 = new JLabel("Categoría:"); l2.setForeground(Color.WHITE);
        JLabel l3 = new JLabel("Dificultad:"); l3.setForeground(Color.WHITE);

        l1.setBounds(30, 200, 100, 25); campoEnunciado.setBounds(140, 200, 420, 25);
        l2.setBounds(30, 235, 100, 25); campoCategoria.setBounds(140, 235, 420, 25);
        l3.setBounds(30, 270, 100, 25); campoDificultad.setBounds(140, 270, 420, 25);

        add(l1); add(campoEnunciado);
        add(l2); add(campoCategoria);
        add(l3); add(campoDificultad);

        int y = 310;
        for (int i = 0; i < 4; i++) {
            camposRespuestas[i] = new JTextField();
            camposRespuestas[i].setBounds(140, y, 300, 25);
            radios[i] = new JRadioButton("Correcta");
            radios[i].setBounds(450, y, 100, 25);
            radios[i].setBackground(new Color(30, 30, 47));
            radios[i].setForeground(Color.WHITE);
            grupoRadios.add(radios[i]);
            add(camposRespuestas[i]);
            add(radios[i]);
            y += 35;
        }

        JButton guardarBtn = Estilos.crearBoton("Guardar cambios", new Color(56, 176, 0));
        guardarBtn.setBounds(200, 470, 200, 40);
        guardarBtn.addActionListener(e -> guardarCambios());
        add(guardarBtn);

        setVisible(true);
    }

    private void cargarPreguntas() {
        modelo.setRowCount(0);
        List<Pregunta> preguntas = new PreguntaBBDD().obtenerPreguntasAleatorias(100);
        for (Pregunta p : preguntas) {
            modelo.addRow(new Object[]{p.getId(), p.getEnunciado()});
        }
    }

    private void cargarDatosPregunta() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) return;

        idPreguntaActual = (int) modelo.getValueAt(fila, 0);
        Pregunta pregunta = new PreguntaBBDD().obtenerPreguntasPorCategoriaYDificultad("%", "%", 100)
                .stream().filter(p -> p.getId() == idPreguntaActual).findFirst().orElse(null);

        if (pregunta == null) return;

        campoEnunciado.setText(pregunta.getEnunciado());
        campoCategoria.setText(pregunta.getCategoria());
        campoDificultad.setText(pregunta.getDificultad());

        List<Respuesta> respuestas = new RespuestaBBDD().obtenerRespuestasPorPregunta(idPreguntaActual);
        for (int i = 0; i < 4; i++) {
            camposRespuestas[i].setText(i < respuestas.size() ? respuestas.get(i).getTexto() : "");
            radios[i].setSelected(i < respuestas.size() && respuestas.get(i).isEsCorrecta());
        }
    }

    private void guardarCambios() {
        if (idPreguntaActual == -1) return;

        String enunciado = campoEnunciado.getText().trim();
        String categoria = campoCategoria.getText().trim();
        String dificultad = campoDificultad.getText().trim();

        if (enunciado.isEmpty() || categoria.isEmpty() || dificultad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos.");
            return;
        }

        int correcta = -1;
        for (int i = 0; i < 4; i++) {
            if (radios[i].isSelected()) {
                correcta = i;
                break;
            }
        }

        if (correcta == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una respuesta correcta.");
            return;
        }

        PreguntaBBDD gestor = new PreguntaBBDD();
        gestor.eliminarPregunta(idPreguntaActual);
        gestor.insertarPregunta(new Pregunta(0, enunciado, categoria, dificultad));
        int nuevoId = gestor.obtenerPreguntasPorCategoriaYDificultad(categoria, dificultad, 1).get(0).getId();

        RespuestaBBDD resp = new RespuestaBBDD();
        for (int i = 0; i < 4; i++) {
            resp.insertarRespuesta(new Respuesta(0, nuevoId, camposRespuestas[i].getText(), i == correcta));
        }

        JOptionPane.showMessageDialog(this, "Pregunta actualizada correctamente.");
        cargarPreguntas();
    }
}
