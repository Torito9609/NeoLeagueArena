/**
 * Este paquete contiene la interfaz gráfica (GUI) relacionada con el proceso de inicio de sesión
 * en el sistema NeoLeague Arena.
 * <p>
 * Proporciona los componentes necesarios para que el usuario ingrese sus credenciales y acceda
 * al sistema con su respectivo rol (administrador, entrenador o jugador).
 * <p>
 * Componentes principales:
 * <ul>
 *   <li><b>VentanaLogin</b>: ventana principal del login, encargada de contener y mostrar el formulario.</li>
 *   <li><b>PanelLogin</b>: panel que incluye los campos de entrada, botón de ingreso y mensajes de error.</li>
 *   <li><b>VistaLogin</b>: clase que integra los componentes anteriores y ofrece acceso centralizado desde el controlador.</li>
 * </ul>
 * Esta vista se comunica con el {@code ControladorLogin} para validar las credenciales y redirigir
 * al usuario a la vista correspondiente según su rol.
 * 
 * @see co.edu.unbosque.controlador.ControladorLogin
 * @see co.edu.unbosque.modelo.servicio.UsuarioService
 * 
 * @version 1.0
 * @author Andres
 */
package co.edu.unbosque.vista.login;
