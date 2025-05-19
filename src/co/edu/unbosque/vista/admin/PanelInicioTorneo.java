package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

public class PanelInicioTorneo extends JPanel {

    private JComboBox<String> comboTorneos;
    private JComboBox<String> comboTipoFase;
    private JPanel panelConfiguracionDinamica;
    private JButton botonIniciarTorneo;

    public PanelInicioTorneo() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createTitledBorder("Inicio de torneo"));
        setBackground(Color.WHITE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Zona superior
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

        // Zona central dinámica
        panelConfiguracionDinamica = new JPanel();
        panelConfiguracionDinamica.setLayout(new BorderLayout());
        panelConfiguracionDinamica.setBorder(BorderFactory.createTitledBorder("Configuración de fase"));

        // Zona inferior
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botonIniciarTorneo = new JButton("Iniciar Torneo");
        botonIniciarTorneo.setActionCommand("INICIAR_TORNEO");
        panelBoton.add(botonIniciarTorneo);

        // Agregar todo
        add(panelSeleccion, BorderLayout.NORTH);
        add(panelConfiguracionDinamica, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);
    }

    // Getters
    public JComboBox<String> getComboTorneos() {
        return comboTorneos;
    }

    public JComboBox<String> getComboTipoFase() {
        return comboTipoFase;
    }

    public JPanel getPanelConfiguracionDinamica() {
        return panelConfiguracionDinamica;
    }

    public JButton getBotonIniciarTorneo() {
        return botonIniciarTorneo;
    }
}
