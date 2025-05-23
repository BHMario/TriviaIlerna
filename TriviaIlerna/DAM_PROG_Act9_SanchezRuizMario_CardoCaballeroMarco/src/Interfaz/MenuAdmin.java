package Interfaz;

import Logica.Usuario;
import Utilidades.Estilos;

import javax.swing.*;
import java.awt.*;

public class MenuAdmin extends JFrame {

    public MenuAdmin(Usuario admin) {
        setTitle("Panel de Administrador");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        Estilos.aplicarTema(this);

        JLabel titulo = Estilos.crearTitulo("Bienvenido, " + admin.getNombre());
        titulo.setBounds(30, 20, 380, 40);
        add(titulo);

        int y = 80;

        JButton agregarBtn = Estilos.crearBoton("Agregar pregunta", new Color(56, 176, 0));
        agregarBtn.setBounds(100, y, 250, 40);
        agregarBtn.addActionListener(e -> {
            dispose();
            new Admin(admin);
        });
        add(agregarBtn);

        JButton eliminarBtn = Estilos.crearBoton("Eliminar pregunta", new Color(220, 20, 60));
        eliminarBtn.setBounds(100, y += 50, 250, 40);
        eliminarBtn.addActionListener(e -> {
            dispose();
            new EliminarPregunta();
        });
        add(eliminarBtn);

        JButton modificarBtn = Estilos.crearBoton("Modificar pregunta", new Color(255, 165, 0));
        modificarBtn.setBounds(100, y += 50, 250, 40);
        modificarBtn.addActionListener(e -> {
            dispose();
            new ModificarPregunta();
        });
        add(modificarBtn);

        JButton borrarUsuarioBtn = Estilos.crearBoton("Eliminar usuario", new Color(138, 43, 226));
        borrarUsuarioBtn.setBounds(100, y += 50, 250, 40);
        borrarUsuarioBtn.addActionListener(e -> {
            dispose();
            new EliminarUsuario();
        });
        add(borrarUsuarioBtn);

        JButton cerrarSesionBtn = Estilos.crearBoton("Cerrar sesión", new Color(100, 149, 237));
        cerrarSesionBtn.setBounds(100, y += 50, 250, 35);
        cerrarSesionBtn.addActionListener(e -> {
            dispose();
            new Login();
        });
        add(cerrarSesionBtn);

        setVisible(true);
    }
}
