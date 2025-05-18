package co.edu.unbosque.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import co.edu.unbosque.vista.entrenador.VistaEntrenador;
import co.edu.unbosque.vista.entrenador.PanelOpcionesEntrenador;

// Asumiendo DTOs
import co.edu.unbosque.modelo.dto.EntrenadorDto;
import co.edu.unbosque.modelo.dto.JugadorDto;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Jugador;
import co.edu.unbosque.modelo.mapper.EntrenadorMapHandler;


public class EntrenadorController implements ActionListener {

    private VistaEntrenador vistaEntrenador;
    private Map<String, Runnable> comandos;
 

    private EntrenadorDto entrenadorActual; // Se obtendría del modelo tras el login

    public EntrenadorController(Entrenador entrenador) {
        this.vistaEntrenador = new VistaEntrenador();
        this.entrenadorActual = EntrenadorMapHandler.convertirADto(entrenador);
        this.comandos = new HashMap<>();

     
        registrarComandos();
        asignarOyentes();

        cargarDatosInicialesPaneles();
    }

    private void cargarDatosEntrenadorActual() {
        // Lógica para obtener datos del entrenador desde el modelo.
        System.out.println("DEBUG: cargarDatosEntrenadorActual() - Implementar con el modelo.");
    }

    private void cargarDatosInicialesPaneles() {
        // Lógica para cargar datos iniciales en PanelEquipos y PanelProximasPartidas desde el modelo.
        System.out.println("DEBUG: cargarDatosInicialesPaneles() - Implementar con el modelo.");
    }


    private void registrarComandos() {
        comandos.put("CERRAR_SESION_ENTRENADOR", this::cerrarSesionEntrenador);

      
        comandos.put("OPCION_EDITAR_PERFIL", this::navegarAEditarPerfil);
        comandos.put("OPCION_VER_MIS_EQUIPOS", this::actualizarVistaMisEquipos);
        comandos.put("OPCION_VER_MIS_TORNEOS", this::navegarAMisTorneos);
        comandos.put("OPCION_VER_CALENDARIO", this::navegarACalendario);
        comandos.put("OPCION_CONFIGURACION_ENTRENADOR", this::navegarAConfiguracion);

    }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Comando EntrenadorController: " + comando); // Depuración
        Runnable action = comandos.get(comando);
        if (action != null) {
            action.run();
        } else {
            System.out.println("Comando no reconocido en EntrenadorController: " + comando);
          
        }
    }


    private void cerrarSesionEntrenador() {
        System.out.println("Cerrando sesión del Entrenador...");
        vistaEntrenador.getVentanaPrincipal().dispose();
        // Instanciar LoginController para volver al login
        System.out.println("DEBUG: Mostrar ventana de login después de cerrar sesión.");
    }

    private void navegarAEditarPerfil() {
        System.out.println("Navegando a Editar Perfil...");
      ;
        System.out.println("DEBUG: Implementar acción para editar perfil.");
    }

    private void actualizarVistaMisEquipos() {
        System.out.println("Actualizando vista de Mis Equipos...");
     
        System.out.println("DEBUG: Implementar actualización de PanelEquiposEntrenador.");
    }

    private void navegarAMisTorneos() {
        System.out.println("Navegando a Mis Torneos...");
        System.out.println("DEBUG: Implementar navegación/actualización para Mis Torneos.");
    }

    private void navegarACalendario() {
        System.out.println("Navegando al Calendario...");
      
        System.out.println("DEBUG: Implementar actualización de PanelProximasPartidas.");
    }

    private void navegarAConfiguracion() {
        System.out.println("Navegando a Configuración...");
        System.out.println("DEBUG: Implementar navegación/acción para Configuración.");
    }

   
}