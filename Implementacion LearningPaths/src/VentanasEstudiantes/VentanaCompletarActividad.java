package VentanasEstudiantes;

import LearningPath.Actividad;
import LearningPath.LearningPath;
import Usuario.Estudiante;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaCompletarActividad extends JFrame {
	
	private JLabel titulo;
	private JPanel panelBotones;
    private Estudiante estudiante;
    private JComboBox<String> comboBoxActividades;
    private JButton botonCompletar; 
    private JButton botonCancelar;
    private JTextArea areaDetalles;

    public VentanaCompletarActividad(Estudiante estudiante) {
        this.estudiante = estudiante;

        setTitle("Completar Actividad");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        titulo = new JLabel("Seleccione la activiadad que desea completar", JLabel.CENTER);
        add(titulo, BorderLayout.NORTH);

        comboBoxActividades = new JComboBox<>();
        cargarActividades();
        add(comboBoxActividades, BorderLayout.CENTER);

        areaDetalles = new JTextArea();
        areaDetalles.setEditable(false);
        add(new JScrollPane(areaDetalles), BorderLayout.EAST);

        panelBotones = new JPanel();
        botonCompletar = new JButton("Completar");
        botonCancelar = new JButton("Cancelar");
        panelBotones.add(botonCompletar);
        panelBotones.add(botonCancelar);
        add(panelBotones, BorderLayout.SOUTH);

        comboBoxActividades.addActionListener(e -> mostrarDetalles());

        botonCompletar.addActionListener(e -> completarActividad());

        botonCancelar.addActionListener(e -> dispose());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cargarActividades() {
        List<LearningPath> lps = estudiante.getLearningPathsInscritos();
        for (LearningPath lp : lps) {
            for (Actividad act : lp.getActividades()) {
            	System.out.println(act.getTitulo());
                if (!"Completada".equalsIgnoreCase(act.getResultado())) {
                    comboBoxActividades.addItem(lp.getTitulo() + " - " + act.getTitulo());
                }
            }
        }
    }

    private void mostrarDetalles() {
        String seleccion = (String) comboBoxActividades.getSelectedItem();
        if (seleccion != null) {
            String[] partes = seleccion.split(" - ");
            String nombreLP = partes[0];
            String nombreAct = partes[1];

            for (LearningPath lp : estudiante.getLearningPathsInscritos()) {
                if (lp.getTitulo().equalsIgnoreCase(nombreLP)) {
                    for (Actividad act : lp.getActividades()) {
                        if (act.getTitulo().equalsIgnoreCase(nombreAct)) {
                            areaDetalles.setText(
                                "Título: " + act.getTitulo() + "\n" +
                                "Descripción: " + act.getDescripcion() + "\n" +
                                "Tipo: " + act.getTipo() + "\n" +
                                "Dificultad: " + act.getDificultad() + "\n" +
                                "Fecha Límite: " + act.getFechaLimite()
                            );
                        }
                    }
                }
            }
        }
    }

    private void completarActividad() {
        String seleccion = (String) comboBoxActividades.getSelectedItem();
        if (seleccion != null) {
            String[] partes = seleccion.split(" - ");
            String nombreLP = partes[0];
            String nombreAct = partes[1];

            for (LearningPath lp : estudiante.getLearningPathsInscritos()) {
                if (lp.getTitulo().equalsIgnoreCase(nombreLP)) {
                    for (Actividad act : lp.getActividades()) {
                        if (act.getTitulo().equalsIgnoreCase(nombreAct)) {
                            estudiante.completarActividad(act);
                            JOptionPane.showMessageDialog(
                                this, 
                                "Actividad completada: " + act.getTitulo(), 
                                "Éxito", 
                                JOptionPane.INFORMATION_MESSAGE
                            );
                            dispose();
                            return;
                        }
                    }
                }
            }
        }
    }
}
