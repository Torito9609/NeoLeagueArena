package co.edu.unbosque.modelo.mapper;

import co.edu.unbosque.modelo.dto.EntrenadorDto;
import co.edu.unbosque.modelo.entidad.Entrenador;


public class EntrenadorMapHandler implements Mapper<Entrenador, EntrenadorDto> {

    private final UsuarioMapHandler usuarioMapper = new UsuarioMapHandler();

    @Override
    public EntrenadorDto toDto(Entrenador entidad) {
        if (entidad == null) {
            return null;
        }
        var base = usuarioMapper.toDto(entidad);

        return new EntrenadorDto(
            base.getId(),
            base.getNombres(),
            base.getApellidos(),
            base.getCorreo(),
            base.getCelular(),
            base.getPais(),
            base.getCiudad(),
            base.getFechaNacimiento(),
            base.getZonaHoraria(),
            base.getPasswordHash(),
            base.getRutaFoto(),
            base.isNecesitaCambioPassword(),
            entidad.getNickname(),
            entidad.getAniosExperiencia(),
            entidad.getBiografia()
        );
    }

    @Override
    public Entrenador toEntity(EntrenadorDto dto) {
        if (dto == null) {
            return null;
        }
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
}
