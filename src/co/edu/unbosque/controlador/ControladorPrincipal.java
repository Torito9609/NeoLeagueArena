package co.edu.unbosque.controlador;

public class ControladorPrincipal {
	private AdminController adminController;
	private EntrenadorController entrenadorController;
	private JugadorController jugadorController;
	private LoginController loginController;
	private TorneoController torneoController;
	
	public ControladorPrincipal() {
		//adminController = new AdminController();
		loginController = new LoginController();
	}
}
