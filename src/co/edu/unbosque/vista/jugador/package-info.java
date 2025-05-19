/**
 * Este paquete contiene la interfaz gráfica (GUI) correspondiente al rol de jugador
 * dentro del sistema NeoLeague Arena.
 * <p>
 * Aquí se definen las ventanas y paneles que permiten a los jugadores interactuar con
 * sus partidas, torneos, equipos y perfil personal de forma intuitiva y segmentada.
 * <p>
 * Estructura de componentes:
 * <ul>
 *   <li><b>VentanaPrincipalJugador</b>: ventana base desde la cual se navega a través de los distintos módulos.</li>
 *   <li><b>PanelContenidoDinamicoJugador</b> y <b>PanelInfoJugadorSuperior</b>: organizan la estructura visual principal.</li>
 *   <li><b>PanelNavegacionJugador</b>: permite acceder a las secciones disponibles.</li>
 *   <li><b>SubPanelDashboardJugador</b>: vista general del estado del jugador dentro del sistema.</li>
 *   <li><b>SubPanelMiPerfilJugador</b>: sección de edición y consulta del perfil personal.</li>
 *   <li><b>SubPanelMisEquiposJugador</b>: muestra los equipos a los que pertenece el jugador.</li>
 *   <li><b>SubPanelMisTorneosJugador</b>: acceso a los torneos en los que está inscrito.</li>
 *   <li><b>SubPanelMisPartidasJugador</b>: historial o próximas partidas asignadas al jugador.</li>
 *   <li><b>SubPanelConfiguracionJugador</b>: opciones de configuración y ajustes personales.</li>
 * </ul>
 * Esta vista se comunica con el controlador del jugador y permite al usuario gestionar
 * su experiencia dentro del ecosistema de torneos de manera eficiente.
 * 
 * @see co.edu.unbosque.controlador.ControladorJugador
 * @see co.edu.unbosque.modelo.entidad.Jugador
 * @see co.edu.unbosque.modelo.servicio.PartidaService
 * 
 * @version 1.0
 * @author Andres
 */
package co.edu.unbosque.vista.jugador;
