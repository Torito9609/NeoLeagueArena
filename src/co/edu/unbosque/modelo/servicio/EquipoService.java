package co.edu.unbosque.modelo.servicio;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.unbosque.modelo.dao.EquipoDaoImpl;
import co.edu.unbosque.modelo.entidad.Equipo;
import co.edu.unbosque.modelo.entidad.ParticipacionTorneo;
import co.edu.unbosque.modelo.entidad.Torneo;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.exception.RegistroDuplicadoException;
import co.edu.unbosque.modelo.exception.RegistroNoEncontradoException;

public class EquipoService {

    private final EquipoDaoImpl equipoDao;
    private final ParticipacionTorneoService participacionService;
    private final TorneoService torneoService;

    public EquipoService() throws AccesoDatosException {
        equipoDao = new EquipoDaoImpl();
        torneoService = new TorneoService();
        participacionService = new ParticipacionTorneoService(this, torneoService);
      
    }

    public List<Equipo> obtenerTodos() throws AccesoDatosException {
        return equipoDao.obtenerTodos();
    }

    public Equipo buscarPorId(String id) throws RegistroNoEncontradoException {
        Equipo encontrado = equipoDao.buscarPorId(id);
        if (encontrado == null) {
            throw new RegistroNoEncontradoException("No se encontró el equipo con id " + id);
        }
        return encontrado;
    }

    public void crearEquipo(Equipo equipo) throws RegistroDuplicadoException, AccesoDatosException {
        try {
            buscarPorId(equipo.getId());
            throw new RegistroDuplicadoException("El ID ingresado ya existe: " + equipo.getId());
        } catch (RegistroNoEncontradoException e) {
          
        }

        if (nombreExiste(equipo.getNombre())) {
            throw new RegistroDuplicadoException("El nombre del equipo ya está en uso: " + equipo.getNombre());
        }

        equipoDao.guardar(equipo);
    }

    public void actualizarEquipo(Equipo equipoActualizado) throws AccesoDatosException, IOException {
        equipoDao.actualizar(equipoActualizado.getId(), equipoActualizado);
    }

    public void eliminarEquipo(String id) throws AccesoDatosException, IOException {
        equipoDao.eliminar(id);
    }

    public boolean nombreExiste(String nombre) throws AccesoDatosException {
        for (Equipo e : equipoDao.obtenerTodos()) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void asignarTorneo(String idEquipo, String idTorneo) throws AccesoDatosException, RegistroNoEncontradoException, IOException {
        Equipo equipo = buscarPorId(idEquipo);
        Torneo torneo = torneoService.buscarPorId(idTorneo);

        ParticipacionTorneo participacion = new ParticipacionTorneo(
                UUID.randomUUID().toString(),
                equipo,
                torneo,
                LocalDate.now()
        );
        participacionService.crearParticipacion(participacion);
    }

    public void removerTorneo(String idEquipo, String idTorneo) throws AccesoDatosException, IOException {
        List<ParticipacionTorneo> participaciones = participacionService.listarPorEquipo(idEquipo);
        for (ParticipacionTorneo p : participaciones) {
            if (p.getTorneo().getId().equals(idTorneo)) {
                participacionService.eliminarParticipacion(p.getIdParticipacion()); 
                return;
            }
        }
        throw new AccesoDatosException("El equipo " + idEquipo + " no está registrado en el torneo " + idTorneo);
    }


    public List<Torneo> listarTorneosAsignados(String idEquipo) throws AccesoDatosException {
        List<Torneo> torneos = new ArrayList<>();
        List<ParticipacionTorneo> participaciones = participacionService.listarPorEquipo(idEquipo);
        for (ParticipacionTorneo p : participaciones) {
            torneos.add(p.getTorneo());
        }
        return torneos;
    }
}
