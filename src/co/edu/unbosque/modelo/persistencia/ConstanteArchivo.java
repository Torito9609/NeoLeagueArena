package co.edu.unbosque.modelo.persistencia;

/**
 * Clase que define constantes para las rutas de los archivos de datos utilizados
 * por la capa de persistencia de la aplicación.
 * <p>
 * Centralizar estas rutas como constantes facilita el mantenimiento y reduce
 * la posibilidad de errores por rutas incorrectas o inconsistentes a lo largo
 * del código. Esta clase no está pensada para ser instanciada.
 * </p>
 *
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class ConstanteArchivo {

    /**
     * Constructor privado para prevenir la instanciación de esta clase de utilidad.
     */
    private ConstanteArchivo() {
        // Esta clase no debe ser instanciada.
    }

    /**
     * Ruta relativa al archivo de persistencia para los datos de {@link co.edu.unbosque.modelo.entidad.Usuario}.
     */
    public static final String ARCHIVO_USUARIOS = "data/usuarios.dat";

    /**
     * Ruta relativa al archivo de persistencia para los datos de {@link co.edu.unbosque.modelo.entidad.Entrenador}.
     */
    public static final String ARCHIVO_ENTRENADORES = "data/entrenadores.dat";

    /**
     * Ruta relativa al archivo de persistencia para los datos de {@link co.edu.unbosque.modelo.entidad.Jugador}.
     */
    public static final String ARCHIVO_JUGADORES = "data/jugadores.dat";

    /**
     * Ruta relativa al archivo de persistencia para los datos de {@link co.edu.unbosque.modelo.entidad.Equipo}.
     */
    public static final String ARCHIVO_EQUIPOS = "data/equipos.dat";

    /**
     * Ruta relativa al archivo de persistencia para los datos de {@link co.edu.unbosque.modelo.entidad.Torneo}.
     */
    public static final String ARCHIVO_TORNEOS = "data/torneos.dat";

    /**
     * Ruta relativa al archivo de persistencia para los datos de {@link co.edu.unbosque.modelo.entidad.Partida}.
     */
    public static final String ARCHIVO_PARTIDAS = "data/partidas.dat";

    /**
     * Ruta relativa al archivo de persistencia para los datos de {@link co.edu.unbosque.modelo.entidad.AsignacionEntrenador}.
     */
    public static final String ARCHIVO_ASIGNACION_ENTRENADORES = "data/asignacion_entrenadores.dat";

    /**
     * Ruta relativa al archivo de persistencia para los datos de {@link co.edu.unbosque.modelo.entidad.ParticipacionTorneo}.
     */
    public static final String ARCHIVO_PARTICIPACIONES_TORNEO = "data/participaciones_torneo.dat";
}