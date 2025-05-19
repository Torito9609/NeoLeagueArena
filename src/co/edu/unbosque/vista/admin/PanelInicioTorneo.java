package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Representa un panel para la configuración y el inicio de un torneo dentro del sistema de administración.
 * Permite seleccionar el torneo, definir la estructura de la fase y gestionar la configuración dinámica.
 */
public class PanelInicioTorneo extends JPanel {

    private JComboBox<String> comboTorneos;
    private JComboBox<String> comboTipoFase;
    private JPanel panelConfiguracionDinamica;
    private JButton botonIniciarTorneo;

    /**
     * Constructor que inicializa el panel con su diseño y configuración.
     */
    public PanelInicioTorneo() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createTitledBorder("Inicio de torneo"));
        setBackground(Color.WHITE);
        inicializarComponentes();
    }

    /**
     * Inicializa los componentes gráficos del panel, incluyendo selección de torneo y configuración de fase.
     */
    private void inicializarComponentes() {
        // Panel superior para selección de torneo y fase
        JPanel panelSeleccion = new JPanel(new GridLayout(2, 2, 10, 10));
        panelSeleccion.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        comboTorneos = new JComboBox<>();
        comboTipoFase = new JComboBox<>();
        comboTipoFase.addItem("Seleccionar estructura");
        comboTipoFase.addItem("Round Robin"); // FIFA, Rocket League
        comboTipoFase.addItem("Eliminación Directa");
        comboTipoFase.addItem("Campeonato de Circuitos"); // F1, GT

        panelSeleccion.add(new JLabel("Torneo:"));
        panelSeleccion.add(comboTorneos);
        panelSeleccion.add(new JLabel("Tipo de fase:"));
        panelSeleccion.add(comboTipoFase);

        // Panel central dinámico para configuración de fase
        panelConfiguracionDinamica = new JPanel();
        panelConfiguracionDinamica.setLayout(new BorderLayout());
        panelConfiguracionDinamica.setBorder(BorderFactory.createTitledBorder("Configuración de fase"));

        // Panel inferior con botón de inicio de torneo
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botonIniciarTorneo = new JButton("Iniciar Torneo");
        botonIniciarTorneo.setActionCommand("INICIAR_TORNEO");
        panelBoton.add(botonIniciarTorneo);

        // Agregar los paneles al diseño principal
        add(panelSeleccion, BorderLayout.NORTH);
        add(panelConfiguracionDinamica, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);
    }

    // Métodos de acceso a los componentes del panel

    /**
     * Devuelve el combo box de selección de torneos.
     * 
     * @return Combo box con la lista de torneos disponibles.
     */
    public JComboBox<String> getComboTorneos() {
        return comboTorneos;
    }

    /**
     * Devuelve el combo box para seleccionar la estructura de la fase del torneo.
     * 
     * @return Combo box con las opciones de estructura de torneo.
     */
    public JComboBox<String> getComboTipoFase() {
        return comboTipoFase;
    }

    /**
     * Devuelve el panel dinámico para configuración específica de la fase del torneo.
     * 
     * @return Panel para configuración de fase.
     */
    public JPanel getPanelConfiguracionDinamica() {
        return panelConfiguracionDinamica;
    }

    /**
     * Devuelve el botón para iniciar el torneo.
     * 
     * @return Botón para ejecutar la acción de inicio de torneo.
     */
    public JButton getBotonIniciarTorneo() {
        return botonIniciarTorneo;
    }
}