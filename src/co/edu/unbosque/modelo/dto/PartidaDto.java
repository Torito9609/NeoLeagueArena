package co.edu.unbosque.modelo.dto;

import java.io.Serializable;
import java.time.LocalDate;
// Importar el enum si no está en el mismo paquete. Asumo que sí lo está o es accesible.
import co.edu.unbosque.modelo.enums.EstadoPartida;
// import java.util.Objects; // No se usa Objects.equals o .hash aquí

/**
 * DTO (Data Transfer Object) para representar la información de una Partida.
 * <p>
 * Esta clase se utiliza para transferir datos de partidas entre diferentes
 * capas de la aplicación. Contiene identificadores para la partida, los equipos
 * local y visitante, la fecha, el estado actual de la partida y un campo
 * para el resultado serializado.
 * </p>
 *
 * @see co.edu.unbosque.modelo.enums.EstadoPartida
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class PartidaDto implements Serializable {

    /**
     * Identificador único para la versión serializada de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único de la partida.
     */
    private String id;

    /**
     * Identificador del equipo local.
     * Referencia al {@link co.edu.unbosque.modelo.entidad.Equipo}.
     */
    private String idEquipoLocal;

    /**
     * Identificador del equipo visitante.
     * Referencia al {@link co.edu.unbosque.modelo.entidad.Equipo}.
     */
    private String idEquipoVisitante;

    /**
     * Fecha en la que se juega o se jugó la partida.
     */
    private LocalDate fecha;

    /**
     * Estado actual de la partida (ej. PROGRAMADA, EN_CURSO, FINALIZADA).
     * Se define mediante el enum {@link EstadoPartida}.
     */
    private EstadoPartida estado;

    /**
     * Representación en cadena del resultado de la partida.
     * Podría ser un JSON, XML, o un formato personalizado que describa el marcador
     * y otros detalles específicos del resultado del juego.
     */
    private String resultadoSerializado;

    /**
     * Constructor por defecto.
     */
    public PartidaDto() { }

    /**
     * Constructor con todos los campos para crear una instancia de {@code PartidaDto}.
     *
     * @param id                   El identificador único de la partida.
     * @param idEquipoLocal        El identificador del equipo local.
     * @param idEquipoVisitante    El identificador del equipo visitante.
     * @param fecha                La fecha de la partida.
     * @param estado               El estado actual de la partida.
     * @param resultadoSerializado La representación en cadena del resultado de la partida.
     */
    public PartidaDto(
            String id,
            String idEquipoLocal,
            String idEquipoVisitante,
            LocalDate fecha,
            EstadoPartida estado,
            String resultadoSerializado
    ) {
        this.id = id;
        this.idEquipoLocal = idEquipoLocal;
        this.idEquipoVisitante = idEquipoVisitante;
        this.fecha = fecha;
        this.estado = estado;
        this.resultadoSerializado = resultadoSerializado;
    }

    /**
     * Obtiene el ID de la partida.
     * @return El ID de la partida.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID de la partida.
     * @param id El nuevo ID de la partida.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el ID del equipo local.
     * @return El ID del equipo local.
     */
    public String getIdEquipoLocal() {
        return idEquipoLocal;
    }

    /**
     * Establece el ID del equipo local.
     * @param idEquipoLocal El nuevo ID del equipo local.
     */
    public void setIdEquipoLocal(String idEquipoLocal) {
        this.idEquipoLocal = idEquipoLocal;
    }

    /**
     * Obtiene el ID del equipo visitante.
     * @return El ID del equipo visitante.
     */
    public String getIdEquipoVisitante() {
        return idEquipoVisitante;
    }

    /**
     * Establece el ID del equipo visitante.
     * @param idEquipoVisitante El nuevo ID del equipo visitante.
     */
    public void setIdEquipoVisitante(String idEquipoVisitante) {
        this.idEquipoVisitante = idEquipoVisitante;
    }

    /**
     * Obtiene la fecha de la partida.
     * @return La fecha de la partida.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la partida.
     * @param fecha La nueva fecha de la partida.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el estado actual de la partida.
     * @return El estado de la partida, como un valor del enum {@link EstadoPartida}.
     */
    public EstadoPartida getEstado() {
        return estado;
    }

    /**
     * Establece el estado actual de la partida.
     * @param estado El nuevo estado de la partida.
     */
    public void setEstado(EstadoPartida estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la representación en cadena del resultado de la partida.
     * @return El resultado serializado de la partida.
     */
    public String getResultadoSerializado() {
        return resultadoSerializado;
    }

    /**
     * Establece la representación en cadena del resultado de la partida.
     * @param resultadoSerializado El nuevo resultado serializado.
     */
    public void setResultadoSerializado(String resultadoSerializado) {
        this.resultadoSerializado = resultadoSerializado;
    }

    /**
     * Devuelve una representación en cadena de este {@code PartidaDto}.
     * @return Una cadena que representa el DTO, incluyendo sus campos principales.
     */
    @Override
    public String toString() {
        return "PartidaDto{" +
               "id='" + id + '\'' +
               ", idEquipoLocal='" + idEquipoLocal + '\'' +
               ", idEquipoVisitante='" + idEquipoVisitante + '\'' +
               ", fecha=" + fecha +
               ", estado=" + estado +
               ", resultadoSerializado='" + resultadoSerializado + '\'' +
               '}';
    }
}