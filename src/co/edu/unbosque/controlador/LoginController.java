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

/**
 * Controlador encargado de gestionar el proceso de inicio de sesión en el sistema NeoLeague Arena.
 * <p>
 * Esta clase se comunica con la vista de login y el servicio de usuarios para validar las credenciales
 * ingresadas y redirigir al usuario al controlador correspondiente según su rol (administrador, entrenador o jugador).
 * <p>
 * Implementa {@link ActionListener} para escuchar eventos sobre los botones de ingreso y cancelación.
 */
public class LoginController implements ActionListener {

    private VistaLogin vistaLogin;
    private UsuarioService usuarioService;
    private ControladorPrincipal controladorPrincipal;

    /**
     * Constructor del controlador de login. Inicializa la vista y el servicio de usuario,
     * asigna los oyentes a los botones y muestra la ventana de login.
     *
     * @param controlador referencia al controlador principal del sistema
     */
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

    /**
     * Asigna los listeners a los botones de ingreso y cancelación en la vista de login.
     */
    private void asignaOyentes() {
        vistaLogin.getVentanaLogin().getPanelLogin().getIngresarButton().addActionListener(this);
        vistaLogin.getVentanaLogin().getPanelLogin().getCancelarButton().addActionListener(this);
    }

    /**
     * Maneja los eventos de los botones de la vista de login.
     * <p>
     * - Si se presiona "INGRESAR", valida las credenciales ingresadas.  
     * - Si el usuario es válido, redirige al controlador correspondiente según su tipo.  
     * - Si se presiona "CANCELAR", permite cerrar la aplicación previa confirmación.
     *
     * @param e evento generado por los botones
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("INGRESAR")) {
            String correo = vistaLogin.getVentanaLogin().getPanelLogin().getCorreoField().getText().trim();
            String password = new String(vistaLogin.getVentanaLogin().getPanelLogin().getContrasenaField().getPassword());

            try {
                Usuario usuario = usuarioService.obtenerUsuarioPorCredenciales(correo, password);

                if (usuario == null) {
                    controladorPrincipal.lanzarAdminController();  // temporal si no se encuentra usuario
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

        } else if (comando.equals("CANCELAR")) {
            int confirmacion = vistaLogin.mostrarMensajeConfirmacion("¿Esta seguro que desea salir?");
            if (confirmacion == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    /**
     * Devuelve la vista de login asociada a este controlador.
     *
     * @return la vista de login
     */
    public VistaLogin getVistaLogin() {
        return vistaLogin;
    }

    /**
     * Asigna una vista de login a este controlador.
     *
     * @param vistaLogin la nueva vista de login
     */
    public void setVistaLogin(VistaLogin vistaLogin) {
        this.vistaLogin = vistaLogin;
    }
}
