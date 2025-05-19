package co.edu.unbosque.vista.admin;

import java.awt.*;
import javax.swing.*;

/**
 * Clase que representa la ventana principal del módulo de administración.
 * Contiene los paneles necesarios para gestionar usuarios, equipos y torneos.
 * 
 * <p>Esta ventana se ajusta automáticamente al tamaño completo de la pantalla 
 * y no permite redimensionamiento por parte del usuario.</p>
 */
public class VentanaPrincipalAdmin extends JFrame {

    private PanelBusquedaAdmin panelBusqueda;
    private PanelLateralAdmin panelLateral;
    private PanelTabla panelTabla;
    private PanelInferiorAdmin panelInferior;
    private PanelInicioAdmin panelInicio;
    private PanelAnalisisReportesAdmin panelAnalisis;
    private PanelNotificacionesAdmin panelNotificaciones;
    private PanelGestionEquipos panelEquipos;
    private PanelTorneoAdmin panelTorneos;
    private CardLayout layoutCentral;
    private JPanel panelCentral;

    /**
     * Constructor que inicializa la ventana principal, configura su tamaño 
     * y organiza los paneles internos.
     */
    public VentanaPrincipalAdmin() {
        setTitle("Gestión de Usuarios");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inicializarComponentes();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Inicializa y agrega los diferentes paneles de administración a la ventana.
     */
    public void inicializarComponentes() {
        panelBusqueda = new PanelBusquedaAdmin();
        panelTabla = new PanelTabla();
        panelInferior = new PanelInferiorAdmin();
        panelLateral = new PanelLateralAdmin();
        panelInicio = new PanelInicioAdmin();
        panelAnalisis = new PanelAnalisisReportesAdmin();
        panelNotificaciones = new PanelNotificacionesAdmin();
        panelEquipos = new PanelGestionEquipos();
        panelTorneos = new PanelTorneoAdmin();

        JPanel panelContenido = new JPanel(new BorderLayout());
        panelContenido.add(panelBusqueda, BorderLayout.NORTH);
        panelContenido.add(panelTabla, BorderLayout.CENTER);

        layoutCentral = new CardLayout();
        panelCentral = new JPanel(layoutCentral);

        panelCentral.add(panelContenido, "USUARIOS");
        panelCentral.add(panelInicio, "INICIO");
        panelCentral.add(panelAnalisis, "ANALISIS");
        panelCentral.add(panelNotificaciones, "NOTIFICACIONES");
        panelCentral.add(panelEquipos, "EQUIPOS");
        panelCentral.add(panelTorneos, "TORNEOS");

        add(panelLateral, BorderLayout.WEST);
        add(panelInferior, BorderLayout.SOUTH);
        add(panelCentral, BorderLayout.CENTER);

        layoutCentral.show(panelCentral, "INICIO");
        panelInferior.setVisible(false);
    }

    // Métodos de acceso a los paneles

    public CardLayout getLayoutCentral() { return layoutCentral; }
    public void setLayoutCentral(CardLayout layoutCentral) { this.layoutCentral = layoutCentral; }

    public JPanel getPanelCentral() { return panelCentral; }
    public void setPanelCentral(JPanel panelCentral) { this.panelCentral = panelCentral; }

    public PanelBusquedaAdmin getPanelBusqueda() { return panelBusqueda; }
    public void setPanelBusqueda(PanelBusquedaAdmin panelBusqueda) { this.panelBusqueda = panelBusqueda; }

    public PanelLateralAdmin getPanelLateral() { return panelLateral; }
    public void setPanelLateral(PanelLateralAdmin panelLateral) { this.panelLateral = panelLateral; }

    public PanelTabla getPanelTabla() { return panelTabla; }
    public void setPanelTabla(PanelTabla panelTabla) { this.panelTabla = panelTabla; }

    public PanelInferiorAdmin getPanelInferior() { return panelInferior; }
    public void setPanelInferior(PanelInferiorAdmin panelInferior) { this.panelInferior = panelInferior; }

    public PanelInicioAdmin getPanelInicio() { return panelInicio; }
    public void setPanelInicio(PanelInicioAdmin panelInicio) { this.panelInicio = panelInicio; }

    public PanelAnalisisReportesAdmin getPanelAnalisis() { return panelAnalisis; }
    public void setPanelAnalisis(PanelAnalisisReportesAdmin panelAnalisis) { this.panelAnalisis = panelAnalisis; }

    public PanelNotificacionesAdmin getPanelNotificaciones() { return panelNotificaciones; }
    public void setPanelNotificaciones(PanelNotificacionesAdmin panelNotificaciones) { this.panelNotificaciones = panelNotificaciones; }

    public PanelGestionEquipos getPanelEquipos() { return panelEquipos; }
    public void setPanelEquipos(PanelGestionEquipos panelEquipos) { this.panelEquipos = panelEquipos; }

    public PanelTorneoAdmin getPanelTorneos() { return panelTorneos; }
    public void setPanelTorneos(PanelTorneoAdmin panelTorneos) { this.panelTorneos = panelTorneos; }
}