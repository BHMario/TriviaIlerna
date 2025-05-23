package Utilidades;

import javax.swing.*;
import java.awt.*;

public class Estilos {

    public static void aplicarTema(JFrame ventana) {
        ventana.getContentPane().setBackground(new Color(30, 30, 47)); // #1e1e2f
        ventana.setFont(new Font("Arial", Font.BOLD, 14));
    }

    public static JButton crearBoton(String texto, Color colorFondo) {
        JButton boton = new JButton(texto);
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return boton;
    }

    public static JLabel crearTitulo(String texto) {
        JLabel titulo = new JLabel(texto, SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(Color.WHITE);
        return titulo;
    }
}
