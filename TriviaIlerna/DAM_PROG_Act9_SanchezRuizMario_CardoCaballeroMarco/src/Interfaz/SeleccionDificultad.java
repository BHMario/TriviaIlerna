package Interfaz;

import Logica.Usuario;
import Utilidades.Estilos;

import javax.swing.*;
import java.awt.*;

public class SeleccionDificultad extends JFrame {

    private String categoria;

    public SeleccionDificultad(Usuario usuario, String categoria) {
        this.categoria = categoria;

        setTitle("Seleccionar dificultad");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        Estilos.aplicarTema(this);

        JLabel titulo = Estilos.crearTitulo("Dificultad - " + categoria);
        titulo.setBounds(40, 20, 320, 40);
        add(titulo);

        String[] dificultades = {"Fácil", "Media", "Difícil"};
        Color[] colores = {
                new Color(144, 238, 144),  // verde claro
                new Color(255, 215, 0),    // dorado
                new Color(255, 69, 0)      // rojo fuerte
        };

        int y = 90;
        for (int i = 0; i < dificultades.length; i++) {
            String dificultad = dificultades[i];
            JButton boton = Estilos.crearBoton(dificultad, colores[i]);
            boton.setBounds(100, y, 200, 40);
            int finalI = i;
            boton.addActionListener(e -> {
                dispose();
                new Juego(usuario, categoria, dificultad);
            });
            add(boton);
            y += 50;
        }

        setVisible(true);
    }
}
