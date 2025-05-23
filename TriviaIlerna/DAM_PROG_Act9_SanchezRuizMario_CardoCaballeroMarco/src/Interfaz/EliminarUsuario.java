package Interfaz;

import BBDD.UsuarioBBDD;
import Logica.Usuario;
import Utilidades.Estilos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class EliminarUsuario extends JFrame {

    private JTable tabla;
    private DefaultTableModel modelo;

    public EliminarUsuario() {
        setTitle("Eliminar Usuario");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        Estilos.aplicarTema(this);

        JLabel titulo = Estilos.crearTitulo("Lista de usuarios");
        titulo.setBounds(30, 10, 440, 40);
        add(titulo);

        modelo = new DefaultTableModel(new String[]{"ID", "Nombre", "Tipo"}, 0);
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(30, 60, 430, 150);
        add(scroll);
        cargarUsuarios();

        JButton eliminarBtn = Estilos.crearBoton("Eliminar seleccionado", new Color(220, 20, 60));
        eliminarBtn.setBounds(150, 220, 200, 35);
        eliminarBtn.addActionListener(e -> eliminarUsuario());
        add(eliminarBtn);

        setVisible(true);
    }

    private void cargarUsuarios() {
        modelo.setRowCount(0);
        UsuarioBBDD gestor = new UsuarioBBDD();
        List<Usuario> usuarios = gestor.obtenerTodos();

        for (Usuario u : usuarios) {
            modelo.addRow(new Object[]{u.getId(), u.getNombre(), u.getTipo()});
        }
    }

    private void eliminarUsuario() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un usuario.");
            return;
        }

        int id = (int) modelo.getValueAt(fila, 0);
        String nombre = (String) modelo.getValueAt(fila, 1);

        if ("admin".equalsIgnoreCase(nombre)) {
            JOptionPane.showMessageDialog(this, "No puedes eliminar al usuario 'admin'.");
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(this, "¿Eliminar al usuario '" + nombre + "'?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_OPTION) {
            UsuarioBBDD gestor = new UsuarioBBDD();
            if (gestor.eliminarUsuario(id)) {
                JOptionPane.showMessageDialog(this, "Usuario eliminado.");
                cargarUsuarios();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el usuario.");
            }
        }
    }
}
