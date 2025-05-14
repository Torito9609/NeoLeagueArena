package co.edu.unbosque.modelo.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dao.AsignacionEntrenadorDaoImpl;
import co.edu.unbosque.modelo.entidad.AsignacionEntrenador;
import co.edu.unbosque.modelo.exception.AccesoDatosException;

public class AsignacionEntrenadorService {

    private final AsignacionEntrenadorDaoImpl asignacionDao;

    public AsignacionEntrenadorService() throws AccesoDatosException {
        this.asignacionDao = new AsignacionEntrenadorDaoImpl();
    }

    public List<AsignacionEntrenador> obtenerTodos() throws AccesoDatosException {
        return asignacionDao.obtenerTodos();
    }

    public AsignacionEntrenador buscarPorId(String id) {
        return asignacionDao.buscarPorId(id);
    }

    public void crearAsignacion(AsignacionEntrenador asignacion) 
            throws AccesoDatosException {
        asignacionDao.guardar(asignacion);
    }

    public void actualizarAsignacion(String id, AsignacionEntrenador asignacionActualizada) 
            throws AccesoDatosException, IOException {
        asignacionDao.actualizar(id, asignacionActualizada);
    }

    public void eliminarAsignacion(String id) 
            throws AccesoDatosException, IOException {
        asignacionDao.eliminar(id);
    }

    public List<AsignacionEntrenador> listarPorEntrenador(String idEntrenador) 
            throws AccesoDatosException {
        List<AsignacionEntrenador> resultado = new ArrayList<>();
        for (AsignacionEntrenador a : asignacionDao.obtenerTodos()) {
            if (a.getEntrenador().getId().equals(idEntrenador)) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    public List<AsignacionEntrenador> listarPorEquipo(String idEquipo) 
            throws AccesoDatosException {
        List<AsignacionEntrenador> resultado = new ArrayList<>();
        for (AsignacionEntrenador a : asignacionDao.obtenerTodos()) {
            if (a.getEquipo().getId().equals(idEquipo)) {
                resultado.add(a);
            }
        }
        return resultado;
    }
}
