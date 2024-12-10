package VentanasEstudiantes;

import Usuario.Estudiante;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaCalificaciones extends JFrame {
	
	private JPanel panelLista;
	private JLabel labelTitulo;
	private JTextArea areaCalificaciones;
	private JButton botonVolver;

    public VentanaCalificaciones(Estudiante estudiante) {
        setTitle("Calificaciones del Estudiante");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        panelLista = new JPanel(new BorderLayout());
        labelTitulo = new JLabel("Calificaciones:");
        areaCalificaciones = new JTextArea(10, 30);
        areaCalificaciones.setEditable(false);

        
        List<String> notas = estudiante.getCalificaciones();
        if(notas==null || notas.isEmpty()) {
        	areaCalificaciones.setText("El estudiante no tiene calificaciones todavía.");
        } else {
        	StringBuilder calificaciones = new StringBuilder();
        	for (String nota : notas) {
                calificaciones.append(nota).append("\n");
            }
            areaCalificaciones.setText(calificaciones.toString());
        }
        

        panelLista.add(labelTitulo, BorderLayout.NORTH);
        panelLista.add(new JScrollPane(areaCalificaciones), BorderLayout.CENTER);

        botonVolver = new JButton("Volver");
        botonVolver.addActionListener(e -> dispose());

        add(panelLista, BorderLayout.CENTER);
        add(botonVolver, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
