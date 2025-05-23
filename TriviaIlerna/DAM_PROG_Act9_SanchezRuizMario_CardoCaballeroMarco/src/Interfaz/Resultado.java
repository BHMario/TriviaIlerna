package Interfaz;

import Logica.Usuario;
import Utilidades.Estilos;

import javax.swing.*;
import java.awt.*;

public class Resultado extends JFrame {

    public Resultado(Usuario usuario, int puntaje) {
        setTitle("¡Fin del juego!");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        Estilos.aplicarTema(this);

        JLabel titulo = Estilos.crearTitulo("¡Juego completado!");
        titulo.setBounds(50, 20, 350, 40);
        add(titulo);

        JLabel puntos = new JLabel(puntaje + " puntos", SwingConstants.CENTER);
        puntos.setForeground(new Color(255, 215, 0)); // dorado
        puntos.setFont(new Font("Arial", Font.BOLD, 36));
        puntos.setBounds(100, 80, 250, 50);
        add(puntos);

        JLabel subtitulo = new JLabel("¡Buen trabajo, " + usuario.getNombre() + "!", SwingConstants.CENTER);
        subtitulo.setForeground(Color.WHITE);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 18));
        subtitulo.setBounds(50, 130, 350, 30);
        add(subtitulo);

        JButton volverBtn = Estilos.crearBoton("Volver al inicio", new Color(100, 149, 237));
        volverBtn.setBounds(125, 180, 200, 35);
        volverBtn.addActionListener(e -> {
            dispose();
            new Login();
        });
        add(volverBtn);

        JButton historialBtn = Estilos.crearBoton("Ver historial", new Color(255, 165, 0));
        historialBtn.setBounds(125, 225, 200, 35);
        historialBtn.addActionListener(e -> new Historial(usuario));
        add(historialBtn);

        JButton salirBtn = Estilos.crearBoton("Salir del juego", new Color(220, 20, 60));
        salirBtn.setBounds(125, 270, 200, 35);
        salirBtn.addActionListener(e -> System.exit(0));
        add(salirBtn);

        setVisible(true);
    }
}
