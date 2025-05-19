package co.edu.unbosque.modelo.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dao.PartidaDaoImpl;
import co.edu.unbosque.modelo.entidad.Partida;
import co.edu.unbosque.modelo.exception.AccesoDatosException;

public class PartidaService {

    private final PartidaDaoImpl partidaDao;

    public PartidaService(String tipoPartida) throws AccesoDatosException {
        this.partidaDao = new PartidaDaoImpl(tipoPartida);
    }

    public List<Partida<?>> obtenerTodas() throws AccesoDatosException {
        return partidaDao.obtenerTodos();
    }

    public Partida<?> buscarPorId(String id) {
        return partidaDao.buscarPorId(id);
    }

    public void crearPartida(Partida<?> partida) throws AccesoDatosException {
        partidaDao.guardar(partida);
    }

    public void actualizarPartida(String id, Partida<?> actualizada)
            throws AccesoDatosException, IOException {
        partidaDao.actualizar(id, actualizada);
    }

    public void eliminarPartida(String id) throws AccesoDatosException, IOException {
        partidaDao.eliminar(id);
    }

    public void guardarTodas(List<Partida<?>> partidas) throws AccesoDatosException {
        partidaDao.guardarTodos(partidas);
    }

    public List<Partida<?>> listarPorEquipo(String idEquipo) throws AccesoDatosException {
        List<Partida<?>> resultado = new ArrayList<>();
        for (Partida<?> p : obtenerTodas()) {
            if ((p.getEquipoLocal() != null && p.getEquipoLocal().getId().equals(idEquipo)) ||
                (p.getEquipoVisitante() != null && p.getEquipoVisitante().getId().equals(idEquipo))) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}
