package Interfaz;

import Logica.Usuario;
import BBDD.UsuarioBBDD;
import Utilidades.Estilos;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoContrasena;

    public Login() {
        setTitle("Trivia Game - Login");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        Estilos.aplicarTema(this); // Fondo y fuente

        JLabel titulo = Estilos.crearTitulo("Trivia Game");
        titulo.setBounds(50, 10, 300, 40);
        add(titulo);

        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setForeground(Color.WHITE);
        usuarioLabel.setBounds(50, 70, 100, 25);
        add(usuarioLabel);

        campoUsuario = new JTextField();
        campoUsuario.setBounds(150, 70, 180, 25);
        add(campoUsuario);

        JLabel passLabel = new JLabel("Contraseña:");
        passLabel.setForeground(Color.WHITE);
        passLabel.setBounds(50, 110, 100, 25);
        add(passLabel);

        campoContrasena = new JPasswordField();
        campoContrasena.setBounds(150, 110, 180, 25);
        add(campoContrasena);

        JButton botonLogin = Estilos.crearBoton("Entrar", new Color(252, 163, 17));
        botonLogin.setBounds(120, 160, 140, 35);
        add(botonLogin);

        JButton botonRegistro = Estilos.crearBoton("Registrarse", new Color(100, 149, 237));
        botonRegistro.setBounds(120, 210, 140, 30);
        add(botonRegistro);

        // Login
        botonLogin.addActionListener(e -> iniciarSesion());

        // Registro
        botonRegistro.addActionListener(e -> new Registro());

        setVisible(true);
    }

    private void iniciarSesion() {
        String nombre = campoUsuario.getText();
        String contrasena = new String(campoContrasena.getPassword());

        UsuarioBBDD gestorUsuario = new UsuarioBBDD();
        Usuario usuario = gestorUsuario.obtenerUsuario(nombre, contrasena);

        if (usuario != null) {
            JOptionPane.showMessageDialog(this, "Bienvenido, " + usuario.getNombre());

            dispose();
            if (usuario.getTipo().equalsIgnoreCase("admin")) {
                new MenuAdmin(usuario);
            } else {
                new SeleccionCategoria(usuario);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
