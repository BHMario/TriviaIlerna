package Interfaz;

import BBDD.PreguntaBBDD;
import Logica.Pregunta;
import Utilidades.Estilos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class EliminarPregunta extends JFrame {

    private JTable tabla;
    private DefaultTableModel modelo;

    public EliminarPregunta() {
        setTitle("Eliminar Pregunta");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Estilos.aplicarTema(this);
        setLayout(null);

        JLabel titulo = Estilos.crearTitulo("Preguntas existentes");
        titulo.setBounds(50, 10, 500, 40);
        add(titulo);

        modelo = new DefaultTableModel(new String[]{"ID", "Enunciado", "Categoría", "Dificultad"}, 0);
        tabla = new JTable(modelo);
        tabla.setBackground(new Color(230, 230, 250));
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(30, 60, 530, 180);
        add(scroll);

        cargarPreguntas();

        JButton botonEliminar = Estilos.crearBoton("Eliminar seleccionada", new Color(220, 20, 60));
        botonEliminar.setBounds(190, 260, 200, 35);
        botonEliminar.addActionListener(e -> eliminarSeleccionada());
        add(botonEliminar);

        setVisible(true);
    }

    private void cargarPreguntas() {
        modelo.setRowCount(0);
        PreguntaBBDD gestor = new PreguntaBBDD();
        List<Pregunta> preguntas = gestor.obtenerPreguntasAleatorias(100);
        for (Pregunta p : preguntas) {
            modelo.addRow(new Object[]{p.getId(), p.getEnunciado(), p.getCategoria(), p.getDificultad()});
        }
    }

    private void eliminarSeleccionada() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una pregunta.");
            return;
        }

        int id = (int) modelo.getValueAt(fila, 0);
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Eliminar la pregunta seleccionada?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            PreguntaBBDD gestor = new PreguntaBBDD();
            boolean exito = gestor.eliminarPregunta(id);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Pregunta eliminada.");
                cargarPreguntas();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar.");
            }
        }
    }
}
