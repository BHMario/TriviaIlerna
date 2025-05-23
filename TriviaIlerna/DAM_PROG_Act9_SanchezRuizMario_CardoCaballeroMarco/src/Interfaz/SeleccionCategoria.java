package Interfaz;

import Logica.Usuario;
import Utilidades.Estilos;

import javax.swing.*;
import java.awt.*;

public class SeleccionCategoria extends JFrame {

    public SeleccionCategoria(Usuario usuario) {
        setTitle("Seleccionar categoría");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        Estilos.aplicarTema(this);

        JLabel titulo = Estilos.crearTitulo("Elige una categoría");
        titulo.setBounds(40, 20, 320, 40);
        add(titulo);

        String[] categorias = {"Historia", "Ciencia", "Geografía", "Deportes", "Anime"};
        Color[] colores = {
                new Color(255, 140, 0),   // naranja
                new Color(100, 149, 237), // azul
                new Color(60, 179, 113),  // verde
                new Color(199, 21, 133),  // rosa
                new Color(18, 213, 146)   // celeste
        };

        int y = 80;
        for (int i = 0; i < categorias.length; i++) {
            JButton boton = Estilos.crearBoton(categorias[i], colores[i]);
            boton.setBounds(100, y, 200, 35);
            int finalI = i;
            boton.addActionListener(e -> {
                dispose();
                new SeleccionDificultad(usuario, categorias[finalI]);
            });
            add(boton);
            y += 45;
        }

        setVisible(true);
    }
}
