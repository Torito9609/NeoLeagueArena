package co.edu.unbosque.modelo.mapper;

import co.edu.unbosque.modelo.dto.JugadorDto;
import co.edu.unbosque.modelo.entidad.Jugador;

public class JugadorMapHandler implements Mapper<Jugador, JugadorDto>{

	@Override
	public JugadorDto toDto(Jugador entidad) {
		JugadorDto jDto = new JugadorDto();
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
        jDto.setNivelCompetitivo(entidad.getNivelCompetitivo());
        jDto.setRankingPuntos(entidad.getRankingPuntos());
        jDto.setGamerTag(entidad.getGamerTag());
		return jDto;
	}
	
	public static JugadorDto convertirADto(Jugador e) {
		return new JugadorMapHandler().toDto(e);
	}

	@Override
	public Jugador toEntity(JugadorDto dto) {
		Jugador j = new Jugador();
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
        j.setNivelCompetitivo(dto.getNivelCompetitivo());
        j.setRankingPuntos(dto.getRankingPuntos());
        j.setGamerTag(dto.getGamerTag());
        return j;
	}
	
	public static Jugador convertirAEntidad(JugadorDto dto) {
		return new JugadorMapHandler().toEntity(dto);
	}

}
