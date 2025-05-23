package Interfaz;

import BBDD.PartidaBBDD;
import Logica.Partida;
import Logica.Usuario;
import Utilidades.Estilos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Historial extends JFrame {

    private JTable tabla;
    private DefaultTableModel modelo;

    public Historial(Usuario usuario) {
        setTitle("Historial de partidas");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        Estilos.aplicarTema(this);

        JLabel titulo = Estilos.crearTitulo("Tus resultados");
        titulo.setBounds(50, 10, 400, 40);
        add(titulo);

        modelo = new DefaultTableModel(new String[]{"Fecha", "Puntaje"}, 0);
        tabla = new JTable(modelo);
        tabla.setFont(new Font("Arial", Font.PLAIN, 14));
        tabla.setRowHeight(25);
        tabla.setBackground(new Color(230, 230, 250));

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(40, 60, 400, 180);
        add(scroll);

        cargarHistorial(usuario);

        JButton volverBtn = Estilos.crearBoton("Volver", new Color(100, 149, 237));
        volverBtn.setBounds(180, 260, 120, 35);
        volverBtn.addActionListener(e -> dispose());
        add(volverBtn);

        setVisible(true);
    }

    private void cargarHistorial(Usuario usuario) {
        PartidaBBDD gestor = new PartidaBBDD();
        List<Partida> partidas = gestor.obtenerPartidasPorUsuario(usuario.getId());

        for (Partida p : partidas) {
            modelo.addRow(new Object[]{p.getFecha().toString(), p.getPuntaje()});
        }
    }
}
