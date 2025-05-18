package co.edu.unbosque.modelo.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dao.ParticipacionTorneoDaoImpl;
import co.edu.unbosque.modelo.entidad.ParticipacionTorneo;
import co.edu.unbosque.modelo.exception.AccesoDatosException;

public class ParticipacionTorneoService {

    private final ParticipacionTorneoDaoImpl participacionDao;

    public ParticipacionTorneoService() throws AccesoDatosException {
        this.participacionDao = new ParticipacionTorneoDaoImpl();
    }

    public List<ParticipacionTorneo> obtenerTodos() throws AccesoDatosException {
        return participacionDao.obtenerTodos();
    }

    public ParticipacionTorneo buscarPorId(String id) {
        return participacionDao.buscarPorId(id);
    }

    public void crearParticipacion(ParticipacionTorneo participacion) throws AccesoDatosException {
        participacionDao.guardar(participacion);
    }

    public void actualizarParticipacion(String id, ParticipacionTorneo participacionActualizada) 
            throws AccesoDatosException, IOException {
        participacionDao.actualizar(id, participacionActualizada);
    }

    public void eliminarParticipacion(String idParticipacion) 
            throws AccesoDatosException, IOException {
        participacionDao.eliminar(idParticipacion);
    }

    public List<ParticipacionTorneo> listarPorEquipo(String idEquipo) throws AccesoDatosException {
        List<ParticipacionTorneo> resultado = new ArrayList<>();
        for (ParticipacionTorneo p : participacionDao.obtenerTodos()) {
            if (p.getEquipo().getId().equals(idEquipo)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<ParticipacionTorneo> listarPorTorneo(String idTorneo) throws AccesoDatosException {
        List<ParticipacionTorneo> resultado = new ArrayList<>();
        for (ParticipacionTorneo p : participacionDao.obtenerTodos()) {
            if (p.getTorneo().getId().equals(idTorneo)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}
