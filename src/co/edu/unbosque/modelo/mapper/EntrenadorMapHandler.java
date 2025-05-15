package co.edu.unbosque.modelo.mapper;

import co.edu.unbosque.modelo.dto.EntrenadorDto;
import co.edu.unbosque.modelo.entidad.Entrenador;


public class EntrenadorMapHandler implements Mapper<Entrenador, EntrenadorDto> {

    @Override
    public EntrenadorDto toDto(Entrenador entidad) {
        EntrenadorDto eDto = new EntrenadorDto();
        eDto.setNombres(entidad.getNombres());
        eDto.setApellidos(entidad.getApellidos());
        eDto.setId(entidad.getId());
        eDto.setCorreo(entidad.getCorreo());
        eDto.setCelular(entidad.getCelular());
        eDto.setPais(entidad.getPais());
        eDto.setCiudad(entidad.getCiudad());
        eDto.setFechaNacimiento(entidad.getFechaNacimiento());
        eDto.setZonaHoraria(entidad.getZonaHoraria());
        eDto.setPasswordHash(entidad.getPasswordHash());
        eDto.setRutaFoto(entidad.getRutaFoto());
        eDto.setNecesitaCambioPassword(entidad.isNecesitaCambioPassword());
        eDto.setNickname(entidad.getNickname());
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
