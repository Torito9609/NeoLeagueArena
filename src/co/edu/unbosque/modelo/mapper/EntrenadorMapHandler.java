package co.edu.unbosque.modelo.mapper;

import co.edu.unbosque.modelo.dto.EntrenadorDto;
import co.edu.unbosque.modelo.dto.UsuarioDto; // Usado indirectamente vía UsuarioMapHandler
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Usuario; // Usado por UsuarioMapHandler y como tipo de Entrenador
// Asumo que la interfaz Mapper y UsuarioMapHandler están en este mismo paquete o importadas.
// import co.edu.unbosque.modelo.mapper.Mapper;
// import co.edu.unbosque.modelo.mapper.UsuarioMapHandler;


/**
 * Implementación de la interfaz {@link Mapper} para convertir entre
 * entidades {@link Entrenador} y DTOs {@link EntrenadorDto}.
 * <p>
 * Esta clase se encarga de la transformación de datos entre el objeto de entidad
 * {@code Entrenador} y su representación como objeto de transferencia de datos
 * {@code EntrenadorDto}. Utiliza {@link UsuarioMapHandler} para mapear
 * los atributos heredados de la clase {@link Usuario}.
 * </p>
 *
 * @see Mapper
 * @see Entrenador
 * @see EntrenadorDto
 * @see UsuarioMapHandler
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class EntrenadorMapHandler implements Mapper<Entrenador, EntrenadorDto> {

    /**
     * Constructor por defecto para {@code EntrenadorMapHandler}.
     * El constructor está vacío, no se realiza inicialización adicional.
     */
    public EntrenadorMapHandler() {
        // El constructor está vacío en el código proporcionado.
    }

    /**
     * Convierte una entidad {@link Entrenador} a su correspondiente
     * DTO {@link EntrenadorDto}.
     * <p>
     * Primero, utiliza {@link UsuarioMapHandler#convertirADto(Usuario)} para obtener un
     * {@link UsuarioDto} base con los atributos heredados. Luego, crea un
     * {@code EntrenadorDto} y puebla tanto los campos base (obtenidos del {@code UsuarioDto})
     * como los campos específicos del {@code Entrenador} (nickname, años de experiencia, biografía).
     * Finalmente, establece el tipo de usuario como "Entrenador".
     * </p>
     *
     * @param entidad La instancia de la entidad {@code Entrenador} a convertir.
     * @return Un objeto {@code EntrenadorDto} con los datos de la entidad.
     * Devuelve {@code null} si la conversión del usuario base en {@code UsuarioMapHandler} devuelve {@code null},
     * o si la entidad es {@code null} (aunque esto último no se verifica explícitamente aquí,
     * se asume que {@code UsuarioMapHandler.convertirADto} maneja la entidad nula).
     */
    @Override
    public EntrenadorDto toDto(Entrenador entidad) {
        // Se asume que 'entidad' no es null aquí, o que UsuarioMapHandler lo maneja.
        // Si 'entidad' es null, UsuarioMapHandler.convertirADto(entidad) debería devolver null.
        UsuarioDto base = UsuarioMapHandler.convertirADto(entidad); // Llama al método estático
        if (base == null) { // Si la conversión base falla (ej. entidad es null y el mapper lo maneja)
            return null;
        }

        EntrenadorDto eDto = new EntrenadorDto();

        // Poblar campos heredados de UsuarioDto
        eDto.setNombres(base.getNombres());
        eDto.setApellidos(base.getApellidos());
        eDto.setId(base.getId());
        eDto.setCorreo(base.getCorreo());
        eDto.setCelular(base.getCelular());
        eDto.setPais(base.getPais());
        eDto.setCiudad(base.getCiudad());
        eDto.setFechaNacimiento(base.getFechaNacimiento());
        eDto.setZonaHoraria(base.getZonaHoraria());
        eDto.setPasswordHash(base.getPasswordHash());
        eDto.setRutaFoto(base.getRutaFoto());
        eDto.setNecesitaCambioPassword(base.isNecesitaCambioPassword());
        // tipoUsuario se establece explícitamente más abajo

        // Poblar campos específicos de EntrenadorDto
        eDto.setNickname(entidad.getNickname());
        eDto.setAniosExperiencia(entidad.getAniosExperiencia());
        eDto.setBiografia(entidad.getBiografia());

        eDto.setTipoUsuario("Entrenador"); // Establece el tipo de usuario específico
        return eDto;
    }

    /**
     * Método estático de utilidad para convertir un {@link EntrenadorDto} a una entidad {@link Entrenador}.
     * Crea una nueva instancia de {@code EntrenadorMapHandler} para realizar la conversión.
     *
     * @param dto El DTO {@code EntrenadorDto} a convertir.
     * @return La entidad {@code Entrenador} correspondiente.
     */
    public static Entrenador convertirAEntidad(EntrenadorDto dto) {
        return new EntrenadorMapHandler().toEntity(dto);
    }

    /**
     * Convierte un DTO {@link EntrenadorDto} a su correspondiente
     * entidad {@link Entrenador}.
     * <p>
     * Crea una nueva instancia de {@code Entrenador} y establece todos sus campos
     * (tanto los heredados de {@link Usuario} como los específicos de {@code Entrenador})
     * utilizando los valores del DTO proporcionado.
     * </p>
     *
     * @param dto La instancia del DTO {@code EntrenadorDto} a convertir.
     * @return Un objeto entidad {@code Entrenador} con los datos del DTO.
     * Devuelve {@code null} si el DTO de entrada es {@code null} (aunque esta verificación
     * no está explícita en el código proporcionado para este método, se asume
     * que un DTO nulo resultaría en un error o una entidad no inicializada correctamente).
     */
    @Override
    public Entrenador toEntity(EntrenadorDto dto) {
        // El código no verifica si 'dto' es null. Si lo fuera, ocurriría un NullPointerException.
        // Para el Javadoc, se asume que el DTO es válido.
        Entrenador e = new Entrenador();

        // Establecer campos heredados de Usuario
        e.setId(dto.getId());
        e.setNombres(dto.getNombres());
        e.setApellidos(dto.getApellidos());
        e.setCorreo(dto.getCorreo());
        e.setCelular(dto.getCelular());
        e.setPais(dto.getPais());
        e.setCiudad(dto.getCiudad());
        e.setFechaNacimiento(dto.getFechaNacimiento());
        e.setZonaHoraria(dto.getZonaHoraria());
        e.setPasswordHash(dto.getPasswordHash());
        e.setRutaFoto(dto.getRutaFoto());
        e.setNecesitaCambioPassword(dto.isNecesitaCambioPassword());
        // El tipo de usuario no se suele establecer en la entidad desde el DTO de esta forma,
        // ya que el tipo de la entidad (Entrenador) ya lo define.

        // Establecer campos específicos de Entrenador
        e.setNickname(dto.getNickname());
        e.setAniosExperiencia(dto.getAniosExperiencia());
        e.setBiografia(dto.getBiografia());

        return e;
    }

    /**
     * Método estático de utilidad para convertir una entidad {@link Entrenador} a un {@link EntrenadorDto}.
     * Crea una nueva instancia de {@code EntrenadorMapHandler} para realizar la conversión.
     *
     * @param e La entidad {@code Entrenador} a convertir.
     * @return El DTO {@code EntrenadorDto} correspondiente.
     */
    public static EntrenadorDto convertirADto(Entrenador e) {
        return new EntrenadorMapHandler().toDto(e);
    }
}