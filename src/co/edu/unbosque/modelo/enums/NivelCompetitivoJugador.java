package co.edu.unbosque.modelo.enums;

/**
 * Define los diferentes niveles competitivos que puede tener un jugador
 * dentro del sistema de gestión de torneos.
 * <p>
 * Estos niveles pueden utilizarse para clasificar jugadores, balancear equipos
 * o determinar elegibilidad para ciertos tipos de torneos.
 * </p>
 *
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public enum NivelCompetitivoJugador {
    /**
     * Nivel inicial para jugadores que recién comienzan o tienen poca experiencia competitiva.
     */
    PRINCIPIANTE,

    /**
     * Nivel para jugadores con alguna experiencia y habilidad, pero que aún no compiten
     * a niveles altos de forma consistente.
     */
    INTERMEDIO,

    /**
     * Nivel para jugadores con habilidad y experiencia considerables, que compiten
     * regularmente y obtienen buenos resultados.
     */
    AVANZADO,

    /**
     * Nivel para jugadores que compiten al más alto nivel, a menudo con dedicación
     * completa y reconocimiento en la comunidad.
     */
    PROFESIONAL,

    /**
     * Nivel excepcional, reservado para los mejores jugadores, a menudo con un historial
     * destacado de logros y dominio en su juego.
     */
    ELITE;

    // Los enums en Java no suelen tener constructores públicos explícitos
    // ni getters/setters para sus constantes, a menos que se añadan campos adicionales a cada constante.
    // El método toString() por defecto devuelve el nombre de la constante (ej. "PRINCIPIANTE").
    // Si se deseara una representación más amigable para la UI (ej. "Principiante" con mayúscula inicial),
    // se podría sobrescribir el método toString() o añadir un campo 'descripcion' a cada constante.
}