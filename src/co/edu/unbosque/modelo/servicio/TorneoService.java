package co.edu.unbosque.modelo.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.unbosque.modelo.dao.TorneoDaoImpl;
import co.edu.unbosque.modelo.entidad.Equipo;
import co.edu.unbosque.modelo.entidad.Fase;
import co.edu.unbosque.modelo.entidad.Partida;
import co.edu.unbosque.modelo.entidad.ParticipacionTorneo;
import co.edu.unbosque.modelo.entidad.Torneo;
import co.edu.unbosque.modelo.enums.EstadoTorneo;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.exception.RegistroDuplicadoException;
import co.edu.unbosque.modelo.exception.RegistroNoEncontradoException;

public class TorneoService {

    private final TorneoDaoImpl torneoDao;

    public TorneoService() throws AccesoDatosException {
        this.torneoDao = new TorneoDaoImpl();
    }

    public List<Torneo> obtenerTodos() throws AccesoDatosException {
        return torneoDao.obtenerTodos();
    }

    public Torneo buscarPorId(String id) throws RegistroNoEncontradoException {
        Torneo encontrado = torneoDao.buscarPorId(id);
        if (encontrado == null) {
            throw new RegistroNoEncontradoException("No se encontró el torneo con id " + id);
        }
        return encontrado;
    }

    public void crearTorneo(Torneo torneo) throws AccesoDatosException, RegistroDuplicadoException {
        try {
            buscarPorId(torneo.getId());
            throw new RegistroDuplicadoException("El ID ya existe: " + torneo.getId());
        } catch (RegistroNoEncontradoException e) {
            // ID válido
        }
        torneoDao.guardar(torneo);
    }

    public void actualizarTorneo(Torneo torneoActualizado) throws AccesoDatosException, IOException {
        torneoDao.actualizar(torneoActualizado.getId(), torneoActualizado);
    }

    public void eliminarTorneo(String id) throws AccesoDatosException, IOException {
        torneoDao.eliminar(id);
    }

    public void agregarFase(String idTorneo, Fase fase) throws AccesoDatosException, RegistroNoEncontradoException, IOException {
        Torneo torneo = buscarPorId(idTorneo);
        torneo.getFases().add(fase);
        actualizarTorneo(torneo);
    }

    public void ejecutarTorneo(String idTorneo) throws AccesoDatosException, RegistroNoEncontradoException, IOException {
        Torneo torneo = buscarPorId(idTorneo);
        torneo.ejecutarTorneo();
        actualizarTorneo(torneo);
    }

    public void agregarParticipacion(String idTorneo, ParticipacionTorneo participacion)
            throws AccesoDatosException, RegistroNoEncontradoException, IOException {
        Torneo torneo = buscarPorId(idTorneo);
        torneo.inscribirEquipo(participacion);
        actualizarTorneo(torneo);
    }

    public void removerParticipacion(String idTorneo, ParticipacionTorneo participacion)
            throws AccesoDatosException, RegistroNoEncontradoException, IOException {
        Torneo torneo = buscarPorId(idTorneo);
        torneo.removerParticipacion(participacion);
        actualizarTorneo(torneo);
    }

    public List<Equipo> listarEquipos(String idTorneo) throws AccesoDatosException, RegistroNoEncontradoException {
        Torneo torneo = buscarPorId(idTorneo);
        return torneo.listarEquipos();
    }

    public List<Partida<?>> listarPartidas(String idTorneo) throws AccesoDatosException, RegistroNoEncontradoException {
        Torneo torneo = buscarPorId(idTorneo);
        return torneo.getPartidas();
    }
}
