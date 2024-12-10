package VentanasEstudiantes;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import InterfazGrafica.InterfazAutenticación;
import LearningPath.LearningPath;
import Usuario.Estudiante;

public class VentanaEstudiante extends JFrame {
	
	private Estudiante estudiante;
	private PanelDatosEstudiante panelDatos;
	
	public VentanaEstudiante(String usuario) {
		
        setTitle("Menú: " + usuario);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        estudiante = getEstudianteByUsername(usuario);

        JLabel label = new JLabel("Hola, " + usuario + ", esta es tu ventana de estudiante.", JLabel.CENTER);
        add(label, BorderLayout.CENTER);
        
        panelDatos = new PanelDatosEstudiante(this);
        add(panelDatos, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }
	

	
	public void inscribirseEnLearningPath() {
		
		String lpName = JOptionPane.showInputDialog(this, "Ingresa el nombre del LearningPath:");
		for (LearningPath lp : VentanasProfesor.VentanaCrearLP.getLearningPathsCreados()) {
			if (lp.getTitulo().equalsIgnoreCase(lpName)) {
				Estudiante.inscribirseEnLearningPath(lp);
				JOptionPane.showMessageDialog(this, "Inscripción exitosa.");
				return;
			}
		}
		JOptionPane.showMessageDialog(this, "Learning Path no encontrado.");
		
	}
	
	private Estudiante getEstudianteByUsername(String usuario) {
		for (Estudiante est : InterfazGrafica.InterfazAutenticación.getEstudiantes()) {
			if (est.getUsername().equals(usuario)) {
				return est;
			}
		}
		return null;
	}

	public void verCalificaciones() {
		new VentanaCalificaciones(estudiante);
	}

	public void verProgreso() {
		new VentanaProgreso(estudiante);
		
	}
	
	public void completarActividad() {
		new VentanaCompletarActividad(estudiante);
	}
	
	public void cerrarSesion() {
		new InterfazGrafica.InterfazAutenticación();
		dispose();
		}
	
	public void cambiarVentana(JFrame nuevaVentana) {
	    nuevaVentana.setVisible(true);
	    this.dispose();
	}

}
