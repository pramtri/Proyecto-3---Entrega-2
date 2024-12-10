package VentanasEstudiantes;

import Usuario.Estudiante;
import LearningPath.LearningPath;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaProgreso extends JFrame {
	
	private JTextArea areaProgreso;
	private StringBuilder progreso;
	private JButton botonVolver;

	public VentanaProgreso(Estudiante estudiante) {
		setTitle("Progreso del Estudiante");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		areaProgreso = new JTextArea();
		areaProgreso.setEditable(false);
		progreso = new StringBuilder();
		
		for (LearningPath lp : estudiante.getLearningPathsInscritos()) {
			int completadas = (int) lp.getActividades().stream().filter(act -> "Completada".equals(act.getResultado())).count();
			int total = lp.getActividades().size();
			int porcentaje;
			if (total == 0) {
			    porcentaje = 0;
			} else {
			    porcentaje = (completadas * 100) / total;
			}
			progreso.append(lp.getTitulo()).append(": ").append(porcentaje).append("% completado\n");
		}
		areaProgreso.setText(progreso.toString());
		add(new JScrollPane(areaProgreso), BorderLayout.CENTER);
		
		botonVolver = new JButton("Volver");
		botonVolver.addActionListener(e -> dispose());
		add(botonVolver, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		setVisible(true);
		}
}
