package co.edu.unbosque.modelo.entidad;

import java.util.List;
// Asumo que Usuario, Juego y AsignacionEntrenador están en el mismo paquete o importados correctamente.
// import java.io.Serializable; // Considerar añadir si se va a persistir.
// import java.util.ArrayList; // Si se inicializan las listas en el constructor.
// import java.util.Objects; // Para equals y hashCode si se añaden.


/**
 * Representa a un Entrenador dentro del sistema.
 * <p>
 * Esta clase entidad extiende {@link Usuario} y contiene información específica
 * de un entrenador, como su alias (nickname), años de experiencia, una biografía,
 * el juego principal en el que se especializa y una lista de sus asignaciones
 * a equipos.
 * </p>
 *
 * @see Usuario
 * @see Juego
 * @see AsignacionEntrenador
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class Entrenador extends Usuario /* implements Serializable */ { // Considerar Serializable

    // private static final long serialVersionUID = 1L; // Si se implementa Serializable

    /**
     * Alias o apodo público del entrenador.
     */
    private String nickname;

    /**
     * Número de años de experiencia profesional del entrenador.
     */
    private int aniosExperiencia;

    /**
     * Texto descriptivo sobre la trayectoria o filosofía del entrenador.
     */
    private String biografia;

    /**
     * El juego principal en el que el entrenador se especializa.
     * El tipo exacto del juego es genérico.
     */
    private Juego<?> juegoPrincipalEspecializado;

    /**
     * Lista de las asignaciones actuales o pasadas del entrenador a diferentes equipos.
     * Cada elemento de la lista es un objeto {@link AsignacionEntrenador}.
     */
    private List<AsignacionEntrenador> equiposAsignados;

    /**
     * Constructor por defecto.
     * Llama al constructor de la superclase {@link Usuario}.
     * La lista de equipos asignados no se inicializa explícitamente aquí,
     * por lo que podría ser {@code null} a menos que se inicialice en el setter o en otro constructor.
     */
    public Entrenador() {
        // La llamada a super() es implícita si Usuario tiene un constructor sin argumentos.
        // this.equiposAsignados = new ArrayList<>(); // Podría inicializarse aquí.
    }

    /**
     * Constructor para crear una instancia de {@code Entrenador} con todos sus atributos específicos.
     *
     * @param nickname                   El alias del entrenador.
     * @param aniosExperiencia           Los años de experiencia del entrenador.
     * @param biografia                  La biografía del entrenador.
     * @param juegoPrincipalEspecializado El juego principal de especialización del entrenador.
     * @param equiposAsignados           La lista de asignaciones a equipos del entrenador.
     */
    public Entrenador(String nickname, int aniosExperiencia, String biografia, Juego<?> juegoPrincipalEspecializado,
                      List<AsignacionEntrenador> equiposAsignados) {
        super(); // Llama al constructor de la superclase Usuario.
        this.nickname = nickname;
        this.aniosExperiencia = aniosExperiencia;
        this.biografia = biografia;
        this.juegoPrincipalEspecializado = juegoPrincipalEspecializado;
        this.equiposAsignados = equiposAsignados; // Asigna la lista proporcionada.
    }

    /**
     * Obtiene el nickname del entrenador.
     * @return El nickname del entrenador.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Establece el nickname del entrenador.
     * @param nickname El nuevo nickname del entrenador.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Obtiene los años de experiencia del entrenador.
     * @return Los años de experiencia.
     */
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    /**
     * Establece los años de experiencia del entrenador.
     * @param aniosExperiencia Los nuevos años de experiencia.
     */
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     * Obtiene la biografía del entrenador.
     * @return La biografía del entrenador.
     */
    public String getBiografia() {
        return biografia;
    }

    /**
     * Establece la biografía del entrenador.
     * @param biografia La nueva biografía del entrenador.
     */
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    /**
     * Obtiene el juego principal en el que el entrenador se especializa.
     * @return El juego principal de especialización.
     */
    public Juego<?> getJuegoPrincipalEspecializado() {
        return juegoPrincipalEspecializado;
    }

    /**
     * Establece el juego principal en el que el entrenador se especializa.
     * @param juegoPrincipalEspecializado El nuevo juego principal de especialización.
     */
    public void setJuegoPrincipalEspecializado(Juego<?> juegoPrincipalEspecializado) {
        this.juegoPrincipalEspecializado = juegoPrincipalEspecializado;
    }

    /**
     * Obtiene la lista de asignaciones a equipos del entrenador.
     * @return La lista de {@link AsignacionEntrenador}. Puede ser {@code null} si no se ha inicializado.
     */
    public List<AsignacionEntrenador> getEquiposAsignados() {
        return equiposAsignados;
    }

    /**
     * Establece la lista de asignaciones a equipos del entrenador.
     * @param equiposAsignados La nueva lista de {@link AsignacionEntrenador}.
     */
    public void setEquiposAsignados(List<AsignacionEntrenador> equiposAsignados) {
        this.equiposAsignados = equiposAsignados;
    }

    /**
     * Devuelve una representación en cadena de este objeto {@code Entrenador}.
     * La cadena incluye información de la superclase {@link Usuario} y los
     * atributos específicos del entrenador: nickname, años de experiencia, biografía,
     * juego principal especializado y la lista de equipos asignados.
     *
     * @return Una cadena que representa el objeto.
     */
    @Override
    public String toString() {
        return super.toString() + "Entrenador [nickname=" + nickname + ", aniosExperiencia=" + aniosExperiencia + ", biografia=" + biografia
                + ", juegoPrincipalEspecializado=" + juegoPrincipalEspecializado + ", equiposAsignados=" + equiposAsignados
                + "]";
    }

    // Los métodos equals() y hashCode() no están definidos explícitamente en esta clase.
    // Heredará la implementación de Usuario o de Object si Usuario no los sobrescribe.
}