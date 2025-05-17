package co.edu.unbosque.modelo.enums;

/**
 * Define los posibles estados en los que se puede encontrar un torneo
 * dentro del sistema de gestión de E-Sports.
 *
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public enum EstadoTorneo {
    /**
     * Indica que el torneo ha sido creado y configurado, pero aún no ha comenzado.
     * En este estado se suelen permitir inscripciones de equipos.
     */
    PLANIFICADO,

    /**
     * Indica que el torneo está actualmente en progreso.
     * Las partidas se están jugando según el calendario establecido.
     */
    EN_CURSO,

    /**
     * Indica que el torneo ha concluido.
     * Todas las partidas han sido jugadas y se han determinado los resultados finales.
     */
    FINALIZADO;

    // Los enums en Java no suelen tener constructores públicos explícitos
    // ni getters/setters para sus constantes, a menos que se añadan campos adicionales a cada constante.
    // El método toString() por defecto devuelve el nombre de la constante (ej. "PLANIFICADO").
}