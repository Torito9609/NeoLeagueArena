package co.edu.unbosque.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import co.edu.unbosque.vista.entrenador.VistaEntrenador;
import co.edu.unbosque.vista.entrenador.PanelOpcionesEntrenador;
import co.edu.unbosque.modelo.dto.EntrenadorDto;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.mapper.EntrenadorMapHandler;

/**
 * Controlador responsable de manejar la interacción del entrenador con la interfaz
 * gráfica del sistema NeoLeague Arena.
 * <p>
 * Este controlador permite al entrenador navegar entre secciones como perfil, equipos,
 * torneos, calendario y configuración, además de gestionar el cierre de sesión.
 * <p>
 * Implementa {@link ActionListener} para responder a eventos generados por los botones
 * en la vista del entrenador.
 */
public class EntrenadorController implements ActionListener {

    private VistaEntrenador vistaEntrenador;
    private Map<String, Runnable> comandos;
    private EntrenadorDto entrenadorActual;

    /**
     * Crea e inicializa el controlador del entrenador. Convierte la entidad recibida en un DTO
     * y configura los comandos, oyentes y datos iniciales para la vista.
     *
     * @param entrenador entidad del entrenador autenticado
     */
    public EntrenadorController(Entrenador entrenador) {
        this.vistaEntrenador = new VistaEntrenador();
        this.entrenadorActual = EntrenadorMapHandler.convertirADto(entrenador);
        this.comandos = new HashMap<>();

        registrarComandos();
        asignarOyentes();
        cargarDatosInicialesPaneles();
    }

    /**
     * Método placeholder para implementar la carga de datos del entrenador desde el modelo.
     */
    private void cargarDatosEntrenadorActual() {
        System.out.println("DEBUG: cargarDatosEntrenadorActual() - Implementar con el modelo.");
    }

    /**
     * Carga los datos iniciales de los paneles asociados a equipos y próximas partidas.
     */
    private void cargarDatosInicialesPaneles() {
        System.out.println("DEBUG: cargarDatosInicialesPaneles() - Implementar con el modelo.");
    }

    /**
     * Registra los comandos disponibles en el sistema para que puedan ser ejecutados
     * en respuesta a eventos de la vista.
     */
    private void registrarComandos() {
        comandos.put("CERRAR_SESION_ENTRENADOR", this::cerrarSesionEntrenador);
        comandos.put("OPCION_EDITAR_PERFIL", this::navegarAEditarPerfil);
        comandos.put("OPCION_VER_MIS_EQUIPOS", this::actualizarVistaMisEquipos);
        comandos.put("OPCION_VER_MIS_TORNEOS", this::navegarAMisTorneos);
        comandos.put("OPCION_VER_CALENDARIO", this::navegarACalendario);
        comandos.put("OPCION_CONFIGURACION_ENTRENADOR", this::navegarAConfiguracion);
    }

    /**
     * Asigna los oyentes a los botones de la ventana principal del entrenador y a
     * sus paneles de navegación.
     */
    private void asignarOyentes() {
        if (vistaEntrenador.getVentanaPrincipal().getBtnCerrarSesion() != null) {
            vistaEntrenador.getVentanaPrincipal().getBtnCerrarSesion().setActionCommand("CERRAR_SESION_ENTRENADOR");
            vistaEntrenador.getVentanaPrincipal().getBtnCerrarSesion().addActionListener(this);
        }

        PanelOpcionesEntrenador panelOpciones = vistaEntrenador.getVentanaPrincipal().getPanelOpciones();
        if (panelOpciones != null) {
            System.out.println("DEBUG: Recordatorio - Asignar oyentes a los botones de PanelOpcionesEntrenador.");
        }
    }

    /**
     * Método que responde a los eventos de la vista.
     * Ejecuta el comando asociado al botón presionado si está registrado.
     *
     * @param e evento de acción generado por la vista
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Comando EntrenadorController: " + comando); // Para depuración
        Runnable action = comandos.get(comando);
        if (action != null) {
            action.run();
        } else {
            System.out.println("Comando no reconocido en EntrenadorController: " + comando);
        }
    }

    /**
     * Cierra la sesión del entrenador y cierra la ventana correspondiente.
     */
    private void cerrarSesionEntrenador() {
        System.out.println("Cerrando sesión del Entrenador...");
        vistaEntrenador.getVentanaPrincipal().dispose();
        System.out.println("DEBUG: Mostrar ventana de login después de cerrar sesión.");
    }

    /**
     * Muestra el panel de edición del perfil del entrenador.
     */
    private void navegarAEditarPerfil() {
        System.out.println("Navegando a Editar Perfil...");
        System.out.println("DEBUG: Implementar acción para editar perfil.");
    }

    /**
     * Actualiza la vista correspondiente a los equipos del entrenador.
     */
    private void actualizarVistaMisEquipos() {
        System.out.println("Actualizando vista de Mis Equipos...");
        System.out.println("DEBUG: Implementar actualización de PanelEquiposEntrenador.");
    }

    /**
     * Navega al panel donde se muestran los torneos del entrenador.
     */
    private void navegarAMisTorneos() {
        System.out.println("Navegando a Mis Torneos...");
        System.out.println("DEBUG: Implementar navegación/actualización para Mis Torneos.");
    }

    /**
     * Muestra el calendario o próximas partidas asignadas al entrenador.
     */
    private void navegarACalendario() {
        System.out.println("Navegando al Calendario...");
        System.out.println("DEBUG: Implementar actualización de PanelProximasPartidas.");
    }

    /**
     * Muestra el panel de configuración personal del entrenador.
     */
    private void navegarAConfiguracion() {
        System.out.println("Navegando a Configuración...");
        System.out.println("DEBUG: Implementar navegación/acción para Configuración.");
    }
}
