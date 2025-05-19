package co.edu.unbosque.vista.admin;

import java.awt.*;
import javax.swing.*;

/**
 * Clase que representa la ventana principal del módulo de administración.
 * Contiene todos los paneles necesarios para gestionar usuarios, incluyendo:
 * búsqueda, tabla de usuarios, opciones laterales y botones inferiores.
 * <p>
 * Esta ventana se ajusta automáticamente al tamaño completo de la pantalla y no
 * permite redimensionamiento por parte del usuario.
 * </p>
 * 
 * @author Kevin Andres Toro Moreno
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
	 * Constructor que inicializa la ventana principal, la configura en pantalla
	 * completa y organiza sus componentes internos.
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
	 * Inicializa y agrega los paneles que componen la ventana principal.
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

	public CardLayout getLayoutCentral() {
		return layoutCentral;
	}

	public void setLayoutCentral(CardLayout layoutCentral) {
		this.layoutCentral = layoutCentral;
	}

	public JPanel getPanelCentral() {
		return panelCentral;
	}

	public void setPanelCentral(JPanel panelCentral) {
		this.panelCentral = panelCentral;
	}

	/**
	 * @return el panel de búsqueda.
	 */
	public PanelBusquedaAdmin getPanelBusqueda() {
		return panelBusqueda;
	}

	/**
	 * Establece el panel de búsqueda.
	 * 
	 * @param panelBusqueda el nuevo panel de búsqueda.
	 */
	public void setPanelBusqueda(PanelBusquedaAdmin panelBusqueda) {
		this.panelBusqueda = panelBusqueda;
	}

	/**
	 * @return el panel lateral.
	 */
	public PanelLateralAdmin getPanelLateral() {
		return panelLateral;
	}

	/**
	 * Establece el panel lateral.
	 * 
	 * @param panelSidebar el nuevo panel lateral.
	 */
	public void setPanelLateral(PanelLateralAdmin panelSidebar) {
		this.panelLateral = panelSidebar;
	}

	/**
	 * @return el panel que contiene la tabla de usuarios.
	 */
	public PanelTabla getPanelTabla() {
		return panelTabla;
	}

	/**
	 * Establece el panel de tabla.
	 * 
	 * @param panelTabla el nuevo panel de tabla.
	 */
	public void setPanelTabla(PanelTabla panelTabla) {
		this.panelTabla = panelTabla;
	}

	/**
	 * @return el panel inferior con las acciones disponibles.
	 */
	public PanelInferiorAdmin getPanelInferior() {
		return panelInferior;
	}

	/**
	 * Establece el panel inferior.
	 * 
	 * @param panelDetalles el nuevo panel inferior.
	 */
	public void setPanelInferior(PanelInferiorAdmin panelDetalles) {
		this.panelInferior = panelDetalles;
	}

	public PanelInicioAdmin getPanelInicio() {
		return panelInicio;
	}

	public void setPanelInicio(PanelInicioAdmin panelInicio) {
		this.panelInicio = panelInicio;
	}

	public PanelAnalisisReportesAdmin getPanelAnalisis() {
		return panelAnalisis;
	}

	public void setPanelAnalisis(PanelAnalisisReportesAdmin panelAnalisis) {
		this.panelAnalisis = panelAnalisis;
	}

	public PanelNotificacionesAdmin getPanelNotificaciones() {
		return panelNotificaciones;
	}

	public void setPanelNotificaciones(PanelNotificacionesAdmin panelNotificaciones) {
		this.panelNotificaciones = panelNotificaciones;
	}

	public PanelGestionEquipos getPanelEquipos() {
		return panelEquipos;
	}

	public void setPanelEquipos(PanelGestionEquipos panelEquipos) {
		this.panelEquipos = panelEquipos;
	}

	public PanelTorneoAdmin getPanelTorneos() {
		return panelTorneos;
	}

	public void setPanelTorneos(PanelTorneoAdmin panelTorneos) {
		this.panelTorneos = panelTorneos;
	}
	
	
}
