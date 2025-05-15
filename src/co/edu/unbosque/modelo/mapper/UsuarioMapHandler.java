package co.edu.unbosque.modelo.mapper;

import co.edu.unbosque.modelo.dto.UsuarioDto;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Jugador;

public class UsuarioMapHandler implements Mapper<Usuario, UsuarioDto> {

    @Override
    public UsuarioDto toDto(Usuario entidad) {
        String tipo;
        if (entidad instanceof Entrenador) {
            tipo = "entrenador";
        } else if (entidad instanceof Jugador) {
            tipo = "jugador";
        } else {
            tipo = "usuario";
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
    
    public static UsuarioDto convertirADto(Usuario u) {
    	return new UsuarioMapHandler().toDto(u);
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
    
    public static Usuario convertirAEntidad(UsuarioDto dto) {
    	return new UsuarioMapHandler().toEntity(dto);
    }
}
