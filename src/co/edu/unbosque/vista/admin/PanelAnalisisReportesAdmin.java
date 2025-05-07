package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Panel para análisis y reportes. Permite generar archivos y mostrar estadísticas.
 */
public class PanelAnalisisReportesAdmin extends JPanel {

    private JButton generarCSVBtn;
    private JButton generarPDFBtn;
    private JTextArea areaEstadisticas;

    public PanelAnalisisReportesAdmin() {
        setLayout(new BorderLayout(15, 15));
        setVisible(false);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Color.WHITE);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
    	JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        generarCSVBtn = new JButton("Generar CSV");
        generarPDFBtn = new JButton("Generar PDF");
        panelBotones.add(generarCSVBtn);
        panelBotones.add(generarPDFBtn);

        areaEstadisticas = new JTextArea("Aquí aparecerán las estadísticas...");
        areaEstadisticas.setEditable(false);
        areaEstadisticas.setLineWrap(true);
        areaEstadisticas.setWrapStyleWord(true);

        add(panelBotones, BorderLayout.NORTH);
        add(new JScrollPane(areaEstadisticas), BorderLayout.CENTER);
		
	}

	public JButton getGenerarCSVBtn() {
        return generarCSVBtn;
    }

    public JButton getGenerarPDFBtn() {
        return generarPDFBtn;
    }

    public JTextArea getAreaEstadisticas() {
        return areaEstadisticas;
    }
}
