package co.edu.unbosque.modelo.enums;

/**
 * Define los diferentes roles que un usuario puede desempeñar dentro
 * del sistema de gestión de torneos NeoLeague Arena.
 * <p>
 * Estos roles se utilizan para determinar los permisos y las funcionalidades
 * accesibles para cada tipo de usuario.
 * </p>
 *
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public enum Rol {
    /**
     * Rol de Administrador del sistema.
     * Usualmente tiene todos los permisos para gestionar usuarios, torneos,
     * equipos, partidas y configuraciones generales de la aplicación.
     */
    ADMIN,

    /**
     * Rol de Jugador.
     * Representa a un participante que compite en los torneos, usualmente
     * como miembro de un equipo. Puede ver su perfil, equipos, partidas y torneos.
     */
    JUGADOR,

    /**
     * Rol de Entrenador.
     * Responsable de uno o más equipos, gestionando jugadores, estrategias
     * y seguimiento del desempeño en torneos.
     */
    ENTRENADOR;

    // Los enums en Java no suelen tener constructores públicos explícitos
    // ni getters/setters para sus constantes, a menos que se añadan campos adicionales a cada constante.
    // El método toString() por defecto devuelve el nombre de la constante (ej. "ADMIN").
    // Si se deseara una representación más amigable para la UI (ej. "Administrador"),
    // se podría sobrescribir el método toString() o añadir un campo 'descripcion'.
}