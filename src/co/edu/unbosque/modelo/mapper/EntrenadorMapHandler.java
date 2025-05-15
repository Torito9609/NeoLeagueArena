package co.edu.unbosque.modelo.mapper;

import co.edu.unbosque.modelo.dto.EntrenadorDto;
import co.edu.unbosque.modelo.entidad.Entrenador;


public class EntrenadorMapHandler implements Mapper<Entrenador, EntrenadorDto> {

    @Override
    public EntrenadorDto toDto(Entrenador entidad) {
    	
    	var base = UsuarioMapHandler.convertirADto(entidad);
        EntrenadorDto eDto = new EntrenadorDto();
        
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
        eDto.setNickname(entidad.getNickname());
        eDto.setAniosExperiencia(entidad.getAniosExperiencia());
        eDto.setBiografia(entidad.getBiografia());
        eDto.setTipoUsuario("Entrenador");
        return eDto;
    }
    
    public static Entrenador convertirAEntidad(EntrenadorDto dto) {
    	return new EntrenadorMapHandler().toEntity(dto);
    }

    @Override
    public Entrenador toEntity(EntrenadorDto dto) {
        Entrenador e = new Entrenador();
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
        e.setNickname(dto.getNickname());
        e.setAniosExperiencia(dto.getAniosExperiencia());
        e.setBiografia(dto.getBiografia());
        return e;
    }
    
    public static EntrenadorDto convertirADto(Entrenador e) {
    	return new EntrenadorMapHandler().toDto(e);
    }
}
