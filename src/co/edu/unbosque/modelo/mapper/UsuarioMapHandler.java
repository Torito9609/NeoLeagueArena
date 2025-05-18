package co.edu.unbosque.modelo.mapper;

import co.edu.unbosque.modelo.dto.EntrenadorDto;
import co.edu.unbosque.modelo.dto.JugadorDto;
import co.edu.unbosque.modelo.dto.UsuarioDto;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Jugador;

public class UsuarioMapHandler implements Mapper<Usuario, UsuarioDto> {

    @Override
    public UsuarioDto toDto(Usuario entidad) {
    	
        if (entidad instanceof Entrenador) {
        	return EntrenadorMapHandler.convertirADto((Entrenador) entidad);
        } else if (entidad instanceof Jugador) {
            return JugadorMapHandler.convertirADto((Jugador) entidad); 
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
        uDto.setTipoUsuario("Usuario");
        return uDto;
    }
    
    public static UsuarioDto convertirADto(Usuario u) {
    	return new UsuarioMapHandler().toDto(u);
    } 

    @Override
    public Usuario toEntity(UsuarioDto dto) {
    	String tipo = dto.getTipoUsuario();
    	//System.out.println("Print desde toEntity de usuario maphandler tipo usuario: " + dto.getClass().getName());
        
        if("Entrenador".equalsIgnoreCase(tipo)) {
        	//System.out.println("He entrado al if del entrenador desde toentity en usuario maphandler");
        	return EntrenadorMapHandler.convertirAEntidad((EntrenadorDto) dto);
        	
        } else if("Jugador".equalsIgnoreCase(tipo)) {
        	//System.out.println("He entrado al if del jugador desde toentity en usuario maphandler");
        	return JugadorMapHandler.convertirAEntidad((JugadorDto) dto);
        	
        }
        //System.out.println("No entre a ninguna condicion en toentity de usuarioMapHandler");
        
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
