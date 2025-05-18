package co.edu.unbosque.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Jugador;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.servicio.UsuarioService;
import co.edu.unbosque.vista.login.VistaLogin;

public class LoginController implements ActionListener {

    private VistaLogin vistaLogin;
    private UsuarioService usuarioService;
    private ControladorPrincipal controladorPrincipal;

    public LoginController(ControladorPrincipal controlador) {
        this.controladorPrincipal = controlador;

        try {
            this.usuarioService = new UsuarioService();
        } catch (AccesoDatosException e) {
            vistaLogin = new VistaLogin();
            vistaLogin.mostrarMensajeError("Error al inicializar el servicio de usuario: " + e.getMessage());
            return;
        }

        vistaLogin = new VistaLogin();
        asignaOyentes();
        vistaLogin.getVentanaLogin().setVisible(true);
    }

    private void asignaOyentes() {
        vistaLogin.getVentanaLogin().getPanelLogin().getIngresarButton().addActionListener(this);
        vistaLogin.getVentanaLogin().getPanelLogin().getCancelarButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("INGRESAR")) {
            String correo = vistaLogin.getVentanaLogin().getPanelLogin().getCorreoField().getText().trim();
            String password = new String(vistaLogin.getVentanaLogin().getPanelLogin().getContrasenaField().getPassword());

            try {
                Usuario usuario = usuarioService.obtenerUsuarioPorCredenciales(correo, password);

                if (usuario == null) {
                	//System.out.println("El usuario es null");
                    controladorPrincipal.lanzarAdminController();
                }
                vistaLogin.getVentanaLogin().dispose();

                if (usuario instanceof Jugador) {
                    controladorPrincipal.lanzarJugadorController((Jugador) usuario);
                } else if (usuario instanceof Entrenador) {
                    controladorPrincipal.lanzarEntrenadorController((Entrenador) usuario);
                } else {
                    controladorPrincipal.lanzarAdminController();
                }

            } catch (AccesoDatosException ex) {
                vistaLogin.mostrarMensajeError("Error al acceder a los datos: " + ex.getMessage());
            }
        }

        else if (comando.equals("CANCELAR")) {
            int confirmacion = vistaLogin.mostrarMensajeConfirmacion("¿Esta seguro que desea salir?");
            if (confirmacion == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public VistaLogin getVistaLogin() {
        return vistaLogin;
    }

    public void setVistaLogin(VistaLogin vistaLogin) {
        this.vistaLogin = vistaLogin;
    }
}
