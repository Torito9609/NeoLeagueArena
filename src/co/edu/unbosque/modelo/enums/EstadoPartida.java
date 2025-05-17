package co.edu.unbosque.modelo.enums;

/**
 * Define los posibles estados en los que se puede encontrar una partida
 * dentro del sistema de gestión de torneos.
 *
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public enum EstadoPartida {
    /**
     * Indica que la partida está programada pero aún no se ha jugado.
     * Es el estado inicial de una partida recién creada.
     */
    PENDIENTE,

    /**
     * Indica que la partida ya se ha jugado y su resultado ha sido registrado.
     */
    FINALIZADA,

    /**
     * Indica que la partida ha sido cancelada y no se jugará.
     * Esto puede ocurrir por diversas razones administrativas o logísticas.
     */
    CANCELADA;

    // Los enums en Java no suelen tener constructores públicos explícitos
    // ni getters/setters para sus constantes, a menos que se añadan campos adicionales a cada constante.
    // El método toString() por defecto devuelve el nombre de la constante (ej. "PENDIENTE").
}