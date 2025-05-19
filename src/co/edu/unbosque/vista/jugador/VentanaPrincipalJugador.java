package co.edu.unbosque.vista.jugador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Ventana principal para el rol de jugador en la aplicación NeoLeague Arena.
 * <p>
 * Esta clase configura la interfaz gráfica que incluye el panel de información superior,
 * el panel de navegación lateral y un panel de contenido dinámico central que se actualiza
 * según la sección seleccionada.
 */
public class VentanaPrincipalJugador extends JFrame {

    private PanelInfoJugadorSuperior panelInfoSuperior;
    private PanelNavegacionJugador panelNavegacion;
    private PanelContenidoDinamicoJugador panelContenidoDinamico;

    /**
     * Constante que representa la vista del panel principal del jugador (dashboard).
     */
    public static final String DASHBOARD_JUGADOR = "DASHBOARD_JUGADOR";

    /**
     * Constante que representa la vista del perfil del jugador.
     */
    public static final String MI_PERFIL_JUGADOR = "MI_PERFIL_JUGADOR";

    /**
     * Constante que representa la vista de los equipos del jugador.
     */
    public static final String MIS_EQUIPOS_JUGADOR = "MIS_EQUIPOS_JUGADOR";

    /**
     * Constante que representa la vista de los torneos del jugador.
     */
    public static final String MIS_TORNEOS_JUGADOR = "MIS_TORNEOS_JUGADOR";

    /**
     * Constante que representa la vista de las partidas del jugador.
     */
    public static final String MIS_PARTIDAS_JUGADOR = "MIS_PARTIDAS_JUGADOR";

    /**
     * Constante que representa la vista de configuración del jugador.
     */
    public static final String CONFIGURACION_JUGADOR = "CONFIGURACION_JUGADOR";

    /**
     * Crea una nueva instancia de la ventana principal del jugador.
     *
     * @param idJugador      ID único del jugador.
     * @param nickname       Apodo del jugador.
     * @param rutaFotoActual Ruta a la imagen de perfil actual del jugador.
     */
    public VentanaPrincipalJugador(String idJugador, String nickname, String rutaFotoActual) {
        setTitle("NeoLeague Arena - Jugador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));

        panelInfoSuperior = new PanelInfoJugadorSuperior(idJugador, nickname, rutaFotoActual);
        panelNavegacion = new PanelNavegacionJugador();
        panelContenidoDinamico = new PanelContenidoDinamicoJugador();

        add(panelInfoSuperior, BorderLayout.NORTH);
        add(panelNavegacion, BorderLayout.WEST);
        add(panelContenidoDinamico, BorderLayout.CENTER);

        getPanelContenidoDinamico().mostrarPanel(DASHBOARD_JUGADOR);
    }

    /**
     * Obtiene el panel de información superior que muestra datos básicos del jugador.
     *
     * @return el panel superior de información del jugador.
     */
    public PanelInfoJugadorSuperior getPanelInfoSuperior() {
        return panelInfoSuperior;
    }

    /**
     * Obtiene el panel lateral de navegación del jugador.
     *
     * @return el panel de navegación del jugador.
     */
    public PanelNavegacionJugador getPanelNavegacion() {
        return panelNavegacion;
    }

    /**
     * Obtiene el panel central donde se carga dinámicamente el contenido según la sección seleccionada.
     *
     * @return el panel de contenido dinámico.
     */
    public PanelContenidoDinamicoJugador getPanelContenidoDinamico() {
        return panelContenidoDinamico;
    }
}
