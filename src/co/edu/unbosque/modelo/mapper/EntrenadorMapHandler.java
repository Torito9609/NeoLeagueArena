package co.edu.unbosque.modelo.mapper;

import co.edu.unbosque.modelo.dto.EntrenadorDto;
import co.edu.unbosque.modelo.entidad.Entrenador;


public class EntrenadorMapHandler implements Mapper<Entrenador, EntrenadorDto> {


    @Override
    public EntrenadorDto toDto(Entrenador e) {
        EntrenadorDto dto = new EntrenadorDto();

        dto.setId(e.getId());
        dto.setNombres(e.getNombres());
        dto.setApellidos(e.getApellidos());
        dto.setCorreo(e.getCorreo());
        dto.setCelular(e.getCelular());
        dto.setPais(e.getPais());
        dto.setCiudad(e.getCiudad());
        dto.setFechaNacimiento(e.getFechaNacimiento());
        dto.setZonaHoraria(e.getZonaHoraria());
        dto.setPasswordHash(e.getPasswordHash());
        dto.setRutaFoto(e.getRutaFoto());
        dto.setNecesitaCambioPassword(e.isNecesitaCambioPassword());
        dto.setNickname(e.getNickname());
        dto.setAniosExperiencia(e.getAniosExperiencia());
        dto.setBiografia(e.getBiografia());
        dto.setTipoUsuario("Entrenador");

        return dto;
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
