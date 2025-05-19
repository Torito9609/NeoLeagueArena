package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Representa un panel para el análisis y la generación de reportes dentro del sistema de administración.
 * Permite generar archivos en formato CSV y PDF con estadísticas relevantes.
 */
public class PanelAnalisisReportesAdmin extends JPanel {

    private JButton generarCSVBtn;
    private JButton generarPDFBtn;
    private JTextArea areaEstadisticas;

    /**
     * Constructor que inicializa el panel con su configuración y diseño.
     */
    public PanelAnalisisReportesAdmin() {
        setLayout(new BorderLayout(15, 15));
        setVisible(false);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Color.WHITE);

        inicializarComponentes();
    }

    /**
     * Inicializa los componentes gráficos del panel, incluyendo botones para exportar datos y área de estadísticas.
     */
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

    // Métodos de acceso a los componentes del panel

    /**
     * Devuelve el botón para generar un archivo CSV con los reportes.
     * 
     * @return Botón de generación de CSV.
     */
    public JButton getGenerarCSVBtn() {
        return generarCSVBtn;
    }

    /**
     * Devuelve el botón para generar un archivo PDF con los reportes.
     * 
     * @return Botón de generación de PDF.
     */
    public JButton getGenerarPDFBtn() {
        return generarPDFBtn;
    }

    /**
     * Devuelve el área de texto donde se muestran las estadísticas generadas.
     * 
     * @return Área de texto para estadísticas.
     */
    public JTextArea getAreaEstadisticas() {
        return areaEstadisticas;
    }
}