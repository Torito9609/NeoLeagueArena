package co.edu.unbosque.modelo.mapper;

import co.edu.unbosque.modelo.dto.JugadorDto;
import co.edu.unbosque.modelo.entidad.Jugador;
// Asumo que la interfaz Mapper está en este mismo paquete o importada correctamente.
// import co.edu.unbosque.modelo.mapper.Mapper;
// Asumo que Jugador y JugadorDto heredan de Usuario y UsuarioDto respectivamente,
// y que los getters/setters para los campos de Usuario son accesibles.

/**
 * Implementación de la interfaz {@link Mapper} para convertir entre
 * entidades {@link Jugador} y DTOs {@link JugadorDto}.
 * <p>
 * Esta clase se encarga de la transformación de datos entre el objeto de entidad
 * {@code Jugador} y su representación como objeto de transferencia de datos
 * {@code JugadorDto}. Mapea tanto los atributos heredados de la clase
 * {@link co.edu.unbosque.modelo.entidad.Usuario} como los específicos del {@code Jugador}.
 * </p>
 *
 * @see Mapper
 * @see Jugador
 * @see JugadorDto
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class JugadorMapHandler implements Mapper<Jugador, JugadorDto> {

    /**
     * Constructor por defecto para {@code JugadorMapHandler}.
     * El constructor está vacío, no se realiza inicialización adicional.
     */
    public JugadorMapHandler() {
        // El constructor está vacío en el código proporcionado.
    }

    /**
     * Convierte una entidad {@link Jugador} a su correspondiente
     * DTO {@link JugadorDto}.
     * <p>
     * Si la entidad de entrada es {@code null}, este método devuelve {@code null}
     * (aunque el código actual no verifica explícitamente la nulidad de la entidad,
     * se produciría un NullPointerException si se intentara acceder a sus métodos).
     * El DTO se puebla con todos los atributos de la entidad, incluyendo los heredados
     * de {@link co.edu.unbosque.modelo.entidad.Usuario} y los específicos del jugador.
     * </p>
     *
     * @param entidad La instancia de la entidad {@code Jugador} a convertir.
     * @return Un objeto {@code JugadorDto} con los datos de la entidad.
     */
    @Override
    public JugadorDto toDto(Jugador entidad) {
        // Se asume que 'entidad' no es null. Si lo fuera, los llamados a entidad.get... lanzarían NullPointerException.
        JugadorDto jDto = new JugadorDto();

        // Poblar campos heredados de UsuarioDto (a través de los getters de Jugador que heredó de Usuario)
        jDto.setNombres(entidad.getNombres());
        jDto.setApellidos(entidad.getApellidos());
        jDto.setId(entidad.getId());
        jDto.setCorreo(entidad.getCorreo());
        jDto.setCelular(entidad.getCelular());
        jDto.setPais(entidad.getPais());
        jDto.setCiudad(entidad.getCiudad());
        jDto.setFechaNacimiento(entidad.getFechaNacimiento());
        jDto.setZonaHoraria(entidad.getZonaHoraria());
        jDto.setPasswordHash(entidad.getPasswordHash());
        jDto.setRutaFoto(entidad.getRutaFoto());
        jDto.setNecesitaCambioPassword(entidad.isNecesitaCambioPassword());
        // El tipoUsuario se establece en el constructor de JugadorDto.

        // Poblar campos específicos de JugadorDto
        jDto.setNivelCompetitivo(entidad.getNivelCompetitivo());
        jDto.setRankingPuntos(entidad.getRankingPuntos());
        jDto.setGamerTag(entidad.getGamerTag());

        return jDto;
    }

    /**
     * Método estático de utilidad para convertir una entidad {@link Jugador} a un {@link JugadorDto}.
     * Crea una nueva instancia de {@code JugadorMapHandler} para realizar la conversión.
     *
     * @param e La entidad {@code Jugador} a convertir.
     * @return El DTO {@code JugadorDto} correspondiente.
     */
    public static JugadorDto convertirADto(Jugador e) {
        return new JugadorMapHandler().toDto(e);
    }

    /**
     * Convierte un DTO {@link JugadorDto} a su correspondiente
     * entidad {@link Jugador}.
     * <p>
     * Si el DTO de entrada es {@code null}, este método devuelve {@code null}
     * (aunque el código actual no verifica explícitamente la nulidad del DTO,
     * se produciría un NullPointerException si se intentara acceder a sus métodos).
     * Crea una nueva instancia de {@code Jugador} y establece todos sus campos
     * (tanto los heredados de {@link co.edu.unbosque.modelo.entidad.Usuario}
     * como los específicos de {@code Jugador}) utilizando los valores del DTO proporcionado.
     * </p>
     *
     * @param dto La instancia del DTO {@code JugadorDto} a convertir.
     * @return Un objeto entidad {@code Jugador} con los datos del DTO.
     */
    @Override
    public Jugador toEntity(JugadorDto dto) {
        // Se asume que 'dto' no es null.
        Jugador j = new Jugador();

        // Establecer campos heredados de Usuario
        j.setId(dto.getId());
        j.setNombres(dto.getNombres());
        j.setApellidos(dto.getApellidos());
        j.setCorreo(dto.getCorreo());
        j.setCelular(dto.getCelular());
        j.setPais(dto.getPais());
        j.setCiudad(dto.getCiudad());
        j.setFechaNacimiento(dto.getFechaNacimiento());
        j.setZonaHoraria(dto.getZonaHoraria());
        j.setPasswordHash(dto.getPasswordHash());
        j.setRutaFoto(dto.getRutaFoto());
        j.setNecesitaCambioPassword(dto.isNecesitaCambioPassword());
        // El tipoUsuario del DTO no se mapea directamente a un campo tipoUsuario en la entidad Jugador,
        // ya que la entidad es de tipo Jugador por su propia clase.

        // Establecer campos específicos de Jugador
        j.setNivelCompetitivo(dto.getNivelCompetitivo());
        j.setRankingPuntos(dto.getRankingPuntos());
        j.setGamerTag(dto.getGamerTag());

        return j;
    }

    /**
     * Método estático de utilidad para convertir un {@link JugadorDto} a una entidad {@link Jugador}.
     * Crea una nueva instancia de {@code JugadorMapHandler} para realizar la conversión.
     *
     * @param dto El DTO {@code JugadorDto} a convertir.
     * @return La entidad {@code Jugador} correspondiente.
     */
    public static Jugador convertirAEntidad(JugadorDto dto) {
        return new JugadorMapHandler().toEntity(dto);
    }
}