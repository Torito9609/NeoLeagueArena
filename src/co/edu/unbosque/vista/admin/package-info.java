/**
 * Este paquete contiene la interfaz gráfica (GUI) específica del rol administrador 
 * dentro del sistema NeoLeague Arena.
 * <p>
 * Aquí se definen todas las ventanas, paneles y componentes visuales que permiten al
 * administrador gestionar los distintos elementos del sistema, como usuarios, equipos, 
 * torneos, partidas, reportes y notificaciones.
 * <p>
 * La vista está diseñada con una arquitectura modular basada en paneles reutilizables
 * y organizados jerárquicamente, incluyendo secciones superiores, laterales e inferiores.
 * <p>
 * Componentes clave:
 * <ul>
 *   <li><b>VentanaPrincipalAdmin</b>: punto central de la interfaz de administración.</li>
 *   <li><b>PanelUsuarioDinamico</b> y <b>PanelUsuarioSuperior</b>: permiten crear y editar usuarios según su rol.</li>
 *   <li><b>PanelTorneoAdmin</b> y <b>PanelInicioTorneo</b>: gestionan la creación, edición e inicio de torneos.</li>
 *   <li><b>PanelGestionEquipos</b> y <b>PanelJugador</b>/<b>PanelEntrenador</b>: permiten administrar equipos y asignaciones.</li>
 *   <li><b>PanelNotificacionesAdmin</b>: muestra avisos o alertas relevantes al administrador.</li>
 *   <li><b>FabricaPanelUsuarioDinamico</b>: construye dinámicamente la vista para cada tipo de usuario.</li>
 * </ul>
 * Toda esta vista se integra con los controladores del administrador y se comunica con los servicios
 * para aplicar acciones sobre el modelo.
 * 
 * @see co.edu.unbosque.controlador.ControladorAdmin
 * @see co.edu.unbosque.modelo.servicio
 * 
 * @author Andres
 * @version 1.0
 */
package co.edu.unbosque.vista.admin;
