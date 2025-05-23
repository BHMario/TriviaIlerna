package Interfaz;

import BBDD.UsuarioBBDD;
import Logica.Usuario;
import Utilidades.Estilos;

import javax.swing.*;
import java.awt.*;

public class Registro extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoContrasena;

    public Registro() {
        setTitle("Registro de nuevo jugador");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        Estilos.aplicarTema(this);

        JLabel titulo = Estilos.crearTitulo("Crear cuenta");
        titulo.setBounds(50, 10, 300, 40);
        add(titulo);

        JLabel etiquetaUsuario = new JLabel("Usuario:");
        etiquetaUsuario.setForeground(Color.WHITE);
        etiquetaUsuario.setBounds(50, 70, 100, 25);
        add(etiquetaUsuario);

        campoUsuario = new JTextField();
        campoUsuario.setBounds(150, 70, 180, 25);
        add(campoUsuario);

        JLabel etiquetaContrasena = new JLabel("Contraseña:");
        etiquetaContrasena.setForeground(Color.WHITE);
        etiquetaContrasena.setBounds(50, 110, 100, 25);
        add(etiquetaContrasena);

        campoContrasena = new JPasswordField();
        campoContrasena.setBounds(150, 110, 180, 25);
        add(campoContrasena);

        JButton botonRegistrar = Estilos.crearBoton("Registrar", new Color(56, 176, 0));
        botonRegistrar.setBounds(120, 170, 140, 35);
        add(botonRegistrar);

        botonRegistrar.addActionListener(e -> registrarUsuario());

        setVisible(true);
    }

    private void registrarUsuario() {
        String nombre = campoUsuario.getText();
        String contrasena = new String(campoContrasena.getPassword());

        if (nombre.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos.");
            return;
        }

        UsuarioBBDD gestor = new UsuarioBBDD();
        if (gestor.existeUsuario(nombre)) {
            JOptionPane.showMessageDialog(this, "El usuario ya existe.");
            return;
        }

        Usuario nuevo = new Usuario(0, nombre, contrasena, "jugador");
        if (gestor.registrarUsuario(nuevo)) {
            JOptionPane.showMessageDialog(this, "Usuario registrado. Inicia sesión.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar el usuario.");
        }
    }
}
