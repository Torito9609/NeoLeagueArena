package co.edu.unbosque.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.vista.login.VistaLogin;

public class LoginController implements ActionListener{
	private VistaLogin vistaLogin;
	
	public LoginController() {
		vistaLogin = new VistaLogin();
	}

	public VistaLogin getVistaLogin() {
		return vistaLogin;
	}

	public void setVistaLogin(VistaLogin vistaLogin) {
		this.vistaLogin = vistaLogin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
