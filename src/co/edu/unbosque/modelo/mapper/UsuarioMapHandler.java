package co.edu.unbosque.modelo.mapper;

import co.edu.unbosque.modelo.dto.UsuarioDto;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Jugador;
// Asumo que la interfaz Mapper está en este mismo paquete o importada correctamente.
// import co.edu.unbosque.modelo.mapper.Mapper;

/**
 * Implementación de la interfaz {@link Mapper} para convertir entre
 * entidades {@link Usuario} y DTOs {@link UsuarioDto}.
 * <p>
 * Esta clase se encarga de la transformación de datos entre el objeto de entidad
 * {@code Usuario} (que puede ser una instancia de sus subclases como {@link Entrenador}
 * o {@link Jugador}) y su representación como objeto de transferencia de datos
 * {@code UsuarioDto}. En la conversión a DTO, determina el tipo de usuario
 * (entrenador, jugador, o usuario genérico) para poblar el campo correspondiente.
 * </p>
 *
 * @see Mapper
 * @see Usuario
 * @see UsuarioDto
 * @see Entrenador
 * @see Jugador
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class UsuarioMapHandler implements Mapper<Usuario, UsuarioDto> {

    /**
     * Constructor por defecto para {@code UsuarioMapHandler}.
     * El constructor está vacío, no se realiza inicialización adicional.
     */
    public UsuarioMapHandler() {
        // El constructor está vacío en el código proporcionado.
    }

    /**
     * Convierte una entidad {@link Usuario} (o una de sus subclases) a su correspondiente
     * DTO {@link UsuarioDto}.
     * <p>
     * Determina el tipo específico de la entidad (Entrenador, Jugador, u otro Usuario)
     * y establece el campo {@code tipoUsuario} en el DTO. Luego, mapea todos los atributos
     * comunes de la entidad {@code Usuario} al {@code UsuarioDto}.
     * </p>
     *
     * @param entidad La instancia de la entidad {@code Usuario} (o subclase) a convertir.
     * @return Un objeto {@code UsuarioDto} con los datos de la entidad.
     * Devuelve {@code null} si la entidad es {@code null} (aunque el código actual
     * no verifica explícitamente la nulidad de la entidad antes de acceder a sus métodos,
     * lo que podría causar un NullPointerException).
     */
    @Override
    public UsuarioDto toDto(Usuario entidad) {
        // Se asume que 'entidad' no es null.
        String tipo;
        if (entidad instanceof Entrenador) {
            tipo = "entrenador";
        } else if (entidad instanceof Jugador) {
            tipo = "jugador";
        } else {
            tipo = "usuario"; // Tipo por defecto o para instancias directas de Usuario (si es posible)
        }

        UsuarioDto uDto = new UsuarioDto();
        uDto.setId(entidad.getId());
        uDto.setNombres(entidad.getNombres());
        uDto.setApellidos(entidad.getApellidos());
        uDto.setCorreo(entidad.getCorreo());
        uDto.setCelular(entidad.getCelular());
        uDto.setPais(entidad.getPais());
        uDto.setCiudad(entidad.getCiudad());
        uDto.setFechaNacimiento(entidad.getFechaNacimiento());
        uDto.setZonaHoraria(entidad.getZonaHoraria());
        uDto.setPasswordHash(entidad.getPasswordHash());
        uDto.setRutaFoto(entidad.getRutaFoto());
        uDto.setNecesitaCambioPassword(entidad.isNecesitaCambioPassword());
        uDto.setTipoUsuario(tipo);
        return uDto;
    }

    /**
     * Método estático de utilidad para convertir una entidad {@link Usuario} a un {@link UsuarioDto}.
     * Crea una nueva instancia de {@code UsuarioMapHandler} para realizar la conversión.
     *
     * @param u La entidad {@code Usuario} a convertir.
     * @return El DTO {@code UsuarioDto} correspondiente.
     */
    public static UsuarioDto convertirADto(Usuario u) {
        return new UsuarioMapHandler().toDto(u);
    }

    /**
     * Convierte un DTO {@link UsuarioDto} a su correspondiente
     * entidad {@link Usuario}.
     * <p>
     * Si el DTO de entrada es {@code null}, este método devuelve {@code null}.
     * Crea una nueva instancia de {@code Usuario} utilizando el constructor que
     * acepta todos los atributos y los puebla con los valores del DTO.
     * </p>
     * <p>
     * Nota: Este método crea una instancia de la clase base {@code Usuario}.
     * No intenta determinar si el DTO representa a un tipo de usuario más específico
     * (como Entrenador o Jugador) para instanciar la subclase correcta.
     * </p>
     *
     * @param dto La instancia del DTO {@code UsuarioDto} a convertir.
     * @return Un objeto entidad {@code Usuario} con los datos del DTO,
     * o {@code null} si el DTO de entrada es {@code null}.
     */
    @Override
    public Usuario toEntity(UsuarioDto dto) {
        if (dto == null) {
            return null;
        }
        // Asume que la clase Usuario tiene un constructor que acepta todos estos parámetros.
        Usuario u = new Usuario(
                dto.getId(),
                dto.getNombres(),
                dto.getApellidos(),
                dto.getCorreo(),
                dto.getCelular(),
                dto.getPais(),
                dto.getCiudad(),
                dto.getFechaNacimiento(),
                dto.getZonaHoraria(),
                dto.getPasswordHash(),
                dto.getRutaFoto(),
                dto.isNecesitaCambioPassword()
        );
        // El campo 'tipoUsuario' del DTO no se usa para determinar el tipo de la entidad creada aquí.
        return u;
    }

    /**
     * Método estático de utilidad para convertir un {@link UsuarioDto} a una entidad {@link Usuario}.
     * Crea una nueva instancia de {@code UsuarioMapHandler} para realizar la conversión.
     *
     * @param dto El DTO {@code UsuarioDto} a convertir.
     * @return La entidad {@code Usuario} correspondiente.
     */
    public static Usuario convertirAEntidad(UsuarioDto dto) {
        return new UsuarioMapHandler().toEntity(dto);
    }
}