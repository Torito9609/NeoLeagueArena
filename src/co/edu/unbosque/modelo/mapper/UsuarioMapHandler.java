package co.edu.unbosque.modelo.mapper;

import co.edu.unbosque.modelo.dto.UsuarioDto;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Jugador;

public class UsuarioMapHandler implements Mapper<Usuario, UsuarioDto> {

    @Override
    public UsuarioDto toDto(Usuario entidad) {
        if (entidad == null) {
            return null;
        }
        String tipo;
        if (entidad instanceof Entrenador) {
            tipo = "ENTRENADOR";
        } else if (entidad instanceof Jugador) {
            tipo = "JUGADOR";
        } else {
            tipo = "USUARIO";
        }

        return new UsuarioDto(
            entidad.getId(),
            entidad.getNombres(),
            entidad.getApellidos(),
            entidad.getCorreo(),
            entidad.getCelular(),
            entidad.getPais(),
            entidad.getCiudad(),
            entidad.getFechaNacimiento(),
            entidad.getZonaHoraria(),
            entidad.getPasswordHash(),
            entidad.getRutaFoto(),
            entidad.isNecesitaCambioPassword(),
            tipo
        );
    }

    @Override
    public Usuario toEntity(UsuarioDto dto) {
        if (dto == null) {
            return null;
        }
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
        return u;
    }
}
